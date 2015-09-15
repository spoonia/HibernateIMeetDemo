package imeet.entity.pk;

import imeet.EmbeddableISBN;
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
public class EmbeddableEntity {
    @Id
    @Getter
    @Setter
    EmbeddableISBN id;

    @Column
    @Getter
    @Setter
    String name;
}