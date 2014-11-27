package pl.java.scalatech.repository.boxer;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.java.scalatech.domain.Boxer;

public interface BoxerRepository extends JpaRepository<Boxer, Long> {

}
