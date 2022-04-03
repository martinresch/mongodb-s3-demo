package de.lonetech.mongodbopenshiftdemo.controller;

import java.io.IOException;
import java.util.List;

import de.lonetech.mongodbopenshiftdemo.controller.form.TransformForm;
import de.lonetech.mongodbopenshiftdemo.model.Transaction;
import de.lonetech.mongodbopenshiftdemo.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TransactionController
{
  @Autowired
  TransactionService transactionService;

  @PostMapping(value = "/api/transform", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity transform(@RequestBody TransformForm transformForm)
    throws IOException
  {
    transactionService.transform(transformForm.getPath());
    return ResponseEntity.ok(HttpStatus.OK);
  }

  @GetMapping(value = "/api/transactions", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public List<Transaction> findAll()
    throws IOException
  {
    return transactionService.findAll();
  }
}
