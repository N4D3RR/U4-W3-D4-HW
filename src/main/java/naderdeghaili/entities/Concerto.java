package naderdeghaili.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "concerti")
@DiscriminatorValue("Concerto")

public class Concerto extends Event {

    @Enumerated(EnumType.STRING)
    private Genere genere;

    private boolean isStreaming;

    public Concerto() {
    }

    public Concerto(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location, Genere genere, boolean isStreaming) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
        this.genere = genere;
        this.isStreaming = isStreaming;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public boolean isStreaming() {
        return isStreaming;
    }

    public void setStreaming(boolean streaming) {
        isStreaming = streaming;
    }

    @Override
    public String toString() {
        return
                "genere=" + genere +
                        ", isStreaming=" + isStreaming +
                        '}';
    }
}
