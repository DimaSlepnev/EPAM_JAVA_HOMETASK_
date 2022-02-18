package advanced.java.ua.univer.practice2;


import advanced.java.ua.univer.practice2.Task2point1.ListImpl;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class XMLReader implements Filename {
    public static ListImpl Read(){
        ListImpl list = new ListImpl();
        try(XMLDecoder xmlDecoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(filename)))){
            list = (ListImpl) xmlDecoder.readObject();
        }catch (FileNotFoundException e ){
            e.printStackTrace();
        }
        return list;
    }
}
