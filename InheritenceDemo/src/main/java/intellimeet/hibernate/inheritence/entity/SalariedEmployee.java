package intellimeet.hibernate.inheritence.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@EqualsAndHashCode(of = {"id"})
@ToString(callSuper = true)
@NoArgsConstructor
public class SalariedEmployee extends Employee {
    @Column
    @Getter
    @Setter
    private Double salary;
}
