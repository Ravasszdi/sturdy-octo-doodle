/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package mian;

/**
 *
 * @author HarasztiMihály(SZF_N
 */
public enum FizeteseMod {
    KARTYA,     //0
    KESZPENZ,   //1
    UTALAS,     //2
    CSEKK,      //3
    NA,;         //4
    
    public static FizeteseMod parsFizeteseMod(String s) {
        switch (s) {
            case "KARTYA": return KARTYA;
            case "KESZPENZ": return KESZPENZ;
            case "UTALAS": return UTALAS;
            case "CSEKK": return CSEKK;
            default: return NA;
        }
    }
}
