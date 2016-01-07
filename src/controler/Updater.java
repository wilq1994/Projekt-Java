package controler;

import model.Model;
//import view.View;

public class Updater implements Runnable
{
	private boolean keepGoing;
	private Model model;
	//private View view;
	private long updateTime;
	Updater(Model model/*, View view*/)
	{
		keepGoing=true;
	}
	@Override
	public void run() {
		while(keepGoing)
		{
			if(System.currentTimeMillis()>updateTime+100)
			{
				updateTime=System.currentTimeMillis();
				//Model.moveBoubles();
				//Model.decreaseHappiness();
				//View.redraw(model.getOwnHappiness(), model.getEnemyHappiness());
			}
		}
	}
}
