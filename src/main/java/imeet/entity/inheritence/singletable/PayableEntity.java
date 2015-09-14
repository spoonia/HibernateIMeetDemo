package imeet.entity.inheritence.singletable;

import lombok.*;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "EntityName", discriminatorType = DiscriminatorType.STRING, length = 255)
@DiscriminatorValue(value = "PayableEntity")
@EqualsAndHashCode
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class PayableEntity {
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
