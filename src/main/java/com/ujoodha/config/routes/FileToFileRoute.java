package com.ujoodha.config.routes;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.model.ProcessorDefinition;
import org.apache.camel.processor.aggregate.AggregationStrategy;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ujoodha.config.processor.AbstractProcessor;
import com.ujoodha.utils.CamelBatchUtils;
import com.ujoodha.utils.PropertiesReader;

public class FileToFileRoute extends CustomRouteBuilder {

	private String in;
	private String out;
	private static int i = 1;

	@Override
	protected ProcessorDefinition composeRoute() {
		in = PropertiesReader.INSTANCE
				.getPropsFromKey(CamelBatchUtils.DIRECTORY_IN);
		out = PropertiesReader.INSTANCE
				.getPropsFromKey(CamelBatchUtils.DIRECTORY_OUT);

		processFin = new AbstractProcessor();

		ProcessorDefinition composeRoute = null;

		// .unmarshal()
		// .bindy(BindyType.Csv, UserLigth.class)

		// // .split(body(UserLigth.class))
		// // .parallelProcessing()

		// .convertBodyTo(String.class)
		// .json()
		// .split(body())
		// .marshal(jackson)

		ObjectMapper objectMapper = new ObjectMapper();
		// objectMapper
		// .disable(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS);
		JacksonDataFormat jackson = new JacksonDataFormat(objectMapper, null);

		// CsvDataFormat csv = new CsvDataFormat();
		// csv.setDelimiter(',');
		// csv.setHeader(header);

		// CSVConfig csvConfig = new CSVConfig();
		// csvConfig.setDelimiter(";");
		// csv.setConfig(csvConfig);

		composeRoute = from("file://" + in)
				.convertBodyTo(String.class)
				.unmarshal(buildDataCSV())
				.split(body())
				.log("fin de transformation")
				.marshal(jackson)
				.convertBodyTo(String.class)
				.process(new Processor() {

					@Override
					public void process(Exchange exchange) throws Exception {
						String tmp = (String) exchange.getIn().getBody();
						String finalStr = "{ \"index\" : { \"_index\" : \"cronos\", \"_type\" : \"employes\", \"_id\" : \""
								+ (i++) + "\" }, \"_source \":" + tmp + "}";
						exchange.getIn().setBody(finalStr);
						System.out.println(finalStr);
					}
				})
				// .split(body())
				// .process(new Processor() {
				//
				// @Override
				// public void process(Exchange exchange) throws Exception {
				// String tmp = exchange.getIn().getBody()
				// +
				// "{ \"index\" : { \"_index\" : \"cronos\", \"_type\" : \"employes\", \"_id\" : \""
				// + (i++) + "\" }}";
				//
				// System.out.println(tmp);
				// exchange.getIn().setBody(tmp);
				// }
				.aggregate(constant(true), new StringAggregationStrategy())
				.completionInterval(500)
				// .marshal(jackson)
				// .process(new Processor() {
				//
				// @Override
				// public void process(Exchange exchange) throws Exception {
				// List<List<String>> data = (List<List<String>>) exchange
				// .getIn().getBody();
				// for (List<String> line : data) {
				// System.out.println(line);
				// //
				// LOG.debug(String.format("%s has an IQ of %s and is currently %s",
				// // line.get(0), line.get(1), line.get(2)));
				// }
				//
				// }
				// })
				// .bindy(BindyType.Csv, MaifCSV2.class)
				// .marshal(jackson)
				// .json(JsonLibrary.Gson)

				// .unmarshal()
				// .bindy(BindyType.Csv, MaifCSV.class)
				//
				// // // .split(body(UserLigth.class))
				// // // .parallelProcessing()
				//
				// // .convertBodyTo(String.class)
				// // .json()
				//
				// // .split(body()).
				// .marshal(jackson).to("file://" + out);

				// composeRoute = from("file://" +
				// in).convertBodyTo(String.class)
				// .process(new Processor() {
				//
				// @Override
				// public void process(Exchange exchange) throws Exception {
				// System.err.println(exchange.getIn().getBody());
				//
				// }
				// }).unmarshal(buildDataCSV()).marshal().json(JsonLibrary.Gson)
				.to("file://" + out);
		//
		return composeRoute;
	}

	// simply combines Exchange String body values using '+' as a delimiter
	class StringAggregationStrategy implements AggregationStrategy {

		public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
			if (oldExchange == null) {
				return newExchange;
			}

			String oldBody = oldExchange.getIn().getBody(String.class);
			String newBody = newExchange.getIn().getBody(String.class);
			oldExchange.getIn().setBody(oldBody + "," + newBody);
			return oldExchange;
		}
	}
}
