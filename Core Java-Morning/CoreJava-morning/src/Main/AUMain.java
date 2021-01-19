package Main;

import Session1.CoreJava;

public class AUMain {
	public static void main(String args[]){
        Session1();
    }
    public static void Session1(){
    	CoreJava a = new CoreJava();
        a.readXml();
        a.deSerialize();
        a.serialize();
        a.printTop5Ranks();
        a.writeToCSV();
        a.singletonExample();
    }
}
