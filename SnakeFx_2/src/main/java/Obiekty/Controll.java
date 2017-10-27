package Obiekty;

import Interfejsy.Interface_Controll;
import Interfejsy.Interface_Grid;
import Interfejsy.Interface_SnakeBody;
import Interfejsy.Interface_Snake_Fx_2;
import Interfejsy.Interfejs_Score;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

public class Controll implements Interface_Controll
{
	// Deklaracja Innych Interfejsow
	Interface_Snake_Fx_2 _Interface_Snake_Fx_2;
	Interface_Grid _Interface_Grid;
	Interface_SnakeBody _Interface_SnakeBody;
	Interfejs_Score _Interfejs_Score;
	// *****************************

	// Deklaracja Zmiennych Lokalnych

	Timeline TimeLineControll = new Timeline();

	// Przerobic tak funkcje zeby mozna bylo wyczyrac inizializacje punktu
	// zsynchronizowana do ruchu
	boolean goUP = false, goDOWN = false, goLEFT = false, goRIGHT = false;
	boolean goUPLast = false, goDOWNLast = false, goLEFTLast = false, goRIGHTLast = false;
	private int _PointXInit = 12;
	private int _PointYInit = 50;
	private int _PointX = _PointXInit;
	private int _PointY = _PointYInit;
	private boolean _TypeControll = false;
	static boolean _pause = false;

	// Konstruktor

	public Controll()
	{
		TimeStart_Init();
	}

	// ***********************************
	// ******* Funkcje Podstawowe ********
	// ***********************************

	public void TimeStart_Init()
	{
		if (!_TypeControll)
		{
			TimeLineControll = new Timeline(new KeyFrame(Duration.millis(100), ae -> ModeControllContinous()));
			TimeLineControll.setCycleCount(Animation.INDEFINITE);
			TimeLineControll.play();
		}
	}

	public void TimeStart()
	{
		TimeLineControll.play();
	}

	public void TimeStop()
	{
		TimeLineControll.stop();
	}

	public void ModeControllManual()
	{

	}

	public void ModeControllContinous()
	{
		if (goUP)
		{
			_PointY = _PointY - Interface_Grid.Grid_SizeRectange;
			if (_PointY < 0)
			{
				_PointY = (int) Interface_Snake_Fx_2.Snake_Fx_2_Pane.getHeight() - Interface_Grid.Grid_SizeRectange;
			}
		}
		if (goDOWN)
		{
			_PointY = _PointY + Interface_Grid.Grid_SizeRectange;
			if (_PointY > Interface_Snake_Fx_2.Snake_Fx_2_Pane.getHeight() - Interface_Grid.Grid_SizeRectange)
			{
				_PointY = 0;
			}
		}
		if (goLEFT)
		{
			_PointX--;
			if (_PointX < 0)
			{
				_PointX = (int) (Interface_Snake_Fx_2.Snake_Fx_2_Pane.getWidth() / Interface_Grid.Grid_SizeRectange)
						- 1;
			}
		}
		if (goRIGHT)
		{
			_PointX++;
			if (_PointX > (Interface_Snake_Fx_2.Snake_Fx_2_Pane.getWidth() / Interface_Grid.Grid_SizeRectange) - 1)
			{
				_PointX = 0;
			}
		}

		_Interface_SnakeBody.SnakeBody_Head_Position(_PointX, _PointY / Interface_Grid.Grid_SizeRectange);
	}

