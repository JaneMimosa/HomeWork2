package HomeWork1;

public class Wall implements Obstacle {
    private double height;

    // сначала рандомизирование высоты потом окруление до 1 цифры после запятой
    public Wall() {
        this.height = Math.round((0.5 + (Math.random() * 5)) * 10.0) / 10.0;
    }

    @Override
    public boolean pass(Movable a) {
        if (a.jump(height)) {
            System.out.println("Стена высотой: " + height + "м преодалена");
            return true;
        } else {
            System.out.println("Стена высотой: " + height + "м не преодалена");
            return false;
        }
    }
}
