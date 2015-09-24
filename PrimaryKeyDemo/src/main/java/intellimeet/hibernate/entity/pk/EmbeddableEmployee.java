package intellimeet.hibernate.entity.pk;

import intellimeet.hibernate.EmbeddableEmployeeDetails;
import intellimeet.hibernate.enums.EmployeeStatus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EmbeddableEmployee {
    @Id
    private EmbeddableEmployeeDetails id;

    @Column
    private String name;

    @Column
    private EmployeeStatus employeeStatus;
}