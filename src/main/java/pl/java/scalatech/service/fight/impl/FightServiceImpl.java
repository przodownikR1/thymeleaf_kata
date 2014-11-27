package pl.java.scalatech.service.fight.impl;

import java.util.List;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.java.scalatech.domain.Fight;
import pl.java.scalatech.repository.fight.FightRepository;
import pl.java.scalatech.service.fight.FightService;
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FightServiceImpl implements FightService{
    private final @NonNull FightRepository fightRepository;

    @Override
    public List<Fight> findAll() {
        return fightRepository.findAll();
    }

    @Override
    public Fight findOne(Long id) {
        return fightRepository.findOne(id);
    }

    @Override
    @Transactional
    public void delete(Fight fight) {
        fightRepository.delete(fight);
        
    }

    @Override
    @Transactional
    public void save(Fight fight) {
        fightRepository.save(fight);
    }
    
}
