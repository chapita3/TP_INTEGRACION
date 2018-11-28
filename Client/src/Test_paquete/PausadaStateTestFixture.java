package Test_paquete;


import modelo.Cliente;
import modelo.Colaborador;
import modelo.PausadaState;
import modelo.Servicio;
import modelo.Tarea;

public class PausadaStateTestFixture 
{
    Colaborador colab=new Colaborador();
    Tarea t1;
    public PausadaStateTestFixture()
    {
    }

    public void setUp()
    {
        this. t1=new Tarea(new Servicio("Investigar","Fijo",5200),new Cliente("Watson","Watson@gmail.com","34567","43902","52c52","grupo1"),colab);
        this.t1.setEstado(new PausadaState(t1));
    }

    public void tearDown()
    {
    }
}