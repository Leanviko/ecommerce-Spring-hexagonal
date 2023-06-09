package com.icodeap.ecommerce.infrastructure.controller;

import com.icodeap.ecommerce.application.service.*;
import com.icodeap.ecommerce.domain.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user/order")
@Slf4j
public class OrderController {
    private final CartService cartService;
    private final UserService userService;
    private final ProductService productService;
    private final OrderService orderService;
    private final OrderProductService orderProductService;
    private final StockService stockService;
    private final ValidateStock validateStock;
    private final Integer UNIT_IN = 0;

    public OrderController(CartService cartService, UserService userService, ProductService productService, OrderService orderService, OrderProductService orderProductService, StockService stockService, ValidateStock validateStock) {
        this.cartService = cartService;
        this.userService = userService;
        this.productService = productService;
        this.orderService = orderService;
        this.orderProductService = orderProductService;
        this.stockService = stockService;
        this.validateStock = validateStock;
    }

    @GetMapping("/summary-order")
    public String showSummaryOrder(Model model, HttpSession httpSession){

        log.info("id user desde la variable de session: {}",httpSession.getAttribute("iduser").toString());
        User user = userService.findById(Integer.parseInt(httpSession.getAttribute("iduser").toString()));
        model.addAttribute("carrit", cartService.getItemsCarts());
        model.addAttribute("total", cartService.getTotalCart());
        model.addAttribute("user", user);
        model.addAttribute("id",httpSession.getAttribute("iduser").toString());
        return "user/sumaryorder";
    }

    @GetMapping("/create-order")
    public String createOrder(RedirectAttributes attributes, HttpSession httpSession){
        log.info("id user desde la variable de session: {}",httpSession.getAttribute("iduser").toString());
        log.info("create order..");
        //obtener user temporal
        User user = userService.findById(Integer.parseInt(httpSession.getAttribute("iduser").toString()));

        //order
        Order order = new Order();
        order.setDateCreated(LocalDateTime.now());
        order.setUser(user);

        //vuelvo a asignar la orden paro ya guardada para tener el id de la BD
        order = orderService.createOrder(order);

        //order product
        List<OrderProduct> orderProducts = new ArrayList<>();

        //itemcart -> orderProducts
        for (ItemCart itemCart : cartService.getItemsCarts()){
            orderProducts.add(new OrderProduct(productService.getProductById(itemCart.getIdProduct()), itemCart.getQuantity(), order));
        }

        //guardar
        orderProducts.forEach(
                op->{orderProductService.create(op);
                Stock stock = new Stock();
                stock.setDateCreated(LocalDateTime.now());
                stock.setProduct(op.getProduct());
                stock.setDescription("venta");
                stock.setUnitIn(UNIT_IN);
                stock.setUnitOut(op.getQuantity());
                stockService.saveStock(validateStock.calculateBalance(stock));
                }
        );

        //vaciar el carrito
        cartService.removeAllItemsCart();
        attributes.addFlashAttribute("id",httpSession.getAttribute("iduser").toString());
        return "redirect:/home";
    }
}
