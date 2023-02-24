package com.ggardet.hibernatesearch.resource.product.model;

import com.ggardet.hibernatesearch.core.repository.RepositoryTrackableEntityWithUUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.GenericField;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@ToString
@NoArgsConstructor
public abstract class Product extends RepositoryTrackableEntityWithUUID {
    public Product(String alias) {
        this.alias = alias;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id")
    private Long id;

    @GenericField()
    @Column(name = "alias", unique = true)
    private String alias;
}
