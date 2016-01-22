package model;

import java.util.HashMap;
import java.util.Map.Entry;

public class Music {
	String name;
	HashMap <Integer, String> track;
	Boolean played;
	
	public Music(String name, HashMap <Integer, String> track){
		this.name=name;
		this.track=track;
	}
	
	TupleMomentSymbol popNewBoubleData(Integer currentMoment){
		TupleMomentSymbol boubleData = null;
		for(Entry<Integer, String> entry : track.entrySet()){
			Integer entryMoment = entry.getKey();
			String symbol = entry.getValue();
			if(isAbout(currentMoment, entryMoment)){
				boubleData = new TupleMomentSymbol(entryMoment, symbol);
				break;
			}
		}
		if(boubleData!=null){
			track.remove(boubleData.getMoment());
		}
		return boubleData;
	}
	
	public Boolean isAbout(Integer a, Integer b){
		if(Math.abs(a-b)<1000){
			return true;
		}else{
			return false;
		}
	}

}
