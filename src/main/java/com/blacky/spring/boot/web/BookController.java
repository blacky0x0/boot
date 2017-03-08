package com.blacky.spring.boot.web;

import com.blacky.spring.boot.domain.Book;
import com.blacky.spring.boot.domain.presentation.BookAnotherRepresentation;
import com.blacky.spring.boot.domain.presentation.BookShortRepresentation;
import com.blacky.spring.boot.service.BookService;
import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class BookController {

    @Autowired BookService bookService;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<Book> getAll() {
        return bookService.getAll();
    }

    @RequestMapping(value = "/books-short", method = RequestMethod.GET)
    public List<BookShortRepresentation> getAllShortRepresentations() {
        return bookService.getAllShortRepresentations();
    }

    @RequestMapping(value = "/books-another", method = RequestMethod.GET)
    public List<BookAnotherRepresentation> getAllByAnotherRepresentation() {
        return bookService.getAllByAnotherRepresentation();
    }


    @RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
    public Book getById(@PathVariable("id") Long id) {
        return bookService.getById(id);
    }

    @RequestMapping(value = "/books-short/{id}", method = RequestMethod.GET)
    public BookShortRepresentation getShortRepresentationById(@PathVariable("id") Long id) {
        return bookService.getShortRepresentationById(id);
    }

    @RequestMapping(value = "/books-another/{id}", method = RequestMethod.GET)
    public BookAnotherRepresentation getAnotherRepresentationById(@PathVariable("id") Long id) {
        return bookService.getAnotherRepresentationById(id);
    }


    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public Map<String, String> init() {
        bookService.init();
        return ImmutableMap.of("status", "OK");
    }

}
