package controler;

import model.Model;
import view.View;

public class Updater implements Runnable
{
	private boolean keepGoing;
	private Model model;
	private View view;
	private long startTime;
	private int updateTime, currentTime;
	

	Updater(Model model, View view)
	{
		this.model = model;
		this.view = view;
		keepGoing = true;
		startTime = System.currentTimeMillis();
	}

	@Override
	public void run()
	{
		while (keepGoing)
		{
			currentTime = (int) (startTime - System.currentTimeMillis());
			if (currentTime > updateTime + 100)
			{
				updateTime = currentTime;
				model.handleRoutines(currentTime);
				view.refresh(model.getEnemyPetHappiness());
			}
		}
	}

	int getCurrentTime()
	{
		return currentTime;
	}
}
