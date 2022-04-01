package de.lonetech.mongodbopenshiftdemo.service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Date;
import java.util.List;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import de.lonetech.mongodbopenshiftdemo.integration.s3.S3Client;
import de.lonetech.mongodbopenshiftdemo.model.Transaction;
import de.lonetech.mongodbopenshiftdemo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransactionService
{
  @Autowired
  TransactionRepository transactionRepo;
  
  @Autowired
  S3Client s3Client;

  public void transform()
    throws IOException
  {
    List<Transaction> transactions = getCsvData();
    transactionRepo.saveAll(transactions);
  }

  List<Transaction> getCsvData()
    throws IOException
  {
    ColumnPositionMappingStrategy<Transaction> ms = new ColumnPositionMappingStrategy<>();
    ms.setType(Transaction.class);

    try(Reader reader = new InputStreamReader(s3Client.getContentAsStream("foo/bar.csv"))) {
      CsvToBean<Transaction> cb = new CsvToBeanBuilder<Transaction>(reader)
        .withType(Transaction.class)
        .withMappingStrategy(ms)
        .withSeparator(';')
        .withSkipLines(1)
        .build();
      return cb.parse();
    }
  }

  public void createTransactions()
  {
    System.out.println("Data creation started...");
    transactionRepo.save(new Transaction("bic",
                                         "iban",
                                         "reference",
                                         new Date(),
                                         "Max",
                                         "Mustermann",
                                         "purp1",
                                         "purp2",
                                         123.43));
    //    groceryItemRepo.save(new GroceryItem("Kodo Millet", "XYZ Kodo Millet healthy", 2, "millets"));
    //    groceryItemRepo.save(new GroceryItem("Dried Red Chilli", "Dried Whole Red Chilli", 2, "spices"));
    //    groceryItemRepo.save(new GroceryItem("Pearl Millet", "Healthy Pearl Millet", 1, "millets"));
    //    groceryItemRepo.save(new GroceryItem("Cheese Crackers", "Bonny Cheese Crackers Plain", 6, "snacks"));
    System.out.println("Data creation complete...");
  }
}
