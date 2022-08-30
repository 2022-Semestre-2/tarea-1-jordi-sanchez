/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resourceReader;

/**
 *
 * @author jordi
 */

public class FileASM {
    private int instruction = 0;
    private String data;
    private String extension = null;
    private int error = 0;

    public FileASM() {}

    public int getInstruction() {
        return instruction;
    }

    public void setInstruction(int instruction) {
        this.instruction = instruction;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
    
    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }
    
}
