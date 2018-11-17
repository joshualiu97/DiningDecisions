public class DiningHall {

	private double crowdLevel;
	private boolean isOpen;

	public DiningHall(int crowdLevel, boolean isOpen){
		this.crowdLevel = crowdLevel;			
		this.isOpen = isOpen;
	}

	public double getcrowdLevel(){
		return crowdLevel;
	}

	public boolean getisOpen(){
		return isOpen;
	}
}