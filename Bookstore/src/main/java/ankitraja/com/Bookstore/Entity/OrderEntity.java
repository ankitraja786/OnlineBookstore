package ankitraja.com.Bookstore.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many-to-One relationship to UserEntity
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    // List of Book IDs as an ElementCollection (BookEntity can also be mapped if needed)
    @ElementCollection
    private List<Long> bookIds;

    private Double totalPrice;

    private LocalDateTime orderDate;

    private String status;
}
