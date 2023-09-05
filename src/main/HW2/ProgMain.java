import java.sql.Array;
import java.util.Arrays;

public class ProgMain {
    public static void main(String[] args) {

        Obstacle[] obstacles = {
                new Wall(5),
                new Tradmill(150),
                new Tradmill(190),
                new Wall(40)};

        Member[] members = {
                new Human("h1", 150, 20),
                new Human("h2", 130, 40),
                new Cat("c1", 300, 110),
                new Robot("R1", 500, 50)};

        for(Member member: members) {
            for(Obstacle obstacle: obstacles){
                if (member.isCanParticipate()) {
                    member.passAnObstacle(obstacle);
                }else break;
            }
            System.out.println("---------------------------");
        }
    }
}