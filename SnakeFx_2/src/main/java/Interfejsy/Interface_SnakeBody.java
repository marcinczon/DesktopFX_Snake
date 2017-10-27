package Interfejsy;

import java.util.ArrayList;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public interface Interface_SnakeBody
{
	ArrayList<Rectangle> SnakeBody_ArrayList = new ArrayList<Rectangle>();
	Pane  SnakeBody_Pane   	            = new Pane();
	Pane  SnakeBody_Pane_Reset          = new Pane();
	

	public void SnakeBody_Head_Position(int _x, int _y);
	
	public void set_Interface_Grid(Interface_Grid _Interface_Grid);
	public Rectangle getSnakeBody_Head();
	public void setSnakeBody_Head(Rectangle snakeBody_Head);
	public void setSnakeBody_Point(Rectangle snakeBody_Point);
	public Pane getSnakeBody_Pane();
	public void SnakeBody_Check();
	public void set_Interfejs_Score(Interfejs_Score _Interfejs_Score);
	public void SnakeBody_init();
	public boolean is_SnakeBody_Stop();
	public void set_SnakeBody_Stop(boolean _SnakeBody_Stop);
	public Pane get_snakeBody_Pane_Reset();
	
}
