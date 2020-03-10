
public class LongestSubstringWithoutRepeatingCharacters {

	  public int lengthOfLongestSubstring(String s) {
	        int max=0,curr=0; 
			char []set=new char[125];
			char[] arr=s.toCharArray();
			int length=arr.length;
			int asci=0;
			for(int i=0;i<length;i++) {
				asci=((int)arr[i])-32;
				if(set[asci]=='\u0000') {
					curr++;
					set[asci]=arr[i];
				}else {
					if(curr>max) {
						max=curr;
					}
					curr=1;
					for(int j=0;j<126;j++) {
						set[j]='\u0000';
					}
					set[asci]=arr[i];
				}
			}
			if(curr>max) {
				max=curr;
			}
			return max;       
	    }
	  
	  public static void main(String ...vars) {
		  LongestSubstringWithoutRepeatingCharacters obj=new LongestSubstringWithoutRepeatingCharacters();
		  String input=" ";
		  System.out.println(obj.lengthOfLongestSubstring(input));
	  }
}
