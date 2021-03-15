package HomeWork1;

public class Treadmill implements Obstacle {
    private int length;

    // здесь при создании объекта ему будет присвоена длина от 100 до 500м
    public Treadmill() {
        this.length = (int) (100 + (Math.random() * 400));
    }

    @Override
    public boolean pass(Movable a) {
        if (a.run(length)) {
            System.out.println("Беговая дорожка длинной: " + length + "м пройдена");
            return true;
        } else {
            System.out.println("Беговая дорожка длинной: " + length + "м  не пройдена");
            return false;
        }
    }
}
