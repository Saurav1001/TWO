package WebDriver;

import java.util.HashMap;
import java.util.Set;

public class StringCount {
	public static void main(String[] args) throws Exception{
		String str="java is the best lang we have we is java";
		String ar[]=str.split(" ");
		HashMap<String, Integer> hs= new HashMap<String, Integer>();
		
		for(String e : ar) {
			if(hs.containsKey(e)) {
				hs.put(e, hs.get(e)+1);
			}else
				hs.put(e, 1);
		}
		
		Set<String> it=hs.keySet();
		for(String w : it) {
			
			if(hs.get(w)>1)
			
				System.out.println(w + " : "+ hs.get(w));
			
		}
		
		
		}

}
