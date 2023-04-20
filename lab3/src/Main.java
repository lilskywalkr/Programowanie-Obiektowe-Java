import java.util.*;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        int number = 0, value = 0, guess = 0, tries = 0;
        boolean flg = true;

        try {
            /*initiating instances of classes*/
            Scanner sc = new Scanner(System.in);
            Random rand = new Random();

            /*Getting range of numbers to generate one*/
            System.out.println("Podaj zakres liczb do losowania:");
            number = sc.nextInt();

            /*Generating random number*/
            value = rand.nextInt(0, number);

            System.out.println("Wylosowalem liczbe, zgadnij jaka to liczba");

            while (flg) {
                /*User guesses the generated number*/
                guess = sc.nextInt();

                if (guess > value) {
                    System.out.println("Zle, ale blisko. Podana liczba jest mniejsza od wylosowanej");
                } else if (guess < value) {
                    System.out.println("Zle, ale blisko. Podana liczba jest wieksza od wylosowanej");
                } else {
                    flg = false;
                    System.out.println("Bardzo dobrze!");
                }

                tries++;
            }

            System.out.format("Ilosc prob: %d", tries);
        } catch (Exception e) {
            System.out.format("Incorrect input");
        }
    }
}