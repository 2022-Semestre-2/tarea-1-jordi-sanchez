/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import java.util.List;
import resourceReader.Instruccion;
import resourceReader.Program;

/**
 *
 * @author Kevin
 */
public class ProcessController {
    private BinaryController binaryController = new BinaryController();;
    private MemoryController memoryController = new MemoryController();;
    private Program program = new Program();
    private Computer computer = new Computer();
    
    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }
    
    
    public ProcessController() {
    }
    
    public void clearData() {
        binaryController = new BinaryController();
        memoryController = new MemoryController();
        program = new Program();
        Computer computer = new Computer();
    }
    
    public void setBinaryController(BinaryController binary) {
        this.binaryController = binary;
    }
    
    public void getMemoryController(MemoryController memory) {
        this.memoryController = memory;
    }
    
    public void setProgram(Program program) {
        this.program = program;
    }
    
    public BinaryController getBinaryController() {
        return binaryController;
    }
    
    public MemoryController getMemoryController() {
        return memoryController;
    }
    
    public Program getProgram() {
        return program;
    }
    
}
