package model;

import java.util.Random;

public class Bouble {
	final String WAIT = "WAIT";
	final String CLICK = "CLICK";
	final String SUCCESS = "SUCCESS";
	final String FAILURE = "FAILURE";
	final Integer LEFTEDGE = 0;
	final Integer RIGHTEDGE = 520;
	final Integer TOPEDGE = 0;
	final Integer BOTTOMEDGE = 940;
	final Integer BOUBLEDIA = 100;
	Integer reactionTime;
	Integer vectorX;
	Integer vectorY;
	Integer moment;
	Integer locationX;
	Integer locationY;
	String state; 
	String symbol;
	
	public Bouble(Integer moment, String symbol){
		this.reactionTime = 300;
		this.symbol=symbol;
		this.moment=moment;
		this.locationX=randInt(LEFTEDGE,RIGHTEDGE-BOUBLEDIA);
		this.locationY=randInt(TOPEDGE,BOTTOMEDGE-BOUBLEDIA);
		this.vectorX=randInt(-10,10);
		this.vectorY=randInt(-10,10);
		this.state = WAIT;
	}
	
	public Integer getLocationX(){
		return locationX;
	}
	
	public Integer getLocationY(){
		return locationY;
	}
	
	public String getState(){
		return state;
	}
	
	public String getSymbol(){
		return symbol;
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
	
	Boolean handleClick(String clickedSymbol){
		Boolean swc = symbolWasClicked(clickedSymbol);
		if(swc && state==WAIT){
			state=FAILURE;
		}else if(swc && state==CLICK){
			state=SUCCESS;
			return true;
		}
		return false;
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
		if(LEFTEDGE<=locationX+vectorX && locationX+vectorX<=RIGHTEDGE-BOUBLEDIA){
			locationX+=vectorX;
		}else{
			vectorX= -vectorX;
		}
		if(TOPEDGE<=locationY+vectorY && locationY+vectorY<=BOTTOMEDGE-BOUBLEDIA){
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
