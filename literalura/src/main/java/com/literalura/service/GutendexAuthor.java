package com.literalura.service;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GutendexAuthor {
  @JsonProperty("name")
  private String name;

  @JsonProperty("birth_year")
  private int birthYear;

  @JsonProperty("death_year")
  private int deathYear;

  public String getFirstName() {
    // Assuming the name format is "Last Name, First Name"
    return name.split(", ")[1];
  }

  public String getLastName() {
    // Assuming the name format is "Last Name, First Name"
    return name.split(", ")[0];
  }

  public int getBirthYear() {
    return birthYear;
  }

  public void setBirthYear(int birthYear) {
    this.birthYear = birthYear;
  }

  public int getDeathYear() {
    return deathYear;
  }

  public void setDeathYear(int deathYear) {
    this.deathYear = deathYear;
  }
}
