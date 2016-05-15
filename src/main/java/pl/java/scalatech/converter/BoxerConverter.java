package pl.java.scalatech.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pl.java.scalatech.domain.Boxer;
import pl.java.scalatech.repository.boxer.BoxerRepository;
@Component("string2BoxerConverter")
public class BoxerConverter implements Converter<String, Boxer> {

    @Autowired
    private BoxerRepository boxerRepository;
    
    @Override
    public Boxer convert(String id) {
        
        return boxerRepository.findOne(Long.parseLong(id));
    }

}
