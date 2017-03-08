package com.blacky.spring.boot.service;

import com.blacky.spring.boot.domain.Book;
import com.blacky.spring.boot.domain.presentation.BookAnotherRepresentation;
import com.blacky.spring.boot.domain.presentation.BookShortRepresentation;
import com.blacky.spring.boot.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class BookService {

    @Autowired BookRepository bookRepository;


    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public List<BookShortRepresentation> getAllShortRepresentations() {
        return bookRepository.findAllProjectedBy();
    }

    public List<BookAnotherRepresentation> getAllByAnotherRepresentation() {
        return bookRepository.findAllByAnotherRepresentation();
    }


    public Book getById(Long id) {
        return bookRepository.findById(id, Book.class);
    }

    public BookShortRepresentation getShortRepresentationById(Long id) {
        return bookRepository.findById(id, BookShortRepresentation.class);
    }

    public BookAnotherRepresentation getAnotherRepresentationById(Long id) {
        return bookRepository.findById(id, BookAnotherRepresentation.class);
    }


    @Transactional
    public void init() {
        Book book = new Book();

        book.setIsbn("0-201-31009-0");
        book.setTitle("Concurrent Programming in Java");
        book.setDescription("This book shows readers how to use the Java platform's threading model more precisely");
        book.setAuthor("Doug Lea");
        book.setPublisher("Addison Wesley");
        book.setPubDate(Date.from(LocalDate.of(1999, Month.OCTOBER, 1).atStartOfDay(ZoneId.of("GMT")).toInstant()));
        book.setPages(432);

        bookRepository.save(book);
    }


}
