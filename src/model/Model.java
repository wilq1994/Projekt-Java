package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Model {
	ArrayList<Bouble> boubles;
	Integer level;
	Pet ownPet;
	Pet enemyPet;
	Music music;
	
	public Model(){
		
	}
	
	public ArrayList<Bouble> getBoubleList(){
		return new ArrayList<Bouble>(this.boubles);
	}
	
	public void setOwnPetHappiness(Integer happiness){
		ownPet.setHappiness(happiness);
	}
	
	public Integer getOwnPetHappiness(){
		return ownPet.getHappiness();
	}
	
	public void setEnemyPetHappiness(Integer happiness){
		if(enemyPet!=null){
			enemyPet.setHappiness(happiness);
		}
	}
	
	public void decreaseOwnPetHappiness(){
		ownPet.decreaseHappiness();
	}
	
	public void increaseOwnPetHappiness(){
		ownPet.increaseHappiness();
	}
	
	public Integer getEnemyPetHappiness(){
		if(enemyPet!=null){
			return enemyPet.getHappiness();
		}else{
			return null;
		}
	}
	
	public void handleRoutines(Integer currentMoment){
		decreaseOwnPetHappiness();
		scrapOldBoubles(currentMoment);
		checkForNewBoubles(currentMoment);
		moveBoubles(currentMoment);
	}
	
	public void handleClick(String symbol){
		for(Bouble b: boubles){
			if(b.handleClick(symbol)){
				increaseOwnPetHappiness();
			}
		}
	}
	
	public void moveBoubles(Integer currentMoment){
		for(Bouble b: boubles){
			b.refresh(currentMoment);
		}
	}
	
	public void scrapOldBoubles(Integer currentMoment){
		ArrayList<Bouble> toScrap = new ArrayList<Bouble>();
		for(Bouble b: boubles){
			if(b.isOld(currentMoment)){
				toScrap.add(b);
			}
		}
		for(Bouble b: toScrap){
			boubles.remove(b);
		}
	}
	
	public void checkForNewBoubles(Integer currentMoment){
		TupleMomentSymbol momentSymbol = music.popNewBoubleData(currentMoment);
		if(momentSymbol!=null){
			addBouble(momentSymbol.getMoment(), momentSymbol.getSymbol());
		}
	}
	
	public void addBouble(Integer moment, String symbol){
		this.boubles.add(new Bouble(moment, symbol));
	}
	
	public void popBouble(Bouble bouble){
		this.boubles.remove(bouble);
	}
	
	public void newGame(Integer level, String songName, HashMap <Integer, String> songData, Boolean enemy){
		this.boubles=new ArrayList <Bouble>();
		this.level=level;
		this.music=new Music(songName, songData);
		this.ownPet=new Pet();
		if(enemy){
			this.enemyPet=new Pet();
		}else{
			this.enemyPet=null;
		}
	}
	
	public void quitGame(){
		this.boubles=null;
		this.level=null;
		this.ownPet=null;
		this.enemyPet=null;
		this.music=null;
	}
	
	public HashMap <Integer, String> generateTrack(){
		HashMap<Integer, String> track = new HashMap <Integer, String>();
		track.put(2000, "w");
		track.put(3000, "d");
		track.put(4500, "s");
		track.put(5500, "a");
		track.put(7000, "d");
		track.put(8000, "a");
		track.put(9500, "s");
		track.put(10500, "w");
		track.put(12000, "d");
		track.put(13500, "s");
		track.put(14500, "w");
		track.put(16000, "a");
		track.put(17500, "d");
		track.put(18500, "w");
		track.put(20000, "s");
		track.put(21500, "a");
		track.put(23000, "s");
		track.put(24500, "w");
		track.put(26000, "d");
		track.put(27000, "a");
		track.put(27500, "d");
		track.put(30000, "d");
		track.put(31000, "w");
		track.put(32000, "s");
		track.put(34000, "a");
		track.put(35500, "d");
		track.put(37000, "w");
		track.put(38000, "s");
		track.put(40000, "a");
		return track;
	}

}
