/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mian;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author HarasztiMihály(SZF_N
 */
public class Main {
    
    private static List<Fuvar> records;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        records = Beolvas.FuvarRecordPars("./src/assets/fuvar.csv");
        
    }
    
    //a fizetések összege
    public static float feladat1(){
        float ertek = 0;
        for (int i = 0; i < records.size(); i++) {
            ertek += records.get(i).getOsszeg();
        }
        return ertek;
    }
    
    public static String feladat2(){
        int legdIndex = 0;
        for (int i = 1; i < records.size(); i++) {
            if(records.get(i).getOsszeg()>records.get(legdIndex).getOsszeg()) legdIndex = i;
        }
        return records.get(legdIndex).getRendszam();
    }
    
    public static int feladat3(float euroForint){
        int legdIndex = 0;
        for (int i = 1; i < records.size(); i++) {
            if(records.get(i).getOsszeg()<records.get(legdIndex).getOsszeg()) legdIndex = i;
        }
        return (int)(records.get(legdIndex).getOsszeg()*euroForint);
    }
    
    public static int feladat4(){
        int fizetes = 0;
        for (int i = 1; i < records.size(); i++) {
            if(records.get(i).getFizm()==FizeteseMod.CSEKK) fizetes++;
        }
        return fizetes;
    }
}
