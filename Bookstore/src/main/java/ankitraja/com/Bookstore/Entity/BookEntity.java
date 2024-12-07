package ankitraja.com.Bookstore.Entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "books")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private  String title;

    @Column(nullable = false)
    private  String author;


    private  String genre;

    @Column(nullable = false)
    private  String description;
    @Lob
    private  double price;
}
