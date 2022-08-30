/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resourceReader;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jordi
 */
public class Instruccion {
    private String type;
    private String register;
    private int number;

    public Instruccion(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

   public int verifyRegister(){
       switch (this.register) {
            case "AX":
               return 1;
            case "BX":
               return 2;
               case "CX":
               return 3;
               case "DX":
               return 4;
           default:
               throw new AssertionError();
       }
   }
    
}
