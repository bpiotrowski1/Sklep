import entity.Producent;
import entity.Produkt;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        Session session = Hibernate.getSessionFactory().openSession();
        session.beginTransaction();

        Producent producent = new Producent("Producent testowy");
        Produkt produkt = new Produkt("testowy produkt", 100, producent);
        session.persist(produkt);
        session.flush();
        session.close();
    }
}
