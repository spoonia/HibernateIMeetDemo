package intellimeet.hibernate.entity.pk;

import intellimeet.hibernate.EmployeeDetails;
import intellimeet.hibernate.enums.EmployeeStatus;

import javax.persistence.*;

@Entity
@IdClass(value = EmployeeDetails.class)

public class EmbeddedIdEmployee {
    @Id
    private Integer code;

    @Id
    private String email;

    @Column
    private String name;

    @Column
    private EmployeeStatus employeeStatus;
}