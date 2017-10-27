package Main;

import Interfejsy.Interface_Snake_Fx_2;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Snake_Fx_2 extends Application implements Interface_Snake_Fx_2
{
	// Deklaracja Innych Interfejsow


	// *****************************

	public static void main(String[] args)
	{
		_Grid.set_Interface_SnakeBody(_SnakeBody);

		_SnakeBody.set_Interface_Grid(_Grid);
		_SnakeBody.set_Interface_Controll(_Controll);
		_SnakeBody.set_Interfejs_RandomPoint(_RandomPoint);
		_SnakeBody.set_Interfejs_Score(_Score);

		_Controll.set_Interface_Grid(_Grid);
		_Controll.set_Interface_SnakeBody(_SnakeBody);
		_Controll.set_Interfejs_Score(_Score);
		
		_RandomPoint.set_Interface_Grid(_Grid);
		_RandomPoint.set_Interface_SnakeBody(_SnakeBody);

		launch();
	}

	@Override
	public void start(Stage Snake_Fx_2_stage) throws Exception
	{
		// Dodajemy na glowny Pane dwa inne Siatke oraz Weza (kazdy osobny
		// obiekt) - unikniecie problemow z edytacja glownej siatki

		
		_Grid.Grid_Create_Base();
		_Grid.Grid_Base_Print();
		_SnakeBody.SnakeBody_init();
		_RandomPoint.RandomPoint_init();
		_Controll.KeyRead();

		Snake_Fx_2_Pane.getChildren().clear();
		Snake_Fx_2_Pane.getChildren().add(_Grid.getGrid_Pane());
		Snake_Fx_2_Pane.getChildren().add(_SnakeBody.getSnakeBody_Pane());
		Snake_Fx_2_Pane.getChildren().add(_RandomPoint.getRandomPoint_Pane());
		Snake_Fx_2_Pane.getChildren().add(_Score.getScore_Pane());		
		Snake_Fx_2_Pane.getChildren().add(_SnakeBody.get_snakeBody_Pane_Reset());
		
		Snake_Fx_2_stage.setTitle("Snake");
		Snake_Fx_2_stage.setResizable(false);
		Snake_Fx_2_stage.setScene(Snake_Fx_2_Scene);
		Snake_Fx_2_stage.show();

	}

	// **********************************
	// ******* Gettery i Settery ********
	// **********************************


}
