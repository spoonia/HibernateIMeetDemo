package intellimeet.hibernate.superclass.entity;

import intellimeet.hibernate.superclass.Parent;
import lombok.*;

import javax.persistence.*;

@Entity
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
public class Child extends Parent {

    @Getter
    @Setter
    @Column(length = 50, nullable = false)
    private String name;
}