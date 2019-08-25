package entity;

import javax.persistence.*;

@Entity
@Table(schema = "sklep", name = "adres")
public class Adres {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id_adres;
    @Column
    private String ulica;
    @Column
    private String numerdomu;
    @Column
    private Integer nrmieszkania;
    @Column
    private String kod_podcztowy;
    @Column
    private String miejscowosc;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_klienta", unique = true)
    private Klient klient;

    public Adres() {
    }

    public Adres(final String ulica, final String numerdomu, final Integer nrmieszkania, final String kod_podcztowy, final String miejscowosc, final Klient klient) {
        this.ulica = ulica;
        this.numerdomu = numerdomu;
        this.nrmieszkania = nrmieszkania;
        this.kod_podcztowy = kod_podcztowy;
        this.miejscowosc = miejscowosc;
        this.klient = klient;
    }
}
