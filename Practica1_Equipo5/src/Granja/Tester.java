package Granja;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Arrays;

public class Tester {
	
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Registro g = new Registro("C:\\Users\\Namae\\Documents\\Prueba_Granja.txt");
        System.out.println(g.ObtenerPromedioVacas());
        System.out.println(g.ObtenerPromedioCabras());
        System.out.println(Arrays.toString(g.Vacas_Max()));
        System.out.println(Arrays.toString(g.Cabras_Max()));
    }
    
}
