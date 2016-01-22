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
			currentTime = (int) (System.currentTimeMillis() - startTime);
			if (currentTime > updateTime + 20)
			{
				updateTime = currentTime;
				model.handleRoutines(currentTime);
				view.refresh(model.getBoubleList(), model.getOwnPetHappiness(), model.getEnemyPetHappiness());
			}
		}
	}

	int getCurrentTime()
	{
		return currentTime;
	}
}
