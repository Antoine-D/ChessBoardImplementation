import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Driver 
{
	public static void main(String[] args)
	{			
		while(true)
		{
		    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		    System.out.print("Opponents Move : ");
		    String username = null;
		    try {
		        username = reader.readLine();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		    System.out.println("My Move : " + username);
		}
	}
}
