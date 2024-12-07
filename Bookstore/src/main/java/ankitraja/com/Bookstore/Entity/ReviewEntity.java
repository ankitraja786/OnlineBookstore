package ankitraja.com.Bookstore.Entity;

import jakarta.persistence.*;

import lombok.Data;



import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "reviews")

public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;


    @ManyToOne
    @JoinColumn(name = "book_id")
    private BookEntity book;

    @Column(nullable = false)
    private int rating;
     @Lob
    private String reviewText;
    private LocalDateTime createdAt;

}
