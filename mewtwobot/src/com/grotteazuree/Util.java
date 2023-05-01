package com.grotteazuree;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {
	/**
	 * Return the number of occurences of a word in a string
	 * @param str the  complete strring to inspect at
	 * @param word the word we want to count
	 * @return the number of occurences
	 */
	public static int count(String str, String word) {
		if(str==null || word==null) {
			return 0;
		}
		int counter = 0;
		Pattern pattern = Pattern.compile(word, Pattern.MULTILINE);
		Matcher matcher = null;

		matcher = pattern.matcher(str);
		while(matcher.find()) {
			counter++;
		}
		return counter;
	}
	
	public static String de(String str) {
		String name = str.toLowerCase();
		String[] vowels = {"a", "à", "e", "é", "è", "ê", "ë", "i", "î", "ï", "o", "ô", "ö", "u", "û", "ü", "y"};
		String[] de = {"hachécateur", "hariyama", "haydaim", "heatran", "héricendre", "ho-oh", "hoopa", "hoothoot", "hotte-de-fer", "hurle-queue", "ouistempo", "ouisticram", "yanma", "yanmega", "yuyu"};
		String[] d = {"hastacuda", "hélédelle", "héliatronc", "hélionceau", "herbizarre", "hexadron", "hexagel", "hippodocus", "hippopotas", "hydragla", "hydragon", "hypnomade", "hypocéan", "hyporoi", "hypotrempe", "ymphect", "yveltal"};
		
		for (String i : de) {
			if (name.equals(i)) {
				return "de ";
			}
		}
		for (String j : d) {
			if (name.equals(j)) {
				return "d'";
			}
		}
		
		String vowel_name = name.substring(0, 1);
		
		for (String v : vowels) {
			if (vowel_name.equals(v)) {
				return "d'";
			}
		}
		
		return "de ";
	}
}
