package com.ceres.library.services.impl;

import com.ceres.library.entities.Book;
import com.ceres.library.repositories.BookRepository;
import com.ceres.library.services.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class BookServiceImpl implements BookService {
//    @PostConstruct
//    void initDb(){
//        List<Book> books = IntStream.rangeClosed(1,200)
//                .mapToObj(i->new Book(
//                        new Random().nextLong(),
//                        "Book "+i,
//                        "Author "+i
//                )).collect(Collectors.toList());
//        bookRepository.saveAll(books);
//    }
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> listAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getOne(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> addMany(List<Book> books) {
        return bookRepository.saveAll(books);
    }

    @Override
    public List<Book> sortList(String sortBy) {
        return bookRepository.findAll(Sort.by(Sort.Direction.ASC, sortBy));
    }

    @Override
    public Page<Book> paginated(int offset, int pageSize) {
        return bookRepository.findAll(PageRequest.of(offset, pageSize));
    }

    @Override
    public void deleBook(Long id) {
        bookRepository.deleteById(id);
    }
}
