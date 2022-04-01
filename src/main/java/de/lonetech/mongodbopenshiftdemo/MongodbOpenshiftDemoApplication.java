package de.lonetech.mongodbopenshiftdemo;

import de.lonetech.mongodbopenshiftdemo.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class MongodbOpenshiftDemoApplication
  implements CommandLineRunner
{
  @Autowired
  TransactionService transactionService;

  public static void main(String[] args)
  {
    SpringApplication.run(MongodbOpenshiftDemoApplication.class, args);
  }

  @Override
  public void run(String... args)
    throws Exception
  {
//    transactionService.createTransactions();
    transactionService.transform();
  }
}
