import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Find_pair_of_k_difference {

    public static void main(String [] arags){


        int [] arr={5,3,2,2,3,6,8,9};
        //2,3,5,6,8,9
        int len=arr.length;
        int k=3;
        int result=0;
        char diff_arr[]=new char[10000];
        for(int i=0;i<len;i++){
            diff_arr[arr[i]]='t';
        }
        for(int i=0;i<len;i++){
            if((arr[i]-k)>0 && diff_arr[arr[i]-k]=='t'){
               diff_arr[arr[i]-k]='f';
                result++;
            }else  if(diff_arr[arr[i]+k]=='t'){
                diff_arr[arr[i]+k]='f';
                result++;
            }


        }
        System.out.println(result);

    }
}