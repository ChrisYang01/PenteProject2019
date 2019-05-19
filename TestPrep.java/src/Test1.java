
public class Test1 {
	
	public static void main(String[] args) {
	
	System.out.println("John said, \" I don't want to go!\"");

	
	
	String [] people = {"Ryan", "Chris", "Sarah", "Felicity", "Jackie", "Will", "Nick", "David", "Paula", "Julian", "Andrew"};
	
	int[] whichSport = {0,1,2,3,1,0,2,3,1,2,1};
	
	System.out.println("\t\tName\t\tSport");
	System.out.println("\t\t_____\t\t______"); 
	for (int i = 0; i< people.length ; i++) {
		System.out.println("\t\t"+people[i]+"\t\t"+ sports[whichSport[i]]);
	}
	
	
	}

}