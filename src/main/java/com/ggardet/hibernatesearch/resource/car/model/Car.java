package com.ggardet.hibernatesearch.resource.car.model;

import com.ggardet.hibernatesearch.resource.product.model.Product;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.Instant;

@Indexed
@Entity
@Table(name = "car")
@Getter
@Setter
public class Car extends Product {
    public Car() {
        this.createdAt = Instant.now();
    }

    public Car(String alias, String model) {
        super(alias);
        this.model = model;
        this.createdAt = Instant.now();
    }

    @FullTextField()
    @Column(name = "model")
    private String model;

    @Column(name = "createdAt")
    private Instant createdAt ;
}
