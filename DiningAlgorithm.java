import java.util.ArrayList;

public class DiningAlgorithm
{
	//The amount of points added to the point total if dining hall is compatible
	private static int MOOD_POINTS = 1;
	private static int HEALTH_POINTS = 1;
	private static int CROWD_POINTS = 1;

	//Local variables
	private int userMood;
	private int userHealthLevel;
	private int location;
	private int takeout;

	private Online online;

	private DiningHall covel;
	private DiningHall deNeve;
	private DiningHall bPlate;
	private DiningHall feast;
	private DiningHall rende;
	private DiningHall cafe19;
	private DiningHall bcafe;
	private DiningHall study;

	//Arraylist of all the dining halls
	private ArrayList<DiningHall> halls;

	public DiningAlgorithm(int userMood, int userHealthLevel, int location, int takeout)
	{
		this.userMood = userMood;
		this.userHealthLevel = userHealthLevel;
		this.location = location;
		this.takeout = takeout;
		online = new Online();
		halls = new ArrayList<DiningHall>();

		//Construct dining hall objects
		covel = new DiningHall(Constants.COVEL_NAME, Constants.COVEL_MOOD, Constants.COVEL_TAKEOUT, Constants.COVEL_HEALTH);
		deNeve = new DiningHall(Constants.DENEVE_NAME, Constants.DENEVE_MOOD, Constants.DENEVE_TAKEOUT, Constants.DENEVE_HEALTH);
		bPlate = new DiningHall(Constants.BPLATE_NAME, Constants.BPLATE_MOOD, Constants.BPLATE_TAKEOUT, Constants.BPLATE_HEALTH);
		feast = new DiningHall(Constants.FEAST_NAME, Constants.FEAST_MOOD, Constants.FEAST_TAKEOUT, Constants.FEAST_HEALTH);
		rende = new DiningHall(Constants.RENDE_NAME, Constants.RENDE_MOOD, Constants.RENDE_TAKEOUT, Constants.RENDE_HEALTH);
		cafe19 = new DiningHall(Constants.CAFE19_NAME, Constants.CAFE19_MOOD, Constants.CAFE19_TAKEOUT, Constants.CAFE19_HEALTH);
		bcafe = new DiningHall(Constants.BCAFE_NAME, Constants.BCAFE_MOOD, Constants.BCAFE_TAKEOUT, Constants.BCAFE_HEALTH);
		study = new DiningHall(Constants.STUDY_NAME, Constants.STUDY_MOOD, Constants.STUDY_TAKEOUT, Constants.STUDY_HEALTH);

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
	public DiningAlgorithm()
	{
		this.userMood = 0;
		this.userHealthLevel = 0;
		this.location = 0;
		this.takeout = 0;
		online = new Online();
		halls = new ArrayList<DiningHall>();

		//Construct dining hall objects
		covel = new DiningHall(Constants.COVEL_NAME, Constants.COVEL_MOOD, Constants.COVEL_TAKEOUT, Constants.COVEL_HEALTH);
		deNeve = new DiningHall(Constants.DENEVE_NAME, Constants.DENEVE_MOOD, Constants.DENEVE_TAKEOUT, Constants.DENEVE_HEALTH);
		bPlate = new DiningHall(Constants.BPLATE_NAME, Constants.BPLATE_MOOD, Constants.BPLATE_TAKEOUT, Constants.BPLATE_HEALTH);
		feast = new DiningHall(Constants.FEAST_NAME, Constants.FEAST_MOOD, Constants.FEAST_TAKEOUT, Constants.FEAST_HEALTH);
		rende = new DiningHall(Constants.RENDE_NAME, Constants.RENDE_MOOD, Constants.RENDE_TAKEOUT, Constants.RENDE_HEALTH);
		cafe19 = new DiningHall(Constants.CAFE19_NAME, Constants.CAFE19_MOOD, Constants.CAFE19_TAKEOUT, Constants.CAFE19_HEALTH);
		bcafe = new DiningHall(Constants.BCAFE_NAME, Constants.BCAFE_MOOD, Constants.BCAFE_TAKEOUT, Constants.BCAFE_HEALTH);
		study = new DiningHall(Constants.STUDY_NAME, Constants.STUDY_MOOD, Constants.STUDY_TAKEOUT, Constants.STUDY_HEALTH);

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

	private void calculatePoints()
	{
		for(int i = 0; i < halls.size(); i++)
		{
			//Takeout calculations
			if(takeout == 0 && halls.get(i).isTakeout() || takeout == 1 && !halls.get(i).isTakeout())
			{
				halls.remove(i);
				i--;
				continue;
			}

			//isOpen
			else if(!halls.get(i).isOpen())
			{
				halls.remove(i);
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
			if(location == 0) //if ur at covel
				halls.get(i).addPoints(Constants.COVEL_LOC[i]);
			else if(location == 1)
				halls.get(i).addPoints(Constants.HEDRICK_LOC[i]);
			else if(location == 2)
				halls.get(i).addPoints(Constants.RIEBER_LOC[i]);
			else if(location == 3)
				halls.get(i).addPoints(Constants.DENEVE_LOC[i]);
			else if(location == 4)
				halls.get(i).addPoints(Constants.SPROUL_LOC[i]);
			else if(location == 5)
				halls.get(i).addPoints(Constants.CAMPUS_LOC[i]);
			
			
		}
	}

	public String calculateDiningHall()
	{
		//The index of the dining hall with the maximum points
		int maxPointsI = 0;
		calculatePoints();

		for(int i = 0; i < halls.size(); i++)
		{
			//If another dining hall has more points, set that to the maximum dining hall
			if(halls.get(i).getPoints() > halls.get(maxPointsI).getPoints())
				maxPointsI = i;
		}

		//Return the name of the dining hall with the most points
		return halls.get(maxPointsI).getName();
	}
}