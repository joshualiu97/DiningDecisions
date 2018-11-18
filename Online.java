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

	public static boolean checkIsOpen(int currentTime, int currentDay, String diningName){
        switch (currentDay){
            case 2 :
            case 3 :
            case 4 :
            case 5 :
            case 6 :
                if (diningName.equals(COVEL_NAME)){
                    if ((currentTime >= 1200 && currentTime < 1500) || (currentTime >= 1700 && currentTime < 2100)) {
                        return true;
                    } else {
                        return false;
                    }
                } else if (diningName.equals(DENEVE_NAME)){
                    if ((currentTime >= 700 && currentTime < 1000) || (currentTime >= 1100 && currentTime < 1400) || (currentTime >= 1700 && currentTime < 2000)){
                        return true;
                    } else if ((currentTime >= 2100 && currentTime <= 2359) || (currentTime >= 0 && currentTime <= 100)){
                        return true;
                    } else {
                        return false;
                    }
                } else if (diningName.equals(BPLATE_NAME)){
                    if ((currentTime >= 700 && currentTime < 900) || (currentTime >= 1100 && currentTime < 1400) || (currentTime >= 1700 && currentTime < 2000)) {
                        return true;
                    } else {
                        return false;
                    }
                } else if (diningName.equals(FEAST_NAME)) {
                    if ((currentTime >= 1000 && currentTime < 1400) || (currentTime >= 1700 && currentTime < 2000)) {
                        return true;
                    } else {
                        return false; 
                    }
                } else if (diningName.equals(RENDE_NAME)) {
                    if ((currentTime >= 700 && currentTime < 1030) || (currentTime >= 1130 && currentTime < 1600) || (currentTime >= 1700 && currentTime < 2359)) {
                        return true;
                    } else {
                        return false;
                    }
                } else if (diningName.equals(CAFE19_NAME)) {
                    if ((currentTime >= 1100 && currentTime < 2359)) {
                        return true;
                    } else {
                        return false; 
                    }
                } else if (diningName.equals(BCAFE_NAME)) {
                    if ((currentTime >= 700 && currentTime <= 2359)) {
                        return true;
                    } else {
                        return false;
                    }
                } else if (diningName.equals(STUDY_NAME)) {
                    if ((currentTime >= 1100 && currentTime < 430) ){
                        return true;
                    } else {
                        return false;
                    }
                }
                break;
            case 1 :
            case 7 :
                if (diningName.equals(COVEL_NAME)){
                    if ((currentTime >= 930 && currentTime < 1500) || (currentTime >= 1700 && currentTime < 900)) {
                        return true;
                    } else {
                        return false;
                    }
                } else if (diningName.equals(DENEVE_NAME)){
                    if ((currentTime >= 700 && currentTime < 1400) || (currentTime >= 1700 && currentTime < 2000) ){
                        return true;
                    } else if ((currentTime >= 2100 && currentTime < 2359) || (currentTime >= 0000 && currentTime < 100)){
                        return true;
                    }else {
                        return false;
                    }
                } else if (diningName.equals(BPLATE_NAME)){
                    if ((currentTime >= 1000 && currentTime < 1400) || (currentTime >= 1700 && currentTime < 2000)) {
                        return true;
                    } else {
                        return false;
                    }
                } else if (diningName.equals(FEAST_NAME)) {
                    return false;
                } else if (diningName.equals(RENDE_NAME)) {
                    if ((currentTime >= 1000 && currentTime < 1400) || (currentTime >= 1700 && currentTime < 2000)) {
                        return true;
                    } else {
                        return false; 
                    }
                } else if (diningName.equals(CAFE19_NAME)) {
                    return false;
                } else if (diningName.equals(BCAFE_NAME)) {
                    if ((currentTime >= 1600 && currentTime < 2100)) {
                        return true;
                    } else {
                        return false;
                    }
                } else if (diningName.equals(STUDY_NAME)) {
                    if ((currentTime >= 1100 && currentTime < 1630) || (currentTime >= 1700 && currentTime < 2100)){
                        return true;
                    } else if ((currentTime >= 2100 && currentTime < 2359) || (currentTime >= 0 && currentTime < 200)) {
                        return true;
                    }else {
                        return false;
                    }
                }
                break;
        }
    return false;
    }

	public int retrieveCrowdLevel (String diningName){
		
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