/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Kevin y Jordi
 */
public class MemoryController {
    private static final int minimunSizeMemory = 10;
    private static int selectMemorySize;
    private int beging;
    private boolean readySizeMemory = false;
    private int actual;

    public void setActual(int actual) {
        this.actual = actual;
    }

    public int getBeging() {
        return beging;
    }

    public void setBeging(int num) {
        if (selectMemorySize - num == 10){
            this.beging = 10;
        } else {
            Random r = new Random();
            int ran = r.nextInt(((selectMemorySize - 1)  - 10) + 1) + 10;
            while(ran >= selectMemorySize-(num-1)){
                 ran = r.nextInt(((selectMemorySize - 1)  - 10) + 1) + 10;
            }
            this.beging = ran;
        }
    }

    public int getActual() {
        return actual;
    }
    
    public int getMinimunSizeMemory() {
        return minimunSizeMemory;
    }
    
    public int getSelectMemorySize() {
        return selectMemorySize;
    }
    
    public boolean readySizeMemory() {
        return readySizeMemory;
    }
    
    public void setSelectedMemorySize(int memorySize) {
        if (minimunSizeMemory <= memorySize) {
            selectMemorySize = memorySize;
            readySizeMemory = true;
        } else {
            JFrame f = new JFrame("frame");
                JOptionPane.showMessageDialog(f ,
                "El tamaño de la memoria debe ser mayor o igual a 10" ,
                "Tamaño de memoria" ,
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
