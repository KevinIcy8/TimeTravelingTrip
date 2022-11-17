import java.util.ArrayList;
import java.util.List;

public class TimeTravelingMechanism {
    private int earliestTime;
    private int latestTime;

    public TimeTravelingMechanism(int earliestTime, int latestTime){
        this.earliestTime = earliestTime;
        this.latestTime = latestTime;
    }
    int currentYear = 2022;
    public String travelTo(int timePeriod){
        int randomYear = 0000;
        if(isGlitch()){
            randomYear = (int)(Math.random()*2100)+0;
        }
        else if (timePeriod >= earliestTime && timePeriod <= latestTime){
            randomYear = (int)(Math.random()*100)+timePeriod;
        }
        else{
            return "The time was beyond the watch's system.";
        }
        return String.valueOf(randomYear);
    }

    public boolean isGlitch(){
        int chance = (int)(Math.random()*2)+1;
        if(chance == 1){
            return true;
        }
        return false;
    }

    List<Integer> list = new ArrayList<Integer>();

    public List<Integer> listYears() {
        list.add(1755);
        return list;
    }
}
