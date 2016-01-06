package model;

public class Pet {
	Integer happiness;
	
	public Pet(){
		setHappiness(50);
	}
	
	void increaseHappiness(){
		this.happiness+=1;
	}
	
	void decreaseHappiness(){
		this.happiness-=1;
	}
	
	void setHappiness(Integer happiness){
		this.happiness = happiness;
	}
	
	Integer getHappiness(){
		return this.happiness;
	}

}
