/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javaapplication4.CitasDatos.citas;
import static javaapplication4.UsuariosDatos.usuarios;

/**
 *
 * @author Mirna
 */
class DoctoresDatos {
    int códigoSecuencial;
    String nombreCompleto;
    String especialidad;
    String horaEntrada;

    public int getCódigoSecuencial() {
        return códigoSecuencial;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }
    String horaSalida;
    boolean activo;
   // private static final String FILENAME = "./doctores.med";
    public static boolean doctorHardcoded = false;
    public static DoctoresDatos doctorSeleccionado=null;
     
     public static void init(){
        if(DoctoresDatos.doctorHardcoded)
            return;
        
        
       // DoctoresDatos.doctores.add(new DoctoresDatos(123,"doctor","doc@gmail.com",99778866,"Cirujano",true));
        //DoctoresDatos.doctores.add(new DoctoresDatos(1234,"doctor1","doc2@gmail.com",91778866,"Cirujano1",true));
      
        
       DoctoresDatos.doctorHardcoded = true;
    }

    public int getCodigoSecuencial() {
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
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public DoctoresDatos() {
    }
    public DoctoresDatos(int códigoSecuencial, String nombreCompleto, String especialidad, boolean activo, int hora1, int hora2,int min1, int min2, int seg1, int seg2 ) {
        this.códigoSecuencial = códigoSecuencial;
        this.nombreCompleto = nombreCompleto;
        this.especialidad = especialidad;
        this.activo =activo;
        String horaEntradaDoc=(String.valueOf(hora1)+":"+String.valueOf(min1)+":"+String.valueOf(seg1));
        String horaSalidaDoc=(String.valueOf(hora2)+":"+String.valueOf(min2)+":"+String.valueOf(seg2));

        DateFormat df = new SimpleDateFormat("HH:mm:ss");
        String strDate = String.valueOf(hora1) + ":" + String.valueOf(min1) + ": " + String.valueOf(seg1);
        Date dataFrom;
        try {
            dataFrom = df.parse(strDate);
        } catch (Exception e) {
            System.out.println("Error ingresando fecha: "+e.getMessage());
            dataFrom = new Date();
        }
        this.horaEntrada=horaEntradaDoc;
        DateFormat df2 = new SimpleDateFormat("HH:mm:ss");
        String strDate2 = String.valueOf(hora2) + ":" + String.valueOf(min2) + ": " + String.valueOf(seg2);
        Date dataFrom2;
        try {
            dataFrom2 = df2.parse(strDate2);
        } catch (Exception e) {
            System.out.println("Error ingresando fecha: "+e.getMessage());
            dataFrom2 = new Date();
        }
        this.horaSalida=horaSalidaDoc;
    }

    public static ArrayList<DoctoresDatos> doctores = new ArrayList<DoctoresDatos>();
    
    public DoctoresDatos findUserByCode(int code){

    for (DoctoresDatos doc : DoctoresDatos.doctores) {
        if (doc.getCodigoSecuencial()==code) {
            return doc;
        }
    }
    return null; 


    }
    /*  public static void ReadDoctoresText(){
           try {
            new FileOutputStream(FILENAME, false).close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UsuariosDatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DoctoresDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedReader br = null;
        FileReader     fr = null;
        
        try{
            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);
            for(String line; (line = br.readLine()) != null; ) {
                String u_datos [] = line.split(",");
                
                int codigo      = Integer.parseInt(u_datos [0]); 
                String nombre   = u_datos [1];
                String email    = u_datos [2];
                int numeroT     = Integer.parseInt(u_datos [3]);
                String especialidad  =u_datos [4];
                boolean activo =Boolean.parseBoolean(u_datos [5]);
             
                            
               DoctoresDatos.doctores.add(new DoctoresDatos( 
                 codigo      ,
                 nombre  ,
                 email    ,
                 numeroT     ,
                 especialidad       ,
                 activo));             
                 
            }
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
        
        for(DoctoresDatos u : doctores){
            System.out.println(u);
        }
    }
    
    
    public static void SaveDoctoresText(){
        
        /*
        File f = new File(FILENAME);
        if(!f.exists() || f.isDirectory()) { 
            
        }*/
/*
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {

                String content = "";
                
                for(DoctoresDatos u : doctores){
                    System.out.println(u);
                    content += u.códigoSecuencial +"," 
                            + u.nombreCompleto +","
                            + u.email+","
                            + u.numeroTelefono+","
                            + u.especialidad+","
                            + u.activo
                            +"\r\n";
                }

                fw = new FileWriter(FILENAME);
                bw = new BufferedWriter(fw);
                bw.write(content);

                System.out.println("Done");
                
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
    } */
  
    
    
    
}

