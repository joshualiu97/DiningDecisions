public class DiningHall {

	private double crowdLevel;
	private boolean isOpen;
	private boolean isTakeout;
	private int moodRating;
	private int healthRating;
	private int points;

	public DiningHall(int crowdLevel, boolean isOpen, int moodRating, boolean isTakeout, int healthRating){
		this.crowdLevel = crowdLevel;			
		this.isOpen = isOpen;
		this.points = 0;
		this.moodRating = moodRating;
		this.isTakeout = isTakeout;
		this.healthRating = healthRating;
	}

	public double getcrowdLevel(){
		return crowdLevel;
	}

	public boolean getisOpen(){
		return isOpen;
	}

	public int getpoints(){
		return points;
	}

	public int addPoints(int add){
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
}