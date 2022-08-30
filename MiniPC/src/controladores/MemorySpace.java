/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

/**
 *
 * @author Usuario
 */
public class MemorySpace {
    private int spaceInMemory;
    private String binaryData;
    
    MemorySpace (int spaceInMemory, String binaryData) {
        this.spaceInMemory = spaceInMemory;
        this.binaryData = binaryData;
    }
    
    public int getSpaceInMemory() {
        return spaceInMemory;
    }
    
    public String getBinaryData() {
        return binaryData;
    }
}
