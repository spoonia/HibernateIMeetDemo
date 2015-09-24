package intellimeet.hibernate;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
public class EmbeddableEmployeeDetails implements Serializable {
    private Integer code;

    private String email;
}
