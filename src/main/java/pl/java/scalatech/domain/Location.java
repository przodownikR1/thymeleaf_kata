package pl.java.scalatech.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;



@Embeddable
@XmlRootElement(name = "address")
@Data
public class Location implements Serializable {

    private static final long serialVersionUID = -2191631126853132555L;
    private final Double latitude;
    private final Double longitude;

   

}
