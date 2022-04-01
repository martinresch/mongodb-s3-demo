package de.lonetech.mongodbopenshiftdemo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.List;

import de.lonetech.mongodbopenshiftdemo.model.Transaction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TransactionServiceTest
{

  @Autowired
  private TransactionService transactionService;


  @Test
  void getCsvData()
    throws IOException
  {
    List<Transaction> result = transactionService.getCsvData();
    assertEquals(3, result.size());
  }
}