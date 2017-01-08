/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package music.business;

/**
 *
 * @author Ishita
 */


import java.util.*;
import java.io.Serializable;

public class Cart implements Serializable {

    private List<MenuItem> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public void setItems(List<MenuItem> lineItems) {
        items = lineItems;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public int getCount() {
        return items.size();
    }

    public void addItem(MenuItem item) {
        //If the item already exists in the cart, only the quantity is changed.
        String code = item.getMenu().getCode();
        for (MenuItem lineItem : items) {
            if (lineItem.getMenu().getCode().equals(code)) {
                lineItem.setQuantity(lineItem.getQuantity() + 1);
                return;
            }
        }
        items.add(item);
    }
    public int getTotalQuantity(){
        int quantity = 0;
        for (MenuItem lineItem : items) {
            quantity = quantity + lineItem.getQuantity();
        }
        return quantity;
    }
    public void removeItem(MenuItem item) {
        String code = item.getMenu().getCode();
        for (int i = 0; i < items.size(); i++) {
            MenuItem lineItem = items.get(i);
            if (lineItem.getMenu().getCode().equals(code)) {
                if(lineItem.getQuantity() == 1)
                    items.remove(i);
                else{
                    lineItem.setQuantity(lineItem.getQuantity() - 1);
                }
                return;
            }
        }
    }
    
    public int totalCartItems(){
        int totalCount = 0;
        for(MenuItem itm : items){
            totalCount = totalCount + itm.getQuantity();
        }
        return totalCount;
    }
    
    public double totalCartValuation(){
        double totalPrice = 0;
        for(MenuItem itm : items){
            totalPrice = totalPrice + itm.getTotal();
        }
        return totalPrice;
    }
}
