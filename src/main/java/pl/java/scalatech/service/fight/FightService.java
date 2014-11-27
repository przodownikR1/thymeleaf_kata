package pl.java.scalatech.service.fight;

import java.util.List;

import pl.java.scalatech.domain.Fight;

public interface FightService {
    List<Fight> findAll();

    Fight findOne(Long id);

    void delete(Fight fight);

    void save(Fight fight);
    
    
}
