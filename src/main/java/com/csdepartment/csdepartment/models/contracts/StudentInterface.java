package com.csdepartment.csdepartment.models.contracts;

public interface StudentInterface{

  void setFirstName(String firstName);

  void setLastName(String lastName);

  int getId();

  String getFirstName();

  String getLastName();

  void setYearInUni(int yearInUni);

  void setCredits(int credits);

  void setCountStudies(int countStudies);

  int getYearInUni();

  int getCredits();

  int getCountStudies();

  String toString();
  }
