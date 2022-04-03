package de.lonetech.mongodbopenshiftdemo.service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
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

  public void transform(String path)
    throws IOException
  {
    List<Transaction> transactions = getCsvData(path);
    transactionRepo.saveAll(transactions);
  }

  List<Transaction> getCsvData(String aPath)
    throws IOException
  {
    ColumnPositionMappingStrategy<Transaction> ms = new ColumnPositionMappingStrategy<>();
    ms.setType(Transaction.class);

    try(Reader reader = new InputStreamReader(s3Client.getContentAsStream(aPath))) {
      CsvToBean<Transaction> cb = new CsvToBeanBuilder<Transaction>(reader)
        .withType(Transaction.class)
        .withMappingStrategy(ms)
        .withSeparator(';')
        .withSkipLines(1)
        .build();
      return cb.parse();
    }
  }

  public List<Transaction> findAll()
    throws IOException
  {
    return transactionRepo.findAll();
  }
}
