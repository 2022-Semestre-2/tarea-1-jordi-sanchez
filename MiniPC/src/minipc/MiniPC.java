/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package minipc;
import GUI.NewJFrame;
import controladores.ProcessController;

/**
 *
 * @author Kevin y Jordi
 */
public class MiniPC {
    
    public ProcessController mainProcess = new ProcessController();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NewJFrame form = new NewJFrame();
        form.setVisible(true);
    }
    
}
