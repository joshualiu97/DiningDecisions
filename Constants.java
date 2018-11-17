public class Constants
{
	//Number of dining halls
	public static final int NUM_DINING_HALLS	= 8;

	//Dining hall names
	public static final String COVEL_NAME 		= "Covel";
	public static final String DENEVE_NAME		= "De Neve";
	public static final String BPLATE_NAME 		= "Bruin Plate";
	public static final String FEAST_NAME 		= "Feast";
	public static final String RENDE_NAME 		= "Rendevous";
	public static final String CAFE19_NAME 		= "Cafe 1919";
	public static final String BCAFE_NAME 		= "Bruin Cafe";
	public static final String STUDY_NAME 		= "The Study at Hedrick";

	//Health levels
	//Lower number = unhealthy, higher unmber = healthy
	public static final int COVEL_HEALTH 		= 0; //0
	public static final int DENEVE_HEALTH 		= 0; //1
	public static final int BPLATE_HEALTH 		= 2; //7
	public static final int FEAST_HEALTH 		= 1; //4
	public static final int RENDE_HEALTH 		= 1; //2
	public static final int CAFE19_HEALTH 		= 1; //3
	public static final int BCAFE_HEALTH 		= 2; //5
	public static final int STUDY_HEALTH 		= 2; //6

	//Takeout or not
	//true = is takeout, false = not takeout
	public static final boolean COVEL_TAKEOUT	= false;
	public static final boolean DENEVE_TAKEOUT 	= false;
	public static final boolean BPLATE_TAKEOUT 	= false;
	public static final boolean FEAST_TAKEOUT 	= false;
	public static final boolean RENDE_TAKEOUT	= true;
	public static final boolean CAFE19_TAKEOUT 	= true;
	public static final boolean BCAFE_TAKEOUT 	= true;
	public static final boolean STUDY_TAKEOUT 	= true;

	//Mood
	//higher number, what will make you feel the happiest
	public static final int COVEL_MOOD 			= 3; //7
	public static final int DENEVE_MOOD			= 2; //5
	public static final int BPLATE_MOOD 		= 2; //4
	public static final int FEAST_MOOD 			= 3; //6
	public static final int RENDE_MOOD 			= 1; //3
	public static final int CAFE19_MOOD 		= 1; //2
	public static final int BCAFE_MOOD 			= 0; //0
	public static final int STUDY_MOOD 			= 0; //1

	//location stats  
	public static final int[] COVEL_LOC = new int[]{8,2,3,5,4,6,7,1}; //covel, deneve, bplate, Feast, Rende, 1919, bcaf, Hedrick
	public static final int[] HEDRICK_LOC = new int[]{3,1,2,6,7,5,4,8}; //covel, deneve, bplate, Feast, Rende, 1919, bcaf, Hedrick
	public static final int[] RIEBER_LOC = new int[]{3,1,2,7,8,5,4,6}; //covel, deneve, bplate, Feast, Rende, 1919, bcaf, Hedrick
	public static final int[] DENEVE_LOC = new int[]{4,8,7,2,3,6,5,1}; //covel, deneve, bplate, Feast, Rende, 1919, bcaf, Hedrick
	public static final int[] SPROUL_LOC = new int[]{5,4,8,2,3,6,7,1}; //covel, deneve, bplate, Feast, Rende, 1919, bcaf, Hedrick
	public static final int[] CAMPUS_LOC = new int[]{5,8,7,2,3,4,6,1}; //covel, deneve, bplate, Feast, Rende, 1919, bcaf, Hedrick

}