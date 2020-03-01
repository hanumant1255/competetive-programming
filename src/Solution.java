import java.util.*;

public class Solution {

    public static boolean canWin(int leap, int[] game) {
         int n =game.length;
         int k=0;
        for (int i = 0; i < n; i++) {
        	if(leap>1) {
        	k=i+leap;
        	while(k<n && k>=0 && game[k]==0) {
        	  if((k+leap)>=n) {
        		 return true; 
        	  }
        	  if((k+leap)<n && game[k+leap]==0) {
        		  k+=leap;
        	  }else if((k-1)>0 && game[k-1]==0) {
        		  k-=1;
        	  }else if((k+1)<n && game[k+1]==0) {
        		  k+=1;
        	  }else {
        		  break;
        	  }    	        		
        	}  
        	}
            if(i<n-1 && game[i+1]==0){
                return false;
            }        
        }
        return false;        
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();
            
            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}

