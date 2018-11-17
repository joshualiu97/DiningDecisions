import java.util.Date;
public class Online{
 
	private int currentTime;
	private int currentDay;
	private int crowdLevel;

	public class Online(int currentTime, int currentDay; int crowdLevel){
		this.currentTime = currentTime;
		this.currentDay = currentDay;
		this.crowdLevel = crowdLevel;

	}

	public bool checkOpen(int currentTime, int currentDay, String diningName){
		//gets current time using CurrentTime
		//checks if current time is in between getOpenTime() and getCloseTime()
		if (openTime <= currentTime && currentTime < closeTime) {
			return true;
		}
		return false; 
		//returns true or false
	}

	public double retrieveCrowdLevel (String diningName){
		//gets crowd level from API
		//returs crowdlevel
	}

	public String retrieveCurrentTime(){
        Date date = new Date();
        String time = date.toString();
        String t1 = time.substring(11,13) + time.substring(14,16);
        return t1;
   }

   public int retrieveCurrentDay() {
 
        Date now = new Date();
 
        /*SimpleDateFormat simpleDateformat = new SimpleDateFormat("E"); // the day of the week abbreviated
        System.out.println(simpleDateformat.format(now));
 
        simpleDateformat = new SimpleDateFormat("EEEE"); // the day of the week spelled out completely
        System.out.println(simpleDateformat.format(now));*/
 
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        //System.out.println(day); // the day of the week in numerical format
        return day;
    }

   public String getCurrentTime(){
   		return currentTime;
   }

   public int getCurrentDay(){
   		return currentDay;

   }

   public String getCrowdLevel(){
   		return crowdlevel;
   }

}