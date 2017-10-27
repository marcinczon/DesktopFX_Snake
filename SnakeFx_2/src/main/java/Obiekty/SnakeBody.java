package Obiekty;

import Interfejsy.Interface_Controll;
import Interfejsy.Interface_Grid;
import Interfejsy.Interface_SnakeBody;
import Interfejsy.Interface_Snake_Fx_2;
import Interfejsy.Interfejs_RandomPoint;
import Interfejsy.Interfejs_Score;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class SnakeBody implements Interface_SnakeBody
{
	// Deklaracja Innych Interfejsow

	Interface_Grid _Interface_Grid;
	Interface_Controll _Interface_Controll;
	Interfejs_RandomPoint _Interfejs_RandomPoint;
	Interfejs_Score _Interfejs_Score;
	Interface_Snake_Fx_2 _Interface_Snake_Fx_2;

	// *****************************

	// Deklaracja Zmiennych Lokalnych

	private Rectangle SnakeBody_Head = new Rectangle();
	private Rectangle SnakeBody_Head_Old = new Rectangle();
	private Rectangle SnakeBody_Point = new Rectangle();
	
	private Label SnakeBody_Label_Stop = new Label("RESTART ? \n\n PRESS R");
		
	boolean SnakeBody_Stop_Flag = false;
	

	// Konstruktor

	public SnakeBody()
	{

	}

	public void SnakeBody_init()
	{
		// Inicjalizacja pozycji poczatku weza do puntu ktory jest ustalony w
		// Controll
		int _SnakeBody_Temp_Position_Grid_Number = _Interface_Grid.Grid_Position_Calculate(
				_Interface_Controll.getGlobalPointX(),
				_Interface_Controll.getGlobalPointX() / Interface_Grid.Grid_SizeRectange);
		SnakeBody_Head.setX(Interface_Grid.Grid_Base_ArrayList.get(_SnakeBody_Temp_Position_Grid_Number).getX());
		SnakeBody_Head.setY(Interface_Grid.Grid_Base_ArrayList.get(_SnakeBody_Temp_Position_Grid_Number).getY());
		SnakeBody_Head.setHeight(_Interface_Grid.getGrid_SizeRectange());
		SnakeBody_Head.setWidth(_Interface_Grid.getGrid_SizeRectange());
		SnakeBody_Head.setFill(Color.BLACK);
		SnakeBody_Head.setStroke(Color.BLACK);
		SnakeBody_Head.setOpacity(1);
		
		// Dodanie pierwszego elementu(glowy) do SnakeBody
		
		SnakeBody_ArrayList.clear();
		SnakeBody_ArrayList.add(SnakeBody_Head);
		
		// Ustawianie  ekranu RESET
		
		SnakeBody_Label_Stop.setLayoutX(_Interface_Grid.getGrid_Scene_Width()/2);
		SnakeBody_Label_Stop.setLayoutY(_Interface_Grid.getGrid_Scene_Height()/2);				
		SnakeBody_Pane_Reset.setPrefSize(_Interface_Grid.getGrid_Scene_Width(), _Interface_Grid.getGrid_Scene_Height());
		SnakeBody_Pane_Reset.setLayoutX(0);
		SnakeBody_Pane_Reset.setLayoutY(0);
		SnakeBody_Pane_Reset.getChildren().clear();
		SnakeBody_Pane_Reset.getChildren().add(SnakeBody_Label_Stop);
		SnakeBody_Pane_Reset.setVisible(false);
		
	//	SnakeBody_Label_Stop.set

		SnakeBody_Print();

	}

	// ***********************************
	// ******* Funkcje Podstawowe ********
	// ***********************************

	public void SnakeBody_Head_Position(int _x, int _y)
	{
		// Odczyt starej wartosci potrzebny do edycji weza
		SnakeBody_Head_Old.setX(SnakeBody_Head.getX());
		SnakeBody_Head_Old.setY(SnakeBody_Head.getY());
		SnakeBody_Head_Old.setHeight(SnakeBody_Head.getHeight());
		SnakeBody_Head_Old.setWidth(SnakeBody_Head.getWidth());
		SnakeBody_Head_Old.setFill(Color.RED);
		SnakeBody_Head_Old.setStroke(Color.CRIMSON);

		// Odczytujemy jaki numer na siatce podstawowej ma ta pozycja
		// Odczytujemy odpowiedni kwadrat z podstawowej siatki
		int _SnakeBody_Temp_Position_Grid_Number = _Interface_Grid.Grid_Position_Calculate(_x, _y);

		// Musi byc odczytywanie samej pozycji, winnym przypadku kopiowany jest
		// pointer z array listy i podmieniany, Tak jak w tablicach !
		SnakeBody_Head.setX(Interface_Grid.Grid_Base_ArrayList.get(_SnakeBody_Temp_Position_Grid_Number).getX());
		SnakeBody_Head.setY(Interface_Grid.Grid_Base_ArrayList.get(_SnakeBody_Temp_Position_Grid_Number).getY());
		SnakeBody_Head.setHeight(_Interface_Grid.getGrid_SizeRectange());
		SnakeBody_Head.setWidth(_Interface_Grid.getGrid_SizeRectange());

		SnakeBody_Head.setFill(Color.BLACK);
		SnakeBody_Head.setStroke(Color.BLACK);
		SnakeBody_Head.setOpacity(1);

		SnakeBody_Check();
		SnakeBody_Print();
	}
	
	public void SnakeBody_Reset()
	{
		SnakeBody_Stop_Flag=true;	
		SnakeBody_Pane_Reset.setVisible(true);
		SnakeBody_Pane_Reset.requestLayout();
		Interface_Snake_Fx_2.Snake_Fx_2_Pane.getChildren().set(Interface_Snake_Fx_2.Snake_Fx_2_Pane.getChildren().size()-1, SnakeBody_Pane_Reset);
		
		
	}

	public void SnakeBody_Check()
	{

		// Wyczytanie danych z SnakeBody_Head, Nie przekazywac pointera do
		// drugiego obiektu, bo wtedy on bedzie wplywa³ na ten obiekt!
		Rectangle _SnakeBody_Temp = new Rectangle();
		_SnakeBody_Temp.setX(SnakeBody_Head.getX());
		_SnakeBody_Temp.setY(SnakeBody_Head.getY());
		_SnakeBody_Temp.setHeight(SnakeBody_Head.getHeight());
		_SnakeBody_Temp.setWidth(SnakeBody_Head.getWidth());

		if (SnakeBody_Head.getX() == SnakeBody_Point.getX() && SnakeBody_Head.getY() == SnakeBody_Point.getY())
		{
			SnakeBody_ArrayList.add(_SnakeBody_Temp);
			_Interfejs_RandomPoint.getNewPoint();
			_Interfejs_Score.Score_Show(SnakeBody_ArrayList.size());
			
		
			//System.out.println(SnakeBody_ArrayList.size());

		} else
		{
			SnakeBody_ArrayList.remove(0);
			SnakeBody_ArrayList.add(_SnakeBody_Temp);
		}
		
		// Sprawdzanie czy glowa weza nie nachodzi na reszte ciala
		for (int i = 0; i < SnakeBody_ArrayList.size() - 1; i++)
		{
			if ((SnakeBody_Head.getX() == SnakeBody_ArrayList.get(i).getX()) && (SnakeBody_Head.getY() == SnakeBody_ArrayList.get(i).getY()))
			{
				System.out.println("Kolizja");
						
				SnakeBody_Reset();
				
				
				_Interface_Controll.TimeStop();		
				_Interfejs_RandomPoint.TimeStop();
			}
		}
	}

	public void SnakeBody_Print()
	{
		SnakeBody_Pane.getChildren().clear();
		for (int i = 0; i < SnakeBody_ArrayList.size(); i++)
		{
			SnakeBody_Pane.getChildren().add(SnakeBody_ArrayList.get(i));
		}
	
	}

	// **********************************
	// ******* Gettery i Settery ********
	// **********************************

	public void set_Interface_Grid(Interface_Grid _Interface_Grid)
	{
		this._Interface_Grid = _Interface_Grid;
	}

	public Rectangle getSnakeBody_Head()
	{
		return SnakeBody_Head;
	}

	public void setSnakeBody_Head(Rectangle snakeBody_Head)
	{
		SnakeBody_Head = snakeBody_Head;
	}

	public Pane getSnakeBody_Pane()
	{
		return SnakeBody_Pane;
	}

	public void set_Interface_Controll(Interface_Controll _Interface_Controll)
	{
		this._Interface_Controll = _Interface_Controll;
	}

	public void setSnakeBody_Point(Rectangle snakeBody_Point)
	{
		SnakeBody_Point = snakeBody_Point;
	}

	public void set_Interfejs_RandomPoint(Interfejs_RandomPoint _Interfejs_RandomPoint)
	{
		this._Interfejs_RandomPoint = _Interfejs_RandomPoint;
	}

	public void set_Interfejs_Score(Interfejs_Score _Interfejs_Score)
	{
		this._Interfejs_Score = _Interfejs_Score;
	}

	public boolean is_SnakeBody_Stop()
	{
		return SnakeBody_Stop_Flag;
	}

	public void set_SnakeBody_Stop(boolean _SnakeBody_Stop)
	{
		this.SnakeBody_Stop_Flag = _SnakeBody_Stop;
	}
	public Pane get_snakeBody_Pane_Reset()
	{
		return SnakeBody_Pane_Reset;
	}

}
