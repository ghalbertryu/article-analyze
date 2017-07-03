package dgx.albert.dictionary;

import java.io.File;
import java.io.IOException;


import dgx.albert.dicset.DicSet;

public class DictionaryDemo {

	public static void main(String[] args) throws IOException {
		String dicPath = "./res/dic.txt";
		String dicText = Analyzer.readArticle(new File(dicPath));
		DicSet dicSet = new DicSet(dicText);
		
		String fileName = "article1";
		String readPath = "./res/"+fileName+".txt";
		String writePath = "./result/"+fileName+"Result.csv";
		String text = Analyzer.readArticle(new File(readPath));
		Analyzer counter = new Analyzer();
		counter.stringAnalyzer(text, dicSet.getter());
		
		counter.writeArticleForm(new File(writePath));
		counter.describeString();
	}
}
