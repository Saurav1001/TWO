package WebDriver;

public class SmallerAdjacentRightNumber {

	public static void main(String[] args) {
		int ar[]= {1,2,4,3,5,2,0,3,1,7,5};
		

		for(int i=0;i<ar.length;i++) {
			for(int j=i+1;j<ar.length;) {
				if(ar[i]>ar[j]) {
					System.out.println(ar[i]);
					
				}break;
			}
			
		}
		

	}

}
