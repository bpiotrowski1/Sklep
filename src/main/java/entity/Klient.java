package entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema = "sklep", name = "klient")
public class Klient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @Getter
    private Integer id_klient;
    @Column
    private String imie;
    @Column
    private String nazwisko;
    @Column
    private String telefon;

    @OneToOne(mappedBy = "klient")
    private Adres adres;
    @ManyToMany(mappedBy = "klienci")
    private List<Produkt> produkty;

    public Klient() {
    }

    public Klient(final String imie, final String nazwisko, final String telefon, final Adres adres) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.telefon = telefon;
        this.adres = adres;
    }
}
