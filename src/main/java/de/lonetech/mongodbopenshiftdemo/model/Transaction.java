package de.lonetech.mongodbopenshiftdemo.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("transaction")
public class Transaction
{
  @Id
  private String id;
  
  private String bic;
  private String iban;
  private String reference;
  private Date date;
  private String firstName;
  private String lastName;
  private String purpose1;
  private String purpose2;
  private Double amount;

  public Transaction()
  {
  }

  public Transaction(String aId,
                     String aBic,
                     String aIban,
                     String aReference,
                     Date aDate,
                     String aFirstName,
                     String aLastName,
                     String aPurpose1,
                     String aPurpose2,
                     Double aAmount)
  {
    id = aId;
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