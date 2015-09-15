package imeet.inheritence.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "InvoiceEntity")
@EqualsAndHashCode(of = {"id"})
@ToString(callSuper = true)
@NoArgsConstructor
public class InvoiceEntity extends PayableEntity {
    @Column
    @Getter
    @Setter
    private Integer quantity;

    @Column
    @Getter
    @Setter
    private Double pricePerItem;
}
