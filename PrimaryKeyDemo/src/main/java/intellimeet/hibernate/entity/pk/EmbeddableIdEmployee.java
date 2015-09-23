package intellimeet.hibernate.entity.pk;

import intellimeet.hibernate.EmbeddableEmployeeDetails;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
@EqualsAndHashCode
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class EmbeddableIdEmployee {
    @EmbeddedId
    @Getter
    @Setter
    EmbeddableEmployeeDetails id;

    @Column
    @Getter
    @Setter
    String name;
}