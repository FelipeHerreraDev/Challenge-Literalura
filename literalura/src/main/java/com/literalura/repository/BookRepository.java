package com.literalura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.literalura.model.Book;
import java.util.Optional;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
  Optional<Book> findByTitle(String title);
  List<Book> findByLanguage(String language);
}
