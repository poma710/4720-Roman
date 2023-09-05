import lombok.Getter;

@Getter
public abstract class Obstacle {

    protected int obstacleParam;

    Obstacle(int obstacleParam){
        if(!(obstacleParam <= 0)){
            this.obstacleParam = obstacleParam;
        }else{
            throw new IllegalArgumentException("Must be non negative or != 0 param");
        }
    }
}