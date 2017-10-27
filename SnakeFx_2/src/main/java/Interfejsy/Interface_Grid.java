package Interfejsy;

import java.util.ArrayList;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public interface Interface_Grid
{
	Pane Grid_Pane = new Pane();

	ArrayList<Rectangle> Grid_Base_ArrayList = new ArrayList<Rectangle>();

	int Grid_SizeRectange = 20;

	public void Grid_Create_Base();

	public void Grid_Base_Print();

	public int Grid_Position_Calculate(int _x, int _y);

	public Pane getGrid_Pane();

	public int getGrid_SizeRectange();
	public int getGrid_Scene_Height();
	public int getGrid_Scene_Width();
}
