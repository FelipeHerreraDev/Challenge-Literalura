package com.literalura.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.literalura.service.BookService;
import com.literalura.model.Book;
import com.literalura.model.Author;
import java.util.List;
import java.util.Scanner;

@Component
public class ConsoleController {

  @Autowired
  private BookService bookService;

  public void run() {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.println("Ingrese una opción: 1. Buscar libro 2. Listar libros 3. Listar autores 4. Listar autores vivos 5. Listar libros por idioma 6. Salir");
      int option = scanner.nextInt();
      scanner.nextLine(); // Consume newline

      switch (option) {
        case 1:
          System.out.println("Ingrese el título del libro:");
          String title = scanner.nextLine();
          try {
            Book book = bookService.addBook(title);
            System.out.println("Libro añadido: " + book.getTitle());
          } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
          }
          break;
        case 2:
          List<Book> books = bookService.listBooks();
          books.forEach(book -> System.out.println(book.getTitle()));
          break;
        case 3:
          List<Author> authors = bookService.listAuthors();
          authors.forEach(author -> System.out.println(author.getLastName() + ", " + author.getFirstName()));
          break;
        case 4:
          System.out.println("Ingrese el año:");
          int year = scanner.nextInt();
          List<Author> livingAuthors = bookService.listLivingAuthors(year);
          livingAuthors.forEach(author -> System.out.println(author.getLastName() + ", " + author.getFirstName()));
          break;
        case 5:
          System.out.println("Ingrese el idioma (ES, EN, FR, PT):");
          String language = scanner.nextLine();
          List<Book> booksByLanguage = bookService.listBooksByLanguage(language);
          booksByLanguage.forEach(book -> System.out.println(book.getTitle()));
          break;
        case 6:
          System.out.println("Saliendo...");
          return;
        default:
          System.out.println("Opción no válida");
      }
    }
  }
}
