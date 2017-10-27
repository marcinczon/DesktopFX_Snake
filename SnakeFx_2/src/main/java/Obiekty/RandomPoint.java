package Obiekty;

import java.util.Random;

import Interfejsy.Interface_Grid;
import Interfejsy.Interface_SnakeBody;
import Interfejsy.Interfejs_RandomPoint;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class RandomPoint implements Interfejs_RandomPoint
{
	// Deklaracja Innych Interfejsow
	Interface_Grid _Interface_Grid;
	Interface_SnakeBody _Interface_SnakeBody;

	// *****************************
	Rectangle RandomPoint = new Rectangle();
	static Random _generator = new Random();
	Timeline TimeLine = new Timeline();
	
	private int _x = 0, _y = 0;	
	

	public RandomPoint()
	{

	}

	// ***********************************
	// ******* Funkcje Podstawowe ********
	// ***********************************
	public void RandomPoint_init()
	{
		getNewPoint();
		TimeStart();
	}

	public void TimeStart()
	{
		TimeLine = new Timeline(new KeyFrame(Duration.millis(10000), ae -> getNewPoint()));
		TimeLine.setCycleCount(Animation.INDEFINITE);
		TimeLine.play();
	}
	public void TimeStop()
	{
		TimeLine.stop();
	}

	public int RandomPoint_RandomInt(int _min, int _max)
	{
		int _random = _generator.nextInt((_max - _min) + 1) + _min;
		return _random;
	}

	public void RandomPoint_RandomNewXY()
	{
		_x = RandomPoint_RandomInt(0, 25);
		_y = RandomPoint_RandomInt(0, 25);
	}

	public void getNewPoint()
	{
		RandomPoint_RandomNewXY();

		int _NumberNew = _Interface_Grid.Grid_Position_Calculate(_x, _y);

		// Nowy Wylosowany Punkt
		RandomPoint.setX((int) Interface_Grid.Grid_Base_ArrayList.get(_NumberNew).getX());
		RandomPoint.setY((int) Interface_Grid.Grid_Base_ArrayList.get(_NumberNew).getY());
		RandomPoint.setHeight((int) Interface_Grid.Grid_Base_ArrayList.get(_NumberNew).getHeight());
		RandomPoint.setWidth((int) Interface_Grid.Grid_Base_ArrayList.get(_NumberNew).getWidth());
		RandomPoint.setStroke(Color.RED);
		RandomPoint.setFill(Color.RED);

		_Interface_SnakeBody.setSnakeBody_Point(RandomPoint);

		RandomPoint_Pane.getChildren().clear();
		RandomPoint_Pane.getChildren().add(RandomPoint);

	}

	public Rectangle getNewRectanglePoint()
	{
		RandomPoint_RandomNewXY();
		int _NumberNew = _Interface_Grid.Grid_Position_Calculate(_x, _y);
		// Nowy Wylosowany Punkt
		Rectangle _tempRectangleNew = new Rectangle();
		_tempRectangleNew.setX((int) Interface_Grid.Grid_Base_ArrayList.get(_NumberNew).getX());
		_tempRectangleNew.setY((int) Interface_Grid.Grid_Base_ArrayList.get(_NumberNew).getY());
		_tempRectangleNew.setHeight((int) Interface_Grid.Grid_Base_ArrayList.get(_NumberNew).getHeight());
		_tempRectangleNew.setWidth((int) Interface_Grid.Grid_Base_ArrayList.get(_NumberNew).getWidth());
		_tempRectangleNew.setStroke(Color.YELLOW);
		_tempRectangleNew.setFill(Color.YELLOW);
		return _tempRectangleNew;
	}

	// **********************************
	// ******* Gettery i Settery ********
	// **********************************

	public void set_Interface_Grid(Interface_Grid _Interface_Grid)
	{
		this._Interface_Grid = _Interface_Grid;
	}

	public void set_Interface_SnakeBody(Interface_SnakeBody _Interface_SnakeBody)
	{
		this._Interface_SnakeBody = _Interface_SnakeBody;
	}

	public void setRandomPoint(Rectangle randomPoint)
	{
		RandomPoint = randomPoint;
	}

	public Pane getRandomPoint_Pane()
	{
		return RandomPoint_Pane;
	}
}
