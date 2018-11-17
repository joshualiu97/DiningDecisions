public class DiningHall {

	private double crowdLevel;
	private boolean isOpen;
	private int points;

	public DiningHall(int crowdLevel, boolean isOpen){
		this.crowdLevel = crowdLevel;			
		this.isOpen = isOpen;
		this.points = 0;
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
}