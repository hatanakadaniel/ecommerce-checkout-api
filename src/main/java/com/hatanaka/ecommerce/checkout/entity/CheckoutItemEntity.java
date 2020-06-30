package com.hatanaka.ecommerce.checkout.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Audited
@EntityListeners(AuditingEntityListener.class)
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckoutItemEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String product;

    @ManyToOne
    private CheckoutEntity checkout;
}
