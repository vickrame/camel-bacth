package com.ujoodha.config.processor;

import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

public class LogProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {

		Message in = exchange.getIn();
		Map<String, Object> headers = in.getHeaders();
		headers.forEach((clef, valeur) -> {
			System.out.println("clef " + clef + ", valeur " + valeur);
		});
		System.out.println(in.getBody());
	}

}
