import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        TreeMap<NrTelefoniczny, Wpis> ksiazkaTelefoniczna = new TreeMap<>();

        NrTelefoniczny nr1 = new NrTelefoniczny("48", "456726384");
        Osoba osoba1 = new Osoba("Ronald", "Frangulyan", "ul. Piłsudskiego 4, 12-331, Poznań", nr1);
        ksiazkaTelefoniczna.put(nr1, osoba1);

        NrTelefoniczny nr2 = new NrTelefoniczny("48", "456726383");
        Osoba osoba2 = new Osoba("Roland", "Frankiewicz", "ul. Piłsudskiego 4, 12-331, Poznań", nr2);
        ksiazkaTelefoniczna.put(nr2, osoba2);

        NrTelefoniczny nr3 = new NrTelefoniczny("48", "237998231");
        Osoba osoba3 = new Osoba("Shavo", "Odadjian", "ul. Jana Pawła II 15, 78-233, Wrocław", nr3);
        ksiazkaTelefoniczna.put(nr3, osoba3);

        NrTelefoniczny nr4 = new NrTelefoniczny("48", "772899098");
        Firma firma1 = new Firma("Angry Doughnut Sp. z o.o.", "ul. Schwarzenegger 7, 23-884, Opole", nr4);
        ksiazkaTelefoniczna.put(nr4, firma1);

        NrTelefoniczny nr5 = new NrTelefoniczny("48", "678231880");
        Firma firma2 = new Firma("Real Chiggaz Sp. z o.o.", "ul. Nortona 2, 78-004, Gdynia", nr5);
        ksiazkaTelefoniczna.put(nr5, firma2);

        System.out.println("Ksiazka telefoniczna: ");
        for (Map.Entry<NrTelefoniczny, Wpis> entry : ksiazkaTelefoniczna.entrySet()) {
            System.out.println(entry.getValue().opis());
        }


        HashSet<String> uniqueValues = new HashSet<>();
        Iterator<Map.Entry<NrTelefoniczny, Wpis>> iterator = ksiazkaTelefoniczna.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<NrTelefoniczny, Wpis> entry = iterator.next();
            String[] values = entry.getValue().opis().split(", ");
            if (uniqueValues.contains(values[1])) {
                iterator.remove();
            } else {
                uniqueValues.add(values[1]);
            }
        }

        System.out.println();
        System.out.println("Ksiazka telefoniczna: ");
        for (Map.Entry<NrTelefoniczny, Wpis> entry : ksiazkaTelefoniczna.entrySet()) {
            System.out.println(entry.getValue().opis());
        }
    }
}