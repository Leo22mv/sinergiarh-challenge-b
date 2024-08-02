package sinergiarh.challenge.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://u4xbhafwsx3z5lg0:BEbxLe6x7uSuhiTzZiPf@b7v2h0wyhihgvv2hla9q-mysql.services.clever-cloud.com:3306/b7v2h0wyhihgvv2hla9q");
        dataSource.setUsername("u4xbhafwsx3z5lg0");
        dataSource.setPassword("BEbxLe6x7uSuhiTzZiPf");
        return dataSource;
    }
}
