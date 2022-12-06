import java.util.Scanner;
public class TimeTravelingRun {
    public static void main(String[] args) throws InterruptedException {
        Scanner s = new Scanner(System.in);
        TimeTravelingMechanism timeTrip = new TimeTravelingMechanism("2022","2022");
        boolean isFalseInput = true;
        String newCurrentYear = "2022";
        System.out.print("Welcome to this Time Traveling Trip!\nMy name is Dr. Chronos. What is your name?\n");
        String userName = s.nextLine();
        System.out.print("Hello, " + userName + ". I have this watch that can travel to any time period.\nNow tell me how many times do you want to travel before coming back\n");
        String numberOfTrips = s.nextLine();
        while(timeTrip.isContainLetter(numberOfTrips)){
            System.out.println("Invalid input! Please type in an integer (i.e. 8)");
            System.out.print("Number of Trips you want to travel: ");
            numberOfTrips = s.nextLine();
        }
        System.out.println("You will travel " + numberOfTrips + " times before coming back, or you can always type in the year 2022 to return manually");
        System.out.print("To travel, just type the year you want to travel to. For example, if you want to travel to Year 1946, just type 1946 (Minimum: Year 0; Maximum: Year 2022)\nIf you want to go to a random year press r instead\nNow what time period do you want to go?\n");
        String yearOfTravel = s.nextLine();
        while(isFalseInput) {
            if (timeTrip.isContainLetter(yearOfTravel)) {
                if (yearOfTravel.equals("r")) {
                    timeTrip = new TimeTravelingMechanism("2022");
                    isFalseInput = false;
                } else {
                    System.out.println("Please enter a valid input! (Enter r for random year or a year from 0-2022): ");
                    System.out.print("To what time period do you want to travel next: ");
                    yearOfTravel = s.nextLine();
                }
            } else if (Integer.parseInt(yearOfTravel) >= 0 && Integer.parseInt(yearOfTravel) <= 2022) {
                timeTrip = new TimeTravelingMechanism(yearOfTravel, "2022");
                isFalseInput = false;
            } else {
                System.out.println("Please enter a valid input! (Enter for random year or a year from 0-2022): ");
                System.out.print("To what time period do you want to travel next: ");
                yearOfTravel = s.nextLine();
            }
        }
        System.out.println();
        System.out.println("Oh, I forgot to mention! The adventures might kill you, so good luck...");
        newCurrentYear = "0";
        int count = 0;
        while (!yearOfTravel.equals("2022") && count < Integer.parseInt(numberOfTrips)) {
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
                    int modifiedYOT = timeTrip.getYearOfTravel();
                    for (int i = 9; i >= 0; i--) {
                        System.out.println(modifiedYOT + 10);
                        modifiedYOT--;
                        Thread.sleep(ms);
                        ms += 100;
                    }
                } else {
                    for (int i = 0; i < 2022 - Integer.parseInt(yearOfTravel); i++) {
                        System.out.println(timeTrip.rewindSequence());
                        Thread.sleep(ms);
                        ms -= 100;
                    }
                }
                newCurrentYear = String.valueOf(timeTrip.getYearOfTravel());
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
                    int modifiedYOT = timeTrip.getYearOfTravel();
                    for (int i = 9; i >= 0; i--) {
                        System.out.println(modifiedYOT - 10);
                        modifiedYOT++;
                        Thread.sleep(ms);
                        ms += 100;
                    }
                } else {
                    for (int i = 0; i < Integer.parseInt(yearOfTravel) - 2022; i++) {
                        System.out.println(timeTrip.forwardSequence());
                        Thread.sleep(ms);
                        ms -= 100;
                    }
                }
                newCurrentYear = String.valueOf(timeTrip.getYearOfTravel());
            }

            if (timeTrip.getYearOfTravel()>= 0 && timeTrip.getYearOfTravel() <= 500) {
                System.out.println("Rome, " + timeTrip.getYearOfTravel());
                System.out.println("You traveled to the Roman Empire, and is currently in the Colosseum except you're no spectator...\nYou are a gladiator!");
                System.out.print("Pick 1 for sword; enter 2 for spear; enter 3 for bow\n");
                String choice = s.nextLine();
                System.out.println(timeTrip.swordSpearBow(choice));
            }
            else if (timeTrip.getYearOfTravel() > 500 && timeTrip.getYearOfTravel() <= 1000){
                System.out.println("China, " + timeTrip.getYearOfTravel());
                System.out.println("You traveled to the Tang Dynasty, and is currently in the palace and in front of you is the Emperor");
                System.out.println("The emperor is going to ask you a few question, try to answer them the best you can.\nYou get a certain number of points based on how the emperor likes your answer.");
                for(int i=0;i<3;i++){
                    String question = timeTrip.guessChineseQuestions();
                    System.out.println(question);
                    System.out.print("Your answer choice: ");
                    String answer = s.nextLine();
                    System.out.println(timeTrip.guessChineseAnswer(question, answer));
                    Thread.sleep(1000);
                    System.out.println();
                }
            }
            else if (timeTrip.getYearOfTravel() > 1000 && timeTrip.getYearOfTravel() <= 1400){
                System.out.println("Italy, " + timeTrip.getYearOfTravel());
                int guessTimes = 0;
                String guess = "";
                System.out.println("You traveled to an era of Enlightenment, and is currently in school taking a test");
                System.out.println("The test is to guess the word while getting hints");
                System.out.println("If you get the letter correct at the right place, it will show the letter\nIf the letter you guessed is contained in the word but it is not in the right place then it will show yellow\nIf the letter doesn't exist in the word it will show red");
                System.out.println("The words are alwyas 5 letters long");
                String quizWord = timeTrip.randomQuizWord();
                while(guessTimes!=6 && !guess.toUpperCase().equals(quizWord)){
                    System.out.println("Make a guess: ");
                    guess = s.nextLine();
                    System.out.println(timeTrip.renaissanceWordle(guess, quizWord));
                    guessTimes++;
                }
            }
            else if (timeTrip.getYearOfTravel() > 1400 && timeTrip.getYearOfTravel() <= 1600){
                System.out.println("Japan, " + timeTrip.getYearOfTravel());
                System.out.println("You traveled to the Shinobi era, and you are confronted by a bunch of ninjas");
                System.out.println("They said that they are going to kill you unless you play a games of Odd or Even");
                System.out.println("We each get 10 shurikens, I am going to go first and hide whatever amount of shurikens\nThen,you have to guess whether it's odd or even and if you guess it correctly you will get that corresponding amount, and vice versa if you get it wrong. ");
                while(timeTrip.oddOrEvenWin()) {
                    timeTrip.ninjaShurikenAmt();
                    System.out.print("The ninja has hidden a certain number of shuriken; press 1 for odd and press 2 for even\n");
                    String guess = s.nextLine();
                    System.out.println(timeTrip.ninjaOddsOrEven(guess));
                }
                System.out.println(timeTrip.oddOrEvenVictor());
            }
            else if(timeTrip.getYearOfTravel() >1600 && timeTrip.getYearOfTravel() <=1900){
                System.out.println("England, " + timeTrip.getYearOfTravel());
                System.out.println("You traveled to an era of waging war, so now you would be strategizing in a game of war");
                System.out.println("You can pick 2-10, and JQKA and in that order who ever is greater gets the point. you cannot pick the same card twice. First to three points wins");
                System.out.println("Your deck: " + timeTrip.getUserDeck());
                for(int i=0;i<12;i++){
                    System.out.print("Pick a card: ");
                    String choice = s.nextLine();
                    while(!timeTrip.isContainUserDeck(choice)){
                        System.out.println("You already picked this card, pick another from your remaining deck");
                        System.out.println(timeTrip.getUserDeck());
                        System.out.print("Pick a card: ");
                        choice = s.nextLine();
                    }
                    String compChoice = timeTrip.compChoiceGenerator();
                    while(!timeTrip.isContainCompDeck(compChoice)){
                        compChoice = timeTrip.compChoiceGenerator();
                    }
                    timeTrip.compCardChecker(compChoice);
                    System.out.println(timeTrip.userCardChecker(choice));
                    System.out.println(timeTrip.gameOfWar(choice,compChoice));
                    System.out.println(timeTrip.getScoreBoard());
                }
                System.out.println();
                System.out.println("Last Round:");
                System.out.println(timeTrip.gameOfWar(timeTrip.getUserDeck(),timeTrip.getCompDeck()));
                System.out.println(timeTrip.getScoreBoard());
            }
            else if (timeTrip.getYearOfTravel() >1900 && timeTrip.getYearOfTravel() <=2000){
                System.out.println("Soviet Union, " + timeTrip.getYearOfTravel());
                System.out.println("You traveled to the cold War era, and you are currently strategizing with other representatives.");
                System.out.println("The rules are to rate a joke from 1 - 10, and the closer you are to the rating of the rest of the representatives, the better.");
                String joke = timeTrip.coldWarJokes();
                System.out.println(joke);
                Thread.sleep(1000);
                String punchLine = timeTrip.coldWarPunchLines(joke);
                System.out.println(punchLine);
                System.out.println("Please rate this joke from 1-10: ");
                String rating = s.nextLine();
                System.out.println(timeTrip.coldWarRatingComparison(punchLine,rating));
            }
            else if(timeTrip.getYearOfTravel() >2000 && timeTrip.getYearOfTravel() <2022){
                System.out.println("USA, " + timeTrip.getYearOfTravel());
                System.out.println("From this decision i can already tell that you are insecure");
                System.out.println("Nothing interesting happened in these years plus you probably remember them anyway");
                System.out.println("Choose another interesting timeline, there is nothing to see here");
                System.out.println("I totally did not run out of ideas to what I should put here");
                timeTrip.cameToContemporary();
            }

            count++;
            if(count != Integer.parseInt(numberOfTrips)) {
                isFalseInput = true;
                System.out.print("To what time period do you want to travel next: ");
                yearOfTravel = s.nextLine();
                while(isFalseInput){
                    if (timeTrip.isContainLetter(yearOfTravel)) {
                        if (yearOfTravel.equals("r")) {
                            timeTrip = new TimeTravelingMechanism("2022");
                            isFalseInput = false;
                        }
                        else {
                            System.out.println("Please enter a valid input! (Enter r for random year or a year from 0-2022): ");
                            System.out.print("To what time period do you want to travel next: ");
                            yearOfTravel = s.nextLine();
                        }
                    }
                    else if (Integer.parseInt(yearOfTravel)>=0 && Integer.parseInt(yearOfTravel)<=2022) {
                        timeTrip = new TimeTravelingMechanism(yearOfTravel, newCurrentYear);
                        isFalseInput = false;
                    }
                    else{
                        System.out.println("Please enter a valid input! (Enter r for random year or a year from 0-2022): ");
                        System.out.print("To what time period do you want to travel next: ");
                        yearOfTravel = s.nextLine();
                    }
                }
            }
        }
        System.out.println();
        System.out.println("Welcome back!");
        System.out.println(timeTrip);
    }
}

