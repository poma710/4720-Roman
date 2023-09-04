import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Category {
    String name;
    List<Goods> categoryGoods;
    static List<String> categories = new ArrayList<>();

    public Category(String name, List<Goods> categoryGoods) {
        if(!(categories.contains(name))){
            this.name = name;
            this.categoryGoods = categoryGoods;
            categories.add(name);
        }else{
            throw new IllegalArgumentException("Same category already exists");
        }
    }

    @Override
    public String toString() {
        return name + ", "+ categoryGoods;
    }
}