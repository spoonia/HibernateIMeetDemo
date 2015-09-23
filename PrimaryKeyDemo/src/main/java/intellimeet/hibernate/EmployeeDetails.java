package intellimeet.hibernate;

import lombok.*;

import java.io.Serializable;

@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class EmployeeDetails implements Serializable {
    @Getter
    @Setter
    Integer code;

    @Getter
    @Setter
    String email;
}