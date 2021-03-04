package br.com.etrust.test.models;

import java.util.ArrayList;
import java.util.List;

import br.com.etrust.test.enuns.Status;

public class Temperature {
	
	private Double value;
	private Status status;
	private static final Double COMPARE = 0.0;
	
	public Temperature(Double value) {
		this.setValue(value);
	}
	

	public Temperature() {}
	
	//generate temperature list
	public static ArrayList<Temperature> buildTemperatureList (List<Double> values){
		ArrayList<Temperature> temperatures = new ArrayList<Temperature>();
		for(Double value : values) {
			temperatures.add(new Temperature(value));
		}
		return temperatures;
	}
	
	//get value from temperature list most closer to zero
	public static Temperature getCloserToZero(ArrayList<Temperature> temperatures){
		
		Double max = Double.MAX_VALUE;
		Temperature temperature = new Temperature();

		for(Temperature tmp : temperatures) {

			if(tmp.getValue().equals(max)) {
				temperature = (tmp.getStatus() == Status.POSITIVE) ? tmp : temperature ;
				max = temperature.getValue();
			}
			else if(tmp.getValue() < max) {
			  temperature = tmp;
			  max = tmp.getValue();
			}
			
		}
		
		return temperature;
	}
	
	public Double getValue() {
		return value;
	}
	
	public Double getValuePattern() {
		return (this.getStatus() == Status.NEGATIVE) ? -1 * this.value : this.value;
	}

	public void setValue(Double value) {
		this.setStatus(value);
		this.value = Math.abs(value);
	}

	public Status getStatus() {
		return status;
	}

	private void setStatus(Double value) {
		this.status = (value > 0) ? Status.POSITIVE : Status.NEGATIVE;
	}
	
	
}