	public void KeyRead()
	{

		Interface_Snake_Fx_2.Snake_Fx_2_Scene.setOnKeyPressed(new EventHandler<KeyEvent>()
		{

			@SuppressWarnings("incomplete-switch")
			public void handle(KeyEvent event)
			{
				switch (event.getCode())
				{
				case UP:
					if (_TypeControll)
					{
						_PointY = _PointY - Interface_Grid.Grid_SizeRectange;
						if (_PointY < 0)
						{
							_PointY = (int) (Interface_Snake_Fx_2.Snake_Fx_2_Pane.getHeight())
									- Interface_Grid.Grid_SizeRectange;
							System.out.println("Granica UP");
						}
					} else
					{
						goUP = true;
						goDOWN = false;
						goLEFT = false;
						goRIGHT = false;
					}
					break;
				case DOWN:
					if (_TypeControll)
					{
						_PointY = _PointY + Interface_Grid.Grid_SizeRectange;
						if (_PointY > Interface_Snake_Fx_2.Snake_Fx_2_Pane.getHeight()
								- Interface_Grid.Grid_SizeRectange)
						{
							_PointY = 0;
							System.out.println("Granica DOWN");
						}

					} else
					{
						goUP = false;
						goDOWN = true;
						goLEFT = false;
						goRIGHT = false;
					}
					break;
				case LEFT:
					if (_TypeControll)
					{
						_PointX--;
						if (_PointX < 0)
						{
							_PointX = (int) (Interface_Snake_Fx_2.Snake_Fx_2_Pane.getWidth()
									/ Interface_Grid.Grid_SizeRectange) - 1;

						}
					} else
					{
						goUP = false;
						goDOWN = false;
						goLEFT = true;
						goRIGHT = false;
					}
					break;
				case RIGHT:
					if (_TypeControll)
					{
						_PointX++;
						if (_PointX > (Interface_Snake_Fx_2.Snake_Fx_2_Pane.getWidth()
								/ Interface_Grid.Grid_SizeRectange) - 1)
						{
							_PointX = 0;
						}
					} else
					{
						goUP = false;
						goDOWN = false;
						goLEFT = false;
						goRIGHT = true;
					}
					break;
				case R:
					if (_Interface_SnakeBody.is_SnakeBody_Stop())
					{
						_Interfejs_Score.Score_Show(1);
						_PointX = _PointXInit;
						_PointY = _PointYInit;
						goUP = false;
						goDOWN = false;
						goLEFT = false;
						goRIGHT = false;
						_Interface_SnakeBody.set_SnakeBody_Stop(false);
						_Interface_SnakeBody.SnakeBody_init();
						TimeStart();
					}
					break;
				case P:
					_pause = !_pause;

					if (_pause)
					{
						goUPLast = goUP;
						goDOWNLast = goDOWN;
						goLEFTLast = goLEFT;
						goRIGHTLast = goRIGHT;
						// System.out.print(" "+goUPLast + " "+ goDOWNLast + "
						// "+ goLEFTLast + " "+ goRIGHTLast);
						goUP = false;
						goDOWN = false;
						goLEFT = false;
						goRIGHT = false;
						TimeStop();
					}
					if (!_pause)
					{
						goUP = goUPLast;
						goDOWN = goDOWNLast;
						goLEFT = goLEFTLast;
						goRIGHT = goRIGHTLast;
						TimeStart();
					}

					break;

				}
				if (_TypeControll)
				{
					_Interface_SnakeBody.SnakeBody_Head_Position(_PointX, _PointY / Interface_Grid.Grid_SizeRectange);
					System.out.format("%d %d\n", _PointX, _PointY / Interface_Grid.Grid_SizeRectange);
				}

			}
		});

	}

	// **********************************
	// ******* Gettery i Settery ********
	// **********************************

	public void set_Interface_Snake_Fx_2(Interface_Snake_Fx_2 _Interface_Snake_Fx_2)
	{
		this._Interface_Snake_Fx_2 = _Interface_Snake_Fx_2;
	}

	public void set_Interface_Grid(Interface_Grid _Interface_Grid)
	{
		this._Interface_Grid = _Interface_Grid;
	}

	public void set_Interface_SnakeBody(Interface_SnakeBody _Interface_SnakeBody)
	{
		this._Interface_SnakeBody = _Interface_SnakeBody;
	}

	public int getGlobalPointX()
	{
		return _PointX;
	}

	public void setGlobalPointX(int globalPointX)
	{
		this._PointX = globalPointX;
	}

	public int getGlobalPointY()
	{
		return _PointY;
	}

	public void setGlobalPointY(int globalPointY)
	{
		this._PointY = globalPointY;
	}

	public void set_Interfejs_Score(Interfejs_Score _Interfejs_Score)
	{
		this._Interfejs_Score = _Interfejs_Score;
	}

}
