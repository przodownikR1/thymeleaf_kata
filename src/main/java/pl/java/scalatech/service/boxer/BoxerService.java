package pl.java.scalatech.service.boxer;

import java.util.List;

import pl.java.scalatech.domain.Boxer;

public interface BoxerService {

    List<Boxer> findAll();

    Boxer findOne(Long id);

    void delete(Boxer boxer);

    Boxer save(Boxer boxer);

   

}
