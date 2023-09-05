import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tradmill extends Obstacle{
    public Tradmill(int tradeMillDistance){
        super(tradeMillDistance);
    }
}