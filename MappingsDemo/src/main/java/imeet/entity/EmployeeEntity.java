package imeet.entity;

import imeet.EmployeeStatus;
import lombok.*;

import javax.persistence.*;


@Entity(name = "EmployeeEntity")
@EqualsAndHashCode
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Table(name = "employee")
public class EmployeeEntity {

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Version
    @Getter
    @Setter
    private Long Version;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private EmployeeStatus employeeStatus;

    @Transient
    private Boolean flag;
}