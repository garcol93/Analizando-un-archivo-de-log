import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * Write a description of class AnalizadorAccesosAServidor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AnalizadorAccesosAServidor
{
    private ArrayList<Acceso> listaDeAcceso;    
    /**
     * Constructor for objects of class AnalizadorAccesosAServidor
     */
    public AnalizadorAccesosAServidor()
    {
        listaDeAcceso = new ArrayList<>();
    }

    /**
     * método lee el archivo de log y analiza 
     *      
     */
    public void analizarArchivoDeLog(String nombreLog)
    {
        listaDeAcceso.clear();
        try {
            File archivo = new File(nombreLog);
            Scanner sc = new Scanner(archivo);
            while (sc.hasNextLine()) {                                
                String[] arrayStrings = sc.nextLine().split(" ");
                int año =Integer.parseInt(arrayStrings[0]);
                int mes=Integer.parseInt(arrayStrings[1]);
                int dia=Integer.parseInt(arrayStrings[2]);
                int hora=Integer.parseInt(arrayStrings[3]);
                int min=Integer.parseInt(arrayStrings[4]);
                addAcceso(año ,mes,dia, hora,min);
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * El método muestra por pantalla dicha hora y la devuelve.
     */
    public int obtenerHoraMasAccesos()
    {
        int horaActual = 0;
        int contActual = 0;
        int horaMasAccesos = -1;
        int contMasAccesos = 0;
        if(listaDeAcceso.size()!=0){
            for (int cont = 0; cont < 24; cont++){
                horaActual = cont;
                for (Acceso acceso : listaDeAcceso){
                    if (acceso.getHora() == horaActual){
                        contActual++;
                    }
                }

                if (contActual >= contMasAccesos){
                    contMasAccesos = contActual;
                    horaMasAccesos = horaActual;
                }

                contActual = 0;
            }
            System.out.println("La hora con más accesos es: " + horaMasAccesos); 
        }

        return horaMasAccesos;
    }


    /**
     * introducir Accesos
     */    
    public void addAcceso(int año,int mes, int dia, int hora, int min)
    {
        Acceso nuevoAcceso = new Acceso(año ,mes,dia, hora,min);
        listaDeAcceso.add(nuevoAcceso);                         
    }
}
