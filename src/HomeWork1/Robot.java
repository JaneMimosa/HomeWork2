package HomeWork1;

public class Robot implements Movable {
    private double height;
    private int length;

    public Robot() {
        this.height = Math.round((3 + (Math.random() * 5)) * 10.0) / 10.0;
        this.length = (int) (400 + (Math.random() * 200));
    }

    @Override
    public boolean run(int l) {
        if (length > l) {
            System.out.println("Робот пробежал");
            return true;
        } else {
            System.out.println("Робот не смог пробежать");
            return false;
        }
    }

    @Override
    public boolean jump(double h) {
        if (height > h) {
            System.out.println("Робот подпрыгнул");
            return true;
        } else {
            System.out.println("Робот не смог подпрыгнуть");
            return false;
        }
    }
}
