/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mian;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HarasztiMihály(SZF_N
 */
public class Beolvas {
    public static List Beolvasas(String path) throws IOException{
        return Files.readAllLines(Path.of(path));
    }
    
    public static Fuvar fuvarFormazo(String szoveg){
        String[] tmp = szoveg.split(",");
        return new Fuvar(   tmp[0],
                            Integer.parseInt(tmp[1]),
                            Float.parseFloat(tmp[2]),
                            FizeteseMod.parsFizeteseMod(tmp[3])
                        );
    }
    
    public static List FuvarListazas(List<String> records){
        List<Fuvar> fuvarok = new ArrayList<>();
        
        for (int i = 1; i < records.size(); i++) {
            fuvarok.add(fuvarFormazo(records.get(i)));
        }
        
        return fuvarok;
    }
    
    public static List FuvarRecordParse(String path) throws IOException{
        List sorok = Beolvasas(path);
        return FuvarListazas(sorok);
    }
}
