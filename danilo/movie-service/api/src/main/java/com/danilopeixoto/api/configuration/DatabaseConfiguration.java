package com.danilopeixoto.api.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;

@Configuration
public class DatabaseConfiguration {
  @Autowired
  private APIConfiguration configuration;

  @Bean
  public Jackson2RepositoryPopulatorFactoryBean populator() {
    ObjectMapper objectMapper = new ObjectMapper();

    Jackson2RepositoryPopulatorFactoryBean factory = new Jackson2RepositoryPopulatorFactoryBean();

    factory.setResources(new Resource[]{
      new ClassPathResource(this.configuration.getDatabasePath())
    });

    return factory;
  }
}
