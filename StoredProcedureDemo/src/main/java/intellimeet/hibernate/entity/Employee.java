package intellimeet.hibernate.entity;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    private Integer id;

    @Version
    private Integer version;

    @Basic(optional = false)
    private String name;

//    @OneToOne
    @OneToOne(mappedBy = "person")
    private Passport passport;

    public Employee() {
    }

    public Employee(String name) {
        this.name = name;
    }

    public Employee(String name, Passport passport) {
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

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee that = (Employee) o;

        return id.equals(that.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", version=" + version +
                ", name='" + name + '\'' +
                ", passport=" + (passport == null ? null : passport.getPassportNumber()) +
                '}';
    }
}