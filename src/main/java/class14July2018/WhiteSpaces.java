package class14July2018;

public class WhiteSpaces {

	public static void main(String[] args) {

		// this sentence contains one or more whitespace between words
		// make sure there is only one white space between the words
		// for readability
		String sentence = "TestLeaf started in 2009  and we are based out             of chennai";
		String replaceAll = sentence.replaceAll("[\\s]+", " ");
		System.out.println(replaceAll);

	}

}