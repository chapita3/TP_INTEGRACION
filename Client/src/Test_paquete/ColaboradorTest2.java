package Test_paquete;

import java.util.Date;

import modelo.Cliente;
import modelo.Colaborador;
import modelo.Servicio;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.JUnitCore;

public class ColaboradorTest2
{
    ColaboradorTestFixture2 fixture2=new ColaboradorTestFixture2();
    public ColaboradorTest2()
    {
    }

    public static void main(String[] args)
    {
        String[] args2 = { ColaboradorTest2.class.getName() };
        JUnitCore.main(args2);
    }

    @Before
    public void setUp() throws Exception
    {
        this.fixture2.setUp();
    }

    @After
    public void tearDown() throws Exception
    {
        this.fixture2.tearDown();
    }

    @BeforeClass
    public static void setUpBeforeClass() throws Exception
    {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception
    {
    }

     /**
      * @see modelo.Colaborador#crearTarea(modelo.Servicio,modelo.Cliente)
      */
     @Test
     public void testCrearTarea1()
     {
         try
         {
             int size=this.fixture2.colab.getTareas().size();
             this.fixture2.colab.crearTarea(new Servicio("Limpiar","tipoA",52),new Cliente("Juan","juan@gmail.com","4324234","2121321312","123","grupo1"));
             assertTrue("No se agregó la tarea",size+1==this.fixture2.colab.getTareas().size());
         }
         catch(final Exception e)
         {
             fail("Crear una tarea nueva dispara excepcion");
         }
     }
    
    /**
     * @see modelo.Colaborador#solicitarITareasIntervalo(java.util.Date,java.util.Date)
     */
    @Test
    public void testSolicitarITareasIntervalo1()
    {
        try
        {
            Date d1= new Date(2018,10,1);
            Date d2= new Date(2018,10,30);
            long horas= (d2.getTime() - d1.getTime())/3600000;
            String resultado=this.fixture2.colab.solicitarITareasIntervalo(d1, d2);
            String mensaje="";
            //String mensaje= /*"Cliente  |  Tarea de servicio  | Total horas\n" +*/ "Juan" + " " + "Limpiar" + " " + horas + "\n";
            assertEquals("Informe incorrecto",resultado,mensaje);
            fail("No lanza excepcion por lista vacia");
        }
        catch( final Exception e )
        {
            //fail("solicitarInformeColaboradorIntervalo dispara excepcion");
        }
    }

    /**
     * @see modelo.Colaborador#solicitarITareasIntervaloCliente(modelo.Cliente,java.util.Date,java.util.Date)
     */
    @Test
    public void testSolicitarITareasIntervaloCliente1()
    {
        try
        {
            Cliente c1=new Cliente("Watson","Watson@gmail.com","34567","43902","52c52","grupo1");
            Date d1= new Date(2018,10,1);
            Date d2= new Date(2018,10,20);
            long horas= (d2.getTime() - d1.getTime())/3600000;
            String resultado= fixture2.colab.solicitarITareasIntervaloCliente(c1, d1, d2,0);
            String mensaje="";
            //String mensaje=/* "Tarea de Servicio | Total horas  | Importe \n" + */"Investigar"+ " " + horas + " " + 5200 + "\n";
            assertEquals("Informe incorrecto",resultado,mensaje);
            fail("No lanza excepcion por lista vacia");
        }
        catch( final Exception e )
        {
            //fail("solicitarInformeCliente dispara excepcion por lista vacia");
        }
    }
    
    /**
     * @see modelo.Colaborador#solicitarITareasEstadoIntervalo(String,java.util.Date,java.util.Date)
     */
    @Test
    public void testSolicitarITareasEstadoIntervalo1()
    {
        try
        {
            String resp = "Cliente  |  Tarea de Servicio  |  Inicio  |  Estado  |  Horas Acumuladas\n";
            Date d1= new Date(2018,10,1);
            Date d2= new Date(2018,10,20);
            String mensaje=this.fixture2.colab.solicitarITareasEstadoIntervalo("cerrada", d1, d2);
            long horas=(d2.getTime()-d1.getTime())/3600000;
            //resp+=this.fixture2.tareas.get(3).getCliente()+" "+fixture2.tareas.get(3).getServicio().getDescripcion()+" "+fixture1.tareas.get(3).getFechainicio()+" "+fixture1.tareas.get(3).getEstado().devolverestado()+" ";
            assertEquals("Informe incorrecto",resp,mensaje);
            fail("No lanza excepcion por lista de tareas vacias");
        }
        catch(final Exception e)
        {
            //fail("Dispara excepción por lista de tareas vacia");
        }
    }

    /**
     * @see modelo.Colaborador#solicitarITareasEnCurso()
     */
    @Test
    public void testSolicitarITareasEnCurso()
    {
        try
        {
            String resultado=this.fixture2.colab.solicitarITareasEnCurso();
            String mensaje="";
            assertEquals("Informe Incorrecto", mensaje,resultado);   
            fail("No dispara excepcion por lista de tareas vacia");
        }
        catch(final Exception e)
        {
        }
    }
}
