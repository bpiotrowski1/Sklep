package entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema = "sklep", name = "produkt")
public class Produkt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @Getter
    private Integer id_produktu;
    @Column
    private String nazwa;
    @Column
    private Integer cena;

    @ManyToOne
    @JoinColumn(name = "id_producenta")
    private Producent producent_produktu;

    @ManyToOne
    @JoinColumn(name = "id_kategori")
    private Kategoria_produktu kategoria_produktu;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "produkt_klient",
            joinColumns = @JoinColumn(name = "id_produktu"),
            inverseJoinColumns = @JoinColumn(name = "id_klient"))
    private List<Klient> klienci;

    public Produkt() {
    }

    public Produkt(final String nazwa, final Integer cena, final Producent producent_produktu, final Kategoria_produktu kategoria_produktu) {
        this.nazwa = nazwa;
        this.cena = cena;
        this.producent_produktu = producent_produktu;
        this.kategoria_produktu = kategoria_produktu;
    }
}
