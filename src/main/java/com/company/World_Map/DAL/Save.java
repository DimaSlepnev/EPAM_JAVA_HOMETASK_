package com.company.World_Map.DAL;

import com.company.World_Map.BLL.WorldMap;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Save implements FileName {
    public static void WriteMapToXML(WorldMap worldMap) {
        try (XMLEncoder xmlEncoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(FileName.filename+".xml")))) {
                xmlEncoder.writeObject(worldMap);
                xmlEncoder.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}