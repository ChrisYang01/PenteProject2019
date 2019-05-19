import java.util.Scanner;

public class read {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner (System.in);
		
		//Ask the user for text 
		System.out.println("Type in your String or text");
		String input = in.nextLine();
		
		for (int i = 1; i < input.length(); i += 2) {
			
			

			input.charAt(i);
			
			System.out.println("The second letter of every string is " + input.charAt(i));
		}
	}
	
}	
			
		
		
		
		
		
