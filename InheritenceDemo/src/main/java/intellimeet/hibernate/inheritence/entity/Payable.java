package intellimeet.hibernate.inheritence.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "EntityName", discriminatorType = DiscriminatorType.STRING, length = 255)
@DiscriminatorValue(value = "Payable")
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class Payable {
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @Getter
    @Setter
    private Double amount;
}
