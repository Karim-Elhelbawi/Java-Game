package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import engine.*;
import exceptions.*;
import model.abilities.*;
import model.effects.*;
import model.world.*;

public class Main extends Application implements EventHandler<ActionEvent> {

	static Game game;
	Stage window;
	Label Hello;
	Button Start;
	Button Exit;
	Label Choose;
	Label Champ;
	Label Leader;
	Label p1l;
	Label p2l;
	TextField player1;
	TextField player2;
	Button Next1;
	Button Exit2;
	Button Exit3;
	Button Exit4;
	Button Exit5;
	Button Captain_America;
	Button Deadpool;
	Button Dr_Strange;
	Button Electro;
	Button Ghost_Rider;
	Button Hela;
	Button Hulk;
	Button Iceman;
	Button Ironman;
	Button Loki;
	Button Quicksilver;
	Button Spiderman;
	Button Thor;
	Button Venom;
	Button Yellow_Jacket;
	Button Next2;
	Button Next3;
	Player p1;
	Player p2;
	Button ch1;
	Button ch2;
	Button ch3;
	Button ch4;
	Button ch5;
	Button ch6;
	Button leaderability = new Button("Use Leader Ability");
	Button endturn = new Button("Endturn");
	MenuItem moveup = new MenuItem("Up");
	MenuItem movedown = new MenuItem("Down");
	MenuItem moveleft = new MenuItem("Left");
	MenuItem moveright = new MenuItem("Right");
	MenuButton move = new MenuButton("Move", null, moveup, movedown, moveleft, moveright);
	MenuItem attackup = new MenuItem("Up");
	MenuItem attackdown = new MenuItem("Down");
	MenuItem attackleft = new MenuItem("Left");
	MenuItem attackright = new MenuItem("Right");
	MenuButton attack = new MenuButton("Attack", null, attackup, attackdown, attackleft, attackright);
	ButtonType dirup = new ButtonType("Up");
	ButtonType dirdown = new ButtonType("Down");
	ButtonType dirleft = new ButtonType("Left");
	ButtonType dirright = new ButtonType("Right");
	Button ab1 = new Button("");
	Button ab2 = new Button("");
	Button ab3 = new Button("");
	Button curr = new Button("");
	int i = -1;
	int height = 1366;
	int width = 788;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws IOException {
		Game.loadAbilities("Abilities.csv");
		Game.loadChampions("Champions.csv");

		window = primaryStage;
		window.setTitle("Marvel - Ultimate Wars");
		// window.initStyle(StageStyle.UNDECORATED);
		window.setResizable(false);
		window.setFullScreenExitHint("");

		// INITIALIZATION OF WINDOW
		StackPane x = new StackPane();
		Scene scene = new Scene(x, height, width);

		Image img = new Image("C:\\Users\\Karim\\eclipse-workspace\\M3Fx\\startscreen.jpg");
		BackgroundImage bImg = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background bGround = new Background(bImg);
		x.setBackground(bGround);

		Hello = new Label();
		Hello.setText("WELCOME TO AVENGERS" + "\r\n" + "      ULTIMATE WARS!!");
		Hello.setPrefSize(250, 100);
		Hello.setFont(new Font("Impact", 27.2));
		Hello.setTextFill(Color.WHITE);

		Hello.setTranslateY(-80);
		Hello.setTranslateX(-550);

		Start = new Button();
		Start.setText("Start");
		Start.setPrefSize(250, 50);
		Start.setTranslateY(0);
		Start.setTranslateX(-550);
		Start.setStyle("-fx-background-color: #48F353; -fx-text-fill: white;");

		Exit = new Button();
		Exit.setText("Exit");
		Exit.setPrefSize(250, 50);
		Exit.setTranslateY(75);
		Exit.setTranslateX(-550);
		Exit.setOnAction(e -> window.close());
		Exit.setStyle("-fx-background-color: #DF1D1D; -fx-text-fill: white;");

		x.getChildren().addAll(Start, Exit, Hello);

		// END OF FIRST SCENE

		StackPane x2 = new StackPane();
		Scene scene2 = new Scene(x2, height, width);

		Image img2 = new Image("C:\\Users\\Karim\\eclipse-workspace\\M3Fx\\BG3.png");
		BackgroundImage bImg2 = new BackgroundImage(img2, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background bGround2 = new Background(bImg2);
		x2.setBackground(bGround2);

		Start.setOnAction(e -> {
			window.setScene(scene2);
			// window.setFullScreen(true);
		});

		Choose = new Label();
		Choose.setText("PLEASE ENTER NAMES OF PLAYERS");
		Choose.setPrefSize(750, 200);
		Choose.setFont(new Font("Arial", 30));
		Choose.setTranslateY(-100);
		Choose.setTranslateX(125);
		Choose.setTextFill(Color.WHITE);

		player1 = new TextField();
		player1.setPromptText("Please enter first player name");
		player1.setPrefSize(400, 35);
		player1.setMaxSize(400, 35);
		player1.setTranslateX(-300);

		player2 = new TextField();
		player2.setPromptText("Please enter second player name");
		player2.setPrefSize(400, 35);
		player2.setMaxSize(400, 35);
		player2.setTranslateX(300);

		Next1 = new Button();
		Next1.setText("Next");
		Next1.setPrefSize(200, 50);
		Next1.setTranslateY(100);
		Next1.setStyle("-fx-background-color: #48F353; -fx-text-fill: white;");

		Exit2 = new Button();
		Exit2.setText("Exit");
		Exit2.setPrefSize(200, 50);
		Exit2.setTranslateY(175);
		Exit2.setStyle("-fx-background-color: #DF1D1D; -fx-text-fill: white;");
		Exit2.setOnAction(e -> window.close());

		x2.getChildren().addAll(Next1, player1, player2, Exit2, Choose);

		// END OF SECOND SCENE

		StackPane x3 = new StackPane();
		Scene scene3 = new Scene(x3, height, width);

		Image img3 = new Image("C:\\Users\\Karim\\eclipse-workspace\\M3Fx\\BG3.png");
		BackgroundImage bImg3 = new BackgroundImage(img3, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background bGround3 = new Background(bImg3);
		x3.setBackground(bGround3);

		Next1.setOnAction(e -> {
			String pl1 = player1.getCharacters().toString();
			String pl2 = player2.getCharacters().toString();
			Champ.setText(pl1 + " & " + pl2 + ", please pick your champions (first 3 picks for " + pl1
					+ " & second 3 picks for " + pl2 + ")");
			p1 = new Player(pl1);
			p2 = new Player(pl2);
			window.setScene(scene3);
			// window.setFullScreen(true);
		});

		// BEGINNING OF THIRD SCENE (CHOOSING CHAMPIONS)

		Champ = new Label();
		Champ.setPrefSize(1300, 200);
		Champ.setFont(new Font("Arial", 25));
		Champ.setTranslateY(-300);
		Champ.setTranslateX(0);
		Champ.setAlignment(Pos.CENTER);
		Champ.setTextFill(Color.WHITE);

		Captain_America = new Button();
		Captain_America.setText("Captain America");
		Captain_America.setPrefSize(150, 150);
		Captain_America.setTranslateX(-400);
		Captain_America.setTranslateY(-150);
		Captain_America.setOnAction(this);
		Captain_America.setStyle("-fx-background-color: #676171; -fx-text-fill: white;");

		Deadpool = new Button();
		Deadpool.setText("Deadpool");
		Deadpool.setPrefSize(150, 150);
		Deadpool.setTranslateX(-200);
		Deadpool.setTranslateY(-150);
		Deadpool.setOnAction(this);
		Deadpool.setStyle("-fx-background-color: #676171; -fx-text-fill: white;");

		Dr_Strange = new Button();
		Dr_Strange.setText("Dr. Strange");
		Dr_Strange.setPrefSize(150, 150);
		Dr_Strange.setTranslateX(0);
		Dr_Strange.setTranslateY(-150);
		Dr_Strange.setOnAction(this);
		Dr_Strange.setStyle("-fx-background-color: #676171; -fx-text-fill: white;");

		Electro = new Button();
		Electro.setText("Electro");
		Electro.setPrefSize(150, 150);
		Electro.setTranslateX(200);
		Electro.setTranslateY(-150);
		Electro.setOnAction(this);
		Electro.setStyle("-fx-background-color: #676171; -fx-text-fill: white;");

		Ghost_Rider = new Button();
		Ghost_Rider.setText("Ghost Rider");
		Ghost_Rider.setPrefSize(150, 150);
		Ghost_Rider.setTranslateX(400);
		Ghost_Rider.setTranslateY(-150);
		Ghost_Rider.setOnAction(this);
		Ghost_Rider.setStyle("-fx-background-color: #676171; -fx-text-fill: white;");

		Hela = new Button();
		Hela.setText("Hela");
		Hela.setPrefSize(150, 150);
		Hela.setTranslateX(-400);
		Hela.setTranslateY(50);
		Hela.setOnAction(this);
		Hela.setStyle("-fx-background-color: #676171; -fx-text-fill: white;");

		Hulk = new Button();
		Hulk.setText("Hulk");
		Hulk.setPrefSize(150, 150);
		Hulk.setTranslateX(-200);
		Hulk.setTranslateY(50);
		Hulk.setOnAction(this);
		Hulk.setStyle("-fx-background-color: #676171; -fx-text-fill: white;");

		Iceman = new Button();
		Iceman.setText("Iceman");
		Iceman.setPrefSize(150, 150);
		Iceman.setTranslateX(0);
		Iceman.setTranslateY(50);
		Iceman.setOnAction(this);
		Iceman.setStyle("-fx-background-color: #676171; -fx-text-fill: white;");

		Ironman = new Button();
		Ironman.setText("Ironman");
		Ironman.setPrefSize(150, 150);
		Ironman.setTranslateX(200);
		Ironman.setTranslateY(50);
		Ironman.setOnAction(this);
		Ironman.setStyle("-fx-background-color: #676171; -fx-text-fill: white;");

		Loki = new Button();
		Loki.setText("Loki");
		Loki.setPrefSize(150, 150);
		Loki.setTranslateX(400);
		Loki.setTranslateY(50);
		Loki.setOnAction(this);
		Loki.setStyle("-fx-background-color: #676171; -fx-text-fill: white;");

		Quicksilver = new Button();
		Quicksilver.setText("Quicksilver");
		Quicksilver.setPrefSize(150, 150);
		Quicksilver.setTranslateX(-400);
		Quicksilver.setTranslateY(250);
		Quicksilver.setOnAction(this);
		Quicksilver.setStyle("-fx-background-color: #676171; -fx-text-fill: white;");

		Spiderman = new Button();
		Spiderman.setText("Spiderman");
		Spiderman.setPrefSize(150, 150);
		Spiderman.setTranslateX(-200);
		Spiderman.setTranslateY(250);
		Spiderman.setOnAction(this);
		Spiderman.setStyle("-fx-background-color: #676171; -fx-text-fill: white;");

		Thor = new Button();
		Thor.setText("Thor");
		Thor.setPrefSize(150, 150);
		Thor.setTranslateX(0);
		Thor.setTranslateY(250);
		Thor.setOnAction(this);
		Thor.setStyle("-fx-background-color: #676171; -fx-text-fill: white;");

		Venom = new Button();
		Venom.setText("Venom");
		Venom.setPrefSize(150, 150);
		Venom.setTranslateX(200);
		Venom.setTranslateY(250);
		Venom.setOnAction(this);
		Venom.setStyle("-fx-background-color: #676171; -fx-text-fill: white;");

		Yellow_Jacket = new Button();
		Yellow_Jacket.setText("Yellow Jacket");
		Yellow_Jacket.setPrefSize(150, 150);
		Yellow_Jacket.setTranslateX(400);
		Yellow_Jacket.setTranslateY(250);
		Yellow_Jacket.setOnAction(this);
		Yellow_Jacket.setStyle("-fx-background-color: #676171; -fx-text-fill: white;");

		Next2 = new Button();
		Next2.setText("Next");
		Next2.setPrefSize(50, 50);
		Next2.setTranslateX(600);
		Next2.setTranslateY(15);
		Next2.setStyle("-fx-background-color: #48F353; -fx-text-fill: white;");

		Exit3 = new Button();
		Exit3.setText("Exit");
		Exit3.setPrefSize(50, 50);
		Exit3.setTranslateY(85);
		Exit3.setTranslateX(600);
		Exit3.setStyle("-fx-background-color: #DF1D1D; -fx-text-fill: white;");
		Exit3.setOnAction(e -> window.close());

		x3.getChildren().addAll(Captain_America, Deadpool, Dr_Strange, Electro, Ghost_Rider, Hela, Hulk, Iceman,
				Ironman, Loki, Quicksilver, Spiderman, Thor, Venom, Yellow_Jacket, Next2, Champ, Exit3);

		// END OF THIRD SCENE

		StackPane x4 = new StackPane();
		Scene scene4 = new Scene(x4, height, width);

		Image img4 = new Image("C:\\Users\\Karim\\eclipse-workspace\\M3Fx\\BG3.png");
		BackgroundImage bImg4 = new BackgroundImage(img4, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background bGround4 = new Background(bImg4);
		x4.setBackground(bGround4);

		Next2.setOnAction(e -> {
			window.setScene(scene4);
			// window.setFullScreen(true);
			String le1 = p1.getTeam().get(0).getName();
			ch1.setText(le1);
			String le2 = p1.getTeam().get(1).getName();
			ch2.setText(le2);
			String le3 = p1.getTeam().get(2).getName();
			ch3.setText(le3);
			String le4 = p2.getTeam().get(0).getName();
			ch4.setText(le4);
			String le5 = p2.getTeam().get(1).getName();
			ch5.setText(le5);
			String le6 = p2.getTeam().get(2).getName();
			ch6.setText(le6);
			Leader.setText(p1.getName() + " & " + p2.getName()
					+ ", please pick your leaders (1 each from your chosen champions)");
			p1l.setText(p1.getName() + ": ");
			p2l.setText(p2.getName() + ": ");
		});

		// START OF FOURTH SCENE (CHOOSING LEADER)

		Leader = new Label();
		Leader.setPrefSize(1300, 200);
		Leader.setFont(new Font("Arial", 30));
		Leader.setTranslateY(-250);
		Leader.setTranslateX(0);
		Leader.setAlignment(Pos.CENTER);
		Leader.setTextFill(Color.WHITE);

		p1l = new Label();
		p1l.setPrefSize(200, 200);
		p1l.setFont(new Font("Arial", 25));
		p1l.setTranslateY(-70);
		p1l.setTranslateX(-450);
		p1l.setTextFill(Color.WHITE);

		p2l = new Label();
		p2l.setPrefSize(200, 200);
		p2l.setFont(new Font("Arial", 25));
		p2l.setTranslateY(170);
		p2l.setTranslateX(-450);
		p2l.setTextFill(Color.WHITE);

		ch1 = new Button();
		ch1.setPrefSize(150, 150);
		ch1.setTranslateX(-200);
		ch1.setTranslateY(-70);
		ch1.setOnAction(this);
		ch1.setStyle("-fx-background-color: #676171; -fx-text-fill: white;");

		ch2 = new Button();
		ch2.setPrefSize(150, 150);
		ch2.setTranslateX(0);
		ch2.setTranslateY(-70);
		ch2.setOnAction(this);
		ch2.setStyle("-fx-background-color: #676171; -fx-text-fill: white;");

		ch3 = new Button();
		ch3.setPrefSize(150, 150);
		ch3.setTranslateX(200);
		ch3.setTranslateY(-70);
		ch3.setOnAction(this);
		ch3.setStyle("-fx-background-color: #676171; -fx-text-fill: white;");

		ch4 = new Button();
		ch4.setPrefSize(150, 150);
		ch4.setTranslateX(-200);
		ch4.setTranslateY(170);
		ch4.setOnAction(this);
		ch4.setStyle("-fx-background-color: #676171; -fx-text-fill: white;");

		ch5 = new Button();
		ch5.setPrefSize(150, 150);
		ch5.setTranslateX(0);
		ch5.setTranslateY(170);
		ch5.setOnAction(this);
		ch5.setStyle("-fx-background-color: #676171; -fx-text-fill: white;");

		ch6 = new Button();
		ch6.setPrefSize(150, 150);
		ch6.setTranslateX(200);
		ch6.setTranslateY(170);
		ch6.setOnAction(this);
		ch6.setStyle("-fx-background-color: #676171; -fx-text-fill: white;");

		Next3 = new Button();
		Next3.setText("Next");
		Next3.setPrefSize(50, 50);
		Next3.setTranslateX(400);
		Next3.setTranslateY(10);
		Next3.setStyle("-fx-background-color: #48F353; -fx-text-fill: white;");

		Exit4 = new Button();
		Exit4.setText("Exit");
		Exit4.setPrefSize(50, 50);
		Exit4.setTranslateY(110);
		Exit4.setTranslateX(400);
		Exit4.setStyle("-fx-background-color: #DF1D1D; -fx-text-fill: white;");
		Exit4.setOnAction(e -> window.close());

		x4.getChildren().addAll(ch1, ch2, ch3, ch4, ch5, ch6, Leader, Next3, p1l, p2l, Exit4);

		// END OF FOURTH SCENE

		Next3.setOnAction(e -> {

			game = new Game(p1, p2);
			Alert confirm = new Alert(AlertType.INFORMATION);
			confirm.setTitle("Instructions!");
			confirm.setHeaderText("1- Hover over each player's champions to view their live stats (Under player name)"
					+ "\r\n" + "2- Every player's Leader is coloured in yellow" + "\r\n"
					+ "3- Hover over every ability to view its stats, then click on it to cast" + "\r\n"
					+ "4- Which champion is curretly playing is visible on the top of the screen" + "\r\n"
					+ "5- Current champion's details are visible on the bottom of the screen (Hover over button to show)"
					+ "\r\n" + "6- Controls for the current champion are visible on the right and left of the screen"
					+ "\r\n" + "7- Status of leader ability is visible in the bottom corners of the screen" + "\r\n"
					+ "8- Kill all the enemy's champions to win the game!");
			confirm.setContentText("HAVE FUN :)");
			confirm.initOwner(window);
			window.setScene(setBoard());
			// window.setFullScreen(true);
			Optional<ButtonType> result = confirm.showAndWait();
		});

		window.setScene(scene);
		window.show();

	}

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub

		if (event.getSource() == Captain_America) {
			Alert confirm = new Alert(AlertType.CONFIRMATION);
			confirm.setTitle("Captain America");
			confirm.getDialogPane().setMaxHeight(750);
			confirm.setHeaderText(Game.getAvailableChampions().get(0).Type() + "\r\n"+ "Max HP: " 
					+ Game.getAvailableChampions().get(0).getMaxHP() + "\r\n" + "Mana: "
					+ Game.getAvailableChampions().get(0).getMana() + "\r\n" + "Max ActionPoints per Turn: "
					+ Game.getAvailableChampions().get(0).getMaxActionPointsPerTurn() + "\r\n" + "Speed: "
					+ Game.getAvailableChampions().get(0).getSpeed() + "\r\n" + "Attack Range: "
					+ Game.getAvailableChampions().get(0).getAttackRange() + "\r\n" + "Attack Damage: "
					+ Game.getAvailableChampions().get(0).getAttackDamage() + "\r\n" + "\r\n" + "Abilities: " + "\r\n" + "\r\n"
					+ Game.getAvailableChampions().get(0).getAbilities().get(0).getName() + "\r\n"
					+ Game.getAvailableChampions().get(0).getAbilities().get(0).toString2()
					+ Game.getAvailableChampions().get(0).getAbilities().get(1).getName() + "\r\n"
					+ Game.getAvailableChampions().get(0).getAbilities().get(1).toString2()
					+ Game.getAvailableChampions().get(0).getAbilities().get(2).getName()  + "\r\n"
					+ Game.getAvailableChampions().get(0).getAbilities().get(2).toString2()
					);
			confirm.setContentText("Are you sure you want to pick this champion?");
			confirm.initOwner(window);

			Optional<ButtonType> result = confirm.showAndWait();

			if (result.isPresent() && result.get() == ButtonType.OK) {
				i++;
				if (i < 3) {
					Captain_America.setDisable(true);
					p1.getTeam().add(Game.getAvailableChampions().get(0));
				} else if (i >= 3 && i < 5) {
					Captain_America.setDisable(true);
					p2.getTeam().add(Game.getAvailableChampions().get(0));
				} else if (i == 5) {
					Captain_America.setDisable(true);
					Deadpool.setDisable(true);
					Dr_Strange.setDisable(true);
					Electro.setDisable(true);
					Ghost_Rider.setDisable(true);
					Hela.setDisable(true);
					Hulk.setDisable(true);
					Iceman.setDisable(true);
					Ironman.setDisable(true);
					Loki.setDisable(true);
					Quicksilver.setDisable(true);
					Spiderman.setDisable(true);
					Thor.setDisable(true);
					Venom.setDisable(true);
					Yellow_Jacket.setDisable(true);
					p2.getTeam().add(Game.getAvailableChampions().get(0));
				}
			}
		}

		if (event.getSource() == Deadpool) {
			Alert confirm = new Alert(AlertType.CONFIRMATION);
			confirm.setTitle("Deadpool");
			confirm.setHeaderText(Game.getAvailableChampions().get(1).Type() + "\r\n"+ "Max HP: " + Game.getAvailableChampions().get(1).getMaxHP() + "\r\n" + "Mana: "
					+ Game.getAvailableChampions().get(1).getMana() + "\r\n" + "Max ActionPoints per Turn: "
					+ Game.getAvailableChampions().get(1).getMaxActionPointsPerTurn() + "\r\n" + "Speed: "
					+ Game.getAvailableChampions().get(1).getSpeed() + "\r\n" + "Attack Range: "
					+ Game.getAvailableChampions().get(1).getAttackRange() + "\r\n" + "Attack Damage: "
					+ Game.getAvailableChampions().get(1).getAttackDamage() + "\r\n" + "\r\n" + "Abilities: " + "\r\n" + "\r\n"
					+ Game.getAvailableChampions().get(1).getAbilities().get(0).getName() + "\r\n"
					+ Game.getAvailableChampions().get(1).getAbilities().get(0).toString2()
					+ Game.getAvailableChampions().get(1).getAbilities().get(1).getName() + "\r\n"
					+ Game.getAvailableChampions().get(1).getAbilities().get(1).toString2()
					+ Game.getAvailableChampions().get(1).getAbilities().get(2).getName()  + "\r\n"
					+ Game.getAvailableChampions().get(1).getAbilities().get(2).toString2()
					);
			confirm.setContentText("Are you sure you want to pick this champion?");
			confirm.initOwner(window);

			Optional<ButtonType> result = confirm.showAndWait();
			if (result.isPresent() && result.get() == ButtonType.OK) {
				i++;
				if (i < 3) {
					Deadpool.setDisable(true);
					p1.getTeam().add(Game.getAvailableChampions().get(1));
				} else if (i >= 3 && i < 5) {
					Deadpool.setDisable(true);
					p2.getTeam().add(Game.getAvailableChampions().get(1));
				} else if (i == 5) {
					Captain_America.setDisable(true);
					Deadpool.setDisable(true);
					Dr_Strange.setDisable(true);
					Electro.setDisable(true);
					Ghost_Rider.setDisable(true);
					Hela.setDisable(true);
					Hulk.setDisable(true);
					Iceman.setDisable(true);
					Ironman.setDisable(true);
					Loki.setDisable(true);
					Quicksilver.setDisable(true);
					Spiderman.setDisable(true);
					Thor.setDisable(true);
					Venom.setDisable(true);
					Yellow_Jacket.setDisable(true);
					p2.getTeam().add(Game.getAvailableChampions().get(1));
				}
			}
		}

		if (event.getSource() == Dr_Strange) {
			Alert confirm = new Alert(AlertType.CONFIRMATION);
			confirm.setTitle("Dr Strange");
			confirm.setHeaderText(Game.getAvailableChampions().get(2).Type() + "\r\n"+ "Max HP: " + Game.getAvailableChampions().get(2).getMaxHP() + "\r\n" + "Mana: "
					+ Game.getAvailableChampions().get(2).getMana() + "\r\n" + "Max ActionPoints per Turn: "
					+ Game.getAvailableChampions().get(2).getMaxActionPointsPerTurn() + "\r\n" + "Speed: "
					+ Game.getAvailableChampions().get(2).getSpeed() + "\r\n" + "Attack Range: "
					+ Game.getAvailableChampions().get(2).getAttackRange() + "\r\n" + "Attack Damage: "
					+ Game.getAvailableChampions().get(2).getAttackDamage() + "\r\n" + "\r\n" + "Abilities: " + "\r\n" + "\r\n"
					+ Game.getAvailableChampions().get(2).getAbilities().get(0).getName() + "\r\n"
					+ Game.getAvailableChampions().get(2).getAbilities().get(0).toString2()
					+ Game.getAvailableChampions().get(2).getAbilities().get(1).getName() + "\r\n"
					+ Game.getAvailableChampions().get(2).getAbilities().get(1).toString2()
					+ Game.getAvailableChampions().get(2).getAbilities().get(2).getName()  + "\r\n"
					+ Game.getAvailableChampions().get(2).getAbilities().get(2).toString2()
					);
			confirm.setContentText("Are you sure you want to pick this champion?");
			confirm.initOwner(window);

			Optional<ButtonType> result = confirm.showAndWait();
			if (result.isPresent() && result.get() == ButtonType.OK) {
				i++;
				if (i < 3) {
					Dr_Strange.setDisable(true);
					p1.getTeam().add(Game.getAvailableChampions().get(2));
				} else if (i >= 3 && i < 5) {
					Dr_Strange.setDisable(true);
					p2.getTeam().add(Game.getAvailableChampions().get(2));
				} else if (i == 5) {
					Captain_America.setDisable(true);
					Deadpool.setDisable(true);
					Dr_Strange.setDisable(true);
					Electro.setDisable(true);
					Ghost_Rider.setDisable(true);
					Hela.setDisable(true);
					Hulk.setDisable(true);
					Iceman.setDisable(true);
					Ironman.setDisable(true);
					Loki.setDisable(true);
					Quicksilver.setDisable(true);
					Spiderman.setDisable(true);
					Thor.setDisable(true);
					Venom.setDisable(true);
					Yellow_Jacket.setDisable(true);
					p2.getTeam().add(Game.getAvailableChampions().get(2));
				}
			}
		}

		if (event.getSource() == Electro) {
			Alert confirm = new Alert(AlertType.CONFIRMATION);
			confirm.setTitle("Electro");
			confirm.setHeaderText(Game.getAvailableChampions().get(3).Type() + "\r\n"+ "Max HP: " + Game.getAvailableChampions().get(3).getMaxHP() + "\r\n" + "Mana: "
					+ Game.getAvailableChampions().get(3).getMana() + "\r\n" + "Max ActionPoints per Turn: "
					+ Game.getAvailableChampions().get(3).getMaxActionPointsPerTurn() + "\r\n" + "Speed: "
					+ Game.getAvailableChampions().get(3).getSpeed() + "\r\n" + "Attack Range: "
					+ Game.getAvailableChampions().get(3).getAttackRange() + "\r\n" + "Attack Damage: "
					+ Game.getAvailableChampions().get(3).getAttackDamage() + "\r\n" + "\r\n" + "Abilities: " + "\r\n" + "\r\n"
					+ Game.getAvailableChampions().get(3).getAbilities().get(0).getName() + "\r\n"
					+ Game.getAvailableChampions().get(3).getAbilities().get(0).toString2()
					+ Game.getAvailableChampions().get(3).getAbilities().get(1).getName() + "\r\n"
					+ Game.getAvailableChampions().get(3).getAbilities().get(1).toString2()
					+ Game.getAvailableChampions().get(3).getAbilities().get(2).getName()  + "\r\n"
					+ Game.getAvailableChampions().get(3).getAbilities().get(2).toString2()
					);
			confirm.setContentText("Are you sure you want to pick this champion?");
			confirm.initOwner(window);

			Optional<ButtonType> result = confirm.showAndWait();
			if (result.isPresent() && result.get() == ButtonType.OK) {
				i++;
				if (i < 3) {
					Electro.setDisable(true);
					p1.getTeam().add(Game.getAvailableChampions().get(3));
				} else if (i >= 3 && i < 5) {
					Electro.setDisable(true);
					p2.getTeam().add(Game.getAvailableChampions().get(3));
				} else if (i == 5) {
					Captain_America.setDisable(true);
					Deadpool.setDisable(true);
					Dr_Strange.setDisable(true);
					Electro.setDisable(true);
					Ghost_Rider.setDisable(true);
					Hela.setDisable(true);
					Hulk.setDisable(true);
					Iceman.setDisable(true);
					Ironman.setDisable(true);
					Loki.setDisable(true);
					Quicksilver.setDisable(true);
					Spiderman.setDisable(true);
					Thor.setDisable(true);
					Venom.setDisable(true);
					Yellow_Jacket.setDisable(true);
					p2.getTeam().add(Game.getAvailableChampions().get(3));
				}
			}
		}

		if (event.getSource() == Ghost_Rider) {
			Alert confirm = new Alert(AlertType.CONFIRMATION);
			confirm.setTitle("Ghost Rider");
			confirm.setHeaderText(Game.getAvailableChampions().get(4).Type() + "\r\n"+ "Max HP: " + Game.getAvailableChampions().get(4).getMaxHP() + "\r\n" + "Mana: "
					+ Game.getAvailableChampions().get(4).getMana() + "\r\n" + "Max ActionPoints per Turn: "
					+ Game.getAvailableChampions().get(4).getMaxActionPointsPerTurn() + "\r\n" + "Speed: "
					+ Game.getAvailableChampions().get(4).getSpeed() + "\r\n" + "Attack Range: "
					+ Game.getAvailableChampions().get(4).getAttackRange() + "\r\n" + "Attack Damage: "
					+ Game.getAvailableChampions().get(4).getAttackDamage() + "\r\n" + "\r\n" + "Abilities: " + "\r\n" + "\r\n"
					+ Game.getAvailableChampions().get(4).getAbilities().get(0).getName() + "\r\n"
					+ Game.getAvailableChampions().get(4).getAbilities().get(0).toString2()
					+ Game.getAvailableChampions().get(4).getAbilities().get(1).getName() + "\r\n"
					+ Game.getAvailableChampions().get(4).getAbilities().get(1).toString2()
					+ Game.getAvailableChampions().get(4).getAbilities().get(2).getName()  + "\r\n"
					+ Game.getAvailableChampions().get(4).getAbilities().get(2).toString2()
					);
			confirm.setContentText("Are you sure you want to pick this champion?");
			confirm.initOwner(window);

			Optional<ButtonType> result = confirm.showAndWait();
			if (result.isPresent() && result.get() == ButtonType.OK) {
				i++;
				if (i < 3) {
					Ghost_Rider.setDisable(true);
					p1.getTeam().add(Game.getAvailableChampions().get(4));
				} else if (i >= 3 && i < 5) {
					Ghost_Rider.setDisable(true);
					p2.getTeam().add(Game.getAvailableChampions().get(4));
				} else if (i == 5) {
					Captain_America.setDisable(true);
					Deadpool.setDisable(true);
					Dr_Strange.setDisable(true);
					Electro.setDisable(true);
					Ghost_Rider.setDisable(true);
					Hela.setDisable(true);
					Hulk.setDisable(true);
					Iceman.setDisable(true);
					Ironman.setDisable(true);
					Loki.setDisable(true);
					Quicksilver.setDisable(true);
					Spiderman.setDisable(true);
					Thor.setDisable(true);
					Venom.setDisable(true);
					Yellow_Jacket.setDisable(true);
					p2.getTeam().add(Game.getAvailableChampions().get(4));
				}
			}
		}

		if (event.getSource() == Hela) {
			Alert confirm = new Alert(AlertType.CONFIRMATION);
			confirm.setTitle("Hela");
			confirm.setHeaderText(Game.getAvailableChampions().get(5).Type() + "\r\n"+ "Max HP: " + Game.getAvailableChampions().get(5).getMaxHP() + "\r\n" + "Mana: "
					+ Game.getAvailableChampions().get(5).getMana() + "\r\n" + "Max ActionPoints per Turn: "
					+ Game.getAvailableChampions().get(5).getMaxActionPointsPerTurn() + "\r\n" + "Speed: "
					+ Game.getAvailableChampions().get(5).getSpeed() + "\r\n" + "Attack Range: "
					+ Game.getAvailableChampions().get(5).getAttackRange() + "\r\n" + "Attack Damage: "
					+ Game.getAvailableChampions().get(5).getAttackDamage() + "\r\n" + "\r\n" + "Abilities: " + "\r\n" + "\r\n"
					+ Game.getAvailableChampions().get(5).getAbilities().get(0).getName() + "\r\n"
					+ Game.getAvailableChampions().get(5).getAbilities().get(0).toString2()
					+ Game.getAvailableChampions().get(5).getAbilities().get(1).getName() + "\r\n"
					+ Game.getAvailableChampions().get(5).getAbilities().get(1).toString2()
					+ Game.getAvailableChampions().get(5).getAbilities().get(2).getName()  + "\r\n"
					+ Game.getAvailableChampions().get(5).getAbilities().get(2).toString2()
					);
			confirm.setContentText("Are you sure you want to pick this champion?");
			confirm.initOwner(window);

			Optional<ButtonType> result = confirm.showAndWait();
			if (result.isPresent() && result.get() == ButtonType.OK) {
				i++;
				if (i < 3) {
					Hela.setDisable(true);
					p1.getTeam().add(Game.getAvailableChampions().get(5));
				} else if (i >= 3 && i < 5) {
					Hela.setDisable(true);
					p2.getTeam().add(Game.getAvailableChampions().get(5));
				} else if (i == 5) {
					Captain_America.setDisable(true);
					Deadpool.setDisable(true);
					Dr_Strange.setDisable(true);
					Electro.setDisable(true);
					Ghost_Rider.setDisable(true);
					Hela.setDisable(true);
					Hulk.setDisable(true);
					Iceman.setDisable(true);
					Ironman.setDisable(true);
					Loki.setDisable(true);
					Quicksilver.setDisable(true);
					Spiderman.setDisable(true);
					Thor.setDisable(true);
					Venom.setDisable(true);
					Yellow_Jacket.setDisable(true);
					p2.getTeam().add(Game.getAvailableChampions().get(5));
				}
			}
		}

		if (event.getSource() == Hulk) {
			Alert confirm = new Alert(AlertType.CONFIRMATION);
			confirm.setTitle("Hulk");
			confirm.setHeaderText(Game.getAvailableChampions().get(6).Type() + "\r\n"+ "Max HP: " + Game.getAvailableChampions().get(6).getMaxHP() + "\r\n" + "Mana: "
					+ Game.getAvailableChampions().get(6).getMana() + "\r\n" + "Max ActionPoints per Turn: "
					+ Game.getAvailableChampions().get(6).getMaxActionPointsPerTurn() + "\r\n" + "Speed: "
					+ Game.getAvailableChampions().get(6).getSpeed() + "\r\n" + "Attack Range: "
					+ Game.getAvailableChampions().get(6).getAttackRange() + "\r\n" + "Attack Damage: "
					+ Game.getAvailableChampions().get(6).getAttackDamage() + "\r\n" + "\r\n" + "Abilities: " + "\r\n" + "\r\n"
					+ Game.getAvailableChampions().get(6).getAbilities().get(0).getName() + "\r\n"
					+ Game.getAvailableChampions().get(6).getAbilities().get(0).toString2()
					+ Game.getAvailableChampions().get(6).getAbilities().get(1).getName() + "\r\n"
					+ Game.getAvailableChampions().get(6).getAbilities().get(1).toString2()
					+ Game.getAvailableChampions().get(6).getAbilities().get(2).getName()  + "\r\n"
					+ Game.getAvailableChampions().get(6).getAbilities().get(2).toString2()
					);
			confirm.setContentText("Are you sure you want to pick this champion?");
			confirm.initOwner(window);

			Optional<ButtonType> result = confirm.showAndWait();
			if (result.isPresent() && result.get() == ButtonType.OK) {
				i++;
				if (i < 3) {
					Hulk.setDisable(true);
					p1.getTeam().add(Game.getAvailableChampions().get(6));
				} else if (i >= 3 && i < 5) {
					Hulk.setDisable(true);
					p2.getTeam().add(Game.getAvailableChampions().get(6));
				} else if (i == 5) {
					Captain_America.setDisable(true);
					Deadpool.setDisable(true);
					Dr_Strange.setDisable(true);
					Electro.setDisable(true);
					Ghost_Rider.setDisable(true);
					Hela.setDisable(true);
					Hulk.setDisable(true);
					Iceman.setDisable(true);
					Ironman.setDisable(true);
					Loki.setDisable(true);
					Quicksilver.setDisable(true);
					Spiderman.setDisable(true);
					Thor.setDisable(true);
					Venom.setDisable(true);
					Yellow_Jacket.setDisable(true);
					p2.getTeam().add(Game.getAvailableChampions().get(6));
				}
			}
		}

		if (event.getSource() == Iceman) {
			Alert confirm = new Alert(AlertType.CONFIRMATION);
			confirm.setTitle("Iceman");
			confirm.setHeaderText(Game.getAvailableChampions().get(7).Type() + "\r\n"+ "Max HP: " + Game.getAvailableChampions().get(7).getMaxHP() + "\r\n" + "Mana: "
					+ Game.getAvailableChampions().get(7).getMana() + "\r\n" + "Max ActionPoints per Turn: "
					+ Game.getAvailableChampions().get(7).getMaxActionPointsPerTurn() + "\r\n" + "Speed: "
					+ Game.getAvailableChampions().get(7).getSpeed() + "\r\n" + "Attack Range: "
					+ Game.getAvailableChampions().get(7).getAttackRange() + "\r\n" + "Attack Damage: "
					+ Game.getAvailableChampions().get(7).getAttackDamage() + "\r\n" + "\r\n" + "Abilities: " + "\r\n" + "\r\n"
					+ Game.getAvailableChampions().get(7).getAbilities().get(0).getName() + "\r\n"
					+ Game.getAvailableChampions().get(7).getAbilities().get(0).toString2()
					+ Game.getAvailableChampions().get(7).getAbilities().get(1).getName() + "\r\n"
					+ Game.getAvailableChampions().get(7).getAbilities().get(1).toString2()
					+ Game.getAvailableChampions().get(7).getAbilities().get(2).getName()  + "\r\n"
					+ Game.getAvailableChampions().get(7).getAbilities().get(2).toString2()
					);
			confirm.setContentText("Are you sure you want to pick this champion?");
			confirm.initOwner(window);

			Optional<ButtonType> result = confirm.showAndWait();
			if (result.isPresent() && result.get() == ButtonType.OK) {
				i++;
				if (i < 3) {
					Iceman.setDisable(true);
					p1.getTeam().add(Game.getAvailableChampions().get(7));
				} else if (i >= 3 && i < 5) {
					Iceman.setDisable(true);
					p2.getTeam().add(Game.getAvailableChampions().get(7));
				} else if (i == 5) {
					Captain_America.setDisable(true);
					Deadpool.setDisable(true);
					Dr_Strange.setDisable(true);
					Electro.setDisable(true);
					Ghost_Rider.setDisable(true);
					Hela.setDisable(true);
					Hulk.setDisable(true);
					Iceman.setDisable(true);
					Ironman.setDisable(true);
					Loki.setDisable(true);
					Quicksilver.setDisable(true);
					Spiderman.setDisable(true);
					Thor.setDisable(true);
					Venom.setDisable(true);
					Yellow_Jacket.setDisable(true);
					p2.getTeam().add(Game.getAvailableChampions().get(7));
				}
			}
		}

		if (event.getSource() == Ironman) {
			Alert confirm = new Alert(AlertType.CONFIRMATION);
			confirm.setTitle("Ironman");
			confirm.setHeaderText(Game.getAvailableChampions().get(8).Type() + "\r\n"+ "Max HP: " + Game.getAvailableChampions().get(8).getMaxHP() + "\r\n" + "Mana: "
					+ Game.getAvailableChampions().get(8).getMana() + "\r\n" + "Max ActionPoints per Turn: "
					+ Game.getAvailableChampions().get(8).getMaxActionPointsPerTurn() + "\r\n" + "Speed: "
					+ Game.getAvailableChampions().get(8).getSpeed() + "\r\n" + "Attack Range: "
					+ Game.getAvailableChampions().get(8).getAttackRange() + "\r\n" + "Attack Damage: "
					+ Game.getAvailableChampions().get(8).getAttackDamage()+ "\r\n" + "\r\n" + "Abilities: " + "\r\n" + "\r\n"
					+ Game.getAvailableChampions().get(8).getAbilities().get(0).getName() + "\r\n"
					+ Game.getAvailableChampions().get(8).getAbilities().get(0).toString2()
					+ Game.getAvailableChampions().get(8).getAbilities().get(1).getName() + "\r\n"
					+ Game.getAvailableChampions().get(8).getAbilities().get(1).toString2()
					+ Game.getAvailableChampions().get(8).getAbilities().get(2).getName()  + "\r\n"
					+ Game.getAvailableChampions().get(8).getAbilities().get(2).toString2()
					);
			confirm.setContentText("Are you sure you want to pick this champion?");
			confirm.initOwner(window);

			Optional<ButtonType> result = confirm.showAndWait();
			if (result.isPresent() && result.get() == ButtonType.OK) {
				i++;
				if (i < 3) {
					Ironman.setDisable(true);
					p1.getTeam().add(Game.getAvailableChampions().get(8));
				} else if (i >= 3 && i < 5) {
					Ironman.setDisable(true);
					p2.getTeam().add(Game.getAvailableChampions().get(8));
				} else if (i == 5) {
					Captain_America.setDisable(true);
					Deadpool.setDisable(true);
					Dr_Strange.setDisable(true);
					Electro.setDisable(true);
					Ghost_Rider.setDisable(true);
					Hela.setDisable(true);
					Hulk.setDisable(true);
					Iceman.setDisable(true);
					Ironman.setDisable(true);
					Loki.setDisable(true);
					Quicksilver.setDisable(true);
					Spiderman.setDisable(true);
					Thor.setDisable(true);
					Venom.setDisable(true);
					Yellow_Jacket.setDisable(true);
					p2.getTeam().add(Game.getAvailableChampions().get(8));
				}
			}
		}

		if (event.getSource() == Loki) {
			Alert confirm = new Alert(AlertType.CONFIRMATION);
			confirm.setTitle("Loki");
			confirm.setHeaderText(Game.getAvailableChampions().get(9).Type() + "\r\n"+ "Max HP: " + Game.getAvailableChampions().get(9).getMaxHP() + "\r\n" + "Mana: "
					+ Game.getAvailableChampions().get(9).getMana() + "\r\n" + "Max ActionPoints per Turn: "
					+ Game.getAvailableChampions().get(9).getMaxActionPointsPerTurn() + "\r\n" + "Speed: "
					+ Game.getAvailableChampions().get(9).getSpeed() + "\r\n" + "Attack Range: "
					+ Game.getAvailableChampions().get(9).getAttackRange() + "\r\n" + "Attack Damage: "
					+ Game.getAvailableChampions().get(9).getAttackDamage() + "\r\n" + "\r\n" + "Abilities: " + "\r\n" + "\r\n"
					+ Game.getAvailableChampions().get(9).getAbilities().get(0).getName() + "\r\n"
					+ Game.getAvailableChampions().get(9).getAbilities().get(0).toString2()
					+ Game.getAvailableChampions().get(9).getAbilities().get(1).getName() + "\r\n"
					+ Game.getAvailableChampions().get(9).getAbilities().get(1).toString2()
					+ Game.getAvailableChampions().get(9).getAbilities().get(2).getName()  + "\r\n"
					+ Game.getAvailableChampions().get(9).getAbilities().get(2).toString2()
					);
			confirm.setContentText("Are you sure you want to pick this champion?");
			confirm.initOwner(window);

			Optional<ButtonType> result = confirm.showAndWait();
			if (result.isPresent() && result.get() == ButtonType.OK) {
				i++;
				if (i < 3) {
					Loki.setDisable(true);
					p1.getTeam().add(Game.getAvailableChampions().get(9));
				} else if (i >= 3 && i < 5) {
					Loki.setDisable(true);
					p2.getTeam().add(Game.getAvailableChampions().get(9));
				} else if (i == 5) {
					Captain_America.setDisable(true);
					Deadpool.setDisable(true);
					Dr_Strange.setDisable(true);
					Electro.setDisable(true);
					Ghost_Rider.setDisable(true);
					Hela.setDisable(true);
					Hulk.setDisable(true);
					Iceman.setDisable(true);
					Ironman.setDisable(true);
					Loki.setDisable(true);
					Quicksilver.setDisable(true);
					Spiderman.setDisable(true);
					Thor.setDisable(true);
					Venom.setDisable(true);
					Yellow_Jacket.setDisable(true);
					p2.getTeam().add(Game.getAvailableChampions().get(9));
				}
			}
		}

		if (event.getSource() == Quicksilver) {
			Alert confirm = new Alert(AlertType.CONFIRMATION);
			confirm.setTitle("Quicksilver");
			confirm.setHeaderText(Game.getAvailableChampions().get(10).Type() + "\r\n"+ "Max HP: " + Game.getAvailableChampions().get(10).getMaxHP() + "\r\n" + "Mana: "
					+ Game.getAvailableChampions().get(10).getMana() + "\r\n" + "Max ActionPoints per Turn: "
					+ Game.getAvailableChampions().get(10).getMaxActionPointsPerTurn() + "\r\n" + "Speed: "
					+ Game.getAvailableChampions().get(10).getSpeed() + "\r\n" + "Attack Range: "
					+ Game.getAvailableChampions().get(10).getAttackRange() + "\r\n" + "Attack Damage: "
					+ Game.getAvailableChampions().get(10).getAttackDamage() + "\r\n" + "\r\n" + "Abilities: " + "\r\n" + "\r\n"
					+ Game.getAvailableChampions().get(10).getAbilities().get(0).getName() + "\r\n"
					+ Game.getAvailableChampions().get(10).getAbilities().get(0).toString2()
					+ Game.getAvailableChampions().get(10).getAbilities().get(1).getName() + "\r\n"
					+ Game.getAvailableChampions().get(10).getAbilities().get(1).toString2()
					+ Game.getAvailableChampions().get(10).getAbilities().get(2).getName()  + "\r\n"
					+ Game.getAvailableChampions().get(10).getAbilities().get(2).toString2()
					);
			confirm.setContentText("Are you sure you want to pick this champion?");
			confirm.initOwner(window);

			Optional<ButtonType> result = confirm.showAndWait();
			if (result.isPresent() && result.get() == ButtonType.OK) {
				i++;
				if (i < 3) {
					Quicksilver.setDisable(true);
					p1.getTeam().add(Game.getAvailableChampions().get(10));
				} else if (i >= 3 && i < 5) {
					Quicksilver.setDisable(true);
					p2.getTeam().add(Game.getAvailableChampions().get(10));
				} else if (i == 5) {
					Captain_America.setDisable(true);
					Deadpool.setDisable(true);
					Dr_Strange.setDisable(true);
					Electro.setDisable(true);
					Ghost_Rider.setDisable(true);
					Hela.setDisable(true);
					Hulk.setDisable(true);
					Iceman.setDisable(true);
					Ironman.setDisable(true);
					Loki.setDisable(true);
					Quicksilver.setDisable(true);
					Spiderman.setDisable(true);
					Thor.setDisable(true);
					Venom.setDisable(true);
					Yellow_Jacket.setDisable(true);
					p2.getTeam().add(Game.getAvailableChampions().get(10));
				}
			}
		}

		if (event.getSource() == Spiderman) {
			Alert confirm = new Alert(AlertType.CONFIRMATION);
			confirm.setTitle("Spiderman");
			confirm.setHeaderText(Game.getAvailableChampions().get(11).Type() + "\r\n"+ "Max HP: " + Game.getAvailableChampions().get(11).getMaxHP() + "\r\n" + "Mana: "
					+ Game.getAvailableChampions().get(11).getMana() + "\r\n" + "Max ActionPoints per Turn: "
					+ Game.getAvailableChampions().get(11).getMaxActionPointsPerTurn() + "\r\n" + "Speed: "
					+ Game.getAvailableChampions().get(11).getSpeed() + "\r\n" + "Attack Range: "
					+ Game.getAvailableChampions().get(11).getAttackRange() + "\r\n" + "Attack Damage: "
					+ Game.getAvailableChampions().get(11).getAttackDamage() + "\r\n" + "\r\n" + "Abilities: " + "\r\n" + "\r\n"
					+ Game.getAvailableChampions().get(11).getAbilities().get(0).getName() + "\r\n"
					+ Game.getAvailableChampions().get(11).getAbilities().get(0).toString2()
					+ Game.getAvailableChampions().get(11).getAbilities().get(1).getName() + "\r\n"
					+ Game.getAvailableChampions().get(11).getAbilities().get(1).toString2()
					+ Game.getAvailableChampions().get(11).getAbilities().get(2).getName()  + "\r\n"
					+ Game.getAvailableChampions().get(11).getAbilities().get(2).toString2()
					);
			confirm.setContentText("Are you sure you want to pick this champion?");
			confirm.initOwner(window);

			Optional<ButtonType> result = confirm.showAndWait();
			if (result.isPresent() && result.get() == ButtonType.OK) {
				i++;
				if (i < 3) {
					Spiderman.setDisable(true);
					p1.getTeam().add(Game.getAvailableChampions().get(11));
				} else if (i >= 3 && i < 5) {
					Spiderman.setDisable(true);
					p2.getTeam().add(Game.getAvailableChampions().get(11));
				} else if (i == 5) {
					Captain_America.setDisable(true);
					Deadpool.setDisable(true);
					Dr_Strange.setDisable(true);
					Electro.setDisable(true);
					Ghost_Rider.setDisable(true);
					Hela.setDisable(true);
					Hulk.setDisable(true);
					Iceman.setDisable(true);
					Ironman.setDisable(true);
					Loki.setDisable(true);
					Quicksilver.setDisable(true);
					Spiderman.setDisable(true);
					Thor.setDisable(true);
					Venom.setDisable(true);
					Yellow_Jacket.setDisable(true);
					p2.getTeam().add(Game.getAvailableChampions().get(11));
				}
			}
		}

		if (event.getSource() == Thor) {
			Alert confirm = new Alert(AlertType.CONFIRMATION);
			confirm.setTitle("Thor");
			confirm.setHeaderText(Game.getAvailableChampions().get(12).Type() + "\r\n"+ "Max HP: " + Game.getAvailableChampions().get(12).getMaxHP() + "\r\n" + "Mana: "
					+ Game.getAvailableChampions().get(12).getMana() + "\r\n" + "Max ActionPoints per Turn: "
					+ Game.getAvailableChampions().get(12).getMaxActionPointsPerTurn() + "\r\n" + "Speed: "
					+ Game.getAvailableChampions().get(12).getSpeed() + "\r\n" + "Attack Range: "
					+ Game.getAvailableChampions().get(12).getAttackRange() + "\r\n" + "Attack Damage: "
					+ Game.getAvailableChampions().get(12).getAttackDamage() + "\r\n" + "\r\n" + "Abilities: " + "\r\n" + "\r\n"
					+ Game.getAvailableChampions().get(12).getAbilities().get(0).getName() + "\r\n"
					+ Game.getAvailableChampions().get(12).getAbilities().get(0).toString2()
					+ Game.getAvailableChampions().get(12).getAbilities().get(1).getName() + "\r\n"
					+ Game.getAvailableChampions().get(12).getAbilities().get(1).toString2()
					+ Game.getAvailableChampions().get(12).getAbilities().get(2).getName()  + "\r\n"
					+ Game.getAvailableChampions().get(12).getAbilities().get(2).toString2()
					);
			confirm.setContentText("Are you sure you want to pick this champion?");
			confirm.initOwner(window);

			Optional<ButtonType> result = confirm.showAndWait();
			if (result.isPresent() && result.get() == ButtonType.OK) {
				i++;
				if (i < 3) {
					Thor.setDisable(true);
					p1.getTeam().add(Game.getAvailableChampions().get(12));
				} else if (i >= 3 && i < 5) {
					Thor.setDisable(true);
					p2.getTeam().add(Game.getAvailableChampions().get(12));
				} else if (i == 5) {
					Captain_America.setDisable(true);
					Deadpool.setDisable(true);
					Dr_Strange.setDisable(true);
					Electro.setDisable(true);
					Ghost_Rider.setDisable(true);
					Hela.setDisable(true);
					Hulk.setDisable(true);
					Iceman.setDisable(true);
					Ironman.setDisable(true);
					Loki.setDisable(true);
					Quicksilver.setDisable(true);
					Spiderman.setDisable(true);
					Thor.setDisable(true);
					Venom.setDisable(true);
					Yellow_Jacket.setDisable(true);
					p2.getTeam().add(Game.getAvailableChampions().get(12));
				}
			}
		}

		if (event.getSource() == Venom) {
			Alert confirm = new Alert(AlertType.CONFIRMATION);
			confirm.setTitle("Venom");
			confirm.setHeaderText(Game.getAvailableChampions().get(13).Type() + "\r\n"+ "Max HP: " + Game.getAvailableChampions().get(13).getMaxHP() + "\r\n" + "Mana: "
					+ Game.getAvailableChampions().get(13).getMana() + "\r\n" + "Max ActionPoints per Turn: "
					+ Game.getAvailableChampions().get(13).getMaxActionPointsPerTurn() + "\r\n" + "Speed: "
					+ Game.getAvailableChampions().get(13).getSpeed() + "\r\n" + "Attack Range: "
					+ Game.getAvailableChampions().get(13).getAttackRange() + "\r\n" + "Attack Damage: "
					+ Game.getAvailableChampions().get(13).getAttackDamage() + "\r\n" + "\r\n" + "Abilities: " + "\r\n" + "\r\n"
					+ Game.getAvailableChampions().get(13).getAbilities().get(0).getName() + "\r\n"
					+ Game.getAvailableChampions().get(13).getAbilities().get(0).toString2()
					+ Game.getAvailableChampions().get(13).getAbilities().get(1).getName() + "\r\n"
					+ Game.getAvailableChampions().get(13).getAbilities().get(1).toString2()
					+ Game.getAvailableChampions().get(13).getAbilities().get(2).getName()  + "\r\n"
					+ Game.getAvailableChampions().get(13).getAbilities().get(2).toString2()
					);
			confirm.setContentText("Are you sure you want to pick this champion?");
			confirm.initOwner(window);

			Optional<ButtonType> result = confirm.showAndWait();
			if (result.isPresent() && result.get() == ButtonType.OK) {
				i++;
				if (i < 3) {
					Venom.setDisable(true);
					p1.getTeam().add(Game.getAvailableChampions().get(13));
				} else if (i >= 3 && i < 5) {
					Venom.setDisable(true);
					p2.getTeam().add(Game.getAvailableChampions().get(13));
				} else if (i == 5) {
					Captain_America.setDisable(true);
					Deadpool.setDisable(true);
					Dr_Strange.setDisable(true);
					Electro.setDisable(true);
					Ghost_Rider.setDisable(true);
					Hela.setDisable(true);
					Hulk.setDisable(true);
					Iceman.setDisable(true);
					Ironman.setDisable(true);
					Loki.setDisable(true);
					Quicksilver.setDisable(true);
					Spiderman.setDisable(true);
					Thor.setDisable(true);
					Venom.setDisable(true);
					Yellow_Jacket.setDisable(true);
					p2.getTeam().add(Game.getAvailableChampions().get(13));
				}
			}
		}

		if (event.getSource() == Yellow_Jacket) {
			Alert confirm = new Alert(AlertType.CONFIRMATION);
			confirm.setTitle("Yellow Jacket");
			confirm.setHeaderText(Game.getAvailableChampions().get(14).Type() + "\r\n"+ "Max HP: " + Game.getAvailableChampions().get(14).getMaxHP() + "\r\n" + "Mana: "
					+ Game.getAvailableChampions().get(14).getMana() + "\r\n" + "Max ActionPoints per Turn: "
					+ Game.getAvailableChampions().get(14).getMaxActionPointsPerTurn() + "\r\n" + "Speed: "
					+ Game.getAvailableChampions().get(14).getSpeed() + "\r\n" + "Attack Range: "
					+ Game.getAvailableChampions().get(14).getAttackRange() + "\r\n" + "Attack Damage: "
					+ Game.getAvailableChampions().get(14).getAttackDamage() + "\r\n" + "\r\n" + "Abilities: " + "\r\n" + "\r\n"
					+ Game.getAvailableChampions().get(14).getAbilities().get(0).getName() + "\r\n"
					+ Game.getAvailableChampions().get(14).getAbilities().get(0).toString2()
					+ Game.getAvailableChampions().get(14).getAbilities().get(1).getName() + "\r\n"
					+ Game.getAvailableChampions().get(14).getAbilities().get(1).toString2()
					+ Game.getAvailableChampions().get(14).getAbilities().get(2).getName()  + "\r\n"
					+ Game.getAvailableChampions().get(14).getAbilities().get(2).toString2()
					);
			confirm.setContentText("Are you sure you want to pick this champion?");
			confirm.initOwner(window);

			Optional<ButtonType> result = confirm.showAndWait();
			if (result.isPresent() && result.get() == ButtonType.OK) {
				i++;
				if (i < 3) {
					Yellow_Jacket.setDisable(true);
					p1.getTeam().add(Game.getAvailableChampions().get(14));
				} else if (i >= 3 && i < 5) {
					Yellow_Jacket.setDisable(true);
					p2.getTeam().add(Game.getAvailableChampions().get(14));
				} else if (i == 5) {
					Captain_America.setDisable(true);
					Deadpool.setDisable(true);
					Dr_Strange.setDisable(true);
					Electro.setDisable(true);
					Ghost_Rider.setDisable(true);
					Hela.setDisable(true);
					Hulk.setDisable(true);
					Iceman.setDisable(true);
					Ironman.setDisable(true);
					Loki.setDisable(true);
					Quicksilver.setDisable(true);
					Spiderman.setDisable(true);
					Thor.setDisable(true);
					Venom.setDisable(true);
					Yellow_Jacket.setDisable(true);
					p2.getTeam().add(Game.getAvailableChampions().get(14));
				}
			}
		}

		if (event.getSource() == ch1) {
			p1.setLeader(p1.getTeam().get(0));
			ch1.setDisable(true);
			ch2.setDisable(true);
			ch3.setDisable(true);
		}
		if (event.getSource() == ch2) {
			p1.setLeader(p1.getTeam().get(1));
			ch1.setDisable(true);
			ch2.setDisable(true);
			ch3.setDisable(true);
		}
		if (event.getSource() == ch3) {
			p1.setLeader(p1.getTeam().get(2));
			ch1.setDisable(true);
			ch2.setDisable(true);
			ch3.setDisable(true);
		}
		if (event.getSource() == ch4) {
			p2.setLeader(p2.getTeam().get(0));
			ch4.setDisable(true);
			ch5.setDisable(true);
			ch6.setDisable(true);
		}
		if (event.getSource() == ch5) {
			p2.setLeader(p2.getTeam().get(1));
			ch4.setDisable(true);
			ch5.setDisable(true);
			ch6.setDisable(true);
		}
		if (event.getSource() == ch6) {
			p2.setLeader(p2.getTeam().get(2));
			ch4.setDisable(true);
			ch5.setDisable(true);
			ch6.setDisable(true);
		}
		if (event.getSource() == moveup) {
			try {
				game.move(Direction.UP);
			} catch (NotEnoughResourcesException | UnallowedMovementException e) {
				// TODO Auto-generated catch block
				String x = e.getMessage();
				Alert inform = new Alert(AlertType.INFORMATION);
				inform.setTitle("Error!");
				inform.setHeaderText(x);
				inform.initOwner(window);
				Optional<ButtonType> result = inform.showAndWait();
			}
			;
			window.setScene(setBoard());
			// window.setFullScreen(true);
		}
		if (event.getSource() == movedown) {
			try {
				game.move(Direction.DOWN);
			} catch (NotEnoughResourcesException | UnallowedMovementException e) {
				String x = e.getMessage();
				Alert inform = new Alert(AlertType.INFORMATION);
				inform.setTitle("Error!");
				inform.setHeaderText(x);
				inform.initOwner(window);
				Optional<ButtonType> result = inform.showAndWait();
			}
			window.setScene(setBoard());
		}
		if (event.getSource() == moveleft) {
			try {
				game.move(Direction.LEFT);
			} catch (NotEnoughResourcesException | UnallowedMovementException e) {
				String x = e.getMessage();
				Alert inform = new Alert(AlertType.INFORMATION);
				inform.setTitle("Error!");
				inform.setHeaderText(x);
				inform.initOwner(window);
				Optional<ButtonType> result = inform.showAndWait();
			}
			window.setScene(setBoard());
		}
		if (event.getSource() == moveright) {
			try {
				game.move(Direction.RIGHT);
			} catch (NotEnoughResourcesException | UnallowedMovementException e) {

				String x = e.getMessage();
				Alert inform = new Alert(AlertType.INFORMATION);
				inform.setTitle("Error!");
				inform.setHeaderText(x);
				inform.initOwner(window);
				Optional<ButtonType> result = inform.showAndWait();
			}
			window.setScene(setBoard());
			// window.setFullScreen(true);
		}
		if (event.getSource() == attackleft) {
			try {
				game.attack(Direction.LEFT);
			} catch (NotEnoughResourcesException | ChampionDisarmedException | InvalidTargetException e) {
				// TODO Auto-generated catch block
				String x = e.getMessage();
				Alert inform = new Alert(AlertType.INFORMATION);
				inform.setTitle("Error!");
				inform.setHeaderText(x);
				inform.initOwner(window);
				Optional<ButtonType> result = inform.showAndWait();
			}
			window.setScene(setBoard());
			// window.setFullScreen(true);
		}
		if (event.getSource() == attackright) {
			try {
				game.attack(Direction.RIGHT);
			} catch (NotEnoughResourcesException | ChampionDisarmedException | InvalidTargetException e) {
				// TODO Auto-generated catch block
				String x = e.getMessage();
				Alert inform = new Alert(AlertType.INFORMATION);
				inform.setTitle("Error!");
				inform.setHeaderText(x);
				inform.initOwner(window);
				Optional<ButtonType> result = inform.showAndWait();
			}
			window.setScene(setBoard());
			// window.setFullScreen(true);
		}
		if (event.getSource() == attackup) {
			try {
				game.attack(Direction.UP);
			} catch (NotEnoughResourcesException | ChampionDisarmedException | InvalidTargetException e) {
				// TODO Auto-generated catch block
				String x = e.getMessage();
				Alert inform = new Alert(AlertType.INFORMATION);
				inform.setTitle("Error!");
				inform.setHeaderText(x);
				inform.initOwner(window);
				Optional<ButtonType> result = inform.showAndWait();
			}
			window.setScene(setBoard());
			// window.setFullScreen(true);
		}
		if (event.getSource() == attackdown) {
			try {
				game.attack(Direction.DOWN);
			} catch (NotEnoughResourcesException | ChampionDisarmedException | InvalidTargetException e) {
				// TODO Auto-generated catch block
				String x = e.getMessage();
				Alert inform = new Alert(AlertType.INFORMATION);
				inform.setTitle("Error!");
				inform.setHeaderText(x);
				inform.initOwner(window);
				Optional<ButtonType> result = inform.showAndWait();
			}
			window.setScene(setBoard());
		}
		if (event.getSource() == endturn) {
			game.endTurn();
			window.setScene(setBoard());
		}
		if (event.getSource() == leaderability) {
			try {
				game.useLeaderAbility();
			} catch (LeaderNotCurrentException | LeaderAbilityAlreadyUsedException e) {
				// TODO Auto-generated catch block
				String x = e.getMessage();
				Alert inform = new Alert(AlertType.INFORMATION);
				inform.setTitle("Error!");
				inform.setHeaderText(x);
				inform.initOwner(window);
				Optional<ButtonType> result = inform.showAndWait();
			}
			window.setScene(setBoard());
		}
		if (event.getSource() == ab1) {
			if (game.getCurrentChampion().getAbilities().get(0).getCastArea().equals(AreaOfEffect.SELFTARGET)
					|| game.getCurrentChampion().getAbilities().get(0).getCastArea().equals(AreaOfEffect.TEAMTARGET)
					|| game.getCurrentChampion().getAbilities().get(0).getCastArea().equals(AreaOfEffect.SURROUND)) {
				try {
					game.castAbility(game.getCurrentChampion().getAbilities().get(0));
				} catch (NotEnoughResourcesException | AbilityUseException | CloneNotSupportedException e) {
					// TODO Auto-generated catch block
					String x = e.getMessage();
					Alert inform = new Alert(AlertType.INFORMATION);
					inform.setTitle("Error!");
					inform.setHeaderText(x);
					inform.initOwner(window);
					Optional<ButtonType> result = inform.showAndWait();
				}
			}

			else if (game.getCurrentChampion().getAbilities().get(0).getCastArea().equals(AreaOfEffect.DIRECTIONAL)) {
				// Directional
				TextInputDialog direc = new TextInputDialog("Ex. UP, DOWN, etc..");
				direc.setContentText("Direction: ");
				direc.setHeaderText("Please enter the direction in which you wish to cast the ability, in all caps");
				direc.showAndWait();
				if (direc.getEditor().getText().equals("UP")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(0), Direction.UP);
					} catch (NotEnoughResourcesException | AbilityUseException | CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (direc.getEditor().getText().equals("DOWN")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(0), Direction.DOWN);
					} catch (NotEnoughResourcesException | AbilityUseException | CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (direc.getEditor().getText().equals("LEFT")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(0), Direction.LEFT);
					} catch (NotEnoughResourcesException | AbilityUseException | CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (direc.getEditor().getText().equals("RIGHT")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(0), Direction.RIGHT);
					} catch (NotEnoughResourcesException | AbilityUseException | CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				}
			} else if (game.getCurrentChampion().getAbilities().get(0).getCastArea()
					.equals(AreaOfEffect.SINGLETARGET)) {
				// Single Target
				TextInputDialog single = new TextInputDialog("Ex. 1,3 or 4,1 etc..");
				single.setContentText("Cell: ");
				single.setHeaderText(
						"Please enter cell number you wish to cast ability on, x-coordinate and y-coordinate seperated by a comma and with no spaces ie. x,y");
				single.showAndWait();
				if (single.getEditor().getText().equals("0,0")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(0), 0, 0);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("0,1")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(0), 1, 0);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("0,2")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(0), 2, 0);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("0,3")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(0), 3, 0);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("0,4")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(0), 4, 0);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("1,0")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(0), 0, 1);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("1,1")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(0), 1, 1);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("1,2")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(0), 2, 1);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("1,3")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(0), 3, 1);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("1,4")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(0), 4, 1);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("2,0")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(0), 0, 2);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("2,1")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(0), 1, 2);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("2,2")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(0), 2, 2);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("2,3")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(0), 3, 2);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("2,4")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(0), 4, 2);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("3,0")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(0), 0, 3);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("3,1")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(0), 1, 3);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("3,2")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(0), 2, 3);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("3,3")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(0), 3, 3);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("3,4")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(0), 4, 3);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("4,0")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(0), 0, 4);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("4,1")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(0), 1, 4);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("4,2")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(0), 2, 4);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("4,3")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(0), 3, 4);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("4,4")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(0), 4, 4);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				}
			}
			window.setScene(setBoard());
		}

		if (event.getSource() == ab2) {
			if (game.getCurrentChampion().getAbilities().get(1).getCastArea().equals(AreaOfEffect.SELFTARGET)
					|| game.getCurrentChampion().getAbilities().get(1).getCastArea().equals(AreaOfEffect.TEAMTARGET)
					|| game.getCurrentChampion().getAbilities().get(1).getCastArea().equals(AreaOfEffect.SURROUND)) {
				try {
					game.castAbility(game.getCurrentChampion().getAbilities().get(1));
				} catch (NotEnoughResourcesException | AbilityUseException | CloneNotSupportedException e) {
					// TODO Auto-generated catch block
					String x = e.getMessage();
					Alert inform = new Alert(AlertType.INFORMATION);
					inform.setTitle("Error!");
					inform.setHeaderText(x);
					inform.initOwner(window);
					Optional<ButtonType> result = inform.showAndWait();
				}
			}

			else if (game.getCurrentChampion().getAbilities().get(1).getCastArea().equals(AreaOfEffect.DIRECTIONAL)) {
				// Directional
				TextInputDialog direc = new TextInputDialog("Ex. UP, DOWN, etc..");
				direc.setContentText("Direction: ");
				direc.setHeaderText("Please enter ability direction in all caps");
				direc.showAndWait();
				if (direc.getEditor().getText().equals("UP")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(1), Direction.UP);
					} catch (NotEnoughResourcesException | AbilityUseException | CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (direc.getEditor().getText().equals("DOWN")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(1), Direction.DOWN);
					} catch (NotEnoughResourcesException | AbilityUseException | CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (direc.getEditor().getText().equals("LEFT")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(1), Direction.LEFT);
					} catch (NotEnoughResourcesException | AbilityUseException | CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (direc.getEditor().getText().equals("RIGHT")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(1), Direction.RIGHT);
					} catch (NotEnoughResourcesException | AbilityUseException | CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				}
			} else if (game.getCurrentChampion().getAbilities().get(1).getCastArea()
					.equals(AreaOfEffect.SINGLETARGET)) {
				// Single Target
				TextInputDialog single = new TextInputDialog("Ex. 1,3 or 4,1 etc..");
				single.setContentText("Cell: ");
				single.setHeaderText(
						"Please enter cell number you wish to cast ability on, x-coordinate and y-coordinate seperated by a comma and with no spaces ie. x,y");
				single.showAndWait();
				if (single.getEditor().getText().equals("0,0")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(1), 0, 0);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("0,1")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(1), 1, 0);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("0,2")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(1), 2, 0);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("0,3")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(1), 3, 0);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("0,4")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(1), 4, 0);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("1,0")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(1), 0, 1);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("1,1")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(1), 1, 1);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("1,2")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(1), 2, 1);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("1,3")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(1), 3, 1);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("1,4")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(1), 4, 1);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("2,0")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(1), 0, 2);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("2,1")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(1), 1, 2);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("2,2")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(1), 2, 2);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("2,3")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(1), 3, 2);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("2,4")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(1), 4, 2);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("3,0")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(1), 0, 3);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("3,1")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(1), 1, 3);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("3,2")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(1), 2, 3);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("3,3")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(1), 3, 3);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("3,4")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(1), 4, 3);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("4,0")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(1), 0, 4);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("4,1")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(1), 1, 4);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("4,2")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(1), 2, 4);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("4,3")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(1), 3, 4);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("4,4")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(1), 4, 4);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				}
			}
			window.setScene(setBoard());
		}

		if (event.getSource() == ab3) {
			if (game.getCurrentChampion().getAbilities().get(2).getCastArea().equals(AreaOfEffect.SELFTARGET)
					|| game.getCurrentChampion().getAbilities().get(2).getCastArea().equals(AreaOfEffect.TEAMTARGET)
					|| game.getCurrentChampion().getAbilities().get(2).getCastArea().equals(AreaOfEffect.SURROUND)) {
				try {
					game.castAbility(game.getCurrentChampion().getAbilities().get(2));
				} catch (NotEnoughResourcesException | AbilityUseException | CloneNotSupportedException e) {
					// TODO Auto-generated catch block
					String x = e.getMessage();
					Alert inform = new Alert(AlertType.INFORMATION);
					inform.setTitle("Error!");
					inform.setHeaderText(x);
					inform.initOwner(window);
					Optional<ButtonType> result = inform.showAndWait();
				}
			}

			else if (game.getCurrentChampion().getAbilities().get(2).getCastArea().equals(AreaOfEffect.DIRECTIONAL)) {
				// Directional
				TextInputDialog direc = new TextInputDialog("Ex. UP, DOWN, etc..");
				direc.setContentText("Direction: ");
				direc.setHeaderText("Please enter ability direction in all caps");
				direc.showAndWait();
				if (direc.getEditor().getText().equals("UP")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(2), Direction.UP);
					} catch (NotEnoughResourcesException | AbilityUseException | CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (direc.getEditor().getText().equals("DOWN")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(2), Direction.DOWN);
					} catch (NotEnoughResourcesException | AbilityUseException | CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (direc.getEditor().getText().equals("LEFT")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(2), Direction.LEFT);
					} catch (NotEnoughResourcesException | AbilityUseException | CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (direc.getEditor().getText().equals("RIGHT")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(2), Direction.RIGHT);
					} catch (NotEnoughResourcesException | AbilityUseException | CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				}
			} else if (game.getCurrentChampion().getAbilities().get(2).getCastArea()
					.equals(AreaOfEffect.SINGLETARGET)) {
				// Single Target
				TextInputDialog single = new TextInputDialog("Ex. 1,3 or 4,1 etc..");
				single.setContentText("Cell: ");
				single.setHeaderText(
						"Please enter cell number you wish to cast ability on, x-coordinate and y-coordinate seperated by a comma and with no spaces ie. x,y");
				single.showAndWait();
				if (single.getEditor().getText().equals("0,0")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(2), 0, 0);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("0,1")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(2), 1, 0);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("0,2")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(2), 2, 0);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("0,3")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(2), 3, 0);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("0,4")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(2), 4, 0);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("1,0")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(2), 0, 1);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("1,1")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(2), 1, 1);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("1,2")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(2), 2, 1);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("1,3")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(2), 3, 1);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("1,4")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(2), 4, 1);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("2,0")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(2), 0, 2);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("2,1")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(2), 1, 2);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("2,2")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(2), 2, 2);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("2,3")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(2), 3, 2);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("2,4")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(2), 4, 2);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("3,0")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(2), 0, 3);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("3,1")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(2), 1, 3);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("3,2")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(2), 2, 3);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("3,3")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(2), 3, 3);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("3,4")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(2), 4, 3);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("4,0")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(2), 0, 4);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("4,1")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(2), 1, 4);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("4,2")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(2), 2, 4);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("4,3")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(2), 3, 4);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				} else if (single.getEditor().getText().equals("4,4")) {
					try {
						game.castAbility(game.getCurrentChampion().getAbilities().get(2), 4, 4);
					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
							| CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						String x = e.getMessage();
						Alert inform = new Alert(AlertType.INFORMATION);
						inform.setTitle("Error!");
						inform.setHeaderText(x);
						inform.initOwner(window);
						Optional<ButtonType> result = inform.showAndWait();
					}
				}
			}
			window.setScene(setBoard());
		}
	}

	public Scene setBoard() {

		if (game.checkGameOver() == p1 || game.checkGameOver() == p2) {
			Label w = new Label(game.checkGameOver().getName() + " WON!!");
			w.setPrefSize(750, 200);
			w.setFont(new Font("Arial", 30));
			w.setAlignment(Pos.CENTER);
			StackPane s6 = new StackPane(w, Exit);
			Scene s7 = new Scene(s6, height, width);
			return s7;
		}

		BorderPane border = new BorderPane();

		String name = game.getFirstPlayer().getName();
		String name2 = game.getSecondPlayer().getName();
		String lead1 = "NOT USED YET";
		String lead2 = "NOT USED YET";
		if (game.isFirstLeaderAbilityUsed())
			lead1 = "USED";
		if (game.isSecondLeaderAbilityUsed())
			lead2 = "USED";

		String app1 = "Applied Effects: ";
		String app2 = "Applied Effects: ";
		String app3 = "Applied Effects: ";
		String app4 = "Applied Effects: ";
		String app5 = "Applied Effects: ";
		String app6 = "Applied Effects: ";
		String app7 = "Applied Effects: ";

		if (game.getFirstPlayer().getTeam().size() > 0) {
			for (int j = 0; j < game.getFirstPlayer().getTeam().get(0).getAppliedEffects().size(); j++)
				app1 += game.getFirstPlayer().getTeam().get(0).getAppliedEffects().get(j).getName() + ", Duration: "
						+ game.getFirstPlayer().getTeam().get(0).getAppliedEffects().get(j).getDuration() + "\r\n";
		}
		if (game.getFirstPlayer().getTeam().size() > 1) {
			for (int j = 0; j < game.getFirstPlayer().getTeam().get(1).getAppliedEffects().size(); j++)
				app2 += game.getFirstPlayer().getTeam().get(1).getAppliedEffects().get(j).getName() + ", Duration: "
						+ game.getFirstPlayer().getTeam().get(1).getAppliedEffects().get(j).getDuration() + "\r\n";
		}
		if (game.getFirstPlayer().getTeam().size() > 2) {
			for (int j = 0; j < game.getFirstPlayer().getTeam().get(2).getAppliedEffects().size(); j++)
				app3 += game.getFirstPlayer().getTeam().get(2).getAppliedEffects().get(j).getName() + ", Duration: "
						+ game.getFirstPlayer().getTeam().get(2).getAppliedEffects().get(j).getDuration() + "\r\n";
		}
		if (game.getSecondPlayer().getTeam().size() > 0) {
			for (int j = 0; j < game.getSecondPlayer().getTeam().get(0).getAppliedEffects().size(); j++)
				app4 += game.getSecondPlayer().getTeam().get(0).getAppliedEffects().get(j).getName() + ", Duration: "
						+ game.getSecondPlayer().getTeam().get(0).getAppliedEffects().get(j).getDuration() + "\r\n";
		}
		if (game.getSecondPlayer().getTeam().size() > 1) {
			for (int j = 0; j < game.getSecondPlayer().getTeam().get(1).getAppliedEffects().size(); j++)
				app5 += game.getSecondPlayer().getTeam().get(1).getAppliedEffects().get(j).getName() + ", Duration: "
						+ game.getSecondPlayer().getTeam().get(1).getAppliedEffects().get(j).getDuration() + "\r\n";
		}
		if (game.getSecondPlayer().getTeam().size() > 2) {
			for (int j = 0; j < game.getSecondPlayer().getTeam().get(2).getAppliedEffects().size(); j++)
				app6 += game.getSecondPlayer().getTeam().get(2).getAppliedEffects().get(j).getName() + ", Duration: "
						+ game.getSecondPlayer().getTeam().get(2).getAppliedEffects().get(j).getDuration() + "\r\n";
		}
		for (int j = 0; j < game.getCurrentChampion().getAppliedEffects().size(); j++) {
			app7 += game.getCurrentChampion().getAppliedEffects().get(j).getName() + ", Duration: "
					+ game.getCurrentChampion().getAppliedEffects().get(j).getDuration() + "\r\n";
		}

		String ab1type = "";
		String ab2type = "";
		String ab3type = "";
		if (game.getCurrentChampion().getAbilities().get(0) instanceof DamagingAbility) {
			ab1type = "Type: Damaging Ability";
		}
		if (game.getCurrentChampion().getAbilities().get(0) instanceof HealingAbility) {
			ab1type = "Type: Healing Ability";
		}
		if (game.getCurrentChampion().getAbilities().get(0) instanceof CrowdControlAbility) {
			ab1type = "Type: Crowd Control Ability";
		}
		if (game.getCurrentChampion().getAbilities().get(1) instanceof DamagingAbility) {
			ab2type = "Type: Damaging Ability";
		}
		if (game.getCurrentChampion().getAbilities().get(1) instanceof HealingAbility) {
			ab2type = "Type: Healing Ability";
		}
		if (game.getCurrentChampion().getAbilities().get(1) instanceof CrowdControlAbility) {
			ab2type = "Type: Crowd Control Ability";
		}
		if (game.getCurrentChampion().getAbilities().get(2) instanceof DamagingAbility) {
			ab3type = "Type: Damaging Ability";
		}
		if (game.getCurrentChampion().getAbilities().get(2) instanceof HealingAbility) {
			ab3type = "Type: Healing Ability";
		}
		if (game.getCurrentChampion().getAbilities().get(2) instanceof CrowdControlAbility) {
			ab3type = "Type: Crowd Control Ability";
		}

		StackPane playerone = new StackPane();
		//playerone.setStyle("-fx-background-color: #6C6AE0;");
		
		Label namep1 = new Label();
		namep1.setText("Player Name: " + name);
		namep1.setTranslateY(-300);

		Label Leadp1 = new Label();
		Leadp1.setText(game.getFirstPlayer().getName() + "'s Leader Ability: " + lead1);
		Leadp1.setTranslateY(300);

		Label controls = new Label("CONTROLS");
		controls.setPrefSize(160, 20);
		controls.setTranslateY(-72);
		controls.setAlignment(Pos.CENTER);

		Label controls2 = new Label("CONTROLS");
		controls2.setPrefSize(160, 20);
		controls2.setTranslateY(-72);
		controls2.setAlignment(Pos.CENTER);

		move.setTranslateY(-25);
		move.setPrefSize(100, 50);

		if (game.getFirstPlayer().getTeam().size() > 0) {
			Button l1 = new Button();
			l1.setPrefSize(200, 50);
			l1.setTranslateY(-240);
			if (game.getFirstPlayer().getTeam().get(0).getName().equals(game.getFirstPlayer().getLeader().getName()))
				l1.setStyle("-fx-background-color: #F3F935;");
			l1.setText(game.getFirstPlayer().getTeam().get(0).getName());
			Tooltip l11 = new Tooltip(game.getFirstPlayer().getTeam().get(0).getName() + ":" + "\r\n"  
					+ game.getFirstPlayer().getTeam().get(0).Type() + "\r\n" + "Max HP: "
					+ game.getFirstPlayer().getTeam().get(0).getMaxHP() + "\r\n" + "CurrentHP: "
					+ game.getFirstPlayer().getTeam().get(0).getCurrentHP() + "\r\n" + "Mana: "
					+ game.getFirstPlayer().getTeam().get(0).getMana() + "\r\n" + "Current ActionPoints: "
					+ game.getFirstPlayer().getTeam().get(0).getCurrentActionPoints() + "\r\n"
					+ "Max ActionPoints per Turn: " + game.getFirstPlayer().getTeam().get(0).getMaxActionPointsPerTurn()
					+ "\r\n" + "Speed: " + game.getFirstPlayer().getTeam().get(0).getSpeed() + "\r\n" + "Attack Range: "
					+ game.getFirstPlayer().getTeam().get(0).getAttackRange() + "\r\n" + "Attack Damage: "
					+ game.getFirstPlayer().getTeam().get(0).getAttackDamage() + "\r\n" + "\r\n" + "Abilities: "
					+ game.getFirstPlayer().getTeam().get(0).getAbilities().get(0).getName() + "\r\n"
					+ game.getFirstPlayer().getTeam().get(0).getAbilities().get(0).toString()
					+ game.getFirstPlayer().getTeam().get(0).getAbilities().get(1).getName() + "\r\n"
					+ game.getFirstPlayer().getTeam().get(0).getAbilities().get(1).toString()
					+ game.getFirstPlayer().getTeam().get(0).getAbilities().get(2).getName() + "\r\n"
					+ game.getFirstPlayer().getTeam().get(0).getAbilities().get(2).toString() + "\r\n" + "\r\n" + app1);
			Tooltip.install(l1, l11);
			playerone.getChildren().add(l1);
		}
		if (game.getFirstPlayer().getTeam().size() > 1) {
			Button l2 = new Button();
			l2.setPrefSize(200, 50);
			l2.setTranslateY(-180);
			if (game.getFirstPlayer().getTeam().get(1).getName().equals(game.getFirstPlayer().getLeader().getName()))
				l2.setStyle("-fx-background-color: #F3F935;");

			l2.setText(game.getFirstPlayer().getTeam().get(1).getName());
			Tooltip l22 = new Tooltip(game.getFirstPlayer().getTeam().get(1).getName() + ":" + "\r\n" 
					+ game.getFirstPlayer().getTeam().get(1).Type() + "\r\n" +"Max HP: "
					+ game.getFirstPlayer().getTeam().get(1).getMaxHP() + "\r\n" + "CurrentHP: "
					+ game.getFirstPlayer().getTeam().get(1).getCurrentHP() + "\r\n" + "Mana: "
					+ game.getFirstPlayer().getTeam().get(1).getMana() + "\r\n" + "Current ActionPoints: "
					+ game.getFirstPlayer().getTeam().get(1).getCurrentActionPoints() + "\r\n"
					+ "Max ActionPoints per Turn: " + game.getFirstPlayer().getTeam().get(1).getMaxActionPointsPerTurn()
					+ "\r\n" + "Speed: " + game.getFirstPlayer().getTeam().get(1).getSpeed() + "\r\n" + "Attack Range: "
					+ game.getFirstPlayer().getTeam().get(1).getAttackRange() + "\r\n" + "Attack Damage: "
					+ game.getFirstPlayer().getTeam().get(1).getAttackDamage() + "\r\n" + "\r\n" + "Abilities: "
					+ game.getFirstPlayer().getTeam().get(1).getAbilities().get(0).getName() + "\r\n"
					+ game.getFirstPlayer().getTeam().get(1).getAbilities().get(0).toString()
					+ game.getFirstPlayer().getTeam().get(1).getAbilities().get(1).getName() + "\r\n"
					+ game.getFirstPlayer().getTeam().get(1).getAbilities().get(1).toString()
					+ game.getFirstPlayer().getTeam().get(1).getAbilities().get(2).getName() + "\r\n"
					+ game.getFirstPlayer().getTeam().get(1).getAbilities().get(2).toString() + "\r\n" + "\r\n" + app2);
			Tooltip.install(l2, l22);
			playerone.getChildren().add(l2);
		}
		if (game.getFirstPlayer().getTeam().size() > 2) {
			Button l3 = new Button();
			l3.setPrefSize(200, 50);
			l3.setTranslateY(-120);
			if (game.getFirstPlayer().getTeam().get(2).getName().equals(game.getFirstPlayer().getLeader().getName()))
				l3.setStyle("-fx-background-color: #F3F935;");

			l3.setText(game.getFirstPlayer().getTeam().get(2).getName());
			Tooltip l33 = new Tooltip(game.getFirstPlayer().getTeam().get(2).getName() + ":" + "\r\n" 
					+ game.getFirstPlayer().getTeam().get(2).Type() + "\r\n" +"Max HP: "
					+ game.getFirstPlayer().getTeam().get(2).getMaxHP() + "\r\n" + "CurrentHP: "
					+ game.getFirstPlayer().getTeam().get(2).getCurrentHP() + "\r\n" + "Mana: "
					+ game.getFirstPlayer().getTeam().get(2).getMana() + "\r\n" + "Current ActionPoints: "
					+ game.getFirstPlayer().getTeam().get(2).getCurrentActionPoints() + "\r\n"
					+ "Max ActionPoints per Turn: " + game.getFirstPlayer().getTeam().get(2).getMaxActionPointsPerTurn()
					+ "\r\n" + "Speed: " + game.getFirstPlayer().getTeam().get(2).getSpeed() + "\r\n" + "Attack Range: "
					+ game.getFirstPlayer().getTeam().get(2).getAttackRange() + "\r\n" + "Attack Damage: "
					+ game.getFirstPlayer().getTeam().get(2).getAttackDamage() + "\r\n" + "\r\n" + "Abilities: "
					+ game.getFirstPlayer().getTeam().get(2).getAbilities().get(0).getName() + "\r\n"
					+ game.getFirstPlayer().getTeam().get(2).getAbilities().get(0).toString()
					+ game.getFirstPlayer().getTeam().get(2).getAbilities().get(1).getName() + "\r\n"
					+ game.getFirstPlayer().getTeam().get(2).getAbilities().get(1).toString()
					+ game.getFirstPlayer().getTeam().get(2).getAbilities().get(2).getName() + "\r\n"
					+ game.getFirstPlayer().getTeam().get(2).getAbilities().get(2).toString() + "\r\n" + "\r\n" + app3);
			Tooltip.install(l3, l33);
			playerone.getChildren().add(l3);
		}
		playerone.getChildren().addAll(namep1, Leadp1, ab1, ab2, ab3, move, controls);

		StackPane playertwo = new StackPane();
		//playertwo.setStyle("-fx-background-color: #2CF5FF;");
		Label namep2 = new Label();
		namep2.setText("Player Name: " + name2);
		namep2.setTranslateY(-300);

		Label Leadp2 = new Label();
		Leadp2.setText(game.getSecondPlayer().getName() + "'s Leader Ability: " + lead2);
		Leadp2.setTranslateY(300);

		attack.setTranslateY(-25);
		attack.setPrefSize(100, 50);

		Exit5 = new Button();
		Exit5.setText("Exit");
		Exit5.setPrefSize(50, 50);
		Exit5.setTranslateY(210);
		Exit5.setStyle("-fx-background-color: #DF1D1D; -fx-text-fill: white;");
		Exit5.setOnAction(e -> window.close());

		if (game.getSecondPlayer().getTeam().size() > 0) {
			Button l4 = new Button();
			l4.setPrefSize(200, 50);
			l4.setTranslateY(-240);
			if (game.getSecondPlayer().getTeam().get(0).getName().equals(game.getSecondPlayer().getLeader().getName()))
				l4.setStyle("-fx-background-color: #F3F935;");

			l4.setText(game.getSecondPlayer().getTeam().get(0).getName());
			Tooltip l44 = new Tooltip(game.getSecondPlayer().getTeam().get(0).getName() + ":" + "\r\n" 
					+ game.getSecondPlayer().getTeam().get(0).Type() + "\r\n" +"Max HP: "
					+ game.getSecondPlayer().getTeam().get(0).getMaxHP() + "\r\n" + "CurrentHP: "
					+ game.getSecondPlayer().getTeam().get(0).getCurrentHP() + "\r\n" + "Mana: "
					+ game.getSecondPlayer().getTeam().get(0).getMana() + "\r\n" + "Current ActionPoints: "
					+ game.getSecondPlayer().getTeam().get(0).getCurrentActionPoints() + "\r\n"
					+ "Max ActionPoints per Turn: "
					+ game.getSecondPlayer().getTeam().get(0).getMaxActionPointsPerTurn() + "\r\n" + "Speed: "
					+ game.getSecondPlayer().getTeam().get(0).getSpeed() + "\r\n" + "Attack Range: "
					+ game.getSecondPlayer().getTeam().get(0).getAttackRange() + "\r\n" + "Attack Damage: "
					+ game.getSecondPlayer().getTeam().get(0).getAttackDamage() + "\r\n" + "\r\n" + "Abilities: "
					+ game.getSecondPlayer().getTeam().get(0).getAbilities().get(0).getName() + "\r\n"
					+ game.getSecondPlayer().getTeam().get(0).getAbilities().get(0).toString()
					+ game.getSecondPlayer().getTeam().get(0).getAbilities().get(1).getName() + "\r\n"
					+ game.getSecondPlayer().getTeam().get(0).getAbilities().get(1).toString()
					+ game.getSecondPlayer().getTeam().get(0).getAbilities().get(2).getName() + "\r\n"
					+ game.getSecondPlayer().getTeam().get(0).getAbilities().get(2).toString() + "\r\n" + "\r\n"
					+ app4);
			Tooltip.install(l4, l44);
			playertwo.getChildren().add(l4);
		}
		if (game.getSecondPlayer().getTeam().size() > 1) {
			Button l5 = new Button();
			l5.setPrefSize(200, 50);
			l5.setTranslateY(-180);
			if (game.getSecondPlayer().getTeam().get(1).getName().equals(game.getSecondPlayer().getLeader().getName()))
				l5.setStyle("-fx-background-color: #F3F935;");

			l5.setText(game.getSecondPlayer().getTeam().get(1).getName());
			Tooltip l55 = new Tooltip(game.getSecondPlayer().getTeam().get(1).getName() + ":" + "\r\n" 
					+ game.getSecondPlayer().getTeam().get(1).Type() + "\r\n" +"Max HP: "
					+ game.getSecondPlayer().getTeam().get(1).getMaxHP() + "\r\n" + "CurrentHP: "
					+ game.getSecondPlayer().getTeam().get(1).getCurrentHP() + "\r\n" + "Mana: "
					+ game.getSecondPlayer().getTeam().get(1).getMana() + "\r\n" + "Current ActionPoints: "
					+ game.getSecondPlayer().getTeam().get(1).getCurrentActionPoints() + "\r\n"
					+ "Max ActionPoints per Turn: "
					+ game.getSecondPlayer().getTeam().get(1).getMaxActionPointsPerTurn() + "\r\n" + "Speed: "
					+ game.getSecondPlayer().getTeam().get(1).getSpeed() + "\r\n" + "Attack Range: "
					+ game.getSecondPlayer().getTeam().get(1).getAttackRange() + "\r\n" + "Attack Damage: "
					+ game.getSecondPlayer().getTeam().get(1).getAttackDamage() + "\r\n" + "\r\n" + "Abilities: "
					+ game.getSecondPlayer().getTeam().get(1).getAbilities().get(0).getName() + "\r\n"
					+ game.getSecondPlayer().getTeam().get(1).getAbilities().get(0).toString()
					+ game.getSecondPlayer().getTeam().get(1).getAbilities().get(1).getName() + "\r\n"
					+ game.getSecondPlayer().getTeam().get(1).getAbilities().get(1).toString()
					+ game.getSecondPlayer().getTeam().get(1).getAbilities().get(2).getName() + "\r\n" 
					+ game.getSecondPlayer().getTeam().get(1).getAbilities().get(2).toString() + "\r\n" + "\r\n"
					+ app5);
			Tooltip.install(l5, l55);
			playertwo.getChildren().add(l5);
		}
		if (game.getSecondPlayer().getTeam().size() > 2) {
			Button l6 = new Button();
			l6.setPrefSize(200, 50);
			l6.setTranslateY(-120);
			if (game.getSecondPlayer().getTeam().get(2).getName().equals(game.getSecondPlayer().getLeader().getName()))
				l6.setStyle("-fx-background-color: #F3F935;");

			l6.setText(game.getSecondPlayer().getTeam().get(2).getName());
			Tooltip l66 = new Tooltip(game.getSecondPlayer().getTeam().get(2).getName() + ":" + "\r\n" 
					+ game.getSecondPlayer().getTeam().get(2).Type() + "\r\n" +"Max HP: "
					+ game.getSecondPlayer().getTeam().get(2).getMaxHP() + "\r\n" + "CurrentHP: "
					+ game.getSecondPlayer().getTeam().get(2).getCurrentHP() + "\r\n" + "Mana: "
					+ game.getSecondPlayer().getTeam().get(2).getMana() + "\r\n" + "Current ActionPoints: "
					+ game.getSecondPlayer().getTeam().get(2).getCurrentActionPoints() + "\r\n"
					+ "Max ActionPoints per Turn: "
					+ game.getSecondPlayer().getTeam().get(2).getMaxActionPointsPerTurn() + "\r\n" + "Speed: "
					+ game.getSecondPlayer().getTeam().get(2).getSpeed() + "\r\n" + "Attack Range: "
					+ game.getSecondPlayer().getTeam().get(2).getAttackRange() + "\r\n" + "Attack Damage: "
					+ game.getSecondPlayer().getTeam().get(2).getAttackDamage() + "\r\n" + "\r\n" + "Abilities: "
					+ game.getSecondPlayer().getTeam().get(2).getAbilities().get(0).getName() + "\r\n"
					+ game.getSecondPlayer().getTeam().get(2).getAbilities().get(0).toString()
					+ game.getSecondPlayer().getTeam().get(2).getAbilities().get(1).getName() + "\r\n"
					+ game.getSecondPlayer().getTeam().get(2).getAbilities().get(1).toString()
					+ game.getSecondPlayer().getTeam().get(2).getAbilities().get(2).getName() + "\r\n"
					+ game.getSecondPlayer().getTeam().get(2).getAbilities().get(2).toString() + "\r\n" + "\r\n"
					+ app6);
			Tooltip.install(l6, l66);
			playertwo.getChildren().add(l6);
		}
		playertwo.getChildren().addAll(namep2, Leadp2, attack, leaderability, endturn, Exit5, controls2);

		PriorityQueue z = new PriorityQueue(6);
		HBox order = new HBox();
		order.setAlignment(Pos.CENTER);
		order.setSpacing(10);
		int r2 = game.getTurnOrder().size();
		Button or1 = new Button(game.getTurnOrder().peekMin().toString());
		or1.setPrefWidth(120);
		or1.setPrefHeight(40);
		or1.setStyle("-fx-background-color: #82FF2C;");
		order.getChildren().add(or1);
		z.insert(game.getTurnOrder().remove());
		for (int i = 0; i < r2 - 1; i++) {
			Button or2 = new Button(game.getTurnOrder().peekMin().toString());
			or2.setPrefWidth(120);
			or2.setPrefHeight(40);
			z.insert(game.getTurnOrder().remove());
			order.getChildren().add(or2);
		}
		int r = z.size();
		for (int p = 0; p < r; p++) {
			game.getTurnOrder().insert(z.remove());
		}

		HBox top = new HBox();
		top.setAlignment(Pos.CENTER);
		top.setPadding(new Insets(15, 12, 15, 12));
		top.setSpacing(10);
		curr.setPrefSize(160, 50);
		curr.setAlignment(Pos.CENTER);
		curr.setStyle("-fx-background-color: #A347BA;");
		String type1 = "";
		if (game.getCurrentChampion() instanceof Hero)
			type1 = "Type: Hero";
		if (game.getCurrentChampion() instanceof Villain)
			type1 = "Type: Villain";
		if (game.getCurrentChampion() instanceof AntiHero)
			type1 = "Type: AntiHero";

		curr.setText(game.getCurrentChampion().getName());
		Tooltip curr1 = new Tooltip(game.getCurrentChampion().getName() + ":" + "\r\n" + type1 + "\r\n" + "Current HP: "
				+ game.getCurrentChampion().getCurrentHP() + "\r\n" + "Mana: " + game.getCurrentChampion().getMana()
				+ "\r\n" + "Current Action Points: " + game.getCurrentChampion().getCurrentActionPoints() + "\r\n"
				+ "Max Action Points: " + game.getCurrentChampion().getMaxActionPointsPerTurn() + "\r\n"
				+ "Abilities: Hover over ability name on the left" + "\r\n" + app7 + "\r\n" + "Attack Damage: "
				+ game.getCurrentChampion().getAttackDamage() + "\r\n" + "Attack Range: "
				+ game.getCurrentChampion().getAttackRange());

		Tooltip.install(curr, curr1);
		movedown.setOnAction(this);
		moveup.setOnAction(this);
		moveleft.setOnAction(this);
		moveright.setOnAction(this);
		attackdown.setOnAction(this);
		attackup.setOnAction(this);
		attackleft.setOnAction(this);
		attackright.setOnAction(this);
		ab1.setPrefSize(120, 65);
		ab1.setOnAction(this);
		ab1.setTranslateY(45);
		ab1.setText(game.getCurrentChampion().getAbilities().get(0).getName());
		Tooltip ab11 = new Tooltip(game.getCurrentChampion().getAbilities().get(0).toString());
		Tooltip.install(ab1, ab11);

		ab2.setPrefSize(120, 65);
		ab2.setOnAction(this);
		ab2.setTranslateY(120);
		ab2.setText(game.getCurrentChampion().getAbilities().get(1).getName());
		Tooltip ab22 = new Tooltip(game.getCurrentChampion().getAbilities().get(1).toString());
		Tooltip.install(ab2, ab22);

		ab3.setPrefSize(120, 65);
		ab3.setOnAction(this);
		ab3.setTranslateY(195);
		ab3.setText(game.getCurrentChampion().getAbilities().get(2).getName());
		Tooltip ab33 = new Tooltip(game.getCurrentChampion().getAbilities().get(2).toString());
		Tooltip.install(ab3, ab33);

		top.getChildren().addAll(order);

		HBox bottom = new HBox();
		bottom.setAlignment(Pos.CENTER);
		bottom.setPadding(new Insets(15, 12, 15, 12));
		bottom.setSpacing(10);
		endturn.setPrefSize(120, 65);
		endturn.setOnAction(this);
		endturn.setTranslateY(120);
		leaderability.setPrefSize(120, 65);
		leaderability.setOnAction(this);
		leaderability.setTranslateY(45);

		bottom.getChildren().add(curr);

		int i;
		int j;
		Button x = null;
		GridPane grid = new GridPane();
		grid.setStyle("-fx-background-color: #7E8C99;");
		grid.setAlignment(Pos.CENTER);
		grid.setVgap(10);
		grid.setHgap(10);
		grid.gridLinesVisibleProperty();
		grid.setPadding(new Insets(0, 10, 0, 10));
		for (i = 0; i < 5; i++) {
			for (j = 0; j < 5; j++) {
				if (game.getBoard()[i][j] instanceof Champion) {
					if (((Champion) game.getBoard()[i][j]).equals(game.getCurrentChampion())) {
						x = new Button(((Champion) game.getBoard()[i][j]).getName() + "\r\n" + "HP: "
								+ ((Champion) game.getBoard()[i][j]).getCurrentHP());
						x.setStyle("-fx-background-color: #82FF2C;");
						x.setPrefSize(140, 110);
					} else {
						if (game.getFirstPlayer().getTeam().contains(((Champion) game.getBoard()[i][j]))) {
							x = new Button(((Champion) game.getBoard()[i][j]).getName() + "\r\n" + "HP: "
									+ ((Champion) game.getBoard()[i][j]).getCurrentHP());
							x.setStyle("-fx-background-color: #6C6AE0;");
							x.setPrefSize(140, 110);
						} else {
							x = new Button(((Champion) game.getBoard()[i][j]).getName() + "\r\n" + "HP: "
									+ ((Champion) game.getBoard()[i][j]).getCurrentHP());
							x.setStyle("-fx-background-color: #2CF5FF;");
							x.setPrefSize(140, 110);
						}
					}
				} else if (game.getBoard()[i][j] instanceof Cover) {
					x = new Button("Cover" + "\r\n " + ((Cover) game.getBoard()[i][j]).getCurrentHP());
					x.setStyle("-fx-background-color: #FFAF2C;");
					x.setPrefSize(140, 110);
				} else {
					x = new Button("(" + j + "," + i + ")");
					x.setStyle("-fx-background-color: #F9B7FE;");
					x.setPrefSize(140, 110);
				}
				grid.add(x, j, Math.abs(i - 4));
			}
		}
		
		border.setCenter(grid);
		border.setLeft(playerone);
		border.setRight(playertwo);
		border.setTop(top);
		border.setBottom(bottom);

		Scene scene = new Scene(border, height, width);

		return scene;
	}
}