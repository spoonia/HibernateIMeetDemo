package intellimeet.hibernate.entity.pk;

import intellimeet.hibernate.EmbeddableEmployeeDetails;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@EqualsAndHashCode
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class EmbeddableEmployee {
    @Id
    @Getter
    @Setter
    EmbeddableEmployeeDetails id;

    @Column
    @Getter
    @Setter
    String name;
}