package sprint1_0.product;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class GUI extends Application {

	private Square[][] squares;

	private Label gameStatus = new Label("X's Turn");

	static private Board board;

	@Override
	public void start(Stage primaryStage) {
		if (board == null) {
			board = new Board();
		}
		GridPane pane = new GridPane();
		squares = new Square[3][3];
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				pane.add(squares[i][j] = new Square(), j, i);

		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(pane);
		borderPane.setBottom(gameStatus);

		Scene scene = new Scene(borderPane, 450, 450);
		primaryStage.setTitle("Tic Tac Toe");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public class Square extends Pane {
		public Square() {
			setStyle("-fx-border-color: white");
			this.setPrefSize(2000, 2000);
			this.setOnMouseClicked(e -> handleMouseClick());
		}

		private void handleMouseClick() {
		}

	}

	public static void main(String[] args) {
		launch(args);
	}
}
