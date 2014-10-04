package com.monkeybusiness.android.temperatureconverter;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText temperatureToCalculate;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.temperatureToCalculate = (EditText) findViewById(R.id.temperatureToCalculate);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

	public void onClick(View view) {
		// TODO Change this mess
		switch (view.getId()) {
		case R.id.calculateTemperatureButton:
			RadioButton celsiusButton = (RadioButton) findViewById(R.id.celsiusRadio);
			RadioButton fahrenheitButton = (RadioButton) findViewById(R.id.fahrenheitRadio);
			if (temperatureToCalculate.getText().length() == 0) {
				Toast.makeText(this, "Please enter a valid number",
						Toast.LENGTH_LONG).show();
				return;
			}

			float inputValue = Float.parseFloat(temperatureToCalculate
					.getText().toString());
			if (celsiusButton.isChecked()) {
				temperatureToCalculate.setText(String
						.valueOf(TemperatureConverter
								.convertFahrenheitToCelsius(inputValue)));
				celsiusButton.setChecked(false);
				fahrenheitButton.setChecked(true);
			} else {
				temperatureToCalculate.setText(String
						.valueOf(TemperatureConverter
								.convertCelsiusToFahrenheit(inputValue)));
				fahrenheitButton.setChecked(false);
				celsiusButton.setChecked(true);
			}
			break;
		}
	}
}
