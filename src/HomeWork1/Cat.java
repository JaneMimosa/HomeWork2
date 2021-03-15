package HomeWork1;

public class Cat implements Movable {
    private double height;
    private int length;

    public Cat() {
        this.height = Math.round((2 + (Math.random() * 5)) * 10.0) / 10.0;
        this.length = (int) (100 + (Math.random() * 200));
    }

    @Override
    public boolean run(int l) {
        if (length > l) {
            System.out.println("Кот пробежал");
            return true;
        } else {
            System.out.println("Кот не смог пробежать");
            return false;
        }
    }

    @Override
    public boolean jump(double h) {
        if (height > h) {
            System.out.println("Кот подпрыгнул");
            return true;
        } else {
            System.out.println("Кот не смог подпрыгнуть");
            return false;
        }
    }
}
