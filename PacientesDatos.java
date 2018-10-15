/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import static javaapplication4.CitasDatos.citas;
import static javaapplication4.DoctoresDatos.doctores;
import static javaapplication4.UsuariosDatos.usuarios;

/**
 *
 * @author Mirna
 */
class PacientesDatos {
    
    int códigoSecuencial;
    String nombreCompleto;
    int edad;
   
    //private static final String FILENAME = "./pacientes.med";
    public static boolean pacHardcoded = false;
    public static PacientesDatos pacienteSeleccionado=null;

     public static void init(){
        if(PacientesDatos.pacHardcoded)
            return;
        
        
      // PacientesDatos.pacientes.add(new PacientesDatos(123,"pac1","pac@gmail.com",99778866,1,10,2000));
       //PacientesDatos.pacientes.add(new PacientesDatos(1423,"pac2","pac2@gmail.com",99778866,2,12,2000));

       PacientesDatos.pacHardcoded = true;
    }

    public PacientesDatos() {
    }
     public PacientesDatos(int códigoSecuencial, String nombreCompleto, int edad
     ) {
        this.códigoSecuencial = códigoSecuencial;
        this.nombreCompleto = nombreCompleto;
        this.edad= edad;
        
        
    }

   
    public int getCódigoSecuencial() {
        return códigoSecuencial;
    }

    public void setCódigoSecuencial(int códigoSecuencial) {
        this.códigoSecuencial = códigoSecuencial;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public static ArrayList<PacientesDatos> getPacientes() {
        return pacientes;
    }

    public static void setPacientes(ArrayList<PacientesDatos> pacientes) {
        PacientesDatos.pacientes = pacientes;
    }
  
     public static ArrayList<PacientesDatos> pacientes = new ArrayList<PacientesDatos>();
    
     
     public PacientesDatos findPacByCode(int code){
        for (PacientesDatos pac : PacientesDatos.pacientes) {
            if (pac.getCódigoSecuencial()==code) {
                return pac;
            }
        }
        return null; 
    }
    /*public static void ReadPacientesText()  {
         try {
            new FileOutputStream(FILENAME, false).close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UsuariosDatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PacientesDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            List<File> filesInFolder = Files.walk(Paths.get("./"))
                                .filter(Files::isRegularFile)
                                .map(Path::toFile)
                                .collect(Collectors.toList());
        
            for( File f : filesInFolder){
                if(f.getName().contains("paciente_")){
                     ReadPacienteText(f);
                }
            }

            for(PacientesDatos u : pacientes){
                System.out.println(u);
            }   
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    public static void ReadPacienteText(File file){
        BufferedReader br = null;
        FileReader     fr = null;
        
        try{
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String line = br.readLine();
            
            if (line == null)
                    return;
            
            String u_datos [] = line.split(",");
                
            int codigo      = Integer.parseInt(u_datos [0]); 
            String nombre   = u_datos [1];
            String email    = u_datos [2];
            int numero      = Integer.parseInt(u_datos [3]);
            int dia         = Integer.parseInt(u_datos [4]);
            int mes         = Integer.parseInt(u_datos [5]);
            int año         = Integer.parseInt(u_datos [6]);


            PacientesDatos.pacientes.add(new PacientesDatos( 
                codigo     ,
                nombre     ,
                email      ,
                numero     ,    
                dia        ,
                mes        ,
                año
            ));             
                   
            // line is not visible here.
        }catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                        br.close();
                if (fr != null)
                        fr.close();
            } catch (IOException ex) {
                    ex.printStackTrace();
            }
        }
       
    }
    
    
    public static void SaveCitasText(){
        for(PacientesDatos p : pacientes){
            SaveCitaText("./paciente_"+p.getCódigoSecuencial()+".med", p );
        }
    }
    public static void SaveCitaText(String filename, PacientesDatos paciente){
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {

            String content = "";
            System.out.println(paciente);
            content += paciente.códigoSecuencial +"," 
                    +  paciente.nombreCompleto +","
                    +  paciente.email+","
                    +  paciente.numeroTelefono+","
                     + paciente.getDia()+","
                    +  paciente.getMes()+","
                    +  paciente.getAño()
                    +"\r\n";


            fw = new FileWriter(filename);
            bw = new BufferedWriter(fw);
            bw.write(content);

            System.out.println("Done : "+content);
                
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null)
                        bw.close();
                if (fw != null)
                        fw.close();
            } catch (IOException ex) {
                    ex.printStackTrace();
            }
        }
    }*/
}
