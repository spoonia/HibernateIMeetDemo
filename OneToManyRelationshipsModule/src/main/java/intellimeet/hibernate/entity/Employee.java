package intellimeet.hibernate.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    private Integer id;

    @Version
    private Integer version;

    @Basic(optional = false)
    private String name;

    @OneToMany(orphanRemoval = true, mappedBy = "person", fetch = FetchType.LAZY)
    private List<Address> addresses;

    public Employee() {
    }

    public Employee(String name) {
        this.name = name;
    }

    public Employee(String name, List<Address> addresses) {
        this.name = name;
        this.addresses = addresses;
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

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
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
                ", addresses=" + addresses.size() +
                '}';
    }
}