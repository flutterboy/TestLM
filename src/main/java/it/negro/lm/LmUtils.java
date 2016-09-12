package it.negro.lm;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public final class LmUtils {

	private LmUtils(){}
	
	public static Double roundUp05(Double number){
		Double result = Math.round(number * 100) / 100.0;
		
		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		symbols.setDecimalSeparator('.');
		symbols.setGroupingSeparator(',');
		DecimalFormat format = new DecimalFormat("0.00", symbols);
		String cString = format.format(result);
		String[] parts = cString.split("\\.");
		Integer intPortion = Integer.parseInt(parts[0]);
		Double decimalPortion = Double.parseDouble("0." + parts[1]);
		
		Double last = Double.parseDouble("0.0" + parts[1].substring(1));
		
		Double toAdd = 0.0;
		if (last != 0.05 && last != 0.00){
			if (last <= 0.05)
				toAdd = 0.05 - last;
			else
				toAdd = 0.1 - last;
		}
		result = intPortion + decimalPortion + toAdd;
		result = Math.round(result * 100) / 100.0;
		return result;
	}
	
}
