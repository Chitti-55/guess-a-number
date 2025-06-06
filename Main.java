import java.util.Scanner;

class rangen {
    public int genrate(int max, int min) {
        return (int) (Math.random() * (max - min + 1) + min);
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        rangen rg = new rangen();
        int totalAttempts = 0;
        int win = 0;

        while (true) {
            System.out.println("Enter the maximum number");
            int max = sc.nextInt();
            System.out.println("Enter the minimum number");
            int min = sc.nextInt();
            sc.nextLine();

            int cnum = rg.genrate(max, min);
            int attempts = 0;
            boolean guessedCorrectly = false;

            while (attempts < 3) {
                System.out.println("Guess a number between " + min + " and " + max);
                int gnum = sc.nextInt();
                attempts++;

                if (gnum > cnum) {
                    System.out.println("It's Greater");
                } else if (gnum < cnum) {
                    System.out.println("It's Lower");
                } else {
                    System.out.println("Correct Guess");
                    win++;
                    guessedCorrectly = true;
                    break;
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Out of attempts! The correct number was: " + cnum);
            }

            totalAttempts += attempts;
            System.out.println("Attempts this round = " + attempts);
            System.out.println("Wins = " + win);

            double winrate = (double) win / totalAttempts * 100;
            System.out.printf("Your winrate is %.2f%%\n", winrate);

            System.out.println("Do you want to play again (yes/no)");
            String playAgain = sc.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                sc.close();
                System.exit(0);
            }
            sc.nextLine();
        }
    }
}