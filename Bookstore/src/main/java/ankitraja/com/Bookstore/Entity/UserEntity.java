package ankitraja.com.Bookstore.Entity;


import jakarta.persistence.*;
import lombok.Data;

import javax.print.attribute.standard.MediaSize;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,unique = true)
    private  String email;
    @Column(nullable = false,unique = true)
    private String username;
    @Column(nullable = false)
    private   String password;
    @Column(nullable = false)
    private String name;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    private Set<String>roles;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true) // Relationship with orders
    private List<OrderEntity> orders;
}
