import java.util.Scanner;
public class TimeTravelingRun {
    public static void main(String[] args) throws InterruptedException {
        Scanner s = new Scanner(System.in);
        System.out.print("Welcome to this Time Traveling Trip!\nMy name is Dr. Chronos. What is your name?\n");
        String userName = s.nextLine();
        System.out.print("Hello, " + userName + ". I have this watch that can travel to any time period. Now tell me how far do you want to travel into the past? (Maximum 0000\n");
        int earliestTime = s.nextInt();
        System.out.print("Now tell how far do you want to travel into the future? (Maximum 2100)\n");
        int latestTime = s.nextInt();
        TimeTravelingMechanism timeTrip = new TimeTravelingMechanism(earliestTime,latestTime);
        System.out.print("Remember type the year you want to go to up to the century. So, if you want to go back to the 1818, just type 1800.\nNow what time period do you want to go?\n");
        int timePeriod = s.nextInt();
        System.out.println("Oh, I forgot to mention! The watch is little glitchy, so good luck...");
        Thread.sleep(1000);
        timeTrip.travelTo(timePeriod);
    }
}
