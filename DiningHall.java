public class DiningHall {

	private double crowdLevel;
	private boolean isOpen;
	private boolean isTakeout;
	private static int moodRating;
	private static int healthRating;
	private int points;
	private String name;

	private Online online;

	public DiningHall(String name, int crowdLevel, boolean isOpen, int moodRating, boolean isTakeout, int healthRating){
		online = new Online();

		this.crowdLevel = crowdLevel;			
		this.isOpen = isOpen;
		this.points = 0;
		this.moodRating = moodRating;
		this.isTakeout = isTakeout;
		this.healthRating = healthRating;
		this.name = name;
	}
	public DiningHall(String name, int moodRating, boolean isTakeout, int healthRating)
	{
		online = new Online();

		this.crowdLevel = online.getCrowdLevel(name);
		this.isOpen = online.isOpen(name);
		points = 0;
		this.moodRating = moodRating;
		this.isTakeout = isTakeout;
		this.healthRating = healthRating;
		this.name = name;
	}
	public DiningHall()
	{
		online = new Online();

		this.crowdLevel = 0;			
		this.isOpen = false;
		this.points = 0;
		this.moodRating = 0;
		this.isTakeout = false;
		this.healthRating = 0;
		this.name = " ";
	}

	public double getCrowdLevel(){
		return crowdLevel;
	}

	public boolean isOpen(){
		return isOpen;
	}

	public int getPoints(){
		return points;
	}

	public void addPoints(int add){
		points += add;
	}

	public int getMoodRating() {
		return moodRating;
	}

	public boolean isTakeout() {
		return isTakeout;
	}

	public int getHealthRating() {
		return healthRating;
	}

	public String getName() {
		return name;
	}
}