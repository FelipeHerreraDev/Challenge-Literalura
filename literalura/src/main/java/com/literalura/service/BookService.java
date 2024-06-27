package com.literalura.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.literalura.repository.BookRepository;
import com.literalura.repository.AuthorRepository;
import com.literalura.model.Book;
import com.literalura.model.Author;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

  @Autowired
  private BookRepository bookRepository;

  @Autowired
  private AuthorRepository authorRepository;

  @Autowired
  private GutendexClient gutendexClient;

  public Book addBook(String title) throws Exception {
    Optional<Book> existingBook = bookRepository.findByTitle(title);
    if (existingBook.isPresent()) {
      throw new Exception("El libro ya está registrado");
    }

    Book book = gutendexClient.searchBook(title);
    Author author = authorRepository.save(book.getAuthor());
    book.setAuthor(author);

    return bookRepository.save(book);
  }

  public List<Book> listBooks() {
    return bookRepository.findAll();
  }

  public List<Author> listAuthors() {
    return authorRepository.findAll();
  }

  public List<Author> listLivingAuthors(int year) {
    return authorRepository.findByDeathYearAfter(year);
  }

  public List<Book> listBooksByLanguage(String language) {
    return bookRepository.findByLanguage(language);
  }
}
