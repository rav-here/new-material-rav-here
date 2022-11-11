package Maps;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapDemo {

	public static void main(String[] args) {
		/*
		 * TreeMap : Sorted Collection of key-value pairs,
		 * where keys are unique and values can be duplicate,
		 * Sorting with respect to keys.
		 */
		
		Map<String, Integer> months=new TreeMap<String, Integer>();
		
		months.put("Jan", 31);
		months.put("Feb", 28);
		months.put("Mar", 31);
		months.put("Apr", 30);
		months.put("May", 31);
		months.put("Jun", 30);
		months.put("Jul", 31);
		months.put("Aug", 31);
		
		System.out.println(months);

		months.put("Feb", 29);
		System.out.println(months);
		
		Set<String> monthNames=months.keySet();
		for(String monthName:monthNames) {
			System.out.println(monthName+" have "+months.get(monthName)+" days");
		} // sorted: alphabetical order 
	}
	

}