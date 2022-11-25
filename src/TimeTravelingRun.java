import java.util.Scanner;
public class TimeTravelingRun {
    public static void main(String[] args) throws InterruptedException {
        Scanner s = new Scanner(System.in);
        System.out.print("Welcome to this Time Traveling Trip!\nMy name is Dr. Chronos. What is your name?\n");
        String userName = s.nextLine();
        System.out.print("Hello, " + userName + ". I have this watch that can travel to any time period.\nNow tell me how many times do you want to travel before coming back\n");
        int numberOfTrips = s.nextInt();
        System.out.println("You will travel " + numberOfTrips + " times before coming back, but you can always press r to return manually");
        System.out.print("To travel, just type the year you want to travel to. For example, if you want to travel to Year 1946, just type 1946 (Minimum: Year 0; Maximum: Year 2100)\nNow what time period do you want to go?\n");
        int yearOfTravel = s.nextInt();
        TimeTravelingMechanism timeTrip = new TimeTravelingMechanism(yearOfTravel);
        System.out.println("Oh, I forgot to mention! The watch is little glitchy, so good luck...");
        String response = "";
        int count = 0;
        while (!response.equals("f") && count < numberOfTrips) {
            if (timeTrip.isTravelingPast()) {
                Thread.sleep(1000);
                int ms = 1100;
                if (timeTrip.isEnoughForTransitionP()) {
                    for (int i = 0; i <= 9; i++) {
                        System.out.println(timeTrip.rewindSequence());
                        Thread.sleep(ms);
                        ms -= 100;
                    }
                    System.out.println("...");
                    int modifiedYOT = yearOfTravel;
                    for (int i = 9; i >= 0; i--) {
                        System.out.println(modifiedYOT + 10);
                        modifiedYOT--;
                        Thread.sleep(ms);
                        ms += 100;
                    }
                } else {
                    for (int i = 0; i < 2022 - yearOfTravel; i++) {
                        System.out.println(timeTrip.rewindSequence());
                        Thread.sleep(ms);
                        ms -= 100;
                    }
                }
            } else if (timeTrip.isTravelingFuture()) {
                Thread.sleep(1000);
                int ms = 1100;
                if (timeTrip.isEnoughForTransitionF()) {
                    for (int i = 0; i <= 9; i++) {
                        System.out.println(timeTrip.forwardSequence());
                        Thread.sleep(ms);
                        ms -= 100;
                    }
                    System.out.println("...");
                    int modifiedYOT = yearOfTravel;
                    for (int i = 9; i >= 0; i--) {
                        System.out.println(modifiedYOT - 10);
                        modifiedYOT++;
                        Thread.sleep(ms);
                        ms += 100;
                    }
                } else {
                    for (int i = 0; i < yearOfTravel - 2022; i++) {
                        System.out.println(timeTrip.forwardSequence());
                        Thread.sleep(ms);
                        ms -= 100;
                    }
                }
            }
            System.out.println(timeTrip.travelTo(yearOfTravel));
            if (yearOfTravel >= 0 && yearOfTravel <= 500) {
                System.out.println("You traveled to the Roman Empire, and is currently in the Colosseum except you're no spectator...\nYou are a gladiator!");
                System.out.print("Pick 1 for sword; enter 2 for spear; enter 3 for bow\n");
                int choice = s.nextInt();
                System.out.println(timeTrip.swordSpearBow(choice));
            }
            count++;
            if(count != numberOfTrips) {
                System.out.print("To what time period do you want to travel next: ");
                yearOfTravel = s.nextInt();
                timeTrip = new TimeTravelingMechanism(yearOfTravel);
            }
        }
    }
}

