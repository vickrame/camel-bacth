/**
 * 
 */
package com.ujoodha.config.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.csv.CsvDataFormat;
import org.apache.camel.model.ProcessorDefinition;
import org.apache.camel.spi.DataFormat;

import com.ujoodha.config.processor.AbstractProcessor;

/**
 * @author vickrame
 *
 */
public abstract class CustomRouteBuilder extends RouteBuilder {

	protected volatile boolean jobFinish = false;
	protected AbstractProcessor processFin = null;
	private int countError = 0;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.camel.builder.RouteBuilder#configure()
	 */
	@Override
	public void configure() throws Exception {
		try {
			terminateRoute();
		} catch (Exception e) {
			e.printStackTrace();
			countError++;
			throw e;
		}

	}

	/**
	 * @return the jobFinish
	 */
	public boolean isJobFinish() {
		return jobFinish;
	}

	/**
	 * @param jobFinish
	 *            the jobFinish to set
	 */
	public void setJobFinish(boolean jobFinish) {
		this.jobFinish = jobFinish;
	}

	/**
	 * @return the processFin
	 */
	public AbstractProcessor getProcessFin() {
		return processFin;
	}

	protected abstract ProcessorDefinition composeRoute() throws Exception;

	private void terminateRoute() throws Exception {
		ProcessorDefinition defineRoute = composeRoute();

		defineRoute.process(traceProcess()).end();

		System.out.println("fin construction de la route");
	}

	/**
	 * 
	 */
	protected AbstractProcessor traceProcess() {
		processFin = new AbstractProcessor();
		return processFin;
	}

	protected DataFormat buildDataCSV() {
		final CsvDataFormat format = new CsvDataFormat();
		format.setUseMaps(true);
		format.setHeader(new String[] { "IDPLANB_DM", "NEMP", "LPRNEMP",
				"LNOMEMP", "CEMP", "LEMP", "CTYPCNT", "LTYPCNT", "CUTR",
				"LUTR", "CEQP", "LEQP", "CSEC", "LSEC", "CENT", "LENT",
				"NEMPMGRENT", "CTYPENT", "LTYPENT", "CREG", "LREG", "CFIL",
				"LFIL", "DDEBVAL", "DFINVAL", "DMAJENR", "HMAJENR", "CFLUAUD",
				"DFINCNT" });
		format.setHeaderDisabled(true);
		format.setDelimiter(';');
		return format;
	}

	/**
	 * @return the countError
	 */
	public int getCountError() {
		return countError;
	}

}
