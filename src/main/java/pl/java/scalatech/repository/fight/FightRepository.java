package pl.java.scalatech.repository.fight;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.java.scalatech.domain.Fight;

public interface FightRepository extends JpaRepository<Fight, Long>{

}
