package imeet.entity.pk;

import imeet.ISBN;
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
public class EmbeddableIdEntity {
    @EmbeddedId
    @Getter
    @Setter
    ISBN id;

    @Column
    @Getter
    @Setter
    String name;
}