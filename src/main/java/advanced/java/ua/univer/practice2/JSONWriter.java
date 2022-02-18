package advanced.java.ua.univer.practice2;

import advanced.java.ua.univer.practice2.Task2point1.ListImpl;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class JSONWriter implements Filename {
    public static void WriteToJSON(ListImpl list) throws IOException {
        FileWriter file = new FileWriter(filename);
        try{
            JSONObject sampleObject = new JSONObject();
            sampleObject.put("cities: ", list);
            file.write(sampleObject.toJSONString());
            System.out.println("\nJSON Object: " + sampleObject);
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            file.flush();
            file.close();
        }
    }
}
