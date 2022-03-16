package fr.istic.vv;
import net.jqwik.api.*;

public class RomanNumeralTest {
    @Property
    boolean integerToRomanNumeral(@ForAll("integers") int integers) {
    	String roman = RomanNumeraUtils.toRomanNumeral(integers);
    	if(RomanNumeraUtils.isValidRomanNumeral(roman)) {
    		return RomanNumeraUtils.parseRomanNumeral(roman) == integers;
    	}
    	return false;
    }
    
    @Property
    boolean romanNumeralToInteger(@ForAll("RomanNumeral") String roman) {
    	if(RomanNumeraUtils.isValidRomanNumeral(roman)) {
    		int integers = RomanNumeraUtils.parseRomanNumeral(roman);
    		String res = RomanNumeraUtils.toRomanNumeral(integers);
        	return res.equals(roman) && RomanNumeraUtils.isValidRomanNumeral(res);
    	}
    	return true;
    	
    }
    
    @Provide
	Arbitrary<Integer> integers() {
		return Arbitraries.integers().between(1, 3999);
	}
    
    @Provide
	Arbitrary<String> RomanNumeral() {
    	return Arbitraries.strings().withChars(new char[] {'M','D','C','L','X','V','I'}).ofMaxLength(9);
	}
}
