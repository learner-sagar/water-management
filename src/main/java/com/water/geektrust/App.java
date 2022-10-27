package com.water.geektrust;

import com.water.geektrust.appConfig.ApplicationConfig;
import com.water.geektrust.commands.CommandInvoker;
import com.water.geektrust.exceptions.CommandNotFoundException;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class App {

	public static void main(String[] args) {
		List<String> commandLineArgs = new ArrayList<>(Arrays.asList(args));
		run(commandLineArgs);
	}

	public static void run(List<String> commandLineArgs) {
		ApplicationConfig applicationConfig = new ApplicationConfig();
		CommandInvoker commandInvoker = applicationConfig.getCommandInvoker();
		BufferedReader reader;
		String inputFile = commandLineArgs.get(0);
		try {
			reader = new BufferedReader(new FileReader(inputFile));
			String line = reader.readLine();
			while (line != null) {
				List<String> tokens = Arrays.asList(line.split(" "));
				commandInvoker.executeCommand(tokens.get(0),tokens);
				// read next line
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException | CommandNotFoundException e) {
			e.printStackTrace();
		}
	}

}