package de.scag.demofachverfahren.paasdemo.model.antragsstellung;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Accessors(chain = true)
@Entity
public class Antrag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    private Art art;
    private LocalDate gueltig;
    private String antragssteller;

    public enum Art {
        KITA,
        SPRACHSTAND,
        EFOEB
    }
}
