package lab.mybatis;

import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;

@SpringBootApplication
@ComponentScan(basePackages = "lab.mybatis")
@MapperScan("lab.mybatis.dao")
public class Application {

    @Autowired
    DataSource dataSource;

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setConfigLocation(new ClassPathResource("mybatis-configuration.xml"));
        sessionFactory.setDataSource(dataSource);
        
        return sessionFactory.getObject();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
