package com.gkehren.avaj;

import java.io.PrintWriter;
import java.io.IOException;

public class FileWriter {
	private static FileWriter instance = null;
	private static PrintWriter writer;

	private FileWriter() {
		try {
			writer = new PrintWriter("simulation.txt", "UTF-8");
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
	}

	public static FileWriter getInstance() {
		if (instance == null) {
			instance = new FileWriter();
		}
		return instance;
	}

	public void writeLine(String line) {
		writer.println(line);
	}

	public void close() {
		writer.close();
	}
}
