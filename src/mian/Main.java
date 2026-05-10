/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mian;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        System.out.println("feladat1:" + feladat1());
        System.out.println("feladat2:" + feladat2());
        System.out.println("feladat3:" + feladat3((float) 355.5));
        System.out.println("feladat4:" + feladat4());
        System.out.println("feladat5:" + feladat5());
        System.out.println("feladat6:" + feladat6());
        System.out.println("feladat7:" + feladat7());
        feladat8();
    }

    // a fizetések összege
    public static float feladat1() {
        float ertek = 0;
        for (int i = 0; i < records.size(); i++) {
            ertek += records.get(i).getOsszeg();
        }
        return ertek;
    }

    public static String feladat2() {
        int legdIndex = 0;
        for (int i = 1; i < records.size(); i++) {
            if (records.get(i).getOsszeg() > records.get(legdIndex).getOsszeg()) {
                legdIndex = i;
            }
        }
        return records.get(legdIndex).getRendszam();
    }

    public static int feladat3(float euroForint) {
        int legdIndex = 0;
        for (int i = 1; i < records.size(); i++) {
            if (records.get(i).getOsszeg() < records.get(legdIndex).getOsszeg()) {
                legdIndex = i;
            }
        }
        return (int) (records.get(legdIndex).getOsszeg() * euroForint);
    }

    public static int feladat4() {
        int fizetes = 0;
        for (int i = 1; i < records.size(); i++) {
            if (records.get(i).getFizm() == FizeteseMod.CSEKK) {
                fizetes++;
            }
        }
        return fizetes;
    }

    public static boolean feladat5() {
        FizeteseMod[] fizfaj = {FizeteseMod.CSEKK, FizeteseMod.KARTYA, FizeteseMod.KESZPENZ, FizeteseMod.UTALAS,
            FizeteseMod.NA};
        boolean ki = true;
        for (int i = 0; i < fizfaj.length; i++) {
            ki &= eld(records, fizfaj[i]);
        }
        return ki;
    }

    private static boolean eld(List<Fuvar> lista, FizeteseMod fizmod) {
        int i = 0;
        while (i < lista.size() && !(lista.get(i).getFizm() == fizmod)) {
            i++;
        }
        return i < lista.size();
    }

    // set nélkül
    public static int feladat6() {
        int rendszamDb = 1;
        List<Fuvar> masolat = records;
        for (int i = 0; i < masolat.size(); i++) {
            for (int j = i; j < masolat.size(); j++) {
                if (masolat.get(j).getRendszam().compareToIgnoreCase(masolat.get(i).getRendszam()) < 0) {
                    Fuvar tmp = masolat.get(j);
                    masolat.set(j, masolat.get(i));
                    masolat.set(i, tmp);
                }
            }
        }
        for (int i = 1; i < masolat.size(); i++) {
            if (!masolat.get(i).getRendszam().equals(masolat.get(i - 1).getRendszam())) {
                rendszamDb++;
            }
        }
        return rendszamDb;
    }

    // mire goldolt a költő az alatt hogy "hányféle fizetési mód van" és én így
    // értelmeztem
    public static int feladat7() {
        FizeteseMod[] fizfaj = {FizeteseMod.CSEKK, FizeteseMod.KARTYA, FizeteseMod.KESZPENZ, FizeteseMod.UTALAS,
            FizeteseMod.NA};
        int ki = 0;
        for (int i = 0; i < fizfaj.length; i++) {
            ki += eld(records, fizfaj[i]) ? 1 : 0;
        }
        return ki;
    }

    /*
   * Feladat8
   * létre hozunk egy új obiektumot ami tárolja a rendszámokat és hogy eddig
   * hányszor voltak
   * csinálunk egy listát és ahogy végigmegyünk a records listán minden eddigi nem
   * létező kocsit
   * betesszük egy új példányba ha létezik már akkor a létező példánynak a
   * számláló változojához hozzá adunk egyett.
     */
    
    public static Map<String, Integer> feladat8() {
        Map<String, Integer> mm = new HashMap<>();
        for (Fuvar fuvar : records) {
            if (mm.containsKey(fuvar.getRendszam())) {
                int ertek = mm.get(fuvar.getRendszam());
                mm.put(fuvar.getRendszam(), ++ertek);
            } else {
                mm.put(fuvar.getRendszam(), 1);
            }
        }

        for (Map.Entry<String, Integer> entry : mm.entrySet()) {
            String key = entry.getKey();
            int val = entry.getValue();
            System.out.println(key + " " + val);

        }
        return mm;
    }
}
