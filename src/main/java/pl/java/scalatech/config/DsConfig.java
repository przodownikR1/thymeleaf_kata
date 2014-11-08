package pl.java.scalatech.config;

import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@PropertySource("classpath:ds.properties")
@Import(value={PropertiesLoader.class})
@EnableJpaRepositories("pl.java.scalatech.repository")
public class DsConfig {
    @Value("${hibernate.dialect}")
    private String dialect;
    @Value("${spring.jpa.show-sql}")
    private boolean sqlShowFlag;
    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddlGenerate;
    @Value("${hibernate.show.sql}")
    private boolean formatSql;
    
  /*  @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
    }*/
    
    @Bean
    @DependsOn(value="h2Server")
    DataSource dataSource(Server h2Server) {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(org.h2.Driver.class);
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        dataSource.setUrl("jdbc:h2:tcp://localhost:9092/mem:przodownik;DB_CLOSE_DELAY=-1");
        return dataSource;
    }
    
    
    @Bean(name = "h2Server", initMethod = "start", destroyMethod = "stop")
    @DependsOn(value = "h2WebServer")
    public org.h2.tools.Server createTcpServer() throws SQLException {
        return org.h2.tools.Server.createTcpServer("-tcp,-tcpAllowOthers,-tcpPort,9092".split(","));
    }

    @Bean(name = "h2WebServer", initMethod = "start", destroyMethod = "stop")
    public org.h2.tools.Server createWebServer() throws SQLException {
        return org.h2.tools.Server.createWebServer("-web,-webAllowOthers,-webPort,8082".split(","));
    }
    
    
    @Bean
    @DependsOn(value="dataSource")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws SQLException {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource(createTcpServer()));
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan("pl.java.scalatech.domain");
        entityManagerFactoryBean.setJpaProperties(jpaProperties());
        return entityManagerFactoryBean;
    }

    
    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
    
    private Properties jpaProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty("hibernate.dialect", dialect);
        properties.setProperty("hibernate.show_sql", ""+sqlShowFlag);
        properties.setProperty("hibernate.format_sql", ""+formatSql);
        return properties;
    }

   
    
    @Bean
    public JpaTransactionManager transactionManager() throws SQLException {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        transactionManager.setDataSource(dataSource(createTcpServer()));
        return transactionManager;
    }
  /*  @Bean
    public SpringLiquibase liquibase() throws SQLException {
      
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource(createTcpServer()));
        liquibase.setChangeLog("classpath:liquibase/master.xml");
        liquibase.setContexts("development, production");
        return liquibase;
    }*/
}
