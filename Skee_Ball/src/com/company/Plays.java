import java.security.SecureRandom;
import java.util.Scanner;

public class Plays {
    // MAX_PLAYS refers to the maximum number of plays allowed (cannot be changed)
    private static final int MAX_PLAYS = 8;

    // helper function to generate a random value
    public int randomValueGenerator() {

        // create instance of SecureRandom
        SecureRandom rand = new SecureRandom();

        // percentage is any random number from 1 to 100
        int percentage = rand.nextInt(100) + 1;

        int hallValue;

        // simulate weighted probability by saying that if percentage is less than a certain value, then hellValue gets modified appropriately
        if (percentage <= 5)
            hallValue = 80;
        else if (percentage <= 15)
            hallValue = 60;
        else if (percentage <= 30)
            hallValue = 40;
        else if (percentage <= 45)
            hallValue = 20;
        else if (percentage <= 65)
            hallValue = 10;
        else
            hallValue = 0;

        // not necessary but shows knowledge of switch statement
        switch (hallValue) {
            case 80:
                hallValue = 80;
                break;
            case 60:
                hallValue = 60;
                break;
            case 40:
                hallValue = 40;
                break;
            case 20:
                hallValue = 20;
                break;
            default:
                hallValue = 10;
                break;
        }

        return hallValue;
    }

    // play function to simulate random plays
    public void play(int num) {
        // create an array to store the hallValues
        int hallValueArr[] = new int[num];

        // generate a random hallValue until number of plays is terminated and store these values in an array
        for(int i=0; i<num; i++) {

            // call randomValueGenerator() to generate a random hallValue
            int hallValue = randomValueGenerator();

            hallValueArr[i] = hallValue;
            System.out.printf("%s%d%s%d%n", "Rolling ball #", i+1, ". Landed in ", hallValue);
        }

        // pass array to showStats() which will show the stats in a more compact manner
        showStats(hallValueArr);
    }

    // output function to show points per play as well as total
    public void showStats(int[] hallValueArr) {
        // total helps keep track of all sum of points
        int total = 0;

        System.out.println("+-------+-------+");
        System.out.println("  Play #    Score");
        System.out.println("+-------+-------+");

        // traverse the array and print index+1 as well as each value in a formatted manner
        for(int i=0; i<hallValueArr.length; i++) {
            System.out.printf("%6d%7d%n", i+1, hallValueArr[i]);
            total += hallValueArr[i];
        }

        // print out total
        System.out.printf("%s%d", "Total: ", total);
    }

    public static void main(String args[]) {
        int numOfPlays;
        Scanner input = new Scanner(System.in);

        // execute do while loop until number of plays is valid
        do {
            System.out.print("How many plays (1-8)? ");

            // enter number of plays
            numOfPlays = input.nextInt();

            // if number of plays is invalid, print an error message
            if (numOfPlays > MAX_PLAYS || numOfPlays < 1)
                System.out.println("Invalid input. Please enter a number between 1 and 8.");
        } while(numOfPlays > MAX_PLAYS || numOfPlays < 1);

        // create instance of Plays class to use play() because main method is static and play() is not static
        Plays obj1 = new Plays();
        obj1.play(numOfPlays);

        // close scanner object
        input.close();
    }
}