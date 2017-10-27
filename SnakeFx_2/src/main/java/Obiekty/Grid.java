package Obiekty;

import Interfejsy.Interface_Grid;
import Interfejsy.Interface_SnakeBody;
import Interfejsy.Interface_Snake_Fx_2;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Grid implements Interface_Grid
{
	// Deklaracja Innych Interfejsow
	Interface_Snake_Fx_2 _Interface_Snake_Fx_2;
	Interface_SnakeBody _Interface_SnakeBody;
	// *****************************

	// Zmienne lokalne

	private int Grid_Scene_Height = 500;
	private int Grid_Scene_Width = 500;

	// Konstruktor

	public Grid()
	{
	}

	// ***********************************
	// ******* Funkcje Podstawowe ********
	// ***********************************

	public void Grid_Create_Base()
	{
		// Utworzenie siatki podstawowej, tworzenie kwadratow o rozmiarach
		// SizeRectangle, ustawienie ich w pozycji odpowiadajace jej wielkosci

		for (int i = 0; i < Grid_Scene_Height / Grid_SizeRectange; i++)
		{
			for (int j = 0; j < Grid_Scene_Width / Grid_SizeRectange; j++)
			{
				Rectangle _Grid_Rectangle_Temp = new Rectangle(j * Grid_SizeRectange, i * Grid_SizeRectange,
						Grid_SizeRectange, Grid_SizeRectange);

				_Grid_Rectangle_Temp.setFill(Color.WHITE);
				_Grid_Rectangle_Temp.setOpacity(0.1);
				_Grid_Rectangle_Temp.setStroke(Color.GRAY);
				_Grid_Rectangle_Temp.setStrokeWidth(1);

				Grid_Base_ArrayList.add(_Grid_Rectangle_Temp);
			}
		}

	}

	public void Grid_Base_Print()
	{
		// Ustawianie Pane i jego czyszczenie

		Grid_Pane.setStyle("-fx-background-color: WHITE;");
		Grid_Pane.getChildren().clear();

		// Skopiowanie kazdego elementu(kwadratu) do Pane(Layout), kazdy kwadrat
		// posiada swoja pozycje x:y

		for (int i = 0; i < Grid_Base_ArrayList.size(); i++)
		{
			Grid_Pane.getChildren().add(Grid_Base_ArrayList.get(i));
		}

	}

	public int Grid_Position_Calculate(int _x, int _y)
	{
		int _Grid_Temp_Rectangle_Vertial = Grid_Scene_Height / Grid_SizeRectange;
		int _Grid_Temp_Rectangle_Horizontal = Grid_Scene_Width / Grid_SizeRectange;

		if (_x >= _Grid_Temp_Rectangle_Horizontal - 1)
		{
			_x = _Grid_Temp_Rectangle_Horizontal - 1;
		}
		if (_y >= _Grid_Temp_Rectangle_Vertial - 1)
		{
			_y = _Grid_Temp_Rectangle_Vertial - 1;
		}

		return _x + (_y * _Grid_Temp_Rectangle_Vertial);
	}

	// **********************************
	// ******* Gettery i Settery ********
	// **********************************

	public Pane getGrid_Pane()
	{
		return Grid_Pane;
	}

	public void set_Interface_Snake_Fx_2(Interface_Snake_Fx_2 _Interface_Snake_Fx_2)
	{
		this._Interface_Snake_Fx_2 = _Interface_Snake_Fx_2;
	}

	public void set_Interface_SnakeBody(Interface_SnakeBody _Interface_SnakeBody)
	{
		this._Interface_SnakeBody = _Interface_SnakeBody;
	}

	public void setGrid_Scene_Width(int grid_Scene_Width)
	{
		Grid_Scene_Width = grid_Scene_Width;
	}

	public void setGrid_Scene_Height(int grid_Scene_Height)
	{
		Grid_Scene_Height = grid_Scene_Height;
	}
	public int getGrid_SizeRectange()
	{
		return Grid_SizeRectange;
	}

	public int getGrid_Scene_Height()
	{
		return Grid_Scene_Height;
	}

	public int getGrid_Scene_Width()
	{
		return Grid_Scene_Width;
	}

}
