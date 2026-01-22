package naderdeghaili.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "gare_atletica")
@DiscriminatorValue("Ateltica")
public class GaraDiAtletica extends Event {

    //più atleti competono in più gare
    @ManyToMany
    @JoinTable(
            name = "gara_atleti",
            joinColumns = @JoinColumn(name = "gara_id"),
            inverseJoinColumns = @JoinColumn(name = "persona_id"))
    private Set<Person> atleti;


    @ManyToOne
    @JoinColumn(name = "vincitore_id")
    private Person vincitore;

    public GaraDiAtletica() {
    }

    public GaraDiAtletica(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location, Set<Person> atleti, Person vincitore) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
        this.atleti = atleti;
        this.vincitore = vincitore;
    }

    public Set<Person> getAtleti() {
        return atleti;
    }

    public void setAtleti(Set<Person> atleti) {
        this.atleti = atleti;
    }

    public Person getVincitore() {
        return vincitore;
    }

    public void setVincitore(Person vincitore) {
        this.vincitore = vincitore;
    }

    @Override
    public String toString() {
        return
                "atleti=" + atleti +
                        ", vincitore=" + vincitore +
                        '}';
    }
}
