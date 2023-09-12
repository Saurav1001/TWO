package WebDriver;

import java.util.Arrays;

public class ProductOfHighestNumber {

	public static void main(String[] args) {
		
		int ar[]= {2,1,3,8,6,5,4};
		Arrays.sort(ar);
//		for(int i=0;i<ar.length;i++) {
//			for(int j=i+1;j<ar.length;j++) {
//				if(ar[i]<ar[j]) {
//					int temp=ar[i];
//					ar[i]=ar[j];
//					ar[j]=temp;
//				}
//			}System.out.println(ar[i]);
//		}
	System.out.println(Arrays.toString(ar));
	
	int total=0;
	for(int i=0;i<ar.length;i++) {
		for(int j=i+1;j<ar.length;j++) {
			total=total + ar[i]*ar[j];
			break;
		}
	}System.out.println(total);
	
		
	}

}
