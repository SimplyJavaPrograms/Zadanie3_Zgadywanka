import java.util.Scanner;
import java.util.Random;

public class Game {
    Scanner sc;
    boolean running_round, running_game;
    int round, rangeLimit, solution, maxRound;

    public Game(int upperLimit, int maxRound) {

        this.running_round = false;
        this.running_game = true;
        this.round = 0;
        this.maxRound = maxRound;
        this.rangeLimit = upperLimit;

        this.sc = new Scanner(System.in);

    }

    private void roll() {
        Random rand = new Random(); // instance of random class
        solution = rand.nextInt(rangeLimit);
    }

    public void reaskNumber(int data) {
        System.out.println("" + data);
    }

    public void showSolution() {
        System.out.println("\nRozwiazaniem zagadki jest liczba: " + this.solution + "\n");
    }

    private void checkUserInput(int input) {
        if (input < solution) {
            System.out.println("Podałeś za małą liczbę");
        } else if (input > solution) {
            System.out.println("Podałeś za dużą liczbę");
        } else {
            System.out.println("\nGratuluję! Zgadłeś liczbę w " + this.round + " próbie\n");
            this.running_round = false;
        }
    }

    private void increaseRoundCounter() {
        this.round++;

        if (round > maxRound) {
            System.out.println("Przekroczyles maksymalna ilosc prob.");
            this.round = 0;
            running_round = false;
        }
    }

    private void clearRoundCounter() {
        round = 0;
    }

    private void askToContinue() {
        do {
            System.out.println("Czy chesz kontynuowac gre : yes or no");
            String decision = sc.nextLine();
            switch (decision) {
                case "yes":
                    this.running_game = true;
                    return;
                case "no":
                    this.running_game = false;
                    return;

                default:
                    System.out.println("Nieprawidlowy user input");
                    break;
            }
        } while (true);
    }

    public void play() {

        do {
            running_round = true;
            roll();
            showSolution();
            System.out.println("Sprobuj szczęscia i podaj liczbe: ");

            do {
                int userInput = sc.nextInt();
                sc.nextLine();

                increaseRoundCounter();
                checkUserInput(userInput);
            } while (running_round);

            askToContinue();
            clearRoundCounter();

        } while (running_game);

    }
}
