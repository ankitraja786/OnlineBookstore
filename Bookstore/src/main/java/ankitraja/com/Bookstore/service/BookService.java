package ankitraja.com.Bookstore.service;


import ankitraja.com.Bookstore.Entity.BookEntity;
import ankitraja.com.Bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;


    public List<BookEntity>getAllBooks(){
        return bookRepository.findAll();
    }

    public Optional<BookEntity>getBookById(Long id){
        return bookRepository.findById(id);
    }

    public List<BookEntity>getBooksByGenre(String genre){
        return bookRepository.findByGenre(genre);
    }
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public BookEntity saveBooks(BookEntity bookEntity){
        return bookRepository.save(bookEntity);
    }
}
