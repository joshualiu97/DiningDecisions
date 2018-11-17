import java.util.Scanner;

public class UserIO {
	private String mood_Question;
	private String health_Question; 
	private String loc_Question; 
	private String hunger_Question; 
	private String takeOut_Question; 
	private Scanner sc;
	public UserIO()
	{
		sc = new Scanner(System.in);
		mood_Question = "What mood are you in right now?"; //1
		health_Question = "How healthy are you feeling right now?"; //2
		loc_Question = "Where are you closest to right now?"; //3
		takeOut_Question = "Are you fine with eating at takeout places?"; //4
	}

	public int getMood()
	{
		int ans = 0; //scale out of 10 of mood, 10 being happiest
		System.out.println(mood_Question); //asks the question
		String response = sc.nextLine(); //take in the user input
		if(response.equals("happy"))
		{
			ans = 10;
		}else if(response.equals("alright"))
		{
			ans = 7;
		}else if(response.equals("meh"))
		{
			ans = 4;
		}else if(response.equals("depressed"))
		{
			ans = 0;
		}
		return ans; 
	}
	
	public int getHealthLevel()
	{
		int ans = 0; //scale out of 10 of health, 10 being feeling the most healthy
		System.out.println(health_Question);
		String response = sc.nextLine();
		if(response.equals("healthy"))
		{
			ans = 10;
		}else if(response.equals("don't care"))
		{
			ans = 5;
		}else if(response.equals("unhealthy"))
		{
			ans = 0;
		}
		return ans;
	}

	public int getLoc()
	{
		int ans = 0;
		System.out.println(loc_Question);
		String response = sc.nextLine();
		if(response.equals("covel"))
		{
			ans = 0;
		}else if(response.equals("hedrick"))
		{
			ans = 1;
		}else if(response.equals("rieber"))
		{
			ans = 2;
		}else if(response.equals("de neve"))
		{
			ans = 3;
		}else if(response.equals("sproul"))
		{
			ans = 4;
		}else if(response.equals("campus"))
		{
			ans = 5;
		}
		return ans;
	}

	public void printDiningHall()
	{
		System.out.println("You should go to " + DiningAlgorithm.calculateDiningHall());
	}
}