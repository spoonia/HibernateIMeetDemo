package intellimeet.hibernate.entity.pk;

import intellimeet.hibernate.ISBN;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@EqualsAndHashCode
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@IdClass(value = ISBN.class)
public class EmbeddedId {
    @Id
    @Column(name = "group_number")
    @Getter
    @Setter
    Integer group;

    @Id
    @Getter
    @Setter
    Integer publisher;

    @Id
    @Getter
    @Setter
    Integer title;

    @Id
    @Getter
    @Setter
    Integer checkdigit;

    @Column
    @Getter
    @Setter
    String name;
}