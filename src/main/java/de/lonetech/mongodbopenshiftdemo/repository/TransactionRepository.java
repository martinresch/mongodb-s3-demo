package de.lonetech.mongodbopenshiftdemo.repository;

import de.lonetech.mongodbopenshiftdemo.model.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface TransactionRepository extends MongoRepository<Transaction, String> 
{
  @Query("{lastname:'?0'}")
  Transaction findItemByLastName(String lastName);
  
  public long count();
}
