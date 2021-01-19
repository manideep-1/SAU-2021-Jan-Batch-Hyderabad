package Session1;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CoreJava {

    private String xmlFilePath = "C:\\Users\\Manideep\\Desktop\\Core Java-Morning\\CoreJava-morning\\src\\Session1\\StudentsData.xml";
    private String filename = "stuObject.txt";
    private String csvfilename = "top5.csv";
    private Students students;

    public void readXml(){
        System.out.println("Reading XML Data");
        File xmlFile = new File(xmlFilePath);
        JAXBContext jaxbContext;
        try{
            jaxbContext = JAXBContext.newInstance(Students.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            this.students = (Students) jaxbUnmarshaller.unmarshal(xmlFile);
            this.students.calculateRankAndTotal();
            this.students.printDetails();
        }
        catch(JAXBException e){
            e.printStackTrace();
        }
    }

    public void deSerialize(){
        System.out.println("De Serialization");
        try{
            FileOutputStream fileout = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileout);
            out.writeObject(this.students);
            out.close();
            fileout.close();
        }catch(Exception e){
            System.out.println("Error serialization Exception occured:"+e);
        }
    }

    public void serialize(){
        System.out.println("Serializing");
        try{
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            this.students = (Students) in.readObject();
            in.close();
            fileIn.close();
        }catch(Exception e){
            System.out.println("Error serialization Exception occured:"+e);
        }
    }

    public void printTop5Ranks(){
        System.out.println("Top 5 Rank Holders");
        this.students.printTop5();
    }

    public void writeToCSV(){
        try{
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(csvfilename));
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("Rank", "RollNo", "Total Marks out of 300"));
            this.students.writeTop5(csvPrinter);
            csvPrinter.flush();
            writer.flush();
        }catch(Exception e){
            System.out.println("Error Write to csv exception:"+e);
        }
    }

    public void singletonExample(){
    	SingletonClass inst = SingletonClass.getInstance();
        inst.exampleFuntion();
        inst.setSingletonVar(5);
        inst.exampleFuntion();
        SingletonClass inst2 = SingletonClass.getInstance();
        inst.exampleFuntion();
    }

}
