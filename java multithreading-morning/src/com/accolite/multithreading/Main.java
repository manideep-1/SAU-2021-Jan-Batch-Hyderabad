package com.accolite.multithreading;



public class Main {
	public static void main(String[] args) throws Exception {
	    WordCount w=new WordCount();
	    w.wcmethod();
	    new SentencesCount().scount();
	    new ParagraphCount().pcount();
		WordThread wt=new WordThread();
		wt.start();
		SentenceThread st=new SentenceThread();
		st.start();
		ParagraphThread pt=new ParagraphThread();
		pt.start();
	}
}
