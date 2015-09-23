package intellimeet.hibernate;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class EmbeddableEmployeeDetails implements Serializable {
    @Getter
    @Setter
    Integer code;

    @Getter
    @Setter
    String email;
}
