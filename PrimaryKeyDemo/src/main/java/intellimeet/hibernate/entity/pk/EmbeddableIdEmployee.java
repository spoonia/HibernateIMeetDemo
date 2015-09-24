package intellimeet.hibernate.entity.pk;

import intellimeet.hibernate.EmbeddableEmployeeDetails;
import intellimeet.hibernate.enums.EmployeeStatus;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class EmbeddableIdEmployee {
    @EmbeddedId
    private EmbeddableEmployeeDetails id;

    @Column
    private String name;

    @Column
    private EmployeeStatus employeeStatus;
}