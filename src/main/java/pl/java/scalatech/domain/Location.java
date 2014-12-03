package pl.java.scalatech.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Embeddable
@XmlRootElement(name = "address")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location implements Serializable {

    private static final long serialVersionUID = -2191631126853132555L;
    private  Double latitude;
    private  Double longitude;

   

}
