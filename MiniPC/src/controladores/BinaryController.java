/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;


import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.List;
import resourceReader.Instruccion;
import resourceReader.Program;

/**
 *
 * @author jordi
 */
public class BinaryController {
    
    static String MOV = "0011";
    static String ADD = "0101";
    static String SUB = "0100";
    static String STORE = "0010";
    static String LOAD = "0001";
    
    static String AX = "0001";
    static String BX = "0010";
    static String CX = "0011";
    static String DX = "0100";
    
    static List<MemorySpace> listOfBinaries;
    
    
    /* 
        Toma las instrucciones del programa y las convierte en binario
    
    */
    public void binaryText(Program program, int space){
        List<MemorySpace> listOfBinaries = new ArrayList<MemorySpace>();
        for (Instruccion item : program.getInstructionList()) {
            String newInstruction = typeInstruction(item.getType());
            newInstruction += registerInstruction(item.getRegister());
            newInstruction += numberInstruction(item.getNumber());
            MemorySpace newMem = new MemorySpace(space,newInstruction);
            listOfBinaries.add(newMem);
            space++;
        }
        this.listOfBinaries = listOfBinaries;
        System.out.println(listOfBinaries);
    }
    
    public List<MemorySpace> getListOfBinaries() {
        return this.listOfBinaries;
    }
    
    /*
        Toma las instrucciones y busca que no hayan erroresen el código
    */
    
    public List<String> verifyErrors(Program program){
        int i  = 1;
        List<String> listError = new ArrayList<String>();
        for (Instruccion item : program.getInstructionList()) {
            String type = typeInstruction(item.getType());
            if (type.equals("ERROR INSTRUCTION")){
                listError.add("ERROR INSTRUCCION LINEA: " + i);
            }
            String register = registerInstruction(item.getRegister());
            if(register.equals("ERROR REGISTER")){
                listError.add("ERROR REGISTRO LINEA: " + i);
            }
            String number =  numberInstruction(item.getNumber());
            if (number.equals("ERROR NUMBER")){
                listError.add("ERROR NUMERO LINEA: " + i);
            }
            i++;
        }
        return listError;
    }
    
    /*
        Toma los tipados que se le pasan de parametros y se retorna su valor binario
    */
    private String typeInstruction(String type){
        switch(type){
                case "MOV":
                    return MOV;
                case "ADD":
                    return ADD;
                case "SUB":
                    return SUB;
                case "LOAD":
                    return LOAD;
                case "STORE":
                    return STORE;
                default:
                    return "ERROR INSTRUCTION";
        }  
    }
    
    /*
        Toma los registros que se le pasan de parametros y se retorna su valor binario
    */
    private String registerInstruction(String register){
        switch(register){
                case "AX":
                    return AX;
                case "BX":
                    return BX;
                case "CX":
                    return CX;
                case "DX":
                    return DX;
                default:
                    return "ERROR REGISTER";
        }  
    }
    
    /*
        Toma el numero que se le pasan de parametros y se retorna su valor binario
    */
    private String numberInstruction(int num){
        String numBinary = Integer.toBinaryString(Math.abs(num));
        if (num >= 0) {
            if (num <= 127) {
                return "0" + long7(numBinary);
            } else {
                return "ERROR NUMBER";
            }
            
        }else {
            if (num <= -128){
                return "ERROR NUMBER";
            } else {
                return "1" + long7(numBinary);
            }
        }
    }
   
    
    
    /*
        Toma el numero que se le pasan de parametros y se le agregan la cantidad de ceros para que este
    numero binario tenga 7 bits
    */
    private String long7(String num){
        if (num.length() == 7) {
            return num;
        } else {
            return long7("0"+num);
        }
    }
    
   
}
