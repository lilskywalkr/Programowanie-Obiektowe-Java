public class WektoryRoznejDlugosciException extends Exception{
    private final int lengthOne;
    private final int lengthTwo;

    public WektoryRoznejDlugosciException(int lengthOne, int lengthTwo) {
        this.lengthOne = lengthOne;
        this.lengthTwo = lengthTwo;
    }

    public int getLengthOne() {
        return this.lengthOne;
    }

    public int getLengthTwo() {
        return this.lengthTwo;
    }
}
