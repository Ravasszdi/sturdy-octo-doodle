/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mian;

/**
 *
 * @author HarasztiMihály(SZF_N
 */
public class Fuvar {
    private String rendszam;
    private int idoMp;
    private float osszeg;
    private FizeteseMod fizm;

    public Fuvar(String rendszam, int idoMp, float osszeg, FizeteseMod fizm) {
        this.rendszam = rendszam;
        this.idoMp = idoMp;
        this.osszeg = osszeg;
        this.fizm = fizm;
    }

    public String getRendszam() {
        return rendszam;
    }

    public int getIdoMp() {
        return idoMp;
    }

    public float getOsszeg() {
        return osszeg;
    }

    public FizeteseMod getFizm() {
        return fizm;
    }
    
    
}
