/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jordi y Kevin
 */
public class Computer {
    private String AX = "0";
    private String BX = "0";
    private String CX = "0";
    private String DX = "0";
    private String AC = "0";
    private String IR;
    private String PC;

    public String getAX() {
        return AX;
    }

    public String getBX() {
        return BX;
    }

    public String getCX() {
        return CX;
    }

    public String getDX() {
        return DX;
    }

    public String getAC() {
        return AC;
    }

    public String getIR() {
        return IR;
    }

    public String getPC() {
        return PC;
    }
    

    public Computer() {
    }
    
    public void restart(){
        AX = "0";
        BX = "0";
        CX = "0";
        DX = "0";
        AC = "0";
        IR = " ";
        PC = " ";
    }
    public void processADD(String register, String ir, String pc){
        this.IR = ir;
        this.PC = pc;
        switch(register){
                case "AX":
                    this.AC = Integer.toString(Integer.parseInt(this.AC.trim()) + Integer.parseInt(this.AX.trim()));
                    break;
                case "BX":
                    this.AC = Integer.toString(Integer.parseInt(this.AC.trim()) + Integer.parseInt(this.BX.trim()));
                    break;
                case "CX":
                   this.AC = Integer.toString(Integer.parseInt(this.AC.trim()) + Integer.parseInt(this.CX.trim()));
                   break;
                case "DX":
                    this.AC = Integer.toString(Integer.parseInt(this.AC.trim()) + Integer.parseInt(this.DX.trim()));
                    break;
        }  
    }
    
    public void processSUB(String register, String ir, String pc){
        this.IR = ir;
        this.PC = pc;
        switch(register){
                case "AX":
                    this.AC = Integer.toString(Integer.parseInt(this.AC.trim()) - Integer.parseInt(this.AX.trim()));
                    break;
                case "BX":
                    this.AC = Integer.toString(Integer.parseInt(this.AC.trim()) - Integer.parseInt(this.BX.trim()));
                    break;
                case "CX":
                   this.AC = Integer.toString(Integer.parseInt(this.AC.trim()) - Integer.parseInt(this.CX.trim()));
                   break;
                case "DX":
                    this.AC = Integer.toString(Integer.parseInt(this.AC.trim()) - Integer.parseInt(this.DX.trim()));
                    break;
        }  
    }
    
    public void processLOAD(String register, String ir, String pc){
        this.IR = ir;
        this.PC = pc;
        switch(register){
                case "AX":
                    this.AC = this.AX;
                    break;
                case "BX":
                    this.AC = this.BX;
                    break;
                case "CX":
                   this.AC = this.CX;
                   break;
                case "DX":
                    this.AC = this.DX;
                    break;
        }  
    }
    
    public void processSTORE(String register, String ir, String pc){
        this.IR = ir;
        this.PC = pc;
        switch(register){
                case "AX":
                    this.AX = this.AC ;
                    break;
                case "BX":
                    this.BX = this.AC ;
                    break;
                case "CX":
                    this.CX = this.AC ;
                    break;
                case "DX":
                    this.DX = this.AC ;
                    break;
        }  
    }
    
    public void processMOV(String register,String number, String ir, String pc){
        this.IR = ir;
        this.PC = pc;
        switch(register){
                case "AX":
                    this.AX = number;
                    break;
                case "BX":
                    this.BX = number;
                    break;
                case "CX":
                    this.CX = number;
                    break;
                case "DX":
                    this.DX = number;
                    break;
        }  
    }
    
    
    
}
