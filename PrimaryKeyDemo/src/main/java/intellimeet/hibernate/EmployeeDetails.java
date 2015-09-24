package intellimeet.hibernate;

import lombok.*;

import java.io.Serializable;

@EqualsAndHashCode
public class EmployeeDetails implements Serializable {
    private Integer code;

    private String email;
}