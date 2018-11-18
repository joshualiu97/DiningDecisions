import java.util.Date;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

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

	public int retrieveCrowdLevel (String diningName) throws Exception {

  String url = "https://api.bruin-bite.com/api/v1/menu/ActivityLevels/";

  URL obj = new URL(url);
  HttpURLConnection con = (HttpURLConnection) obj.openConnection();

  // optional default is GET
  con.setRequestMethod("GET");

  int responseCode = con.getResponseCode();
  //System.out.println("\nSending 'GET' request to URL : " + url);
  //System.out.println("Response Code : " + responseCode);

  BufferedReader in = new BufferedReader(
  new InputStreamReader(con.getInputStream()));
  String inputLine;
  StringBuffer response = new StringBuffer();

  while ((inputLine = in.readLine()) != null) {
      response.append(inputLine);
  }
  in.close();

  //print result
  String allActivityLevels = response.toString();
  //System.out.println(allActivityLevels);

  // Covel Activity Level
  int covelIndex = allActivityLevels.indexOf("\"Covel\": ");
  int i = 0;
  while (Character.isDigit(allActivityLevels.charAt(covelIndex + 10 + i))) {
      i++;
  }
  String covelActivityLevel;
  if (i == 0) {
       covelActivityLevel = "-1";
  }
  else {
      covelActivityLevel = allActivityLevels.substring(covelIndex + 10,covelIndex + 10 + i);
  }
  int covel = Integer.parseInt(covelActivityLevel);
  //System.out.println(covel);

  // De Neve Activty Level
  int deNeveIndex = allActivityLevels.indexOf("\"De Neve\": ");
  int j = 0;
  while (Character.isDigit(allActivityLevels.charAt(deNeveIndex + 12 + j))) {
      j++;
  }
  String deNeveActivityLevel;
  if (j == 0) {
       deNeveActivityLevel = "-1";
  }
  else {
      deNeveActivityLevel = allActivityLevels.substring(deNeveIndex + 12,deNeveIndex + 12 + j);
  }
  int deNeve = Integer.parseInt(deNeveActivityLevel);
  //System.out.println(deNeve);

  // Bruin Plate Activty Level
  int bPlateIndex = allActivityLevels.indexOf("\"Bruin Plate\": ");
  int k = 0;
  while (Character.isDigit(allActivityLevels.charAt(bPlateIndex + 16 + k))) {
      k++;
  }
  String bPlateActivityLevel;
  if (k == 0) {
       bPlateActivityLevel = "-1";
  }
  else {
      bPlateActivityLevel = allActivityLevels.substring(bPlateIndex + 16,bPlateIndex + 16 + k);
  }
  int bPlate = Integer.parseInt(bPlateActivityLevel);
  //System.out.println(bPlate);

  // Feast Activity Level
  int feastIndex = allActivityLevels.indexOf("\"FEAST at Rieber\": ");
  int l = 0;
  while (Character.isDigit(allActivityLevels.charAt(feastIndex + 20 + l))) {
      l++;
  }
  String feastActivityLevel;
  if (l == 0) {
       feastActivityLevel = "-1";
  }
  else {
      feastActivityLevel = allActivityLevels.substring(feastIndex + 20,feastIndex + 20 + l);
  }
  int feast = Integer.parseInt(feastActivityLevel);
  //System.out.println(feast);

  if (diningName == COVEL_NAME) {
    return covel;
  }
  if (diningName == DENEVE_NAME) {
    return deNeve;
  }
  if (diningName == BPLATE_NAME) {
    return bPlate;
  }
  if (diningName == FEAST_NAME) {
    return feast;
  }
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