@Getter
@Setter
public abstract class Member {

    public String name;
    protected int possibleRunningDistance;
    protected int possibleJumpHeight;
    protected boolean canParticipate;

    Member(String name, int possibleRunningDistance, int possibleJumpHeight){
        this.name = name;
        this.possibleRunningDistance = possibleRunningDistance;
        this.possibleJumpHeight = possibleJumpHeight;
        this.canParticipate = true;
    }

    private void couldRun(Obstacle obstacle) {
        if (obstacle.getObstacleParam()<=possibleRunningDistance){
            System.out.println(name + " can running " + obstacle.getObstacleParam());
        } else{
            System.out.println(name + " can't running " + obstacle.getObstacleParam()
                    +", he is out");
            canParticipate = false;
        }
    }
    private void couldJump(Obstacle obstacle) {
        if (obstacle.getObstacleParam()<=possibleJumpHeight){
            System.out.println(name + " can jump " + obstacle.getObstacleParam());
        } else{
            System.out.println(name + " can't jump " + obstacle.getObstacleParam()
                    +", he is out");
            canParticipate = false;
        }
    }

    public void passAnObstacle(Obstacle obstacle){
        if(obstacle.getClass().equals(Wall.class)){
            couldJump(obstacle);
        }else if(obstacle.getClass().equals(Tradmill.class)){
            couldRun(obstacle);
        }
    }
}