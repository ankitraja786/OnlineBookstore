package ankitraja.com.Bookstore.repository;

import ankitraja.com.Bookstore.Entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity , Long> {
    List<BookEntity>findByGenre(String genre);
    List<BookEntity>findByTitleContainingIgnoreCase(String title);
}
