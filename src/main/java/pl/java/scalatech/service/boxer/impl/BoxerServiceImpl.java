package pl.java.scalatech.service.boxer.impl;

import java.util.List;









import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.java.scalatech.domain.Boxer;
import pl.java.scalatech.domain.Country;
import pl.java.scalatech.repository.boxer.BoxerRepository;
import pl.java.scalatech.service.boxer.BoxerService;

@Service
@Transactional(readOnly=true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BoxerServiceImpl implements BoxerService {

    private final @NonNull BoxerRepository boxerRepository;
    
    @Override
    public List<Boxer> findAll() {
        return boxerRepository.findAll();
    }

    @Override
    public Boxer findOne(Long id) {
        return boxerRepository.getOne(id);
    }

    @Override
    @Transactional
    public void delete(Boxer boxer) {
        boxerRepository.delete(boxer);
        
    }

    @Override
    @Transactional
    public void save(Boxer boxer) {
        boxerRepository.save(boxer);
        
    }

}
