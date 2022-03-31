package de.lonetech.mongodbopenshiftdemo;

import de.lonetech.mongodbopenshiftdemo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class MongodbOpenshiftDemoApplication
{
  @Autowired
  TransactionRepository transactionRepo;

  public static void main(String[] args)
  {
    SpringApplication.run(MongodbOpenshiftDemoApplication.class, args);
  }

  void createTransactions() {
    System.out.println("Data creation started...");
    // BREAKPOINT
//    transactionRepo.save(new Transaction("Whole Wheat Biscuit", "Whole Wheat Biscuit", 5, "snacks"));
//    groceryItemRepo.save(new GroceryItem("Kodo Millet", "XYZ Kodo Millet healthy", 2, "millets"));
//    groceryItemRepo.save(new GroceryItem("Dried Red Chilli", "Dried Whole Red Chilli", 2, "spices"));
//    groceryItemRepo.save(new GroceryItem("Pearl Millet", "Healthy Pearl Millet", 1, "millets"));
//    groceryItemRepo.save(new GroceryItem("Cheese Crackers", "Bonny Cheese Crackers Plain", 6, "snacks"));
    System.out.println("Data creation complete...");
  }

}
