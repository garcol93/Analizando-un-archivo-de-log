
/**
 * Write a description of class Acceso here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Acceso
{
    private int año;
    private int mes; 
    private int dia;
    private int hora;
    private int min;
    private int numeroAccesos;
    /**
     * Constructor for objects of class Acceso
     */
    public Acceso(int año,int mes, int dia, int hora, int min)
    {
        this.año= año;
        this.mes= mes;
        this.dia=dia;
        this.hora=hora;
        this.min=min;
        numeroAccesos=0;
    }  

    /**
     * devuelve hora
     */
    public int getHora()
    {
        return hora;
    }

    /**
     * aumentar numero Acceso
     */
    public void aumentarAcceso()
    {
        numeroAccesos++;
    }
}
