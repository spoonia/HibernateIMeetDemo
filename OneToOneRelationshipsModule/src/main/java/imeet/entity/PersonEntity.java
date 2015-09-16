package imeet.entity;

import javax.persistence.*;

@Entity
public class PersonEntity {
    @Id
    @GeneratedValue
    private Integer id;

    @Version
    private Integer version;

    @Basic(optional = false)
    private String name;

//    @OneToOne
    @OneToOne(mappedBy = "person")
    private PassportEntity passport;

    public PersonEntity() {
    }

    public PersonEntity(String name) {
        this.name = name;
    }

    public PersonEntity(String name, PassportEntity passport) {
        this.name = name;
        this.passport = passport;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PassportEntity getPassport() {
        return passport;
    }

    public void setPassport(PassportEntity passport) {
        this.passport = passport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonEntity that = (PersonEntity) o;

        return id.equals(that.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "PersonEntity{" +
                "id=" + id +
                ", version=" + version +
                ", name='" + name + '\'' +
                ", passport=" + (passport == null ? null : passport.getPassportNumber()) +
                '}';
    }
}