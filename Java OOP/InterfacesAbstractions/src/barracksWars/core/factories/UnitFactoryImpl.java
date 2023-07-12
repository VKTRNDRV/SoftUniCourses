package barracksWars.core.factories;

import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;
import barracksWars.models.units.AbstractUnit;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"barracksWars.models.units.";

	@Override
	@SuppressWarnings({"rawtypes", "unchecked"})
	public Unit createUnit(String unitType)
			throws ExecutionControl.NotImplementedException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
		Class unitClass = Class.forName(UNITS_PACKAGE_NAME + unitType);
		Constructor<? extends Unit> constructor = unitClass.getDeclaredConstructor();
		Unit unit = constructor.newInstance();
		return unit;
	}
}
