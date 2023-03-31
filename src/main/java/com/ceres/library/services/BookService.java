package com.ceres.library.services;

import com.ceres.library.entities.Book;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> listAll();
    Optional<Book> getOne(Long id);
    Book saveBook(Book book);
    Book updateBook(Book book);
    List<Book> addMany(List<Book> books);
    List<Book> sortList(String sortBy);
    Page<Book> paginated(int offset, int pageSize);
    void deleBook(Long id);
}
