package WebDriver;

import java.util.HashMap;

public class DuplicateValuesWithHashMap {
	
	public static void main(String[] args)  {
		
		int ar[]= {1,2,4,6,7,9,10,3,2,1,10};
		HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
		
		for(int i=0;i<ar.length;i++) {
			hs.put(ar[i], i);
			
		}
		
		System.out.println(hs.keySet());
		
	}

}
