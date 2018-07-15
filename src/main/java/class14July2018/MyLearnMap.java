package class14July2018;

import java.util.LinkedHashMap;
import java.util.Map;

public class MyLearnMap 
{
	public static void main(String[] args) 
	{

		String company = "Amazon India";
		company = company.toLowerCase();
		char[] charArray = company.toCharArray();

		Map<Character, Integer> map = new LinkedHashMap<Character,Integer>();
		
		for (char eachChar : charArray) 
		{
			System.out.println(eachChar);
			if(map.containsKey(eachChar))
			{
				map.put(eachChar, map.get(eachChar)+1);
			}
			else
			{
				map.put(eachChar, 1);
			}
		}
		System.out.println(map);
	}
}
