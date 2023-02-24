package com.ggardet.hibernatesearch.resource.plant.model;

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
@Table(name = "plant")
@Getter
@Setter
public class Plant extends Product {
    public Plant() {
        this.createdAt = Instant.now();
    }

    public Plant(String alias, String scientificName, String family) {
        super(alias);
        this.scientificName = scientificName;
        this.family = family;
        this.createdAt = Instant.now();
    }

    @FullTextField()
    @Column(name = "scientificName")
    private String scientificName;

    @FullTextField()
    @Column(name = "family")
    private String family;

    @Column(name = "createdAt")
    private Instant createdAt ;
}
