import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class User {

    private String login;
    private String password;
    private Basket userBasket;

    public User(String login, String password){
        this.login = login;
        this.password = password;
        this.userBasket = new Basket();
    }

    @Override
    public String toString(){
        return "User name " + login
                + " basket " + getUserBasket();
    }
}