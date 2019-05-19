package WindowRunner2;

import java.awt.Color;


public class WindowRunner2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
				
		for (int i =0; i< 10; i++)
		{
			
			GameWindow w = new GameWindow( 
					new Color((int)(Math.random()* 255),
						(int)(Math.random()* 255),
						(int)(Math.random()* 255)
							),	 
					(int)(Math.random() * 100) +100,
					(int)(Math.random() * 100) +100,
					(int)(Math.random() * 1000),
					(int)(Math.random() * 1000),		
					i + 1);

						
			w.setVisibility(true); 
				

			}
		}

		

	}


