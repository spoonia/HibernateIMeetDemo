package imeet.inheritence.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "PayableEmployeeEntity")
@DiscriminatorValue(value = "PayableEmployeeEntity")
@EqualsAndHashCode(of = {"id"})
@ToString(callSuper = true)
@NoArgsConstructor
public class EmployeeEntity extends PayableEntity {
    @Column
    @Getter
    @Setter
    private String firstName;

    @Column
    @Getter
    @Setter
    private String lastName;
}
