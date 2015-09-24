package intellimeet.hibernate.inheritence.entity;

import intellimeet.hibernate.enums.EmployeeStatus;
import lombok.*;

import javax.persistence.*;

@Entity(name = "PayableEmployeeEntity")
@DiscriminatorValue(value = "PayableEmployeeEntity")
@EqualsAndHashCode(of = {"id"})
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

    @Enumerated(value = EnumType.STRING)
    @Column
    @Getter
    @Setter
    private EmployeeStatus employeeStatus;
}
