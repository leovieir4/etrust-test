package br.com.etrust.test.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.etrust.test.models.Temperature;

public class EtrustTest {

	public static void main(String[] args) {
		
		List<Double> values = Arrays.asList(17.0, 32.0, 14.0, 21.0);
		ArrayList<Temperature> tList = Temperature.buildTemperatureList(values);
		System.out.println(Temperature.getCloserToZero(tList).getValuePattern());
		
		values = Arrays.asList(27.0, -8.0, -12.0, 9.0);
		tList = Temperature.buildTemperatureList(values);
		System.out.println(Temperature.getCloserToZero(tList).getValuePattern());
		
		values = Arrays.asList(-6.0, 14.0, 42.0, 6.0, 25.0, -18.0);
		tList = Temperature.buildTemperatureList(values);
		System.out.println(Temperature.getCloserToZero(tList).getValuePattern());
		
		values = Arrays.asList(34.0, 11.0, 13.0, -23.0, -11.0, 18.0);
		tList = Temperature.buildTemperatureList(values);
		System.out.println(Temperature.getCloserToZero(tList).getValuePattern());

	}

}
