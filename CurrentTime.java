import java.util.Date;

public class CurrentTime {
	private int currentTime;

	public class CurrentTime(int currentTime){
		this.currentTime() = retrieveCurrentTime(); 

	}

    public String retrieveCurrentTime(){
        Date date = new Date();
        String time = date.toString();
        String t1 = time.substring(11,13) + time.substring(14,16);
        return t1;
   }

   public String geturrentTime(){
   		return currentTime();
   }
}