/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package teszt;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import mian.Beolvas;
import mian.Fuvar;

/**
 *
 * @author HarasztiMihály(SZF_N
 */
public class ProgramTeszt {
    List<Fuvar> fuvar;
    
    public static void main(String[] args) throws IOException {
        ProgramTeszt teszt = new ProgramTeszt();
        teszt.tesztFileBeolvasas();
        teszt.tesztAdat100Tagos();
    }
    
    void tesztFileBeolvasas() throws IOException{
        Files.readAllLines(Path.of("src/assets/fuvar.csv"));
    }
    
    void tesztAdat100Tagos() throws IOException{
        List<String> file = Files.readAllLines(Path.of("src/assets/fuvar.csv"));
        int vart = 100;
        int kapott = file.size();
        assert vart==kapott : "nem %d soros a file, %d sort kaptunk".formatted(vart,kapott);
    }
    
    void tesztRendszamForma() throws IOException{
        fuvar = Beolvas.FuvarRecordParse("src/assets/fuvar.csv");
        String[] rsz = fuvar.get(0).getRendszam().split("-");
        String abc = rsz[0];
        String szam = rsz[1];
        assert abc.length()==3 : "nem 3 betűs";
        Integer.parseInt(szam);
        assert szam.length()==3 : "nem 3 szam jegyű";
    }
    
    void tesztRendszamkulombseg() throws IOException{
        int elfogadott = 5;
        int maximum = 90;
        fuvar = Beolvas.FuvarRecordParse("src/assets/fuvar.csv");
        Set<String> rsz = new HashSet<>();
        for(int i = 0; i < fuvar.size(); i++) rsz.add(fuvar.get(i).getRendszam());
        assert rsz.size()>=elfogadott&&rsz.size()<=elfogadott : "nincs megfelelő menyiségű úgyanolyan rendszám a file-ban";
    }
    
}
