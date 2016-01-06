package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Model {
	ArrayList <Bouble> boubles;
	Integer level;
	Pet ownPet;
	Pet enemyPet;
	Music music;
	
	public Model(){
	
	}
	
	void addBouble(Integer moment, String symbol){
		this.boubles.add(new Bouble(moment, symbol));
	}
	
	void popBouble(Bouble bouble){
		this.boubles.remove(bouble);
	}
	
	void moveBoubles(){
		
	}
	
	void newGame(Integer level, String songName, HashMap <Integer, String> songData){
		this.boubles=new ArrayList <Bouble>();
		this.level=level;
		this.ownPet=new Pet();
		this.enemyPet=new Pet();
		this.music=new Music(songName, songData);
	}
	
	void quitGame(){
		this.boubles=null;
		this.level=null;
		this.ownPet=null;
		this.enemyPet=null;
		this.music=null;
	}

}
