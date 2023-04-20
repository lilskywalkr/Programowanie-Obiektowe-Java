import java.util.*;
import java.io.*;

public class Main {
    public static MyVector addTwoVectors(MyVector vectorOne, MyVector vectorTwo) {
        MyVector newVector = new MyVector();

        for (int i = 0; i < (vectorTwo.getVectorSize() + vectorTwo.getVectorSize()) / 2; i++) {
            newVector.addElement(vectorOne.getElement(i) + vectorTwo.getElement(i));
        }

        return newVector;
    }
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            MyVector[] v = new MyVector[2];

            System.out.println("Enter two vectors and separate values adding space in between them");

            for (int i = 0; i < 2; i++) {
                v[i] = new MyVector();

                String str = sc.nextLine();

                if (str.matches("[^\\d]*")) {
                    throw new InputMismatchException("Incorrect input data");
                }

                str = str.replaceAll("\\D+", " ");

                String[] values = str.split(" ");
                Integer[] numbers = new Integer[values.length];

                for (int j = 0; j < values.length; j++) {
                    numbers[j] = Integer.parseInt(values[j]);
                }

                v[i].addElements(numbers);
            }

            if (v[0].getVectorSize() != v[1].getVectorSize()) {
                throw new WektoryRoznejDlugosciException(v[0].getVectorSize(), v[1].getVectorSize());
            }

            FileWriter writer = new FileWriter("result.txt");
            MyVector resultVector = addTwoVectors(v[0], v[1]);

            for (int i = 0; i < resultVector.getVectorSize(); i++) {
                writer.write(Integer.toString(resultVector.getElement(i)));
                writer.write(" ");
            }

            sc.close();
            writer.close();
        } catch (InputMismatchException e) {
            System.out.format("%s", e.getMessage());
        } catch (WektoryRoznejDlugosciException e) {
            System.out.format("The differance in size between the two vectors is %d\n", Math.abs(e.getLengthOne() - e.getLengthTwo()));
            System.out.println("Please enter the vectors again");
        } catch (IOException e) {
            System.out.println("An error occurred when saving to the file");
        }
    }
}