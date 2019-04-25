package sample.animations;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class AnimShaker {

    private TranslateTransition translateTransition;

    public AnimShaker(Node node) {
        translateTransition = new TranslateTransition(Duration.millis(50), node);

        translateTransition.setFromX(0f);
        translateTransition.setByX(10f);
        translateTransition.setCycleCount(2);
        translateTransition.setAutoReverse(true);
    }

    public void animShake() {
        translateTransition.playFromStart();
    }
}
