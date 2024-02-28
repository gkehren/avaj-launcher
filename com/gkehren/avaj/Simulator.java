package com.gkehren.avaj;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Simulator {

	private static int simulationSteps;
	private static WeatherTower weatherTower;
	private static FileWriter writer = FileWriter.getInstance();

	private Simulator() {}

	private void parseFile(String scenarioFile) throws SimulatorException {
		try (BufferedReader reader = new BufferedReader(new FileReader(scenarioFile))) {
			String line = reader.readLine();
			if (line == null) {
				throw new SimulatorException("Scenario file is empty");
			}

			simulationSteps = Integer.parseInt(line);
			if (simulationSteps < 0) {
				throw new SimulatorException("Invalid number of simulation steps: " + simulationSteps);
			}

			weatherTower = new WeatherTower();
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(" ");
				if (parts.length != 5) {
					throw new SimulatorException("Invalid scenario line: " + line);
				}

				AircraftFactory.newAircraft(parts[0], parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4])).registerTower(weatherTower);
			}
			reader.close();
		} catch (IOException e) {
			throw new SimulatorException(e);
		}
	}

	private void runSimulation() {
		for (int i = 0; i < simulationSteps; i++) {
			//writer.writeLine("\n\t --- Simulation step " + (i + 1) + " of " + simulationSteps + " ---");
			weatherTower.changeWeather();
		}
	}

	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Usage: java com.gkehren.avaj.Simulator <scenario-file>");
			System.exit(1);
		}

		try {
			Simulator simulator = new Simulator();
			simulator.parseFile(args[0]);
			simulator.runSimulation();
		} catch (SimulatorException e) {
			System.err.println("Error: " + e.getMessage());
			System.exit(1);
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			System.exit(1);
		} finally {
			writer.writeLine("\n\t --- Simulation ended. ---");
			writer.close();
		}
	}
}
