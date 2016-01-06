package model;

import java.util.Random;

public class Bouble {
	final Integer WAIT = 1;
	final Integer CLICK = 2;
	final Integer SUCCESS = 3;
	final Integer FAILURE = 4;
	Integer locationX;
	Integer locationY;
	Integer vectorX;
	Integer vectorY;
	Integer moment;
	Integer state;//4 stany, 1-czekaj, 2-kliknij 3-dobrze, 4-Ÿle 
	String symbol;
	
	public Bouble(String symbol, Integer moment){
		this.symbol=symbol;
		this.moment=moment;
		this.locationX=randInt(20,450);
		this.locationY=randInt(20,890);
		this.vectorX=0;
		this.vectorY=0;
		this.state = WAIT;
	}
	
	void move(){
		
	}
	
	private Integer randInt(Integer min, Integer max){
		Random rand = new Random();
		Integer num = rand.nextInt(max-min)+min;
		return num;
	}
}
