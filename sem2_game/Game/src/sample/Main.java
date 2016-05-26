package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
    int ballSize = 10;

    int paneWidth = 600;
    int paneHeight = 800;

    int stickWidth = 100;
    int stickHeight = 20;

    Circle ball = new Circle(ballSize);
    Rectangle stick = new Rectangle(stickWidth, stickHeight);

    boolean runningUp = true;
    boolean runningLeft = false;
    boolean running = true;

    int score = 0;

    Action action = Action.NONE;

    Timeline timeline = new Timeline();

    public Pane initialize() {
        Pane pane = new Pane();
        pane.setPrefSize(paneWidth, paneHeight);

        stick.setTranslateX(paneWidth / 2 - stickWidth / 2);
        stick.setTranslateY(paneHeight - stickHeight);
        stick.setFill(Color.RED);


        KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.016), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {


                if (!running) {
                    return;
                }

                //движение платформы (влево или вправо)
                switch (action) {
                    case LEFT:
                        if (stick.getTranslateX() - 7 >= 0) {
                            stick.setTranslateX(stick.getTranslateX() - 7);
                        }
                        break;
                    case RIGHT:
                        if (stick.getTranslateX() + stickWidth + 7 <= paneWidth) {
                            stick.setTranslateX(stick.getTranslateX() + 7);
                        }
                        break;
                    case NONE:
                        break;
                }

                if (runningLeft) {
                    ball.setTranslateX(ball.getTranslateX() - 5);      //мяч двигается влево
                } else {
                    ball.setTranslateX(ball.getTranslateX() + 5);      //мяч двигается вправо
                }


                if (runningUp) {
                    ball.setTranslateY(ball.getTranslateY() - 5);       //мяч двигается вверх
                } else {
                    ball.setTranslateY(ball.getTranslateY() + 5);      //мяч двигается вниз
                }


                if (ball.getTranslateX() - ballSize == 0) {     //врезался в левую границу
                    runningLeft = false;
                } else if (ball.getTranslateX() + ballSize == paneWidth) {    //врезался в правую границу
                    runningLeft = true;
                }

                if (ball.getTranslateY() - ballSize == 0) {    //врезался в верхнюю границу
                    runningUp = false;
                } else if ((ball.getTranslateY() + ballSize == paneHeight - stickHeight &&
                        ball.getTranslateX() + ballSize >= stick.getTranslateX() &&
                        ball.getTranslateX() + ballSize <= stick.getTranslateX() + stickWidth)) {
                    System.out.println(score);
                    score++;
                    runningUp = true;
                }
            }
        });

        pane.getChildren().add(stick);
        pane.getChildren().add(ball);

        timeline.getKeyFrames().add(keyFrame);
        timeline.setCycleCount(Animation.INDEFINITE);

        return pane;
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = initialize();
        Scene scene = new Scene(pane);

        ball.setTranslateX(300);
        ball.setTranslateY(600);
        ball.setFill(Color.BLACK);

        timeline.play();

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case LEFT:
                        action = Action.LEFT;
                        break;
                    case RIGHT:
                        action = Action.RIGHT;
                        break;
                }
            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case LEFT:
                        action = Action.NONE;
                        break;
                    case RIGHT:
                        action = Action.NONE;
                        break;
                }
            }
        });

        primaryStage.setTitle("Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
