package intellimeet.hibernate.entity;

import intellimeet.hibernate.enums.EmployeeStatus;
import lombok.*;

import javax.persistence.*;


@Entity(name = "EmployeeEntity")
@EqualsAndHashCode
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Table(name = "employee")
public class Employee {

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Version
    @Getter
    @Setter
    private Long Version;

    @Getter
    @Setter
    @Column(nullable = false, length = 100)
    private String name;

    @Getter
    @Setter
    @Column(unique = true, nullable = false)
    private String email;

    @Getter
    @Setter
    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private EmployeeStatus employeeStatus;

    @Getter
    @Setter
    @Transient
    private Boolean flag;
}