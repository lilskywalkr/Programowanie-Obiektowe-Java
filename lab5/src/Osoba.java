public class Osoba extends Wpis{
    private final String imie;
    private final String nazwisko;
    private final String adres;
    private final NrTelefoniczny nrTelefoniczny;

    public Osoba(String imie, String nazwisko, String adres, NrTelefoniczny nrTelefoniczny) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.adres = adres;
        this.nrTelefoniczny = nrTelefoniczny;
    }

    public String getImie() {
        return this.imie;
    }

    public String getNazwisko() {
        return this.nazwisko;
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
        result = this.imie + " " + this.nazwisko + ", " + this.adres + ", tel. " + this.nrTelefoniczny.getNrKierunkowy() + " " + this.nrTelefoniczny.getNrTelefoniczny();

        return result;
    }
}
