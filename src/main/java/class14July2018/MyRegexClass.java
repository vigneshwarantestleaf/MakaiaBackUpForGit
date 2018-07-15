package class14July2018;

public class MyRegexClass 
{
	public static void main(String[] args) 
	{

		/*//Replace All except Alphabets
		String text = "TestLeaf(9876) Has Number of Employees 20";
		String pattern = "\\D";
		String textRepNums = text.replaceAll("\\d", "");
		String textRepNumSc = textRepNums.replaceAll("\\W", "");
		System.out.println(textRepNumSc);*/

		/*//Replace All except Numbers
		String text = "TestLeaf(9876) Has Number of Employees 20";
		String textRepChars = text.replaceAll("\\D", "");
		String textRepCharSc = textRepChars.replaceAll("\\W", "");
		System.out.println(textRepCharSc);*/

		//Replace All except Special Characters
		String text = "TestLeaf(9876) Has Number of Employees 20";
//		String replaceAll = text.replaceAll("^\\W", "");
		
		String replaceAll =text.replaceAll("[a-zA-z0-9]", "");
		
		
		System.out.println(replaceAll);
	}
}
