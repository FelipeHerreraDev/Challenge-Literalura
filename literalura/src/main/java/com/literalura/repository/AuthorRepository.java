package com.literalura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.literalura.model.Author;
import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
  List<Author> findByDeathYearAfter(int year);
}
