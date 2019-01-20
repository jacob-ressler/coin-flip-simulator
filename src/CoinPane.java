import java.util.Random;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * A class for managing the score and winner text 
 * and handling the "coin flip logic."
 * @author jress
 *
 */
public class CoinPane extends StackPane {
	int tailsWins, headsWins;
	Text mainText = new Text("Who Will Win?");
	Text tails = new Text("Tails: " + tailsWins);
	Text heads = new Text("Heads: " + headsWins);
	Random random = new Random();
	String style1 = "-fx-font: 72 impact; -fx-alignment: center;";
	String style2 = "-fx-font: lighter 48 arial; -fx-alignment: center;";
	String style3 = "-fx-font: lighter 24 forte; -fx-alignment: left;";

	public CoinPane() {
		getChildren().addAll(mainText, tails, heads);

		mainText.setStyle(style2);
		mainText.setFill(Color.DARKSLATEGREY);

		tails.setStyle(style3);
		tails.setFill(Color.CORNFLOWERBLUE);
		tails.setTranslateX(155);
		tails.setTranslateY(-170);

		heads.setStyle(style3);
		heads.setFill(Color.CRIMSON);
		heads.setTranslateX(-170);
		heads.setTranslateY(-170);
	}

	public void flip() {
		mainText.setStyle(style1);
		mainText.setText(random.nextBoolean() ? "HEADS!" : "TAILS!");
		updateScores(mainText.getText());
	}

	public void updateScores(String winner) {
		if (winner.equals("HEADS!")) {
			heads.setText("Heads: " + ++headsWins);
		} else {
			tails.setText("Tails: " + ++tailsWins);
		}
	}
	
	public void reset() {
		headsWins = 0;
		heads.setText("Heads: " + headsWins);
		tailsWins = 0;
		tails.setText("Tails: " + tailsWins);
		mainText.setStyle(style2);
		mainText.setText("Who Will Win?");
	}
}

