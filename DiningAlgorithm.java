public class DiningAlgorithm
{
	private int userMood;
	private int userHealthLevel;
	private int location;
	private int takeOut;
	private UserIO userIO;

	public DiningAlgorithm()
	{
		userMood = 0;
		userHealthLevel = 0;
		location = 0;
		takeOut = 0;
		userIO = new UserIO();
	}

	public void getData()
	{
		userMood = userIO.getMood();
		userHealthLevel = userIO.getHealthLevel();
		location = userIO.getLoc();
		takeOut = userIO.getTakeout();
	}

	public String calculateDiningHall()
	{
		
	}
}