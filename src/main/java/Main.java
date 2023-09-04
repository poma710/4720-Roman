import java.util.Arrays;
import java.util.Collection;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        List<Goods> furniture = Arrays.asList(
                new Goods("Table", 55.00, 4.0,2),
                new Goods("Sofa", 122.00, 4.5,4),
                new Goods("Closed", 73.50, 3.6,3));

        List<Goods> bath = Arrays.asList(
                new Goods("Mirror", 60.00, 5.0,5),
                new Goods("Brush", 2.00, 4.0,20),
                new Goods("Shampoo", 12.75, 4.2, 10));

        List<Goods> kitchen = Arrays.asList(
                new Goods("Forks", 60.60, 5.0,6),
                new Goods("Sponges", 3.10, 3.,1),
                new Goods("Detergent", 15.00, 4.7,1));

        List<Goods> other = Arrays.asList(
                new Goods("Towels", 6.00,4.00,9),
                new Goods("Pedestal", 0.30),
                new Goods("Thermos", 11.00, 4.1,17),
                new Goods("Filter", 4.15, 4.0,2));


        List<Category> categoryList = Arrays.asList(
                new Category("Furniture", furniture),
                new Category("Bath items", bath),
                new Category("Kitchen goods", kitchen),
                new Category("Other goods", other));

        System.out.println(categoryList);

        User alf = new User("Alf","123");
        User sam = new User("Sam", "111");

        buy(alf, "Towels", 5, categoryList);
        buy(alf, "Forks", 8, categoryList);
        System.out.println(alf);


        buy(sam, "Towels", 5, categoryList);
        System.out.println(sam);

        System.out.println(categoryList);
    }

    static void buy(User user, String  itemName, int itemQ, List<Category> categoryList) {
        Goods goalGoods = findGoalGoods(itemName, categoryList);
        if (goalGoods != null) {

            if (goalGoods.getCount() == 0) {
                System.out.println("no more goods " + goalGoods.getName() + ", count of them: 0");
            } else if (goalGoods.getCount() >= itemQ) {

                user.getUserBasket().addItem(goalGoods, itemQ);
                goalGoods.setCount(goalGoods.getCount() - itemQ);

            } else {

                user.getUserBasket().addItem(goalGoods, goalGoods.getCount());
                System.out.println(user.getLogin() + " want's "+ itemQ +", buy only " + goalGoods.getCount()
                        + " of " + goalGoods.getName());
                goalGoods.setCount(0);
            }
        }else {
            System.out.println("Same product not exist");
        }
    }

    static Goods findGoalGoods(String itemName, List<Category> categoryList){
        for(Category category: categoryList){
            for(Goods goods: category.getCategoryGoods()){
                if(itemName.equals(goods.getName())){
                    return goods;
                }
            }
        }
        return null;
    }
}
