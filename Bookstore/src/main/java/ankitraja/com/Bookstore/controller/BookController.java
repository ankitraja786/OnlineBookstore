package ankitraja.com.Bookstore.controller;

import ankitraja.com.Bookstore.Entity.BookEntity;
import ankitraja.com.Bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<BookEntity>getAllBook(){
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookEntity> getBookById(@PathVariable Long id) {
        Optional<BookEntity> book = bookService.getBookById(id);
        return book.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("/genre/{genre}")
  public  List<BookEntity>getBooksByGenre(@PathVariable String genre){
        return bookService.getBooksByGenre(genre);
  }

   @PostMapping
   public  ResponseEntity<BookEntity>createBook(@RequestBody BookEntity bookEntity){
        BookEntity saveBook = bookService.saveBooks(bookEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveBook);

   }





  @PutMapping("/{id}")
    public ResponseEntity<BookEntity>updateBook(@PathVariable Long id, @RequestBody BookEntity bookEntity){
        Optional<BookEntity>exitingBook = bookService.getBookById(id);
        if (exitingBook.isPresent()){
          BookEntity   updatedBook = bookService.saveBooks(bookEntity);
        }
        return ResponseEntity.notFound().build();
  }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        Optional<BookEntity> existingBook = bookService.getBookById(id);
        if (existingBook.isPresent()) {
            bookService.deleteBook(id); // Implement delete method in the service
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


}
