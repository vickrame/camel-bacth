package com.ujoodha.config.routes;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.model.RouteDefinition;
import org.apache.camel.model.dataformat.JsonLibrary;

import com.ujoodha.config.processor.AbstractProcessor;
import com.ujoodha.utils.CamelBatchUtils;
import com.ujoodha.utils.PropertiesReader;

public class FileToFileRoute extends CustomRouteBuilder {

	private String in;
	private String out;

	@Override
	protected RouteDefinition composeRoute() {
		in = PropertiesReader.INSTANCE
				.getPropsFromKey(CamelBatchUtils.DIRECTORY_IN);
		out = PropertiesReader.INSTANCE
				.getPropsFromKey(CamelBatchUtils.DIRECTORY_OUT);

		processFin = new AbstractProcessor();

		RouteDefinition composeRoute = null;

		composeRoute = from("file://" + in).convertBodyTo(String.class)
				.process(new Processor() {

					@Override
					public void process(Exchange exchange) throws Exception {
						System.err.println(exchange.getIn().getBody());

					}
				}).unmarshal(buildDataCSV()).marshal().json(JsonLibrary.Gson)
				.to("file://" + out);

		return composeRoute;
	}

}
