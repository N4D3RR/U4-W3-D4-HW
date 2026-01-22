package naderdeghaili.entities;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "partite_calcio")
@DiscriminatorValue("Calcio")
public class PartitaDiCalcio extends Event {

    private String squadraCasa;
    private String squadraOspite;
    private String squadraVincente; //null
    private int golSquadraCasa;
    private int golSquadraOspite;

    public PartitaDiCalcio() {

    }

    public PartitaDiCalcio(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location, int golSquadraCasa, int golSquadraOspite, String squadraCasa, String squadraOspite, String squadraVincente) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
        this.golSquadraCasa = golSquadraCasa;
        this.golSquadraOspite = golSquadraOspite;
        this.squadraCasa = squadraCasa;
        this.squadraOspite = squadraOspite;

        if (golSquadraCasa > golSquadraOspite) {
            this.squadraVincente = squadraCasa;
        } else if (golSquadraCasa < golSquadraOspite) {
            this.squadraVincente = squadraOspite;
        } else {
            this.squadraVincente = null;
        }

    }

    public int getGolSquadraCasa() {
        return golSquadraCasa;
    }

    public void setGolSquadraCasa(int golSquadraCasa) {
        this.golSquadraCasa = golSquadraCasa;
    }

    public int getGolSquadraOspite() {
        return golSquadraOspite;
    }

    public void setGolSquadraOspite(int golSquadraOspite) {
        this.golSquadraOspite = golSquadraOspite;
    }

    public String getSquadraCasa() {
        return squadraCasa;
    }

    public void setSquadraCasa(String squadraCasa) {
        this.squadraCasa = squadraCasa;
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }

    public void setSquadraOspite(String squadraOspite) {
        this.squadraOspite = squadraOspite;
    }

    public String getSquadraVincente() {
        return squadraVincente;
    }

    @Override
    public String toString() {
        return
                "golSquadraCasa=" + golSquadraCasa +
                        ", squadraCasa='" + squadraCasa + '\'' +
                        ", squadraOspite='" + squadraOspite + '\'' +
                        ", squadraVincente='" + squadraVincente + '\'' +
                        ", golSquadraOspite=" + golSquadraOspite +
                        '}';
    }
}
