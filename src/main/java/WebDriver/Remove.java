package WebDriver;



public class Remove {

	public static void main(String[] args) {
		String s="saturdays";
		//StringBuilder a=new StringBuilder();
		//String a="";
		char ar[]=s.toCharArray();
		for(int i=0;i<ar.length;i++) {
			//boolean flag=false;
			for(int j=i+1;j<ar.length;j++) {
				if(ar[i]==ar[j]) {
					//flag=true;
					System.out.println(ar[i]);
					//break;
				}
//			}if(!flag) {
//				//a=a.append(ar[i]);
//				a= a + ar[i];
//			}
		}//System.out.println(a);
		
	}
	}
}


