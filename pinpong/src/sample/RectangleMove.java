package sample;
import javafx.scene.shape.Rectangle;

public class RectangleMove implements Runnable {
    private final Rectangle rect;
    private boolean turn = false;

    public RectangleMove(Rectangle rect) {
        this.rect = rect;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {

            checkBounds();

            if (turn) {
                moveToLeft();
            } else {
                moveToRight();
            }

            try {
                Thread.currentThread().sleep(90);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void checkBounds() {
        if (this.rect.getX() > 270 || this.rect.getX() < 30) {
            this.turn = !turn;
        }
    }

    public void moveToLeft() {
        this.rect.setX(this.rect.getX() - 1);
    }

    public void moveToRight() {
        this.rect.setX(this.rect.getX() + 1);
    }

}
