import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Getter
@Setter
public class Basket{

    public HashMap<String, Integer> basket;

    public Basket(){
        this.basket = new HashMap<>();
    }

    public void addItem(Goods goods, int itemQty) {
        if(basket.containsKey(goods.getName())){
            int oldQty = basket.get(goods.getName());
            basket.put(goods.getName(), oldQty+itemQty);
        }else{
            basket.put(goods.getName(), itemQty);
        }
    }

    @Override
    public String toString(){
        return basket.toString();
    }
}
