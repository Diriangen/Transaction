package rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import Dao.AccountHolderDao;
import controllers.transactionController; 

@SpringBootApplication
@ComponentScan(basePackageClasses = transactionController.class)
public class SpringBootTransactionApplication  {

 
	public static void main(String[] args) {
        SpringApplication.run(SpringBootTransactionApplication.class, args);
    }
}
