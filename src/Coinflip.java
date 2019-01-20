import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.layout.*;

/**
 * This is a small JavaFX application I made
 * for one of my college courses. It simulates
 * coin flips and tracks the number of heads
 * and tails flipped. The buttons provide options 
 * for 1, 10, or 100 flips at a time, along 
 * with a score reset.
 * 
 * Created March 11, 2017
 * @author Jacob Ressler
 *
 */
public class Coinflip extends Application {

	private CoinPane coinPane = new CoinPane();

	@Override
	public void start(Stage primaryStage) {

		Button btFlip1 = new Button("Flip 1 Coin");
		btFlip1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				coinPane.flip();
			}
		});
		
		Button btFlip10 = new Button("Flip 10 Coins");
		btFlip10.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				for (int i = 0; i < 10; i++) {
					coinPane.flip();
				}
			}
		});
		
		Button btFlip100 = new Button("Flip 100 Coins");
		btFlip100.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				for (int i = 0; i < 100; i++) {
					coinPane.flip();
				}
			}
		});
		
		Button btReset = new Button("Reset");
		btReset.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				coinPane.reset();
			}
		});
		
		HBox hbox = new HBox(10);
		hbox.getChildren().addAll(btFlip1, btFlip10, btFlip100, btReset);
		hbox.setAlignment(Pos.CENTER);
		hbox.setTranslateY(-15);

		BorderPane border = new BorderPane();
		border.setCenter(coinPane);
		border.setBottom(hbox);
		BorderPane.setAlignment(hbox, Pos.CENTER);
		BorderPane.setAlignment(coinPane, Pos.CENTER);

		Scene scene = new Scene(border, 500, 400);
		primaryStage.setTitle("Coin Flip");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	// Main
	public static void main (String[] args) {
		launch(args);
	}
}

