package com.icodeap.ecommerce.infrastructure.entity;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@Embeddable//atributos como clases compuestas en otra clase
public class OrderProductPK implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
    private ProductEntity productEntity;
    @ManyToOne(fetch = FetchType.LAZY)
    private OrderEntity orderEntity;



}
