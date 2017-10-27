package Interfejsy;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public interface Interfejs_RandomPoint
{
	Pane  RandomPoint_Pane   	            = new Pane();
	public int RandomPoint_RandomInt(int _min, int _max);
	public void RandomPoint_RandomNewXY();
	public void TimeStop();
	public void getNewPoint();
	public Rectangle getNewRectanglePoint();
	public void set_Interface_Grid(Interface_Grid _Interface_Grid);
	public void set_Interface_SnakeBody(Interface_SnakeBody _Interface_SnakeBody);
	public void setRandomPoint(Rectangle randomPoint);
	public Pane getRandomPoint_Pane();
}
