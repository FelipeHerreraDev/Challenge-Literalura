package com.literalura.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;
import com.literalura.model.Book;
import com.literalura.model.Author;

import java.net.URI;

@Service
public class GutendexClient {

  private final RestTemplate restTemplate = new RestTemplate();

  public Book searchBook(String title) throws Exception {
    URI uri = UriComponentsBuilder
            .fromUriString("https://gutendex.com/books/")
            .queryParam("search", title)
            .build()
            .toUri();

    ResponseEntity<GutendexResponse> response = restTemplate.getForEntity(uri, GutendexResponse.class);
    if (response.getBody() != null && !response.getBody().getResults().isEmpty()) {
      return mapToBook(response.getBody().getResults().get(0));
    } else {
      throw new Exception("Libro no encontrado");
    }
  }

  private Book mapToBook(GutendexBook gutendexBook) {
    Author author = new Author();
    author.setFirstName(gutendexBook.getAuthors().get(0).getFirstName());
    author.setLastName(gutendexBook.getAuthors().get(0).getLastName());
    author.setBirthYear(gutendexBook.getAuthors().get(0).getBirthYear());
    author.setDeathYear(gutendexBook.getAuthors().get(0).getDeathYear());

    Book book = new Book();
    book.setTitle(gutendexBook.getTitle());
    book.setLanguage(gutendexBook.getLanguages().get(0));
    book.setDownloads(gutendexBook.getDownloadCount());
    book.setAuthor(author);

    return book;
  }
}
