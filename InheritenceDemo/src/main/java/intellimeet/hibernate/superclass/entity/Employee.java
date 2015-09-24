package intellimeet.hibernate.superclass.entity;

import intellimeet.hibernate.enums.EmployeeStatus;
import intellimeet.hibernate.superclass.Payable;
import lombok.*;

import javax.persistence.*;

@Entity
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
public class Employee extends Payable {

    @Column
    @Getter
    @Setter
    private String firstName;

    @Column
    @Getter
    @Setter
    private String lastName;

    @Getter
    @Setter
    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private EmployeeStatus employeeStatus;
}
