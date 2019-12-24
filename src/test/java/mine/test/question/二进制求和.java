package mine.test.question;

import org.junit.Test;

public class 二进制求和 {
	@Test
	public void result() {
		String a= "1010";
		String b= "1000";
		System.out.println(addBinary( a,  b));
	}

	public String addBinary(String a, String b) {
		int length = Math.max(a.length(),b.length())+1;
		int arra[] = new int[length];
		int arrb[] = new int[length];
		int arrre[] = new int[length];
		String result="";
		ToggletoArr(a,arra);
		ToggletoArr(b,arrb);
		for(int i=0;i<length-1;i++) {
			int temp = arra[i]+arrb[i]+arrre[i];
			if(temp>=2) {
				arrre[i]=temp%2;
				arrre[i+1]=1;
			}else {
				arrre[i]=temp;
			}
		}
		for(int i = length-1;i>=0;i--) {
			if(i==length-1&&arrre[i]==0)continue;
			result=result+arrre[i];
		}
		return result;
	}
	private void ToggletoArr(String str,int[] arr) {
		for(int i=str.length()-1,j=0;i>=0;i--,j++) {
			arr[j]=(int)str.charAt(i)-48;
		}
	}
}