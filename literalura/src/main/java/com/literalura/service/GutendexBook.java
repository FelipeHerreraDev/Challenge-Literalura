package com.literalura.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class GutendexBook {

  private String title;
  private List<String> languages;

  @JsonProperty("download_count")
  private int downloadCount;

  private List<GutendexAuthor> authors;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public List<String> getLanguages() {
    return languages;
  }

  public void setLanguages(List<String> languages) {
    this.languages = languages;
  }

  public int getDownloadCount() {
    return downloadCount;
  }

  public void setDownloadCount(int downloadCount) {
    this.downloadCount = downloadCount;
  }

  public List<GutendexAuthor> getAuthors() {
    return authors;
  }

  public void setAuthors(List<GutendexAuthor> authors) {
    this.authors = authors;
  }
}
