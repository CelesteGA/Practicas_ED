package Granja;

import java.util.Date;

public class Ganado {
    private int edad;
    private String raza;
    private Date fecha_ingreso;
    private String RP;
    private float[] leche_Semana = new float[52];
    private int Semana_Actual = 0;


    public String getRP() {
        return RP;
    }


    public String getRaza() {
        return raza;
    }


    public int getSemana_Actual() {
        return Semana_Actual;
    }
    


    public Ganado(int edad, String raza, Date fecha_ingreso) {
        this.edad = edad;
        this.raza = raza;
        this.setFecha_ingreso(fecha_ingreso);
        GeneraRP();
    }
    
    public void RegistroLeche(float litros){
        leche_Semana[Semana_Actual]=litros; //Se guardan en semana actual para no perder los registros anteriores
        Semana_Actual +=1;  
       
    }
    
    public float ObtenerPromedio(){
        float promedio=0;
        for(int i=0;i<Semana_Actual;i++){
            promedio+=leche_Semana[i];
        }
        if(Semana_Actual!=0){
            promedio /=Semana_Actual;
        }
        return promedio;
    }
    
    private void GeneraRP(){
        RP=String.valueOf(edad)+raza; //Cambiar a 8 digitos (pendiente)
       
    }


	public Date getFecha_ingreso() {
		return fecha_ingreso;
	}


	public void setFecha_ingreso(Date fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}
}

