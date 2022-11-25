import java.util.ArrayList;
import java.util.List;

public class TimeTravelingMechanism {
    private int yearOfTravel;
    int currentYear = 2022;
    public TimeTravelingMechanism(int yearOfTravel){
        this.yearOfTravel = yearOfTravel;
    }

    public TimeTravelingMechanism(){
        yearOfTravel = (int)(Math.random()*2100);
    }

    public String travelTo(int yearOfTravel) throws InterruptedException {
        int randomYear = 0;
        if(isGlitch()){
            randomYear = (int) (Math.random() * 2100);
            yearOfTravel = randomYear;
        }
        else if((yearOfTravel>=0 && yearOfTravel<=500) || (randomYear>=0 && randomYear<=500)){
            return "Rome, " +yearOfTravel;
        }
        else if(yearOfTravel>500 && yearOfTravel<=900 || (randomYear>500 && randomYear<=900)){
            return "China, " +yearOfTravel;
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

    public int rewindSequence(){
        int rewindYear = currentYear--;
        return rewindYear;
    }
    public int forwardSequence(){
        int forwardYear = currentYear++;
        return forwardYear;
    }

    public boolean isTravelingPast(){
        if(yearOfTravel < currentYear){
            return true;
        }
        return false;
    }

    public boolean isTravelingFuture(){
        if(yearOfTravel > currentYear){
            return true;
        }
        return false;
    }

    public boolean isEnoughForTransitionP(){
        if(currentYear - yearOfTravel >= 10){
            return true;
        }
        return false;
    }

    public boolean isEnoughForTransitionF(){
        if(yearOfTravel - currentYear >= 10){
            return true;
        }
        return false;
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
