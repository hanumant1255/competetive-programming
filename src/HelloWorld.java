import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HelloWorld{

     public static void main(String []args){

        String line = "<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>";
        String regex = "<([^>]+)>([^<]+)<\\/\\1>";
        Pattern pattern = Pattern.compile(regex); 
        Matcher m = pattern.matcher(line); 
        boolean flag=true;
        while (m.find()) 
        { 
            System.out.println(m.group(2));   
            flag=false;      
        } 
        if(flag){
            System.out.println("None");   
		}


    }  
}