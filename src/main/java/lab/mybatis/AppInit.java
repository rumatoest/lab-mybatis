package lab.mybatis;

import java.math.BigDecimal;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Statement;
import javax.sql.DataSource;
import lab.mybatis.dao.CustomerMapper;
import lab.mybatis.dao.LinkMapper;
import lab.mybatis.domain.Customer;
import lab.mybatis.domain.Link;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppInit implements ApplicationRunner {

    private static final Logger logger = LoggerFactory.getLogger(AppInit.class);

    @Autowired
    DataSource ds;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        URL resource = getClass().getClassLoader().getResource("initialize.sql");
        byte[] initBypes = Files.readAllBytes(Paths.get(resource.toURI()));

        try (Connection conn = ds.getConnection(); Statement st = conn.createStatement();) {
            st.execute(new String(initBypes));
        }

//        insertCustomers();
    }

//    @Autowired
//    CustomerMapper cuMapper;
//
//    @Autowired
//    LinkMapper liMapper;
//
//    void insertCustomers() {
//        Customer customer = new Customer();
//        customer.setLogin("ivan");
//        customer.setEnabled(true);
//        customer.setEmail("myemail@localhost");
//        customer.setName("Ivan Ne-Durak");
//        customer.setBalance(BigDecimal.ONE);
//
//        cuMapper.insert(customer);
//        logger.info("Customer inserted with ID:" + customer.getId());
//        
//        
//        Link link = new Link();
//        link.setCustomerId(customer.getId());
//        link.setUrl("http://rumatoest.blogspot.com");
//        liMapper.insert(link);
//        logger.info("Link inserted with ID:" + link.getId());
//        
//        Link link2 = new Link();
//        link2.setUrl("http://github.com/rumatoest");
//        liMapper.insert(link2);
//        logger.info("Link inserted with ID:" + link2.getId());
//    }

}
