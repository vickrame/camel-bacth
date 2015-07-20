package com.ujoodha.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.stream.Stream;

public enum PropertiesReader {

	INSTANCE();

	private PropertiesReader() {
	}

	private Properties map;

	public void initialyse(final String filePath) {
		map = new Properties();
		readProperties(filePath);
	}

	private void readProperties(final String filePath) {

		BufferedReader bufferReader = null;
		FileReader reader = null;
		Stream<String> stream = null;
		File f = new File(filePath);

		if (!f.exists()) {
			throw new RuntimeException("Fichier de configuration absent");
		}

		try {
			reader = new FileReader(f);

			bufferReader = new BufferedReader(reader);

			stream = bufferReader.lines();

			stream.filter(p -> {
				// System.out.println(p);
					if ((p.indexOf('#') == -1) && !p.trim().equals("")) {
						return true;
					} else
						return false;
				}).forEach(p -> {
				String tab[] = p.split("=");
				map.put(tab[0], tab[1]);
			});

		} catch (IOException ioEx) {

		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				if (bufferReader != null) {
					bufferReader.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (stream != null) {
				stream.close();
			}
		}

	}

	public String getPropsFromKey(final String clef) {
		return (String) map.get(clef);
	}
}
