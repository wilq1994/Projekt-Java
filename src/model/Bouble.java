package model;

import java.util.Random;

public class Bouble {
	final Integer WAIT = 1;
	final Integer CLICK = 2;
	final Integer SUCCESS = 3;
	final Integer FAILURE = 4;
	final Integer LEFTEDGE = 20;
	final Integer RIGHTEDGE = 500;
	final Integer TOPEDGE = 20;
	final Integer BOTTOMEDGE = 920;
	final Integer BOUBLEDIA = 50;
	Integer reactionTime;
	Integer locationX;
	Integer locationY;
	Integer vectorX;
	Integer vectorY;
	Integer moment;
	Integer state; 
	String symbol;
	
	public Bouble(Integer moment, String symbol){
		this.reactionTime = 300;
		this.symbol=symbol;
		this.moment=moment;
		this.locationX=randInt(LEFTEDGE,RIGHTEDGE-BOUBLEDIA);
		this.locationY=randInt(TOPEDGE,BOTTOMEDGE-BOUBLEDIA);
		this.vectorX=randInt(0,5);
		this.vectorY=randInt(0,5);
		this.state = WAIT;
	}
	
	void refresh(Integer currentMoment){
		this.handleState(currentMoment);
		this.handlePosition();
	}
	
	void handleState(Integer currentMoment){
		if(state==WAIT && timeToClick(currentMoment)){
			state=CLICK;
		}else if(state==CLICK && timeIsUp(currentMoment)){
			state=FAILURE;
		}
	}
	
	void handleClick(String clickedSymbol){
		Boolean swc = symbolWasClicked(clickedSymbol);
		if(swc && state==WAIT){
			state=FAILURE;
		}else if(swc && state==CLICK){
			state=SUCCESS;
		}
	}
	
	Boolean isOld(Integer currentMoment){
		if(currentMoment>moment+3*reactionTime){
			return true;
		}else{
			return false;
		}
	}
	
	
	private Boolean symbolWasClicked(String clickedSymbol){
		if(clickedSymbol.equals(symbol)){
			return true;
		}else{
			return false;
		}
	}
	
	private Boolean timeToClick(Integer currentMoment){
		if(moment-reactionTime<=currentMoment && currentMoment<=moment+reactionTime){
			return true;
		}else{
			return false;
		}
	}
	
	private Boolean timeIsUp(Integer currentMoment){
		if(currentMoment>moment+reactionTime){
			return true;
		}else{
			return false;
		}
	}
	
	
	void handlePosition(){
		if(LEFTEDGE<=locationX+vectorX && locationX+vectorX<=RIGHTEDGE){
			locationX+=vectorX;
		}else{
			vectorX= -vectorX;
		}
		if(TOPEDGE<=locationY+vectorY && locationY+vectorY<=BOTTOMEDGE){
			locationY+=vectorY;
		}else{
			vectorY= -vectorY;
		}
	}
	
	private Integer randInt(Integer min, Integer max){
		Random rand = new Random();
		Integer num = rand.nextInt(max-min)+min;
		return num;
	}
}
