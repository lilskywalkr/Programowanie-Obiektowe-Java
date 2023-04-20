import java.util.ArrayList;
import java.util.Arrays;

public class MyVector {
    private final ArrayList<Integer> theVector = new ArrayList<Integer>();

    public MyVector() { }

    public void displayVector() {
        for (int i = 0; i < this.theVector.size(); i++) {
            if (i != this.theVector.size() - 1) {
                System.out.format("%d ", this.theVector.get(i));
            } else {
                System.out.format("%d", this.theVector.get(i));
            }
        }
    }

    public int getElement(int index) {
        return this.theVector.get(index);
    }

    public int getVectorSize() {
        return this.theVector.size();
    }

    public void addElement(Integer number) {
        this.theVector.add(number);
    }

    public void addElements(Integer[] numbers) {
        this.theVector.addAll(Arrays.asList(numbers));
    }
}
