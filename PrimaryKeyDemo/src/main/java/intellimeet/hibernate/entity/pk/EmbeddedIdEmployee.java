package intellimeet.hibernate.entity.pk;

import intellimeet.hibernate.EmployeeDetails;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(value = EmployeeDetails.class)

@EqualsAndHashCode
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class EmbeddedIdEmployee {
    @Id
    @Getter
    @Setter
    Integer code;

    @Id
    @Getter
    @Setter
    String email;

    @Column
    @Getter
    @Setter
    String name;
}