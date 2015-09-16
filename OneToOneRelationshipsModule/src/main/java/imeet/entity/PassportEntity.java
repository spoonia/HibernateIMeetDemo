package imeet.entity;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
public class PassportEntity {
    @Id
    @GeneratedValue
    private Integer id;

    @Version
    private Integer version;

    @Column(nullable = false)
    private Long passportNumber;

    @OneToOne
    @Cascade(value = CascadeType.ALL)
    private PersonEntity person;

    public PassportEntity() {
    }

    public PassportEntity(Long passportNumber) {
        this.passportNumber = passportNumber;
    }

    public PassportEntity(Long passportNumber, PersonEntity person) {
        this.passportNumber = passportNumber;
        this.person = person;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Long getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(Long passportNumber) {
        this.passportNumber = passportNumber;
    }

    public PersonEntity getPerson() {
        return person;
    }

    public void setPerson(PersonEntity person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PassportEntity that = (PassportEntity) o;

        if (!id.equals(that.id)) return false;
        return passportNumber.equals(that.passportNumber);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + passportNumber.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "PassportEntity{" +
                "id=" + id +
                ", version=" + version +
                ", passportNumber=" + passportNumber +
                ", person=" + (person == null ? null : person.getId()) +
                '}';
    }
}