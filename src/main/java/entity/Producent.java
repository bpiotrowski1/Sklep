package entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema = "sklep", name = "producent")
public class Producent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @Getter
    private Integer id_producenta;
    @Column
    private String nazwa;

    @OneToMany(mappedBy = "producent_produktu", cascade = CascadeType.ALL)
    private List<Produkt> produkty;

    public Producent() {
    }

    public Producent(final String nazwa) {
        this.nazwa = nazwa;
    }
}
