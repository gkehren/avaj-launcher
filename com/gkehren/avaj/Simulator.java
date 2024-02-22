package com.gkehren.avaj;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Simulator {

	public static class SimulatorException extends Exception {
		private static final long serialVersionUID = 1L;

		public SimulatorException() {
			super();
		}

		public SimulatorException(String message) {
			super(message);
		}

		public SimulatorException(Throwable cause) {
			super(cause);
		}
	}

	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Usage: java com.gkehren.avaj.Simulator <scenario_file>");
			System.exit(1);
		}

		String scenarioFile = args[0];

		try (BufferedReader br = new BufferedReader(new FileReader(scenarioFile))) {
			String line;
			System.out.println("Reading scenario file: " + scenarioFile);

			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			System.err.println("Error reading scenario file: " + e.getMessage());
		}
	}
}
