package imeet.entity.inheritence.singletable;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
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
