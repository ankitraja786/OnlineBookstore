package ankitraja.com.Bookstore.service;

import ankitraja.com.Bookstore.Entity.BookEntity;
import ankitraja.com.Bookstore.Entity.OrderEntity;
import ankitraja.com.Bookstore.Entity.UserEntity;
import ankitraja.com.Bookstore.repository.BookRepository;
import ankitraja.com.Bookstore.repository.OrderRepository;
import ankitraja.com.Bookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.lang.module.ResolutionException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private BookRepository bookRepository;
   @Autowired
    private UserRepository userRepository;


   public OrderEntity CreateOrder(Long userId, List<Long>bookIds){
       UserEntity  userEntity = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User not found"));
       List<BookEntity> bookEntities = bookRepository.findAllById(bookIds);

       BigDecimal totalPrice = bookEntities.stream()
               .map(book -> new BigDecimal(book.getPrice())) // Convert price to BigDecimal
               .reduce(BigDecimal.ZERO, BigDecimal::add);


       OrderEntity orderEntity = new OrderEntity();

       orderEntity.setUser(userEntity);
       orderEntity.setTotalPrice(totalPrice.doubleValue());
       orderEntity.setStatus("pending");
       orderEntity.setOrderDate(LocalDateTime.now());

       OrderEntity savedOrder = orderRepository.save(orderEntity);

      for (BookEntity book : bookEntities){
          OrderEntity orderEntity1 = new OrderEntity();
          orderEntity1.setBookIds(bookIds);
          orderEntity1.setTotalPrice(totalPrice.doubleValue());

          orderEntity1.setOrderDate(LocalDateTime.now());

      }
      return savedOrder;

   }
}
