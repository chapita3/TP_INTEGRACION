package Test_paquete;

import modelo.AbiertaState;
import modelo.CerradaState;
import modelo.Cliente;
import modelo.Colaborador;
import modelo.Servicio;
import modelo.Tarea;

public class CerradaStateTestFixture1
{
    Colaborador colab=new Colaborador();
    Tarea t1;
    public CerradaStateTestFixture1()
    {
    }

    public void setUp()
    {
        this. t1= new Tarea(new Servicio("Investigar", "Fijo", 5200),
                              new Cliente("Watson", "Watson@gmail.com", "34567", "43902", "52c52", "grupo1"), colab);
        t1.setEstado(new AbiertaState(t1));
        t1.setEstado(new CerradaState(t1));
       
    }

    public void tearDown()
    {
    }
}