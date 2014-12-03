package pl.java.scalatech.domain;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.MappedSuperclass;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.Type;

import lombok.Data;
import lombok.EqualsAndHashCode;

@MappedSuperclass
@Data
@EqualsAndHashCode(callSuper=false)
public abstract class PKEntity extends AbstactId {

    private static final long serialVersionUID = 7669211182758111346L;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_modification")
    @Basic(fetch = FetchType.LAZY)
    @XmlTransient
    @Type(type = "org.jadira.usertype.dateandtime.threeten.PersistentLocalDate")
    protected LocalDate dateModification;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_added", nullable = false)
    @Basic(fetch = FetchType.LAZY)
    @Type(type = "org.jadira.usertype.dateandtime.threeten.PersistentLocalDate")
    @XmlTransient
    protected LocalDate dateAdded= LocalDate.now();


    @PreUpdate
    private void initPreUpdate() {
        dateModification = LocalDate.now();
        if (dateAdded == null) {
            dateAdded = dateModification;
        }
    }
}