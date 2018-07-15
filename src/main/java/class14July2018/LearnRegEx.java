package class14July2018;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LearnRegEx {

	public static void main(String[] args) {
		String text = "TestLeaf(9876) Has Number of Employees 20";
		// System.out.println(text.replaceAll("[a-zA-Z]", ""));

		/*
		 * String pattern = "\\D"; String replaceAll = text.replaceAll("\\D", "");
		 * String replaceAll2 = replaceAll.replaceAll("\\W", "");
		 * System.out.println(replaceAll2); System.out.println(replaceAll2.substring(0,
		 * 2));
		 * 
		 * String[] split = replaceAll2.split("",3); String value = ""; int i = 0; for
		 * (String eachValue : split) { if(i<2) { //value += eachValue; value =
		 * value+eachValue; i++; } } System.out.println(value);
		 * 
		 * String text = "ABCDE1234A"; String pattern = "[A-Z]{5}[\\d]{4}[A-Z]"; Pattern
		 * p = Pattern.compile(pattern); Matcher m = p.matcher(text);
		 * System.out.println(m.matches()); String replaceAll = text.replaceAll("\\D",
		 * ""); System.out.println(replaceAll.replaceAll("\\W", "")); String replaceAll
		 * = text.replaceAll("\\w", ""); System.out.println(replaceAll);
		 */
		String text2 = "ABCDE1234A";
		String pattern = "\\d{2,4}";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(text);
		while (m.find()) {
			System.out.println(m.group());
		}

	}

}