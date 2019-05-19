
package carjava;

import java.util.Scanner;

public class Car {

    public static void main(String[] args) {

		Scanner s = new Scanner(System.in); 
		System.out.println("Welcome to the car calculator program");
		System.out.println("Enter the number of gallons of gas in your tank");
		System.out.println("Enter the fuel efficiency of your vehicle in miles per gallon");
		System.out.println("Enter your price of gas per gallon");
		
		boolean done = false;
		
		/*String response = s.nextLine();
		String response1 = s.nextLine();
		String response2 = s.nextLine();*/
		
		double gasintank; 
		double fuelEfficiency;
		double priceofgas;
		
		gasintank = getDouble("What is the gas in your tank?", s);
		fuelEfficiency = getDouble("What is the MPG?", s);
		priceofgas = getDouble("What is the price per gallon?", s);
		
		double costper100miles = (priceofgas/fuelEfficiency) * 100; 
		double howfarcar = (fuelEfficiency * gasintank);
		
		System.out.println("Your cost per 100 miles is $" + costper100miles ); 
		System.out.println("You can travel " + howfarcar + " miles");
		
    }	

	public static double getDouble (String question, Scanner cScanner)
	{
		
		double theNumber = -1.0;
		boolean done = false;
		System.out.println( question );
		
		while(!done)
		{
			try {
				
				String stuffComingIn = cScanner.nextLine();
				
				theNumber = Double.parseDouble(stuffComingIn);
				
				if(theNumber <= 0.0) {
					System.out.println("Please enter a positive number");
				} else {
					done = true; 
				}
					
                } catch(Exception error)   {
					
					System.out.println("I'm sorry I needed a number, try again or type to quit ");
					System.out.println(error.toString()); 
				
				}
				
			}
		
			return theNumber;
		}	
	
            

		
	}	

	


