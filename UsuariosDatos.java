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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mirna
 */
class UsuariosDatos {

    public static ArrayList<UsuariosDatos> usuarios = new ArrayList<UsuariosDatos>();
    public static boolean usuarioHardcoded = false;
    public static UsuariosDatos usuarioLoggedIn=null;
    
    private static final String FILENAME = "./users.med";

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    String nombre;
     String pass;
     String username;
    public static void init(){
        if(UsuariosDatos.usuarioHardcoded)
            return;
        
        
        UsuariosDatos.usuarios.add(new UsuariosDatos("administrador", "hosp", "admin"));
       
        
        
        UsuariosDatos.usuarioHardcoded = true;
    }

    public UsuariosDatos() {
    }
    
    
    public UsuariosDatos(String nombre, String pass, String username) {
        this.nombre=nombre;
        this.pass=pass;
        this.username=username;
    }
     public String getNombre() {
        return nombre;
    }

    public String getPass() {
        return pass;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "UsuariosDatos{" + "nombre=" + nombre + ", pass=" + pass + ", username=" + username + '}';
    }
    
    public static void ReadUsersText(){
        try {
            new FileOutputStream(FILENAME, false).close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UsuariosDatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UsuariosDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        BufferedReader br = null;
        FileReader     fr = null;
        
        try{
            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);
            for(String line; (line = br.readLine()) != null; ) {
                String u_datos [] = line.split(",");
                UsuariosDatos.usuarios.add(new UsuariosDatos(u_datos [0], u_datos [2], u_datos [1] ));
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
    
    
    public static void SaveUsersText(){
        
        /*
        File f = new File(FILENAME);
        if(!f.exists() || f.isDirectory()) { 
            
        }*/

        BufferedWriter bw = null;
        FileWriter fw = null;
        try {

                String content = "";
                
                for(UsuariosDatos u : usuarios){
                    System.out.println(u);
                    content += u.nombre +","+ u.username +","+ u.pass+"\r\n";
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
    }          
}
