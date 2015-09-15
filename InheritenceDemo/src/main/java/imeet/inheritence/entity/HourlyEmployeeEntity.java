package imeet.inheritence.entity;

import lombok.*;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@EqualsAndHashCode(of = {"id"})
@ToString(callSuper = true)
@NoArgsConstructor
@AttributeOverride(name = "amount", column = @Column(name = "total_amount"))
public class HourlyEmployeeEntity extends EmployeeEntity {
    @Column
    @Getter
    @Setter
    private Double wage;

    @Column
    @Getter
    @Setter
    private Double hours;
}
