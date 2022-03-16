package fr.istic.vv;

import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanNumeraUtils {
    
        public static boolean isValidRomanNumeral(String value) {
		Pattern pattern = Pattern.compile("^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");

		return pattern.matcher(value).matches();
	}

	public static int parseRomanNumeral(String numeral) {
		int res = 0;
		if (isValidRomanNumeral(numeral)) {
			Integer prev = null;
			for (char c : numeral.toCharArray()) {
				int current;
				switch (c) {
				case 'M':
					current = 1000;
				case 'D':
					current = 500;
				case 'C':
					current = 100;
				case 'L':
					current = 50;
				case 'X':
					current = 10;
				case 'V':
					current = 5;
				case 'I':
					current = 1;
				default:
					current = 0;
				}
				res += (prev != null && current > prev)? current - 2 * prev : current;
				prev = current;
			}
		}else {
			res = -1;
		}
		return res;
	}

	public static String toRomanNumeral(int number) {
		TreeMap<Integer, String> map = new TreeMap<Integer, String>();
		map.put(1000, "M");
		map.put(900, "CM");
		map.put(500, "D");
		map.put(400, "CD");
		map.put(100, "C");
		map.put(90, "XC");
		map.put(50, "L");
		map.put(40, "XL");
		map.put(10, "X");
		map.put(9, "IX");
		map.put(5, "V");
		map.put(4, "IV");
		map.put(1, "I");
		
		String res = "";
		if (number > 0 && number < 4000) {
			int l = map.floorKey(number);
			res = (number == l)? map.get(number) : map.get(l) + toRomanNumeral(number - l);
		}
		return res;
	}
    
}
