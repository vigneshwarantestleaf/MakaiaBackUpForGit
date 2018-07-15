package class14July2018;

public class First7D {

	public static void main(String[] args) {

		String sentence = "C7329DH23J9399K282";
		String replaceAll = sentence.replaceAll("\\D", "");
		//System.out.println(replaceAll.substring(0, 7));
		String[] split = replaceAll.split("",8);
		for (int i = 0; i < split.length; i++) {
			System.out.println(split[i]);
		}/**/
		
	}

}