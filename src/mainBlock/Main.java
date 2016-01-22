package mainBlock;
import controler.Controler;
import view.View;
import model.Model;

public class Main {

	public static void main(String[] args) {

		View view = new View();
		Model model = new Model();
		Controler.Init(model, view);
	}
}
