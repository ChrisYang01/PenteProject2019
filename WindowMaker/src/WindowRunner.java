import java.awt.Color;

public class WindowRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	for (int i =0; i< 100; i++)
	{
		GameWindow w = new GameWindow( 
				new Color((int)(Math.random()* 255),
						 (int)(Math.random()* 255),
						 (int)(Math.random()* 255),
						 ),
				(int)(Math.random() * 200) +100,
				(int)(Math.random() * 200) +100,
				(int)(Math.random() * 1000),
				(int)(Math.random() * 1000),		
				i + 1		
			w.setVisibility(true); 
		

	}
}

}