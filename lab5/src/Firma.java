public class Firma extends Wpis{
    private final String nazwa;
    private final String adres;
    private final NrTelefoniczny nrTelefoniczny;

    public Firma(String nazwa, String adres, NrTelefoniczny nrTelefoniczny) {
        this.nazwa = nazwa;
        this.adres = adres;
        this.nrTelefoniczny = nrTelefoniczny;
    }

    public String getNazwa() {
        return this.nazwa;
    }

    public String getAdres() {
        return this.adres;
    }

    public NrTelefoniczny getNrTelefoniczny() {
        return this.nrTelefoniczny;
    }

    @Override
    public String opis() {
        String result = "";
        result = this.nazwa + ", " + this.adres + ", tel. " + this.nrTelefoniczny.getNrKierunkowy() + " " + this.nrTelefoniczny.getNrTelefoniczny();

        return result;
    }
}
