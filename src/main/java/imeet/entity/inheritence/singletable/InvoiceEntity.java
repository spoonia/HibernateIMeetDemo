package imeet.entity.inheritence.singletable;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "InvoiceEntity")
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
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
