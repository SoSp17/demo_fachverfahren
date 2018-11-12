package de.scag.demofachverfahren.paasdemo.repositories;

import de.scag.demofachverfahren.paasdemo.model.antragsstellung.Antrag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AntragRepository extends JpaRepository<Antrag, Long> {
}
