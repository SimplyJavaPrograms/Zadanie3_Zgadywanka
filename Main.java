import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println(Arrays.toString(args));
            System.out.println(
                    "Blędna ilość argumentów. powinines jako pierwszy argument podac liczbe wskazujaca na maskylany zakres losownych liczb. Poda liczba argumentow:  "
                            + args.length);
            System.out.println("Poprawny przyklad uruchomienia: \"java Main 4\"");
            System.exit(1);
        }

        if (args[0].matches("\\d+")) {
            int upperlimit = Integer.parseInt(args[0]);
            Game game = new Game(upperlimit, 3);
            game.play();
        } else {
            System.out.println("Gorny limit musi byc liczba calkowita dodatnia! Spróbuj ponownie");
        }

    }
}
