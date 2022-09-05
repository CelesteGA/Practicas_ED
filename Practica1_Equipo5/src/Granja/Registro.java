package Granja;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import static java.lang.Float.max;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Registro {

    private Ganado[] rebaños = new Ganado [100];
    private int ganado_Actual=0;

    public Registro(String ruta_Archivo) throws FileNotFoundException, ParseException {
        CargaGanado(ruta_Archivo);
     }
     
     public float ObtenerPromedioVacas(){
         float promedio=0; //Siempre inicialzar las variables dentro de una funcion
         int cantidad_Vacas=0;
         for(int i=0;i<ganado_Actual;i++){
             if(rebaños[i].getRaza().trim().equals("Vaca") || rebaños[i].getRaza().trim().equals("vaca") || rebaños[i].getRaza().trim().equals("VACA") ){
                 promedio+=rebaños[i].ObtenerPromedio()*rebaños[i].getSemana_Actual();
                 cantidad_Vacas+=1;
             }
         }
         promedio /= cantidad_Vacas;
     
         return promedio;
     }
     
     public float ObtenerPromedioCabras(){
         float promedio=0; 
         int cantidad_Cabras=0;
         for(int i=0;i<ganado_Actual;i++){
             if(rebaños[i].getRaza().trim().equals("Cabra") || rebaños[i].getRaza().trim().equals("cabra") || rebaños[i].getRaza().trim().equals("CABRA") ){
                 promedio+=rebaños[i].ObtenerPromedio()*rebaños[i].getSemana_Actual();
                 cantidad_Cabras+=1;
             }
         }


         promedio /= cantidad_Cabras;    
         return promedio;
     }
     
     public String[] Vacas_Max(){
         String [] Respuesta = new String [3];
         float promedio_max =-1;
         int contador=0;
         for(int i=0;i<ganado_Actual;i++){
             if(rebaños[i].getRaza().trim().equals("Vaca") || rebaños[i].getRaza().trim().equals("vaca") || rebaños[i].getRaza().trim().equals("VACA") ){
                 promedio_max=max(promedio_max,rebaños[i].ObtenerPromedio());
             }
         }
         for(int i=0;i<ganado_Actual;i++){
             if(rebaños[i].getRaza().trim().equals("Vaca") || rebaños[i].getRaza().trim().equals("vaca") || rebaños[i].getRaza().trim().equals("VACA") ){
                if(rebaños[i].ObtenerPromedio()==promedio_max){
                   Respuesta[contador]=rebaños[i].getRP();
                   contador +=1;
                   if(contador>=3){
                       break;
                   }
                }
             }
         }
         return Respuesta;
     }
     
     public String[] Cabras_Max(){
         String [] Respuesta = new String [3];
         float promedio_max =-1;
         int contador=0;
         for(int i=0;i<ganado_Actual;i++){
             if(rebaños[i].getRaza().trim().equals("Cabra") || rebaños[i].getRaza().trim().equals("cabra") || rebaños[i].getRaza().trim().equals("CABRA") ){
                 promedio_max=max(promedio_max,rebaños[i].ObtenerPromedio());
             }
         }
         for(int i=0;i<ganado_Actual;i++){
             if(rebaños[i].getRaza().trim().equals("Cabra") || rebaños[i].getRaza().trim().equals("cabra") || rebaños[i].getRaza().trim().equals("CABRA") ){
                if(rebaños[i].ObtenerPromedio()==promedio_max){
                   Respuesta[contador]=rebaños[i].getRP();
                   contador +=1;
                   if(contador>=3){
                       break;
                   }
                }
             }
         }
         return Respuesta; //Como hacer arreglo dinamico
     }
     
     private void CargaGanado(String ruta_Archivo) throws FileNotFoundException, ParseException{
         Scanner read = new Scanner (new FileInputStream(ruta_Archivo));
         read.useDelimiter(",");
         String raza,fecha,edad,l1,l2,l3,l4,l5;


         while(read.hasNext())
         {         
             raza = read.next();
             fecha = read.next();
             edad = read.next();
             l1 = read.next();
             l2 = read.next();
             l3 = read.next();
             l4 = read.next();
             l5 = read.next();                
             rebaños [ganado_Actual]=new Ganado(Integer.valueOf(edad),raza,new SimpleDateFormat("dd/MM/yyyy").parse(fecha));
             rebaños [ganado_Actual].RegistroLeche(Float.valueOf(l1));  
             rebaños [ganado_Actual].RegistroLeche(Float.valueOf(l2));
             rebaños [ganado_Actual].RegistroLeche(Float.valueOf(l3));
             rebaños [ganado_Actual].RegistroLeche(Float.valueOf(l4));
             rebaños [ganado_Actual].RegistroLeche(Float.valueOf(l5));
             ganado_Actual+=1;
         }
         read.close();
     }
     
 }