import java.util.ArrayList;
import java.util.List;

public class TimeTravelingMechanism {
    private int earliestTime;
    private int latestTime;

    int currentYear = 2022;
    public TimeTravelingMechanism(int yearsInPast, int yearsInFuture){
        earliestTime = currentYear - yearsInPast;
        latestTime = currentYear + yearsInFuture;
    }

    public String travelTo(int yearOfTravel) throws InterruptedException {
        int randomYear = 0;
        if(isGlitch()){
            randomYear = (int) (Math.random() * 2100);
            yearOfTravel = randomYear;
        }
        else if(yearOfTravel>=0 && yearOfTravel<=500){
            return "Rome, " +yearOfTravel;
        }

        return String.valueOf(randomYear);
    }

    public boolean isGlitch(){
        int glitchChance = (int)(Math.random()*5)+1;
        if(glitchChance == 1){
            return true;
        }
        return false;
    }

    public int rewindSequence(int yearOfTravel) throws InterruptedException {
        int rewindYear = currentYear--;
        return rewindYear;
    }
    public int forwardSequence(int yearOfTravel){
        return 10;
    }

    public String timeEvent(int yearOfTravel){
        if(yearOfTravel>=0 && yearOfTravel<=500){

        }
        return "sup";
    }

    public String swordSpearBow(int userChoice){
        int compChoice = (int)(Math.random()*3)+1;
        if (compChoice > userChoice){
            if(compChoice == 3 && userChoice == 1){
                return "Your opponent chose the Bow and you chose the Sword; Sword beats Bow\nYou win!";
            }
            else if (compChoice == 3 && userChoice == 2){
                return "Your opponent chose the Bow and you chose the Spear; Bow beats Spear\nYou lose!";
            }
            else{
                return "Your opponent chose the Spear and you chose the Sword; Spear beats Sword\nYou lose!";
            }
        }
        else if (userChoice > compChoice){
            if(userChoice == 3 && compChoice == 1){
                return "Your opponent chose the Sword and you chose the Bow; Sword beats Bow\nYou lose!";
            }
            else if (userChoice == 3 && compChoice == 2){
                return "Your opponent chose the Spear and you chose the Bow; Bow beats Spear\nYou win!";
            }
            else{
                return "Your opponent chose the Sword and you chose the Spear; Spear beats Sword\nYou win!";
            }
        }
        else{
            return "Tie";
        }
    }

    List<Integer> list = new ArrayList<Integer>();

    public List<Integer> easterEggEvents() {
        list.add(1755);
        list.add(31);
        list.add(79);
        return list;
    }
}
