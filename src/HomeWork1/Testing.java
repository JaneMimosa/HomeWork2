package HomeWork1;

public class Testing {
    public static void main(String[] args) {
        Movable[] team = {new Cat(), new Human(), new Robot()};
        Obstacle[] obstacles = {new Treadmill(), new Wall()};
        course(team, obstacles);
    }

    public static void course(Movable[] team, Obstacle[] obstacles) {
        for (Movable t : team) {
            for (Obstacle o : obstacles) {
                if (!o.pass(t)) {
                    break;
                }
            }
        }
    }
}
