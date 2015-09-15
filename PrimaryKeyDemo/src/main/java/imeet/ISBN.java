package imeet;

import lombok.*;

import javax.persistence.Column;
import java.io.Serializable;

@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class ISBN implements Serializable {
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