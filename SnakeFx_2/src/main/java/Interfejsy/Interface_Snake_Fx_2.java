package Interfejsy;

import Obiekty.Controll;
import Obiekty.Grid;
import Obiekty.RandomPoint;
import Obiekty.Score;
import Obiekty.SnakeBody;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public interface Interface_Snake_Fx_2
{
	
	Pane Snake_Fx_2_Pane = new Pane();
	Scene Snake_Fx_2_Scene = new Scene(Snake_Fx_2_Pane, 500, 500);
	
	
	Grid _Grid = new Grid();
	SnakeBody _SnakeBody = new SnakeBody();
	Controll _Controll = new Controll();
	RandomPoint _RandomPoint = new RandomPoint();
	Score _Score = new Score();
	
}
