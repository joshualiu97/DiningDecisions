import java.util.Date;

public class CurrentTime {

    public String getCurrentTime(){

        Date date = new Date();

        String time = date.toString();
    
        String t1 = time.substring(11,13) + time.substring(14,16);

        return t1;
   }
}