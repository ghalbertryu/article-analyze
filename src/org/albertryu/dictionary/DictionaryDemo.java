package org.albertryu.dictionary;

import java.io.File;
import java.io.IOException;


import org.albertryu.dictionary.utils.Analyzer;
import org.albertryu.dictionary.utils.DicSet;

public class DictionaryDemo {

	public static void main(String[] args) throws IOException {
		String dicPath = "./resources/dic.txt";
		String dicText = Analyzer.readArticle(new File(dicPath));
		DicSet dicSet = new DicSet(dicText);
		
		String fileName = "article1";
		String readPath = "./resources/"+fileName+".txt";
		String writePath = "./out/"+fileName+"Result.csv";
		String text = Analyzer.readArticle(new File(readPath));
		Analyzer counter = new Analyzer();
		counter.stringAnalyzer(text, dicSet.getter());
		
		counter.writeArticleForm(new File(writePath));
		counter.describeString();
	}
}