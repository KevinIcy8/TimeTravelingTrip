import java.util.Scanner;
public class TimeTravelingRun {
    public static void main(String[] args) throws InterruptedException {
        Scanner s = new Scanner(System.in);
        System.out.print("Welcome to this Time Traveling Trip!\nMy name is Dr. Chronos. What is your name?\n");
        String userName = s.nextLine();
        System.out.print("Hello, " + userName + ". I have this watch that can travel to any time period.\nNow tell me how far do you want to travel into the past? (Maximum: 2022 years)\n");
        int earliestTime = s.nextInt();
        System.out.print("Now tell how far do you want to travel into the future? (Maximum: 100 years)\n");
        int latestTime = s.nextInt();
        TimeTravelingMechanism timeTrip = new TimeTravelingMechanism(earliestTime, latestTime);
        System.out.print("To travel, just type the year you want to travel to.\nNow what time period do you want to go?\n");
        int yearOfTravel = s.nextInt();
        System.out.println("Oh, I forgot to mention! The watch is little glitchy, so good luck...");
        Thread.sleep(1000);
        int ms = 1100;
        for (int i = 0; i <= 9; i++) {
            System.out.println(timeTrip.rewindSequence(yearOfTravel));
            Thread.sleep(ms);
            ms-= 100;
        }
        System.out.println("...");
        int modifiedYOT = yearOfTravel;
        for(int i = 9; i >= 0; i--){
            System.out.println(modifiedYOT + 10);
            modifiedYOT--;
            Thread.sleep(ms);
            ms+= 100;
        }
        System.out.println(timeTrip.travelTo(yearOfTravel));
        if(yearOfTravel>=0 && yearOfTravel<=500){
            System.out.println("You traveled to the Roman Empire, and is currently in the Colosseum except you're no spectator\nYou are a gladiator!");
            System.out.print("Pick 1 for sword; enter 2 for spear; enter 3 for bow");
            int choice = s.nextInt();
            System.out.println(timeTrip.swordSpearBow(choice));
        }


    }
}

