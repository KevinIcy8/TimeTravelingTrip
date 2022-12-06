import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * The TimeTravelingMechanism represents a time traveling trip. It hasthe year the user wants to travel to,
 * current year, all the travels to different places, as well as some of special attributes for some of the
 * minigames.
 */
public class TimeTravelingMechanism {
    private int yearOfTravel;
    private int currentYear;
    private int romeTravel;
    private int chinaTravel;
    private int italyTravel;
    private int japanTravel;
    private int greatBritainTravel;
    private int coldWarTravel;
    private int contemporaryTravel;
    private String userDeck;
    private String compDeck;
    private int userScore;
    private int compScore;
    private int ninjaNumShuriken;
    private int userNumShuriken;


    private final String RESET = "\u001B[0m";
    private final String RED = "\u001B[31m";
    private final String YELLOW = "\u001B[33m";
    private final String GREEN = "\u001B[32m";

    /**
     * Constructor for the TimeTravelingMechanism class. This creates a new instance of a trip given
     * the below parameters.
     * @param yearOfTravel represents the year the user wants to travel to
     * @param currentYear represents the current year the user is in.
     */
    public TimeTravelingMechanism(String yearOfTravel, String currentYear){
        this.yearOfTravel = Integer.parseInt(yearOfTravel);
        this.currentYear = Integer.parseInt(currentYear);
        userDeck = "2 3 4 5 6 7 8 9 10 J Q K A ";
        compDeck = "2 3 4 5 6 7 8 9 10 J Q K A ";
        userScore = 0;
        compScore = 0;
        romeTravel = 0;
        chinaTravel = 0;
        italyTravel = 0;
        japanTravel = 0;
        greatBritainTravel = 0;
        coldWarTravel = 0;
        contemporaryTravel = 0;
        ninjaNumShuriken = 10;
        userNumShuriken = 10;
    }


    /**
     * This is another constructor of the TimeTravelingMechanism class. This creates a new instance
     * using a randomizer
     * @param currentYear = the current year the user is in
     */
    public TimeTravelingMechanism(String currentYear){
        yearOfTravel = (int)(Math.random()*2021);
        this.currentYear = Integer.parseInt(currentYear);
        userDeck = "2 3 4 5 6 7 8 9 10 J Q K A ";
        compDeck = "2 3 4 5 6 7 8 9 10 J Q K A ";
        userScore = 0;
        compScore = 0;
        romeTravel = 0;
        chinaTravel = 0;
        italyTravel = 0;
        japanTravel = 0;
        greatBritainTravel = 0;
        coldWarTravel = 0;
        contemporaryTravel = 0;
        ninjaNumShuriken = 10;
        userNumShuriken = 10;
    }

    /**
     * this method returns the year of travel
     * @return returns a integer that is the year of travel
     */

    public int getYearOfTravel(){
        return yearOfTravel;
    }

    /**
     * this method does the rewind sequence for when the user travels back in time
     * @return returns a integer which is the years rewinding
     */
    public int rewindSequence(){
        int rewindYear = currentYear--;
        return rewindYear;
    }

    /**
     * this method does the forward sequence for when the user travels forward in time
     * @return returns a integer which is the years going forward
     */
    public int forwardSequence(){
        int forwardYear = currentYear++;
        return forwardYear;
    }

    /**
     *this method determines whether the user is traveling to the past
     * @return returns a boolean
     */
 public boolean isTravelingPast(){
        if(yearOfTravel < currentYear){
            return true;
        }
        return false;
    }

    /**
     * this method determines whether the user is traveling to the future
     * @return returns a boolean
     */
    public boolean isTravelingFuture(){
        if(yearOfTravel > currentYear){
            return true;
        }
        return false;
    }
    /**
     * this method determines whether it is enough for it to do the transition of ... for past
     * @return returns a boolean
     */
    public boolean isEnoughForTransitionP(){
        if(currentYear - yearOfTravel >= 10){
            return true;
        }
        return false;
    }
    /**
     * this method determines whether it is enough for it to do the transition of ... for future
     * @return returns a boolean
     */
    public boolean isEnoughForTransitionF(){
        if(yearOfTravel - currentYear >= 10){
            return true;
        }
        return false;
    }

