package com.icodeap.ecommerce.infrastructure.controller;

import com.icodeap.ecommerce.application.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Controller
@RequestMapping("/user/cart")
@Slf4j
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/add-product")
    public String addProductCart(@RequestParam Integer quantity, @RequestParam Integer idProduct,
                                 @RequestParam String nameProduct, @RequestParam BigDecimal price){
        cartService.addItemCart(quantity,idProduct,nameProduct,price);
        showCart();
        return "redirect:/home";
    }

    @GetMapping("/get-cart")
    public String getCart(Model model){
        showCart();
        model.addAttribute("cart", cartService.getItemsCarts());
        model.addAttribute("total", cartService.getTotalCart());

        return "user/cart/cart";
    }

    private void showCart() {
        cartService.getItemsCarts().forEach(
                itemCart -> log.info("Item cart: {}", itemCart)
        );
    }

}
