package com.icodeap.ecommerce.application.service;

import com.icodeap.ecommerce.domain.ItemCart;

import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CartService {
    private List<ItemCart> itemCarts;
    private HashMap<Integer, ItemCart> itemCartHashMap;

    public CartService(){
        this.itemCarts = new ArrayList<>();
        this.itemCartHashMap = new HashMap<>();
    }

    public void addItemCart(Integer quantity, Integer idProduct, String nameProduct, BigDecimal price){
        ItemCart itemCart = new ItemCart(idProduct, nameProduct, quantity, price);
        itemCartHashMap.put(itemCart.getIdProduct(), itemCart);
        fillList();
    }

    public BigDecimal getTotalCart(){
        BigDecimal total = BigDecimal.ZERO;
        for (ItemCart item : itemCarts){
            total = total.add(item.getTotalPriceItem());
        }
        return total;
    }
    public void removeItemCart(Integer idProduct){
        itemCartHashMap.remove(idProduct);
        fillList();
    }
    public void removeAllItemsCart(){
        itemCartHashMap.clear();
        itemCarts.clear();
    }
    private void fillList(){
        itemCarts.clear();
        itemCartHashMap.forEach((integer, itemCart) ->itemCarts.add(itemCart));//pasamos del HashMap al List
    }

    //para mirar por consola
    public List<ItemCart> getItemsCarts(){
        return itemCarts;
    }
}
