package de.lonetech.mongodbopenshiftdemo.model;

import java.util.Date;
import java.util.UUID;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvDate;
import com.opencsv.bean.CsvNumber;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("transaction")
public class Transaction
{
  @Id
  private String id;

  @CsvBindByPosition(position = 0)
  private String bic;
  
  @CsvBindByPosition(position = 1)
  private String iban;
  
  @CsvBindByPosition(position = 2)
  private String reference;
  
  @CsvDate(value = "dd.MM.yyyy")
  @CsvBindByPosition(position = 3)
  private Date date;
  
  @CsvBindByPosition(position = 4)
  private String firstName;
  
  @CsvBindByPosition(position = 5)
  private String lastName;
  
  @CsvBindByPosition(position = 6)
  private String purpose1;
  
  @CsvBindByPosition(position = 7)
  private String purpose2;
  
  @CsvNumber("#,##")
  @CsvBindByPosition(position = 8)
  private Double amount;

  public Transaction()
  {
    id = UUID.randomUUID().toString();
  }

  public Transaction(String aBic,
                     String aIban,
                     String aReference,
                     Date aDate,
                     String aFirstName,
                     String aLastName,
                     String aPurpose1,
                     String aPurpose2,
                     Double aAmount)
  {
    this();
    bic = aBic;
    iban = aIban;
    reference = aReference;
    date = aDate;
    firstName = aFirstName;
    lastName = aLastName;
    purpose1 = aPurpose1;
    purpose2 = aPurpose2;
    amount = aAmount;
  }

  public String getId()
  {
    return id;
  }

  public String getBic()
  {
    return bic;
  }

  public void setBic(String aBic)
  {
    bic = aBic;
  }

  public String getIban()
  {
    return iban;
  }

  public void setIban(String aIban)
  {
    iban = aIban;
  }

  public String getReference()
  {
    return reference;
  }

  public void setReference(String aReference)
  {
    reference = aReference;
  }

  public Date getDate()
  {
    return date;
  }

  public void setDate(Date aDate)
  {
    date = aDate;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public void setFirstName(String aFirstName)
  {
    firstName = aFirstName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public void setLastName(String aLastName)
  {
    lastName = aLastName;
  }

  public String getPurpose1()
  {
    return purpose1;
  }

  public void setPurpose1(String aPurpose1)
  {
    purpose1 = aPurpose1;
  }

  public String getPurpose2()
  {
    return purpose2;
  }

  public void setPurpose2(String aPurpose2)
  {
    purpose2 = aPurpose2;
  }

  public Double getAmount()
  {
    return amount;
  }

  public void setAmount(Double aAmount)
  {
    amount = aAmount;
  }
}