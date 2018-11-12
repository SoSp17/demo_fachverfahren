package de.scag.demofachverfahren.paasdemo.web.antragsstellung;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
public class AntragDTO {
    private Art art;
    private LocalDate gueltigAb;
    private String antragssteller;

    public static List<Art> arten() {
        return Arrays.asList(Art.values());
    }

    public enum Art {
        KITA,
        SPRACHSTAND,
        EFOEB
    }
}
