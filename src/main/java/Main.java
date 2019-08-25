import entity.*;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        Session session = Hibernate.getSessionFactory().openSession();
        session.beginTransaction();

        Producent producent = new Producent("Producent testowy");
        session.persist(producent);

        Kategoria_produktu kategoria_produktu = new Kategoria_produktu("Kategoria testowa");
        session.persist(kategoria_produktu);

        Produkt produkt = new Produkt("testowy produkt", 100, producent, kategoria_produktu);
        session.persist(produkt);

        Klient klient = new Klient();
        klient.setImie("Imie");
        klient.setNazwisko("Nazwisko");
        klient.setTelefon("123456789");
        session.persist(klient);

        Adres adres = new Adres("Ulica", "1A", 5, "12-345", "Miejscowosc", klient);
        session.persist(adres);

        klient.setAdres(adres);
        session.merge(klient);

        session.flush();
        session.close();
    }
}
