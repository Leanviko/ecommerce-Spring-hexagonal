package com.icodeap.ecommerce.infrastructure.entity;

import com.icodeap.ecommerce.domain.Product;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "stock")
@NoArgsConstructor
@Data
public class StockEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime dateCreated;
    private Integer unitIn;
    private Integer unitOut;
    private String description;
    private Integer balance;

    @ManyToOne
    @OnDelete(action= OnDeleteAction.CASCADE)
    private ProductEntity productEntity;
}
