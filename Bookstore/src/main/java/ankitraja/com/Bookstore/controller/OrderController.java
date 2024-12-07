package ankitraja.com.Bookstore.controller;

import ankitraja.com.Bookstore.Entity.OrderEntity;
import ankitraja.com.Bookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ankitraja.com.Bookstore.controller.BookController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public OrderEntity createOrder(@RequestBody OrderEntity orderEntity) {
        return orderService.CreateOrder(orderEntity.getUser().getId(), orderEntity.getBookIds());
    }
}
