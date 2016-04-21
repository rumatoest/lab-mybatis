package lab.mybatis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Statement;
import javax.sql.DataSource;

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
    }
}
