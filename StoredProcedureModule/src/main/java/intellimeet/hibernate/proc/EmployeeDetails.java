package intellimeet.hibernate.proc;

import java.math.BigInteger;

public class EmployeeDetails {
    private Integer id;
    private String name;
    private BigInteger passportNumber;

    public EmployeeDetails() {
    }

    public EmployeeDetails(Integer id, String name, BigInteger passportNumber) {
        this.id = id;
        this.name = name;
        this.passportNumber = passportNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(BigInteger passportNumber) {
        this.passportNumber = passportNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeDetails that = (EmployeeDetails) o;

        if (!id.equals(that.id)) return false;
        if (!name.equals(that.name)) return false;
        return passportNumber.equals(that.passportNumber);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + passportNumber.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "EmployeeDetails{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", passportNumber=" + passportNumber +
                '}';
    }
}