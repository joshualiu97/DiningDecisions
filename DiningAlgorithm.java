import java.util.Arraylist;

public class DiningAlgorithm
{
	private static MOOD_POINTS = 1;
	private static HEALTH_POINTS = 1;
	private static CROWD_POINTS = 1;

	private int userMood;
	private int userHealthLevel;
	private int location;
	private int takeout;

	private UserIO userIO;
	private Online online;

	private DiningHall covel;
	private DiningHall deNeve;
	private DiningHall bPlate;
	private DiningHall feast;
	private DiningHall rende;
	private DiningHall cafe19;
	private DiningHall bcafe;
	private DiningHall study;

	private Arraylist<DiningHall> halls;

	public DiningAlgorithm()
	{
		userMood = 0;
		userHealthLevel = 0;
		location = 0;
		takeout = 0;
		userIO = new UserIO();
		online = new Online();
		halls = new Arraylist<DiningHall>();

		//Construct dining hall objects
		covel = new DiningHall(Constants.COVEL_NAME, Constants.COVEL_MOOD, Constants.COVEL_TAKEOUT, Constants.HEALTH);
		deNeve = new DiningHall(Constants.DENEVE_NAME, Constants.DENEVE_MOOD, Constants.DENEVE_TAKEOUT, Constants.HEALTH);
		bPlate = new DiningHall(Constants.BPLATE_NAME, Constants.BPLATE_MOOD, Constants.BPLATE_TAKEOUT, Constants.HEALTH);
		feast = new DiningHall(Constants.FEAST_NAME, Constants.FEAST_MOOD, Constants.FEAST_TAKEOUT, Constants.HEALTH);
		rende = new DiningHall(Constants.RENDE_NAME, Constants.RENDE_MOOD, Constants.RENDE_TAKEOUT, Constants.HEALTH);
		cafe19 = new DiningHall(Constants.CAFE19_NAME, Constants.CAFE19_MOOD, Constants.CAFE19_TAKEOUT, Constants.HEALTH);
		bcafe = new DiningHall(Constants.BCAFE_NAME, Constants.BCAFE_MOOD, Constants.BCAFE_TAKEOUT, Constants.HEALTH);
		study = new DiningHall(Constants.STUDY_NAME, Constants.STUDY, Constants.STUDY_TAKEOUT, Constants.HEALTH);

		//Add dining halls into the ArrayList
		halls.add(covel);
		halls.add(deNeve);
		halls.add(bPlate);
		halls.add(feast);
		halls.add(rende);
		halls.add(cafe19);
		halls.add(bcafe);
		halls.add(study);
	}

	private void getData()
	{
		userMood = userIO.getMood();
		userHealthLevel = userIO.getHealthLevel();
		location = userIO.getLoc();
		takeout = userIO.getTakeout();
	}

	private void calculatePoints()
	{
		for(int i = 0; i < halls.size(); i++)
		{
			//Takeout calculations
			if(takeout == 0 && halls.get(i).isTakeout() || takeout == 1 && !halls.get(i).isTakeout())
			{
				halls.pop(i);
				i--;
				continue;
			}

			//isOpen
			else if(!halls.get(i).isOpen())
			{
				halls.pop(i);
				i--;
				continue;
			}

			//Mood calculations
			if(halls.get(i).getMoodRating() == userMood)
				halls.get(i).addPoints(MOOD_POINTS);

			//Health calculations
			if(halls.get(i).getHealthRating() == userHealthLevel)
				halls.get(i).addPoints(HEALTH_POINTS);

			//Crowd calcualtions
			if(!halls.get(i).isTakeout())
			{
				if(halls.get(i).getCrowdLevel() >= 70)
					halls.get(i).addPoints(-CROWD_POINTS);
				else if(halls.get(i).getCrowdLevel() <= 30)
					halls.get(i).addPoints(CROWD_POINTS);
			}

			//Location calculations
			if(location == 3)
				continue;
		}
	}

	public String calculateDiningHall()
	{
		int maxPointsI = 0;

		for(int i = 0; i < halls.size(); i++)
		{
			if(halls.get(i).getPoints() > halls.get(maxPointsI).getPoints())
				maxPointsI = i;
		}

		return halls.get(maxPointsI).getName();
	}
}