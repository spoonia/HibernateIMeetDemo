package intellimeet.hibernate;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class EmbeddableISBN implements Serializable {
    @Column(name = "group_number")
    @Getter
    @Setter
    Integer group;

    @Getter
    @Setter
    Integer publisher;

    @Getter
    @Setter
    Integer title;

    @Getter
    @Setter
    Integer checkdigit;
}
