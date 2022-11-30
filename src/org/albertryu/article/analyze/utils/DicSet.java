package org.albertryu.article.analyze.utils;

import java.util.HashSet;

public class DicSet {
	private HashSet<String> stringSet = new HashSet<String>();
	
	public DicSet(String text){
		stringSetting(text);
	}
	
	//
	public void stringSetting(String text){
		 String[] tmpArray = text.split("\\s*,\\s*");
		 for(String tmp :tmpArray){
			 stringSet.add(tmp);
		 }
	}
	
	public HashSet<String> getter(){
		return stringSet;
	}
}
