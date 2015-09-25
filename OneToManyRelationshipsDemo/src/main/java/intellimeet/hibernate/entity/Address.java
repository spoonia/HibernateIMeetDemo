package intellimeet.hibernate.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false, length = 1024)
    private String address;

    @Basic(optional = false)
    private String city;

    @Basic(optional = false)
    private String state;

    @Basic(optional = false)
    private Long pinCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @Cascade(value = {CascadeType.PERSIST, CascadeType.SAVE_UPDATE})
    private Employee person;

    public Address() {
    }

    public Address(Employee person) {
        this.person = person;
    }

    public Address(String address, String city, String state, Long pinCode) {
        this.address = address;
        this.city = city;
        this.state = state;
        this.pinCode = pinCode;
    }

    public Address(String address, String city, String state, Long pinCode, Employee person) {
        this.address = address;
        this.city = city;
        this.state = state;
        this.pinCode = pinCode;
        this.person = person;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getPinCode() {
        return pinCode;
    }

    public void setPinCode(Long pinCode) {
        this.pinCode = pinCode;
    }

    public Employee getPerson() {
        return person;
    }

    public void setPerson(Employee person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address that = (Address) o;

        return id.equals(that.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", pinCode=" + pinCode +
                ", person=" + (person != null ? person.getId() : null) +
                '}';
    }
}
