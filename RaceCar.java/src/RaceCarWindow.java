import java.awt.Color;

public class RaceCarWindow {
	
	
	private int TrackN;
	private double FuelG = 1.0;
	private Color CarC;
	private String DriverN;
	
		public RaceCarWindow (int TrackNumber, String DriverName, Color CarColor, double FuelGauge) {
			
			
			
			TrackN = TrackNumber;
			
			DriverN = DriverName; 
			
			CarC = CarColor;
			
			FuelGauge = FuelG; 
			
			System.out.println("Do you need fuel? : " + needsFuel());
			System.out.println(" Car" + TrackNumber +"  is driven by " + DriverName + " "+ "Fuel is " + FuelG);
		}
		
		
		
		public class Crab {
			
			
			private Color crabColor; 
			private int myAge;
			
			
			
			
			public Crab(Color _crabColor, int _myAge) {
				
				
				crabColor = _crabColor;
				
				myAge = _myAge;
				
				
			
				
				
				
				
				
			for (int i =0; i < 10; i++)
				System.out.println("i")
				
				
			}
			
		}
		
		
		public static int computeAreaRec(int len, int wid) {
			return Costperitem * numnofItems ;
		}
		
		
		
		
		public class Car{
			
			
		
			
			
			
			
			
		}
		
		
		

		
		public static void main (String args[]) {
			
			//int a=1;
			RaceCarWindow car = new RaceCarWindow(1,"a",Color.red,0.1); 
			
			System.out.println(CarC);
			
		}
		
		public Color getCarC() {
			return CarC;
		}
		
		
		
		
		
		
		
		
		
		
		
		public boolean needsFuel() {
			if (FuelG <= 0.01) {
				return true;
			} else {
				return false;
			}
		}
	
		public void FillTank() {
			if (needsFuel() == true){
				FuelG = 1.0;
			}
		}

		
	
		
		
		public String getDriverName()
		{
			return DriverN;
		}
		public int getTrackNumber()
		{
			return TrackN;
		}
		public Color getCarColor()
		{
			return CarC;
		}
		public double getFuelGauge()
		{
			return FuelG;
		}
		
		
		
		
		
		
		
		
		
	}


