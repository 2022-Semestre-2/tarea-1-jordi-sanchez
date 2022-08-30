/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resourceReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;
import javax.swing.JFileChooser;

/**
 *
 * @author jordi y kevin
 */
public class Reader {
    static final String EXTENSION = ".asm";
    private String pathFile = "";
    private String fileText = "";
    private Optional<FileASM> fileContent = null;
    
    public Reader() {}
    
    /*
        Si la extension es .asm devuelve un fileASM con extension sino un fileASM sin extension
    */
    
    public void getFile() throws FileNotFoundException, IOException{
        FileASM file = new FileASM();
        JFileChooser fileChooser = new JFileChooser();
        
        int selection = fileChooser.showOpenDialog(fileChooser);
        
        if (selection == JFileChooser.APPROVE_OPTION) {
            File fichero = fileChooser.getSelectedFile();
            pathFile = fichero.getAbsolutePath();
            
            if (isASM(fichero.getAbsolutePath())) {
                try (FileReader fr = new FileReader(fichero)) {
                    String cadena = "";
                    int valor = fr.read();
                    while (valor != -1) {
                        cadena = cadena + (char) valor;
                        valor = fr.read();
                    }
                    fileText = cadena;
                }
                fileContent = readFile(pathFile);
            } else {
                pathFile = "";
                fileText = "";
                fileContent = null;
                System.out.println("No es de tipo valido");
            }
        }
    }
    
    /*
        Devuelve un optional con un FileASM con extension asm, si el file no existe devuelve un error 2
        si surge un error inesperado devuelve un error 1, si no hay errores devuelve un file con datos
        cantidad de instrucciones de un programa asm
    */
    private Optional<FileASM> readFile(String path_File){
        File myObj = new File(path_File);
        FileASM file = new FileASM();
        file.setExtension(EXTENSION);
        if (myObj.exists()) {
          try {
            Scanner myReader = new Scanner(myObj);
            String info = "";
            int instruction_cont = 0;
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              info += data + "\n";
              instruction_cont ++;
            }
            info = info.substring(0, info.length()-1);
            file.setData(info);
            file.setInstruction(instruction_cont);
            myReader.close();
            return Optional.of(file);
          } catch (FileNotFoundException e) {
            file.setError(1);
            return Optional.of(file); //error try
          }
        }else {   
            file.setError(2);
            return Optional.of(file); // error no encontrado
        }
    }   
    
    /*
        Verifica que un path tenga extension .asm
    */
    public boolean isASM(String nameFile){
        String extensionFile = nameFile.substring(nameFile.length()-4);
        return extensionFile.equals(EXTENSION);
    }
    
    public String getPathFile() {
        return pathFile;
    }
    
    public String getFileText() {
        return fileText;
    }
    
    public Optional<FileASM> getFileContent() {
        return fileContent;
    }
}
