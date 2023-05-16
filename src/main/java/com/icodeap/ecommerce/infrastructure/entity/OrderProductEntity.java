package com.icodeap.ecommerce.infrastructure.entity;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.criteria.CriteriaBuilder;

@Data
@Entity
@Table(name = "ordersproducts")
public class OrderProductEntity {
    @EmbeddedId
    private OrderProductPK pk;
    private Integer quantity;
}
