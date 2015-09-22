package intellimeet.hibernate.inheritence.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Invoice")
@EqualsAndHashCode(of = {"id"})
@ToString(callSuper = true)
@NoArgsConstructor
public class Invoice extends Payable {
    @Column
    @Getter
    @Setter
    private Integer quantity;

    @Column
    @Getter
    @Setter
    private Double pricePerItem;
}
