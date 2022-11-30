package org.albertryu.article.analyze.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Analyzer {
	private Hashtable<String, Integer> stringAnalyzerTable = new Hashtable<String, Integer>();
	
	//
	public void charAnalyzer(String article){
		for(int i=0; i<article.length(); i++){
			char key = article.charAt(i);
			String tmpKey = ""+key;
			stringAnalyzerTable.put(tmpKey, (stringAnalyzerTable.get(tmpKey)==null)? 1: stringAnalyzerTable.get(tmpKey)+1);
		}
	}
	
	public void stringAnalyzer(String article, HashSet<String> stringSet){
		
		int minStringLength = 2;
		int maxStringLength = 15;
		for(int n = minStringLength; n<=maxStringLength; n++){
			for(int i=0; i<article.length()-n; i++){
				String key = article.substring(i, i+n); 
				//解析方法
				if(stringSet.contains(key)){
					stringAnalyzerTable.put(key, (stringAnalyzerTable.get(key)==null)? 1: stringAnalyzerTable.get(key)+1);
				}
			}
		}
		// Delete value < 2
		Set<String> keys = stringAnalyzerTable.keySet();
		Object[] keyArray = keys.toArray();
		for(Object key : keyArray){
			if(stringAnalyzerTable.get(key)<2){
				stringAnalyzerTable.remove(key);
			}
		}
	}
	
	
	public static String readArticle(File file) throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader(file));
		StringBuffer text = new StringBuffer();
		String tmp = "";
		while((tmp = reader.readLine()) != null){
			text = text.append(tmp);
		}
		reader.close();
		return text.toString();
	}
	
	public void describeString(){
		for(String key: stringAnalyzerTable.keySet()){
			System.out.println("(單詞, 次數) = ("+key+","+stringAnalyzerTable.get(key)+")");
		}
	}
	
	public void describeChar(){
		for(String key: stringAnalyzerTable.keySet()){
			System.out.println("(單字, 次數) = ("+key+","+stringAnalyzerTable.get(key)+")");
		}
	}

	public void writeArticle(File file) throws IOException{
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		for(String key: stringAnalyzerTable.keySet()){
			writer.write("(單字, 次數) = ("+key+","+stringAnalyzerTable.get(key)+")");
			writer.write("\r\n");
		}
		writer.close();
	}
	
	public void writeArticleForm(File file) throws IOException{
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		writer.write(addQuote("單詞")+","+addQuote("次數"));
		writer.write("\r\n");
		for(String key: stringAnalyzerTable.keySet()){
			writer.write(addQuote(key.toString())+","+addQuote(stringAnalyzerTable.get(key).toString()));
			writer.write("\r\n");
		}
		writer.close();
	}
	
	public String addQuote(String s){
		return "\""+s+"\"";
	}
}
