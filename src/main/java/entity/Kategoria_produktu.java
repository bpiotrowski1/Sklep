package entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema = "sklep", name = "kategoria_produktu")
public class Kategoria_produktu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @Getter
    private Integer id_kategori;
    @Column
    private String nazwa;

    @OneToMany(mappedBy = "kategoria_produktu", cascade = CascadeType.ALL)
    private List<Produkt> produkty;

    public Kategoria_produktu() {
    }

    public Kategoria_produktu(final String nazwa) {
        this.nazwa = nazwa;
    }
}
