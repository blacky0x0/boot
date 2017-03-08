package com.blacky.spring.boot.repository;

import com.blacky.spring.boot.domain.Book;
import com.blacky.spring.boot.domain.presentation.BookAnotherRepresentation;
import com.blacky.spring.boot.domain.presentation.BookShortRepresentation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Book> {
    // See examples: https://github.com/spring-projects/spring-data-examples/blob/master/jpa/example/src/main/java/example/springdata/jpa/projections/CustomerRepository.java

    List<BookShortRepresentation> findAllProjectedBy();

    @Query("select b.id as id, b.title as title, b.description as description, b.author as author, b.publisher as publisher from Book b")
    List<BookAnotherRepresentation> findAllByAnotherRepresentation();

    <T> T findById(Long id, Class<T> projection);

}
