public class NrTelefoniczny implements Comparable<NrTelefoniczny> {
    private final String nrKierunkowy;
    private final String nrTelefoniczny;

    public NrTelefoniczny(String k, String t) {
        this.nrKierunkowy = k;
        this.nrTelefoniczny = t;
    }

    public String getNrKierunkowy() {
        return nrKierunkowy;
    }

    public String getNrTelefoniczny() {
        return nrTelefoniczny;
    }

    @Override
    public int compareTo(NrTelefoniczny obj) {
        int resultOne = obj.nrKierunkowy.compareTo(this.nrKierunkowy);
        int resultTwo = obj.nrTelefoniczny.compareTo(this.nrTelefoniczny);

        return resultOne + resultTwo;
    }
}
