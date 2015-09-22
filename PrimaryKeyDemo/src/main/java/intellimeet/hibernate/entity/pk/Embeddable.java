package intellimeet.hibernate.entity.pk;

import intellimeet.hibernate.EmbeddableISBN;
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
public class Embeddable {
    @Id
    @Getter
    @Setter
    EmbeddableISBN id;

    @Column
    @Getter
    @Setter
    String name;
}