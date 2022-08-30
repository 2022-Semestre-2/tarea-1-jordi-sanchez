/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resourceReader;

import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jordi
 */
public class Program {
    /*
        hashmap instruccion ejemplo < Load, <AX, 5>>
                                    operacion, <registro, numero>
    */
    private List<Instruccion> instructionList = new ArrayList<>();

    public Program() {
    }

    private String[] splitData(String data, String limit){
        String[] arrOfStr = data.split(limit);
        return arrOfStr;
    }
    
    public void createLista(String data){
        String[] arrayIntruction = data.split("\n");
        for (String instruccion : arrayIntruction) {
            String[] arrayIntruction2 = instruccion.split(",");
            String[] arrayIntruction3 = arrayIntruction2[0].split(" ");
            Instruccion instructionAdded = new Instruccion(arrayIntruction3[0].trim());
            if (arrayIntruction2.length > 1) {
                int i = Integer.parseInt(arrayIntruction2[1].trim());
                instructionAdded.setNumber(i);
            } else {
                instructionAdded.setNumber(0);
            }
            instructionAdded.setRegister(arrayIntruction3[1].trim());
            this.instructionList.add(instructionAdded);
        }
    }

    public List<Instruccion> getInstructionList() {
        return instructionList;
    }
    
 
}
