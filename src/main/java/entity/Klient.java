package entity;

import lombok.Getter;
import lombok.Setter;

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
    @Setter
    private String imie;
    @Column
    @Setter
    private String nazwisko;
    @Column
    @Setter
    private String telefon;

    @OneToOne(mappedBy = "klient")
    @Setter
    private Adres adres;
    @ManyToMany(mappedBy = "klienci")
    private List<Produkt> produkty;

    public Klient() {
    }
}
