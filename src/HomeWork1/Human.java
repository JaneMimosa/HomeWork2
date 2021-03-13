package HomeWork1;

public class Human implements Movable {
    private double height;
    private int length;

    public Human() {
        this.height = Math.round((0.1 + (Math.random() * 1.5)) * 10.0) / 10.0;
        this.length = (int) (400 + (Math.random() * 200));
    }

    @Override
    public boolean run(int l) {
        if (length > l) {
            System.out.println("Человек пробежал");
            return true;
        } else {
            System.out.println("Человек не смог пробежать");
            return false;
        }
    }

    @Override
    public boolean jump(double h) {
        if (height > h) {
            System.out.println("Человек подпрыгнул");
            return true;
        } else {
            System.out.println("Человек не смог подпрыгнуть");
            return false;
        }
    }
}
