package model;

public class TupleMomentSymbol {
	public final String s;
	public final Integer m;
	
	public TupleMomentSymbol(Integer moment, String symbol){
		this.s=symbol;
		this.m=moment;
	}
	
	public String getSymbol(){
		return this.s;
	}
	
	public Integer getMoment(){
		return this.m;
	}
}
