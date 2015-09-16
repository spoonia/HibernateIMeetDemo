package imeet.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class PersonEntity {
    @Id
    @GeneratedValue
    private Integer id;

    @Version
    private Integer version;

    @Basic(optional = false)
    private String name;

    @OneToMany(orphanRemoval = true, mappedBy = "person", fetch = FetchType.LAZY)
    private List<AddressEntity> addresses;

    public PersonEntity() {
    }

    public PersonEntity(String name) {
        this.name = name;
    }

    public PersonEntity(String name, List<AddressEntity> addresses) {
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

    public List<AddressEntity> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressEntity> addresses) {
        this.addresses = addresses;
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
                ", addresses=" + addresses.size() +
                '}';
    }
}