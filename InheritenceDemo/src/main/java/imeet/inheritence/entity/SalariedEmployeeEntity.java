package imeet.inheritence.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@EqualsAndHashCode(of = {"id"})
@ToString(callSuper = true)
@NoArgsConstructor
public class SalariedEmployeeEntity extends EmployeeEntity {
    @Column
    @Getter
    @Setter
    private Double salary;
}
