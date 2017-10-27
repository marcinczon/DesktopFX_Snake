package Obiekty;



import Interfejsy.Interfejs_Score;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;



public class Score implements Interfejs_Score
{
	Label Score_Label_1 = new Label();


	Pane Score_Pane = new Pane();
	

	@SuppressWarnings("restriction")
	public Score()
	{		
		Score_Label_1.setText("1");
		Score_Label_1.setLayoutX(0.0);
		Score_Label_1.setLayoutY(0.0);
		Score_Label_1.setPrefSize(100, 10);
		Score_Label_1.setVisible(true);
		Score_Label_1.opacityProperty();
		Score_Pane.getChildren().clear();
		Score_Pane.getChildren().add(Score_Label_1);


	}

	@Override
	public void Score_Show(int Score)
	{
		String _StringScore = null;
		_StringScore = String.format(" %d ", Score);
		Score_Label_1.setText(_StringScore);
	}
	public Pane getScore_Pane()
	{
		return Score_Pane;
	}
	public Label getScore_Label_1()
	{
		return Score_Label_1;
	}

	public void setScore_Label_1(Label score_Label_1)
	{
		Score_Label_1 = score_Label_1;
	}
}
