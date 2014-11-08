package pl.java.scalatech.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Configuration
@ComponentScan(basePackages="pl.java.scalatech.repository",useDefaultFilters=false,includeFilters={@Filter(Repository.class)})
@EnableJpaRepositories(basePackages="pl.java.scalatech.repository")
@Import(value={PropertiesLoader.class,DsConfig.class})
public class RepositoryConfig {

}
