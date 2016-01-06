package model;

import java.util.HashMap;

public class Music {
	String name;
	HashMap <Integer, String> track;
	Boolean played;
	
	public Music(String name, HashMap <Integer, String> track){
		this.name=name;
		this.track=track;
	}
	
	TupleMomentSymbol getNewBoubleData(Integer moment){
		return new TupleMomentSymbol(0,"");
	}

}
