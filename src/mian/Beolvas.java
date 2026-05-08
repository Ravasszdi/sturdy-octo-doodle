/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mian;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 *
 * @author HarasztiMihály(SZF_N
 */
public class Beolvas {
    public static List Beolvasas(String path) throws IOException{
        return Files.readAllLines(Path.of(path));
    }
}
