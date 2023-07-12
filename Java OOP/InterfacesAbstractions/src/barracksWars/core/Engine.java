package barracksWars.core;

import barracksWars.core.commands.Command;
import barracksWars.interfaces.*;
import barracksWars.interfaces.Runnable;
import jdk.jshell.spi.ExecutionControl;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {

	private Repository repository;
	private UnitFactory unitFactory;

	public Engine(Repository repository, UnitFactory unitFactory) {
		this.repository = repository;
		this.unitFactory = unitFactory;
	}

	@Override
	public void run()
			throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		while (true) {
			try {
				String input = reader.readLine();
				String[] data = input.split("\\s+");
				String commandName = data[0];
				String result = interpretCommand(data, commandName);
				if (result.equals("fight")) {
					break;
				}
				System.out.println(result);
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			} catch (IOException | ExecutionControl.NotImplementedException e) {
				e.printStackTrace();
			}
		}
	}

	// TODO: refactor for problem 4
	private String interpretCommand(String[] data, String commandName)
			throws ExecutionControl.NotImplementedException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
		String commandClassName = commandName.substring(0, 1).toUpperCase() +
				commandName.substring(1) +
				"Command";
		Class<Command> commandClass =
				(Class<Command>) Class.forName("barracksWars.core.commands." + commandClassName);
		Constructor<Command> ctor = commandClass
				.getDeclaredConstructor(String[].class, Repository.class, UnitFactory.class);
		ctor.setAccessible(true);
		Command command = ctor.newInstance(data, this.repository, this.unitFactory);
		return command.execute();

//		String result;
//		switch (commandName) {
//			case "add":
//				result = this.addUnitCommand(data);
//				break;
//			case "report":
//				result = this.reportCommand(data);
//				break;
//			case "fight":
//				result = this.fightCommand(data);
//				break;
//			case "retire":
//				result = this.retireCommand(data);
//				break;
//			default:
//				throw new RuntimeException("Invalid command!");
//		}
//		return result;

	}

//	private String retireCommand(String[] data) {
//		String unitType = data[1];
//		try {
//			this.repository.retireUnit(unitType);
//			return unitType + " retired!";
//		} catch (IllegalStateException e) {
//			return e.getMessage();
//		}
//	}
//
//	private String reportCommand(String[] data) {
//		String output = this.repository.getStatistics();
//		return output;
//	}
//
//	private String addUnitCommand(String[] data)
//			throws ExecutionControl.NotImplementedException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
//		String unitType = data[1];
//		Unit unitToAdd = this.unitFactory.createUnit(unitType);
//		this.repository.addUnit(unitToAdd);
//		String output = unitType + " added!";
//		return output;
//	}
//
//	private String fightCommand(String[] data) {
//		return "fight";
//	}
}
