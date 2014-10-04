package com.monkeybusiness.android.temperatureconverter;

public class TemperatureConverter {

	public static float convertFahrenheitToCelsius(float fahrenheit) {
		float celsius = ((fahrenheit - 32) * 5 / 9); 
		return celsius;
	}

	public static float convertCelsiusToFahrenheit(float celsius) {
		float fahrenheit = ((celsius * 9) / 5) + 32; 
		return fahrenheit;
	}
}
