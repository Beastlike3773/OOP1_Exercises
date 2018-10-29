package topic06.gameoflife;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    final static int WIDTH = 60;
    final static int HEIGHT = 60;
    final static int CELLSIZE = 8 ;
    final static int CANVASWIDTH = WIDTH * CELLSIZE;
    final static int CANVASHEIGHT = HEIGHT * CELLSIZE ;
    final static int DELAY = 5 ; // frames / s .

    private int frameCounter = 0 ;

    @Override
    public void start(Stage primaryStage) throws Exception {
        GameOfLife game = new GameOfLife (WIDTH, HEIGHT );
        game.createBlinker(10,10);
        game.createBlinker(10,30);
        game.createGlider(20,30);
        game.createPentomino(50,50);
        Canvas canvas = new Canvas(CANVASWIDTH, CANVASHEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        paintGame(gc,game);

        final AnimationTimer timer = new AnimationTimer(){
            @Override
            public void handle(long now) {
                frameCounter++;
                if(frameCounter == DELAY) {
                    frameCounter = 0;
                    game.nextGeneration();
                    paintGame(gc,game);
                }
            }
        };

        Button startButton = new Button("Start");
        startButton.setOnAction(event -> {
            timer.start();
        });
        Button stopButton = new Button("Stop");
        stopButton.setOnAction(event -> {
            timer.stop();
        });

        HBox buttons = new HBox(startButton,stopButton);
        buttons.setAlignment(Pos.CENTER);
        VBox root = new VBox(canvas,buttons);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void paintGame(GraphicsContext gc, GameOfLife game) {
        for (int i = 0;i < game.getWidth();i++){
            for (int j = 0;j < game.getHeight();j++){
                if(game.getCell(i,j)){
                    gc.setFill(Color.BLACK) ;
                } else {
                    gc.setFill(Color.WHITE);
                }
                gc. fillRect( i * CELLSIZE , j * CELLSIZE,CELLSIZE,CELLSIZE) ;
            }
        }
    }

    public static void main (String[] args){
        Main.launch(args);
    }
}

