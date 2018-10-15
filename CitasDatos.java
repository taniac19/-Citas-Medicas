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
import static javaapplication4.UsuariosDatos.usuarios;

/**
 *
 * @author Mirna
 */
class CitasDatos {
    public static ArrayList<CitasDatos> citas = new ArrayList<CitasDatos>();
    int codigoCita;
    int codigoPaciente;
    int codigoDoctor;
    String descripcion;
    String tipoCita;
    String estadoCita;
    double montoCita;
    Date fecha = new Date();
    int dia;
    int mes;
    int año;
    //private static final String FILENAME = "./citas.med";
    public static boolean citHardcoded = false;
    public static CitasDatos citaSeleccionada=null;
 
     public static void init(){
        if(CitasDatos.citHardcoded)
            return;
        
        
       //CitasDatos.citas.add(new CitasDatos(123,123,123,"desc","cita1","pendiente",99778866,20,6,2018));
      

       CitasDatos.citHardcoded = true;
    }

    public Date getFecha() {
        return fecha;
    }

    public CitasDatos() {
    }
    public CitasDatos(int codigoCita, int codigoPaciente, int codigoDoctor, int dia, int mes, int año, int hora, int min,int seg) {
        this.codigoPaciente = codigoPaciente;
        this.codigoDoctor = codigoDoctor;
        this.codigoCita=codigoCita;
        this.dia = dia;
        this.mes = mes;
        this.año = año;
        DateFormat df = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        String strDate = String.valueOf(hora) + ":" + String.valueOf(min) + ": " + String.valueOf(seg)+" "+ String.valueOf(dia) + "/" + String.valueOf(mes) + "/" + String.valueOf(año);
        Date dataFrom;
        try {
            dataFrom = df.parse(strDate);
        } catch (Exception e) {
            System.out.println("Error ingresando fecha: "+e.getMessage());
            dataFrom = new Date();
        }

        this.fecha = dataFrom;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getCodigoCita() {
        return codigoCita;
    }

    public void setCodigoCita(int codigoCita) {
        this.codigoCita = codigoCita;
    }

    public int getCodigoPaciente() {
        return codigoPaciente;
    }

    public void setCodigoPaciente(int codigoPaciente) {
        this.codigoPaciente = codigoPaciente;
    }

    public int getCodigoDoctor() {
        return codigoDoctor;
    }

    public void setCodigoDoctor(int codigoDoctor) {
        this.codigoDoctor = codigoDoctor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoCita() {
        return tipoCita;
    }

    public void setTipoCita(String tipoCita) {
        this.tipoCita = tipoCita;
    }

    public String getEstadoCita() {
        return estadoCita;
    }

    public void setEstadoCita(String estadoCita) {
        this.estadoCita = estadoCita;
    }

    public double getMontoCita() {
        return montoCita;
    }

    public void setMontoCita(double montoCita) {
        this.montoCita = montoCita;
    }
    public CitasDatos findCitaByCode(int code){


    for (CitasDatos citas : CitasDatos.citas) {
        if (citas.getCodigoCita()==code) {
            return citas;
        }
    }
    return null; 
    }
   /* public static void ReadCitasText(){
         try {
            new FileOutputStream(FILENAME, false).close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UsuariosDatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CitasDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedReader br = null;
        FileReader     fr = null;
        
        try{
            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);
            for(String line; (line = br.readLine()) != null; ) {
                String u_datos [] = line.split(",");
                
                int codigoCita      = Integer.parseInt(u_datos [0]); 
                int codigoPaciente  = Integer.parseInt(u_datos [1]);
                int codigoDoctor    = Integer.parseInt(u_datos [2]);
                int dia             = Integer.parseInt(u_datos [3]);
                int mes             = Integer.parseInt(u_datos [4]);
                int año             = Integer.parseInt(u_datos [5]);
                String descripcion  = u_datos [6];
                String tipoCita     = u_datos [7];
                String estadoCita   = u_datos [8];
                double monto        = Double.parseDouble(u_datos [9]);
                            
                CitasDatos.citas.add(new CitasDatos( 
                 codigoCita      ,
                 codigoPaciente  ,
                 codigoDoctor    ,
                 descripcion     ,
                 tipoCita        ,
                 estadoCita      ,
                 monto           ,
                 dia             ,
                 mes             ,
                 año));             
                 
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
        
        for(UsuariosDatos u : usuarios){
            System.out.println(u);
        }
    }
    
    
    public static void SaveCitasText(){
        
        /*
        File f = new File(FILENAME);
        if(!f.exists() || f.isDirectory()) { 
            
        }*/

        /*BufferedWriter bw = null;
        FileWriter fw = null;
        try {

                String content = "";
                
                for(CitasDatos u : citas){
                    System.out.println(u);
                    content += u.codigoCita +"," 
                            + u.codigoPaciente +","
                            + u.codigoDoctor+","
                            + u.getDia()+","
                            + u.getMes()+","
                            + u.getAño()+","
                            + u.descripcion+","
                            + u.tipoCita+","
                            + u.estadoCita+","
                            + u.montoCita
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
    }*/
}
