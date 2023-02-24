package com.ggardet.hibernatesearch.resource.bicycle.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.GenericField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Indexed
@Entity
@Table(name = "bicycle")
@Getter
@Setter
@NoArgsConstructor
public class Bicycle {
    public Bicycle(String alias, String model) {
        this.model = model;
        this.alias = alias;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @FullTextField()
    @Column(name = "model")
    private String model;

    @GenericField()
    @Column(name = "alias", unique = true)
    private String alias;
}