    /**
     *this method represents a minigame: rock paper scissor
     * @param userChoice represents the user's choice of sword, spear, or bow
     * @return returns a String determining the outcome of the batttle
     */
    public String swordSpearBow(String userChoice){
        romeTravel++;
        int compChoice = (int)(Math.random()*3)+1;
        if (compChoice > Integer.parseInt(userChoice)){
            if(compChoice == 3 && Integer.parseInt(userChoice) == 1){
                return "Your opponent chose the Bow and you chose the Sword; Sword beats Bow\nYou win!";
            }
            else if (compChoice == 3 && Integer.parseInt(userChoice) == 2){
                return "Your opponent chose the Bow and you chose the Spear; Bow beats Spear\nYou lose!";
            }
            else{
                return "Your opponent chose the Spear and you chose the Sword; Spear beats Sword\nYou lose!";
            }
        }
        else if (Integer.parseInt(userChoice) > compChoice){
            if(Integer.parseInt(userChoice) == 3 && compChoice == 1){
                return "Your opponent chose the Sword and you chose the Bow; Sword beats Bow\nYou lose!";
            }
            else if (Integer.parseInt(userChoice) == 3 && compChoice == 2){
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

    /**
     * this method contains all the questions for my second minigame
     * @return rerturn a String which is the question
     */
    public String guessChineseQuestions(){
        int randomNum = (int)(Math.random()*5)+1;
        if(randomNum == 1){
            return "你觉得我女儿漂亮吗?\na.Yes, of course!  b.I don't know  c.Truthfully, no  d.Absolute perfection!!!";
        }
        else if(randomNum == 2){
            return "你觉得你自己多好看?\na.Average  b.Top tier  c.I don't feel comfortable answering  d.Atrocious";
        }
        else if(randomNum == 3){
            return "如果你的妈妈和我的女儿掉到水里了，你先救谁?\na.The former  b.Both  c.The latter  d.Neither";
        }
        else if(randomNum == 4){
            return "你想代替我做皇帝吗?\na.I don't know  b.I reject  c.I am itching to do so  d.Not interested";
        }
        return "如果我给你一把剑，你会怎么做?\na.Protect  b.Kill  c.Do nothing  d.Swallow";
    }

    /**
     * this method gives a response based off the question and the user's answer
     * @param question represents the question that is selected from the method guesschineseQuestion
     * @param answer represents the user answer
     * @return return a String representing how the emperor responds to his question
     */
    public String guessChineseAnswer(String question,String answer) {
        chinaTravel++;
        return switch (question) {
            case "你觉得我女儿漂亮吗?\na.Yes, of course!  b.I don't know  c.Truthfully, no  d.Absolute perfection!!!" ->
                    switch (answer) {
                        case "a" ->
                                "The emperor asks whether his daughter was beautiful and you answered \"Yes, of course!\"\nThe emperor is pleased with your answer!  +2 points";
                        case "b" ->
                                "The emperor asks whether his daughter was beautiful and you answered \"I don't know\"\nThe emperor understands your confusion!  +1 points";
                        case "c" ->
                                "The emperor asks whether his daughter was beautiful and you answered \"Truthfully, no\"\nThe emperor is displeased with your blatantly truthful answer!  +0 points";
                        default ->
                                "The emperor asks whether his daughter was beautiful and you answered \"Absolute perfection!!!\"\nThe emperor is overjoyed with your unintentional flattery !  +3 points";
                    };
            case "你觉得你自己多好看?\na.Average  b.Top tier  c.I don't feel comfortable answering  d.Atrocious" ->
                    switch (answer) {
                        case "a" ->
                                "The emperor asks how good looking do you think you look and you answered \"Average\"\nThe emperor thinks you evaluated yourself quite accurately!  +3 points";
                        case "b" ->
                                "The emperor asks how good looking do you think you look and you answered \"Top tier\"\nThe emperor thinks he should get you a mirror.  +0 points";
                        case "c" ->
                                "The emperor asks how good looking do you think you look and you answered \"I don't feel comfortable answering\"\nThe emperor understands that you are shy.  +1 points";
                        default ->
                                "The emperor asks how good looking do you think you look and you answered \"Atrocious\"\nThe emperor appreciates your honesty.  +2 points";
                    };
            case "如果你的妈妈和我的女儿掉到水里了，你先救谁?\na.The former  b.Both  c.The latter  d.Neither" ->
                    switch (answer) {
                        case "a" ->
                                "The emperor asks if your mom and his daughter were to fell in the river, who do you save and you answered \"The former\"\nThe emperor is displeased you didn't choose her daughter, but at least you are practicing filial piety.  +2 points";
                        case "b" ->
                                "The emperor asks if your mom and his daughter were to fell in the river, who do you save and you answered \"Both\"\nThe emperor thinks that you are overestimating your capabilities.  +1 points";
                        case "c" ->
                                "The emperor asks if your mom and his daughter were to fell in the river, who do you save and you answered \"The latter\"\nThe emperor is delighted due to the fact that you would abandon your own mother for her daughter.  +3 points";
                        default ->
                                "The emperor asks if your mom and his daughter were to fell in the river, who do you save and you answered \"Neither\"\nThe emperor thinks that you are either cold hearted or incapable of swimming (Failure)!  +0 points";
                    };
            case "你想代替我做皇帝吗?\na.I don't know  b.I reject  c.I am itching to do so  d.Not interested" ->
                    switch (answer) {
                        case "a" ->
                                "The emperor asks whether you want to replace him as emperor and you answered \"I don't know\"\nThe emperor understands your confusion  +1 points";
                        case "b" ->
                                "The emperor asks whether you want to replace him as emperor and you answered \"I reject\"\nThe emperor is pleased with your humbleness!  +3 points";
                        case "c" ->
                                "The emperor asks whether you want to replace him as emperor and you answered \"I am itching to do so\"\nThe emperor is displeased with your audacity!  +0 points";
                        default ->
                                "The emperor asks whether you want to replace him as emperor and you answered \"Not interested\"\nThe emperor is offended for your disinterest of his role, but he does not get mad!  +2 points";
                    };
            case "如果我给你一把剑，你会怎么做?\na.Protect  b.Kill  c.Do nothing  d.Swallow" ->
                    switch (answer) {
                        case "a" ->
                                "The emperor asks if I were to give you a sword, what would you do and you answered \"Protect\"\nThe emperor is pleased with your righteous spirit!  +3 points";
                        case "b" ->
                                "The emperor asks if I were to give you a sword, what would you do and you answered \"Kill\"\nThe emperor thinks that you are a menace to society!  +0 points";
                        case "c" ->
                                "The emperor asks if I were to give you a sword, what would you do and you answered \"Do nothing\"\nThe emperor thinks that you are lazy!  +1 points";
                        default ->
                                "The emperor asks if I were to give you a sword, what would you do and you answered \"Swallow\"\nThe emperor's interest have been piqued and stated \"Get this a man a sword\"!  +2 points";
                    };
            default -> "I hope you never get to see this";
        };
    }

    /**
     * this method selects a random word for my third minigame
     * @return return a string which is the random word
     */

    public String randomQuizWord(){
        int random = (int)(Math.random()*5)+1;
        if(random == 1){
            return "LOREM";
        }
        else if(random==2){
            return "IPSUM";
        }
        else if(random==3){
            return "ITALY";
        }
        else if(random==4){
            return "ALIBI";
        }
        return "LATIN";
    }

    /**
     * this method simulates a game of wordle
     * @param userGuess represents the user's guess attempt
     * @param guessWord represents the word the user is trying to guess
     * @return a String determining how close the user's guess was to the actual word
     */
    public String renaissanceWordle(String userGuess, String guessWord){
        italyTravel++;
        String modUserGuess = userGuess.toUpperCase();
        int l = guessWord.length();
        String hint = "";
        String letter1 = "";
        String letter2 = "";
        String letter3 = "";
        String letter4 = "";
        String letter5 = "";
        for(int i = 0; i<l; i++){
            String eachUserLetter = modUserGuess.substring(i,i+1);
            String eachGuessLetter = guessWord.substring(i,i+1);
            if(eachUserLetter.equals(eachGuessLetter)){
                if(i == 0){
                    letter1 = GREEN + eachGuessLetter;
                }
                if(i == 1){
                    letter2 = GREEN + eachGuessLetter;
                }
                if(i == 2){
                    letter3 = GREEN + eachGuessLetter;
                }
                if(i == 3){
                    letter4 = GREEN + eachGuessLetter;
                }
                if(i == 4){
                    letter5 = GREEN + eachGuessLetter;
                }
            }
            else if(guessWord.contains(eachUserLetter)){
                if(i == 0){
                    letter1 = YELLOW + eachUserLetter;
                }
                if(i == 1){
                    letter2 = YELLOW + eachUserLetter;
                }
                if(i == 2){
                    letter3 = YELLOW + eachUserLetter;
                }
                if(i == 3){
                    letter4 = YELLOW + eachUserLetter;
                }
                if(i == 4){
                    letter5 = YELLOW + eachUserLetter;
                }
            }
            else{
                if(i == 0){
                    letter1 = RED + eachUserLetter;
                }
                if(i == 1){
                    letter2 = RED + eachUserLetter;
                }
                if(i == 2){
                    letter3 = RED + eachUserLetter;
                }
                if(i == 3){
                    letter4 = RED + eachUserLetter;
                }
                if(i == 4){
                    letter5 = RED + eachUserLetter;
                }
            }
        }
        hint = letter1 + letter2 + letter3 + letter4 + letter5;
        return hint + RESET;
    }

    /**
     * this method determines the number of shuriken the ninja is going to hide
     * @return returns a integer that is th enumber of shurikens
     */
    public int ninjaShurikenAmt(){
        int numOfShuriken = (int)(Math.random()*10)+1;
        return numOfShuriken;
    }

    /**
     * this method checks whether the user's guess was correct
     * @param guess represets the user's guess
     * @return returns a series of String describing whether you have guess correctly
     */
    public String ninjaOddsOrEven(String guess){
        japanTravel++;
    int hideAmt = ninjaShurikenAmt();
        if((Integer.parseInt(guess) == 1 && hideAmt%2==1) || (Integer.parseInt(guess) ==2 && hideAmt%2==0)){
            ninjaNumShuriken -= hideAmt;
            userNumShuriken += hideAmt;
            return "You gained " + hideAmt + " shurikens.\nYou have " + userNumShuriken + "and the ninja has " + ninjaNumShuriken;
        }
        ninjaNumShuriken += hideAmt;
        userNumShuriken -= hideAmt;
        return "You lost" + hideAmt + " shurikens.\nYou have " + userNumShuriken + "and the ninja has " + ninjaNumShuriken;
    }

    /**
     * this method determines the win condition of this minigame
     * @return return a boolean
     */
    public boolean oddOrEvenWin(){
        if(ninjaNumShuriken <=0 || userNumShuriken <=0){
            return false;
        }
        return true;
    }

    /**
     * this method just prints who won
     * @return returns a String describing who won
     */
    public String oddOrEvenVictor(){
        if(ninjaNumShuriken <=0){
            return "You win!";
        }
        return "You lose";
    }

    /**
     * this method determines who wins the round of war
     * @param userChoice represents the user's choice
     * @param compChoice represents the computer;s choice which is randomized
     * @return returns a string that represents whoever won the round
     */
    public String gameOfWar(String userChoice, String compChoice){
        String letters = "JQKA";
        if(userChoice.contains(" ")){
            userChoice = userChoice.substring(0,1);
        }
        if(compChoice.contains(" ")){
            compChoice = compChoice.substring(0,1);
        }
        userChoice = userChoice.toUpperCase();
        if((letters.contains(userChoice)) || (letters.contains(compChoice))){
            if(letters.contains(userChoice) && letters.contains(compChoice)){
                int userIndex = letters.indexOf(userChoice);
                int compIndex = letters.indexOf(compChoice);
                if(compIndex > userIndex){
                    compScore++;
                    return "Your opponent picked " + compChoice + " and you picked " + userChoice + ". You lose!";
                }
                else if(compIndex < userIndex){
                    userScore++;
                    return "Your opponent picked " + compChoice + " and you picked " + userChoice + ". You win!";
                }
                else{
                    return "Your opponent picked " + compChoice + " and you picked " + userChoice + ". You tied!";
                }
            }
            else if(!letters.contains(userChoice)){
                compScore++;
                return "Your opponent picked " + compChoice + " and you picked " + userChoice + ". You lose!";
            }
            else{
                userScore++;
                return "Your opponent picked " + compChoice + " and you picked " + userChoice + ". You win!";
            }
        }
        else{
            if(Integer.parseInt(compChoice) > Integer.parseInt(userChoice)){
                compScore++;
                return "Your opponent picked " + compChoice + " and you picked " + userChoice + ". You lose!";
            }
            else if(Integer.parseInt(compChoice) < Integer.parseInt(userChoice)){
                userScore++;
                return "Your opponent picked " + compChoice + " and you picked " + userChoice + ". You win!";
            }
            else{
                return "Your opponent picked " + compChoice + " and you picked " + userChoice + ". You tied!";
            }
        }
    }

    /**
     * this method just prints the score
     * @return returns a series of Strings that represents the scorre board
     */
    public String getScoreBoard(){
        return "     Score\nYou   " + userScore + ":" + compScore + "   Opponent";
    }

    /**
     * this method cuts out the String described by below parameter
     * @param userChoice represents the user choice of what card to use
     */
    public void setUserDeck(String userChoice){
        String firstHalf = userDeck.substring(0,userDeck.indexOf(userChoice));
        String secondHalf = "";
        if(userChoice.equals("10")){
            secondHalf = userDeck.substring(userDeck.indexOf(userChoice) + 3);
        }
        else {
            secondHalf = userDeck.substring(userDeck.indexOf(userChoice) + 2);
        }
        userDeck = firstHalf + secondHalf;
    }

    /**
     * this method checks for letters and uppercase it as well as it calls the setUserjDeck method
     * @param userChoice represents the user's choice
     * @return returns a instance variable which is a String which is the userDeck
     */
    public String userCardChecker(String userChoice){
        userChoice = userChoice.toUpperCase();
        setUserDeck(userChoice);
        return userDeck;
    }

    /**
     * this method cuts out the String described by below parameter
     * @param strCompChoice represents the comp choice of what card to use
     */
    public void setCompDeck(String strCompChoice){
        String firstHalf = compDeck.substring(0,compDeck.indexOf(strCompChoice));
        String secondHalf = "";
        if(strCompChoice.equals("10")){
            secondHalf = compDeck.substring(compDeck.indexOf(strCompChoice) + 3);
        }
        else {
            secondHalf = compDeck.substring(compDeck.indexOf(strCompChoice) + 2);
        }
        compDeck = firstHalf + secondHalf;
    }

    /**
     * ths method generates the card choice that the computer is going to choose
     * @return returns a string that is going to be the user's choice
     */

    public String compChoiceGenerator(){
        int compChoice = (int)(Math.random()*14)+2;
        String strCompChoice = "";
        if(compChoice>=11){
            if(compChoice == 11){
                strCompChoice = "J";
            }
            else if(compChoice == 12){
                strCompChoice = "Q";
            }
            else if(compChoice == 13){
                strCompChoice = "K";
            }
            else{
                strCompChoice = "A";
            }
        }
        else{
            strCompChoice = String.valueOf(compChoice);
        }
        return strCompChoice;
    }

    /**
     * this method basically calls the othe rmethod of setCompDeck
     * @param strCompChoice represents the computer's choice;
     */
    public void compCardChecker(String strCompChoice){
        setCompDeck(strCompChoice);
    }

    /**
     * this method determines whether the parameter below exists in the compDeck
     * @param strCompChoice represents the string that needs to be checked
     * @return returns a boolean
     */
    public boolean isContainCompDeck(String strCompChoice){
        return compDeck.contains(strCompChoice);
    }

    /**
     * this method determines whether the parameter below exists in the userDeck
     * @param userChoice represents the string that needs to be checked
     * @return returns a boolean
     */

    public boolean isContainUserDeck(String userChoice){
        userChoice = userChoice.toUpperCase();
        return userDeck.contains(userChoice);
    }

    /**
     * this method is a getter method that gets the userDeck
     * @return return a String
     */
    public String getUserDeck(){
        return userDeck;
    }
    /**
     * this method is a getter method that gets the compDeck
     * @return return a String
     */
    public String getCompDeck(){
        return compDeck;
    }

    /**
     * this method determines the joke which is used for the minigame
     * @return returns a sentence of String which is the joke
     */
    public String coldWarJokes(){
        coldWarTravel++;
         int randomNum = (int)(Math.random()*6)+1;
         String joke = "";
         if(randomNum == 1){
             joke =  "My friend once told his crush that if he can rearrange the alphabet, he would put \"U\" and \"I\" together.";
         }
         else if(randomNum ==2){
             joke = "I only know 25 letters of the alphabet.";
         }
         else if(randomNum ==3){
             joke = "Why can't a nose be 12 inches long?";
         }
         else if(randomNum ==4){
             joke = "What's Thanos' favorite app on his phone?";
         }
         else if(randomNum ==5){
             joke = "What concert costs just 45 cents?";
         }
         else{
             joke = "How does a nonbinary samurai kill people?";
         }
         return joke;
    }

    /**
     * this method has all of the punchlines for the minigame
     * @param joke presents the joke created from the prev method
     * @return return a string tha tis the punchline;
     */
    public String coldWarPunchLines(String joke){
        return switch (joke) {
            case "My friend once told his crush that if he can rearrange the alphabet, he would put \"U\" and \"I\" together." ->
                    "His crush replied why do you need to rearrange the alphabet if \"N\" and \"O\" are already together.";
            case "I only know 25 letters of the alphabet." -> "I don't know y.";
            case "Why can't a nose be 12 inches long?" -> "Because then it would be a foot.";
            case "What's Thanos' favorite app on his phone?" -> "Snapchat";
            case "What concert costs just 45 cents?" -> "50 Cent featuring Nickelback!";
            default -> "They/Them";
        };
    }

    /**
     * this method is the comparison of the user's rating vs the creator's rating
     * @param punchLine represents the punchline created by the other method
     * @param rating represents the user's rating
     * @return returns a string that determiness how the generals react
     */
    public String coldWarRatingComparison(String punchLine, String rating){
        switch (punchLine) {
            case "His crush replied why do you need to rearrange the alphabet if \"N\" and \"O\" are already together.":
                if (Integer.parseInt(rating) == 10 || Integer.parseInt(rating) == 9) {
                    return "The generals agree with your rating";
                } else if (Integer.parseInt(rating) <= 8 && Integer.parseInt(rating) >= 6) {
                    return "The generals think your opinion is mid";
                } else {
                    return "The generals absolutely dislikes your opinion";
                }
            case "I don't know y.":
                if (Integer.parseInt(rating) >= 1 && Integer.parseInt(rating) <= 5) {
                    return "The generals agree with your rating";
                } else if (Integer.parseInt(rating) >= 6 && Integer.parseInt(rating) <= 7) {
                    return "The generals think your opinion is mid";
                } else {
                    return "The generals absolutely dislikes your opinion";
                }
            case "Because then it would be a foot.":
                if (Integer.parseInt(rating) >= 1 || Integer.parseInt(rating) <= 5) {
                    return "The generals agree with your rating";
                } else if (Integer.parseInt(rating) >= 6 && Integer.parseInt(rating) <= 7) {
                    return "The generals think your opinion is mid";
                } else {
                    return "The generals absolutely dislikes your opinion";
                }
            case "Snapchat":
                if (Integer.parseInt(rating) >= 4 || Integer.parseInt(rating) <= 6) {
                    return "The generals agree with your rating";
                } else if (Integer.parseInt(rating) >= 1 && Integer.parseInt(rating) <= 3) {
                    return "The generals think your opinion is mid";
                } else {
                    return "The generals absolutely dislikes your opinion";
                }
            case "50 Cent featuring Nickelback!":
                if (Integer.parseInt(rating) >= 8 || Integer.parseInt(rating) <= 10) {
                    return "The generals agree with your rating";
                } else if (Integer.parseInt(rating) <= 7 && Integer.parseInt(rating) >= 6) {
                    return "The generals think your opinion is mid";
                } else {
                    return "The generals absolutely dislikes your opinion";
                }
            default:
                if (Integer.parseInt(rating) >= 5 && Integer.parseInt(rating) <= 7) {
                    return "The generals agree with your rating";
                } else if (Integer.parseInt(rating) <= 4 && Integer.parseInt(rating) >= 1) {
                    return "The generals think your opinion is mid";
                } else {
                    return "The generals absolutely dislikes your opinion";
                }
        }
    }

    /**
     * this method just sets the contemporaryTravel up by 1
     */
    public void cameToContemporary(){
        contemporaryTravel++;
    }

    /**
     * this method checks to see if the parameter below contains any letters
     * @param yearOfTravel the string inputted to check
     * @return return a boolean
     */
    public boolean isContainLetter(String yearOfTravel){
        int l = yearOfTravel.length();
        String numbers = "1234567890";
        int count = 0;
        for(int i = 0; i<l; i++){
            String eachLetter = yearOfTravel.substring(i,i+1);
            if(!numbers.contains(eachLetter)){
                count++;
            }
        }
        if(count>=1){
            return true;
        }
        return false;
    }

    /**
     * this is the toString method which prints out a series of Strings regarding a quick summary of your last trip
     * @return a String that represents a quick summary of your last trip.
     */
    public String toString(){
        String summary = "Here is a quick summary of your last trip\n";
        if(romeTravel>=1){
            summary += "You fought gladiators in the Colosseum\n";
        }
        if(chinaTravel>=1){
            summary += "You impress the Emperor of China with your fluent Chinese\n";
        }
        if(italyTravel>=1){
            summary += "You made Shakespeare proud by completing Latin Wordle\n";
        }
        if(japanTravel>=1){
            summary += "You learned counting with ninjas\n";
        }
        if(greatBritainTravel>=1){
            summary += "You played a game of war with the king while y'all at war, a true warception\n";
        }
        if(coldWarTravel>=1){
            summary += "You almost caused mutual assured destruction, due to your ice cold humor\n";
        }
        if(contemporaryTravel>=1){
            summary += "You thought traveling to the 21st century was a good idea and you exposed the creator for his lack of ideas\n";
        }
        return summary;
    }
}
