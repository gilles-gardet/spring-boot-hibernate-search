package com.ggardet.hibernatesearch.core.config;

import com.ggardet.hibernatesearch.search.repository.SearchRepositoryImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(
        repositoryBaseClass = SearchRepositoryImpl.class,
        basePackages = "com.ggardet.hibernatesearch.resource"
)
public class RepositoryConfiguration {
}
