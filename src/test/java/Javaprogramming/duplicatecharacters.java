package Javaprogramming;

public class duplicatecharacters {
public static void main(String[] args) {
	String a ="codoid";
	char[] s=a.toCharArray();
	
	for(int i=0;i<s.length;i++) {
		int count=1;
		for(int j=i+1;j<s.length;j++) {
			if(s[i]==s[j] ) {
				count++;
				
			}
		}
		if(count>1)
			System.out.println(s[i]+"="+count);
	}
	
}
}
