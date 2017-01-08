

package music.business;

/**
 *
 * @author Ishita
 */


import java.text.NumberFormat;
import java.io.Serializable;

public class MenuItem implements Serializable {

    private Long lineItemId;
    private Menu menu;
    private int quantity = 1;

    public MenuItem() {
    }

    public Long getLineItemId() {
        return lineItemId;
    }

    public void setLineItemId(Long lineItemId) {
        this.lineItemId = lineItemId;
    }

    public void setMenu(Menu product) {
        this.menu = product;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotal() {
        double total = menu.getPrice() * quantity;
        return total;
    }

    public String getTotalCurrencyFormat() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(this.getTotal());
    }
}