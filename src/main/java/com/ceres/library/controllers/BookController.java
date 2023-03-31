package com.ceres.library.controllers;

import com.ceres.library.entities.Book;
import com.ceres.library.services.impl.BookServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookServiceImpl bookService;

    public BookController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }
    @GetMapping
    List<Book> getAll(){
        return bookService.listAll();
    }
    @GetMapping("/sort/{sortBy}")
    List<Book> sortBooks(@PathVariable("sortBy") String sortBy){
        return bookService.sortList(sortBy);
    }
    @GetMapping("/pages/{offset}/{pageSize}")
    ResponseEntity<Page<Book>> addPagination(@PathVariable int offset, @PathVariable int pageSize){
        Page<Book> pages = bookService.paginated(offset, pageSize);
        return new ResponseEntity<>(pages,HttpStatus.ACCEPTED);
    }
    @GetMapping("/{id}")
    Optional<Book> getOne(@PathVariable("id") Long id){
        return bookService.getOne(id);
    }
    @PostMapping
    Book saveBook(@RequestBody Book book){
        return bookService.saveBook(book);
    }
    @PostMapping("/batch")
    ResponseEntity<List<Book>> insertMany(@RequestBody List<Book> books){
        List<Book> bks = bookService.addMany(books);
        return new ResponseEntity<>(bks, HttpStatus.CREATED);
    }
    @PutMapping
    Book updateBook(@RequestBody Book book){
        return bookService.saveBook(book);
    }
    @DeleteMapping("/{id}")
    void delBook(@PathVariable("id") Long id){
        bookService.deleBook(id);
    }
}
