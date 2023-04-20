import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = 0, b = 0, c = 0;
        double delta, x0, x1, x2, re, im;

        try {
            System.out.println("Podaj a: ");
            a = sc.nextDouble();

            System.out.println("Podaj b: ");
            b = sc.nextDouble();

            System.out.println("Podaj c: ");
            c = sc.nextDouble();

            /*Obliczanie pierwiastków*/

            delta = b * b - 4 * a * c;
            if (delta > 0) {
                x1 = (Math.sqrt(delta) - b) / (2 * a);
                x2 = (Math.sqrt(delta) + b) / (2 * a);

                System.out.format("x1 = %.2f\nx2 = %.2f", x1, x2);
            } else if (delta == 0) {
                x0 = -b / (2 * a);
                System.out.format("x0 = %.2f", x0);
            } else {
                re = -b / (2 * a);
                im = Math.sqrt(-delta) / (2 * a);
                System.out.format("x1 = %.2f+%.2fi\nx2 = %.2f-%.2fi", re, im, re, im);
            }
        } catch (Exception e) {
            System.out.format("Incorrect input");
        }
    }
}