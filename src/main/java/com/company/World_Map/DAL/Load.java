package com.company.World_Map.DAL;

import com.company.World_Map.BLL.WorldMap;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Load implements FileName{
    public static WorldMap ReadMapFromXML(){
        WorldMap worldMap = new WorldMap();
        try(XMLDecoder xmlDecoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(FileName.filename + ".xml")))){
            worldMap = (WorldMap) xmlDecoder.readObject();
        }catch (FileNotFoundException e ){
            e.printStackTrace();
        }
        return worldMap;
    }
}
