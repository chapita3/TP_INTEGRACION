package Test_paquete;

import java.util.Date;

import modelo.Cliente;

import modelo.Colaborador;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AdministradorTest1
{
    AdministradorTestFixture1 fixture1= new AdministradorTestFixture1();
    
    public AdministradorTest1()
    {
    }

    @Before
    public void setUp() throws Exception
    {
        fixture1.setUp();
    }

    @After
    public void tearDown() throws Exception
    {
        fixture1.tearDown();
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
      * @see modelo.Administrador#solicitarInformeCliente(modelo.Cliente,java.util.Date,java.util.Date)
      */
     @Test
     public void testSolicitarInformeCliente1()
     {
         try
         {
             Cliente c1= new Cliente("Juan","juan@gmail.com","4324234","2121321312","123","grupo1");
             Date d1= new Date(118,9,1);
             Date real1= new Date(118,10,1);
             Date d2= new Date(118,11,1);
             Date real2= new Date(118,10,30);
             long horas= (real2.getTime() - real1.getTime())/3600000;
             double importe= 100;
             String resultado= fixture1.admin.solicitarInformeCliente(c1, d1, d2);
             String mensaje= "Tarea de Servicio | Total horas  | Importe \n" + "Limpiar"+ " " + horas + " " + 100 + "\n" + "\n Importe total: "+ importe;
             assertEquals("Informe incorrecto",mensaje,resultado);
         }
         catch( final Exception e )
         {
             fail("solicitarInformeCliente dispara excepcion");
         }
     }
     
    /**
     * @see modelo.Administrador#solicitarInformeCliente(modelo.Cliente,java.util.Date,java.util.Date)
     */
    @Test
    public void testSolicitarInformeCliente2()
    {
        try
        {
            Cliente c2= new Cliente("Fran","fran@gmail.com","1234234","2134536546","222","grupo1");
            Date d1= new Date(118,9,1);
            Date real1= new Date(118,10,1);
            Date d2= new Date(118,10,15);
            Date real2= new Date(118,10,10);
            long horas= (real2.getTime() - real1.getTime())/3600000;
            double costo= (double) horas * 25;
            String resultado= fixture1.admin.solicitarInformeCliente(c2, d1, d2);
            String mensaje= "Tarea de Servicio | Total horas  | Importe \n" + "Cocinar"+ " " + horas + " " + costo + "\n"+"\n Importe total: "+costo;
            assertEquals("Informe incorrecto",mensaje,resultado);
        }
        catch( final Exception e )
        {
            fail("solicitarInformeCliente dispara excepcion");
        }
    }
    
    /**
     * @see modelo.Administrador#solicitarInformeCliente(modelo.Cliente,java.util.Date,java.util.Date)
     */
    @Test
    public void testSolicitarInformeCliente3() // X < fecha inicio y fecha cierre > Y
    {
        try
        {
            Cliente c1= new Cliente("Juan","juan@gmail.com","4324234","2121321312","123","grupo1");
            Date d1= new Date(118,9,1);
            Date d2= new Date(118,10,20);
            double importe=0;
            String resultado= fixture1.admin.solicitarInformeCliente(c1, d1, d2);
            String mensaje= "Tarea de Servicio | Total horas  | Importe \n"+"\n Importe total: "+importe;
            assertEquals("Informe incorrecto",mensaje,resultado);
        }
        catch( final Exception e )
        {
            fail("solicitarInformeCliente dispara excepcion");
        }
    }
    
    /**
     * @see modelo.Administrador#solicitarInformeCliente(modelo.Cliente,java.util.Date,java.util.Date)
     */
    @Test
    public void testSolicitarInformeCliente4() // tarea abierta
    {
        try
        {
            Cliente c3= new Cliente("Pedro","pedro@gmail.com","1124234","0123212","443","grupo2");
            Date d1= new Date(118,9,1);
            Date d2= new Date();
            double importe=0;
            String resultado= fixture1.admin.solicitarInformeCliente(c3, d1, d2);
            String mensaje= "Tarea de Servicio | Total horas  | Importe \n" + "\n Importe total: " + importe;
            assertEquals("Informe incorrecto",mensaje,resultado);
        }
        catch( final Exception e )
        {
            fail("solicitarInformeCliente dispara excepcion");
        }
    }

     /**
      * @see modelo.Administrador#solicitarInformeColaboradorIntervalo(modelo.Colaborador,java.util.Date,java.util.Date)
      */
     @Test
     public void testSolicitarInformeColaboradorIntervalo1()
     {
         try
         {
             Colaborador col1= new Colaborador("Pilar","pili@gmail.com","111111111","111A","1234","Colaborador");
             Date d1= new Date(118,9,30);
             Date real1=new Date(118,10,1);
             Date d2= new Date(118,11,1);
             Date real2= new Date(118,10,30);
             long horas= (real2.getTime() - real1.getTime())/3600000;
             String resultado= fixture1.admin.solicitarInformeColaboradorIntervalo(col1, d1, d2);
             String mensaje= "Cliente  |  Tarea de servicio  | Total horas\n" + "" + "Juan" + " " + "Limpiar" + " " + horas + "\n";
             assertEquals("Informe incorrecto",mensaje,resultado);
         }
         catch( final Exception e )
         {
             fail("solicitarInformeColaboradorIntervalo dispara excepcion");
         }
     }
     
    /**
     * @see modelo.Administrador#solicitarInformeColaboradorIntervalo(modelo.Colaborador,java.util.Date,java.util.Date)
     */
    @Test
    public void testSolicitarInformeColaboradorIntervalo2()  // X < fecha inicio y fecha cierre > Y
    {
        try
        {
            Colaborador col1= new Colaborador("Pilar","pili@gmail.com","111111111","111A","1234","Colaborador");
            Date d1= new Date(118,9,30);
            Date d2= new Date(118,10,20);
            String resultado= fixture1.admin.solicitarInformeColaboradorIntervalo(col1, d1, d2);
            String mensaje= "Cliente  |  Tarea de servicio  | Total horas\n";
            assertEquals("Informe incorrecto",mensaje,resultado);
        }
        catch( final Exception e )
        {
            fail("solicitarInformeColaboradorIntervalo dispara excepcion");
        }
    }
    
    /**
     * @see modelo.Administrador#solicitarInformeColaboradorIntervalo(modelo.Colaborador,java.util.Date,java.util.Date)
     */
    @Test
    public void testSolicitarInformeColaboradorIntervalo3() //tarea abierta con X < fecha inicio
    {
        try
        {
            Colaborador col3= new Colaborador("Guille","guillote@gmail.com","333333333","333C","5555","Colaborador");
            Date d1= new Date(118,9,30);
            Date real1=new Date(118,10,1);
            Date d2= new Date(118,10,20);
            long horas= (d2.getTime() - real1.getTime())/3600000;
            String resultado= fixture1.admin.solicitarInformeColaboradorIntervalo(col3, d1, d2);
            String mensaje= "Cliente  |  Tarea de servicio  | Total horas\n" + "" + "Pedro" + " " + "Ordenar" + " " + horas + "\n";
            assertEquals("Informe incorrecto",mensaje,resultado);
        }
        catch( final Exception e )
        {
            fail("solicitarInformeColaboradorIntervalo dispara excepcion");
        }
    }
    
    /**
     * @see modelo.Administrador#solicitarInformeColaboradorIntervalo(modelo.Colaborador,java.util.Date,java.util.Date)
     */
    @Test
    public void testSolicitarInformeColaboradorIntervalo4()  // tarea abierta y X < fecha_inicio, y < fecha_inicio
    {
        try
        {
            Colaborador col3= new Colaborador("Guille","guillote@gmail.com","333333333","333C","5555","Colaborador");
            Date d1= new Date(118,9,20);
            Date real1=new Date(118,10,1);
            Date d2= new Date(118,9,30);
            long horas= (d2.getTime() - real1.getTime())/3600000;
            String resultado= fixture1.admin.solicitarInformeColaboradorIntervalo(col3, d1, d2);
            String mensaje= "Cliente  |  Tarea de servicio  | Total horas\n" + "" + "Pedro" + " " + "Ordenar" + " " + horas + "\n";
            assertEquals("Informe incorrecto",mensaje,resultado);
        }
        catch( final Exception e )
        {
            fail("solicitarInformeColaboradorIntervalo dispara excepcion");
        }
    }

     /**
      * @see modelo.Administrador#solicitarTareasEnCursoColaboradores()
      */
     @Test
     public void testSolicitarTareasEnCursoColaboradores1() // todos
     {
         try
         {
             Date real1= new Date(118,10,1);
             Date d2= new Date();
             long horas= (d2.getTime() - real1.getTime())/3600000;
             String resultado= fixture1.admin.solicitarTareasEnCursoColaboradores(true, null);
             String m1= "Guille" + " " + "Pedro" + " " + "Ordenar" + " " + real1 + " " + "abierta" + " " + horas + "\n";
             String m2= "Leonel" + " " + "Fran" + " " + "Cocinar" + " " + real1 + " " + "abierta" + " " + horas + "\n";
             String mensaje= " Colaborador   |   Cliente  | Servicio  | Inicio    | Estado    | Horas accumuladas | \n" + m1 + m2;
             assertEquals("Informe incorrecto",mensaje,resultado);
         }
         catch( final Exception e )
         {
             fail("solicitarTareasEnCursoColaboradores dispara excepcion");
         }
     }
     
    /**
     * @see modelo.Administrador#solicitarTareasEnCursoColaboradores()
     */
    @Test
    public void testSolicitarTareasEnCursoColaboradores2() //un colaborador
    {
        try
        {
            Date real1= new Date(118,10,1);
            Date d2= new Date();
            long horas= (d2.getTime() - real1.getTime())/3600000;
            String resultado= fixture1.admin.solicitarTareasEnCursoColaboradores(false,fixture1.colaboradores.get(2));
            String m1= "Guille" + " " + "Pedro" + " " + "Ordenar" + " " + real1 + " " + "abierta" + " " + horas + "\n";
            String mensaje= " Colaborador   |   Cliente  | Servicio  | Inicio    | Estado    | Horas accumuladas | \n" + m1;
            assertEquals("Informe incorrecto",mensaje,resultado);
        }
        catch( final Exception e )
        {
            fail("solicitarTareasEnCursoColaboradores dispara excepcion");
        }
    }
    
    /**
     * @see modelo.Administrador#solicitarTareasEnCursoColaboradores()
     */
    @Test
    public void testSolicitarTareasEnCursoColaboradores3() // colaborador null
    {
        try
        {
            Date real1= new Date(118,10,1);
            Date d2= new Date();
            long horas= (d2.getTime() - real1.getTime())/3600000;
            String resultado= fixture1.admin.solicitarTareasEnCursoColaboradores(false,null);
            fail("No dispara excepcion por colaborador null");
        }
        catch( final Exception e )
        {
            fail("solicitarTareasEnCursoColaboradores no contempla excepcion por colaborador null");
        }
    }
    
    /**
     * @see modelo.Administrador#solicitarTareasEnCursoColaboradores()
     */
    @Test
    public void testSolicitarTareasEnCursoColaboradores4() // colaborador no registrado en bdd
    {
        try
        {
            Date real1= new Date(118,10,1);
            Date d2= new Date();
            long horas= (d2.getTime() - real1.getTime())/3600000;
            String resultado= fixture1.admin.solicitarTareasEnCursoColaboradores(false,new Colaborador("p","as","1243","000xx","123","Colaborador"));
            String mensaje= " Colaborador   |   Cliente  | Servicio  | Inicio    | Estado    | Horas accumuladas | \n";
            assertEquals("Informe incorrecto",mensaje,resultado);
        }
        catch( final Exception e )
        {
            fail("solicitarTareasEnCursoColaboradores dispara excepcion");
        }
    }

     /**
      * @see modelo.Administrador#crearTarea(modelo.Servicio,modelo.Cliente,modelo.Colaborador)
      */
     @Test
     public void testCrearTarea1()
     {
         try
         {
             int old=fixture1.colaboradores.get(4).getTareas().size();
             fixture1.admin.crearTarea(fixture1.admin.getBdd().getServicios().get(0), fixture1.clientes.get(3), fixture1.colaboradores.get(4));
             assertTrue("No se crea la tarea",fixture1.admin.getBdd().getColaboradores().get(2).getTareas().size()==old+1);
         }
         catch( final Exception e )
         {
             fail("crearTarea lanza excepcion");
         }
     }
     
    /**
     * @see modelo.Administrador#crearTarea(modelo.Servicio,modelo.Cliente,modelo.Colaborador)
     */
    @Test
    public void testCrearTarea2()
    {
        int old=fixture1.colaboradores.get(2).getTareas().size();
        try
        {
            fixture1.admin.crearTarea(fixture1.admin.getBdd().getServicios().get(0), fixture1.admin.getBdd().getClientes().get(2), fixture1.colaboradores.get(2));
            fail("No lanza excepcion por tarea abierta existente");
        }
        catch( final Exception e )
        {
            String mensaje= "No se puede crear una nueva tarea si hay una abierta previamente";
            assertEquals("No lanza excepcion correcta",mensaje,e.getMessage());
        }
    }

     /**
      * @see modelo.Administrador#eliminarTarea(modelo.Tarea,modelo.Colaborador)
      */
     @Test
     public void testEliminarTarea()
     {
         try
         {
             Colaborador c=fixture1.colaboradores.get(1);
             int old= c.getTareas().size();
             fixture1.admin.eliminarTarea(c.getTareas().get(fixture1.clientes.get(1)), c);
             assertTrue("No se elimina la tarea",c.getTareas().size()==old-1);
         }
         catch( final Exception e )
         {
             fail("eliminarTarea lanza excepcion");
         }
     }

     /**
      * @see modelo.Administrador#cerrarTarea(modelo.Tarea,modelo.Colaborador)
      */
     @Test
     public void testCerrarTarea()
     {
         try
         {
             fixture1.admin.cerrarTarea(fixture1.tareas.get(2), fixture1.colaboradores.get(2));
             assertEquals("No se cierra la tarea","cerrada",fixture1.tareas.get(2).getEstado().devolverestado());
         }
         catch( final Exception e )
         {
             fail("cerrarTarea lanza excepcion");
         }
     }

     /**
      * @see modelo.Administrador#pausarTarea(modelo.Tarea,modelo.Colaborador)
      */
     @Test
     public void testPausarTarea()
     {
         try
         {
             fixture1.admin.pausarTarea(fixture1.tareas.get(3), fixture1.colaboradores.get(3));
             assertEquals("No se pausa la tarea","pausada",fixture1.tareas.get(3).getEstado().devolverestado());
         }
         catch( final Exception e )
         {
             fail("pausarTarea lanza excepcion");
         }
     }

     /**
      * @see modelo.Administrador#reanudarTarea(modelo.Tarea,modelo.Colaborador)
      */
     @Test
     public void testReanudarTarea1()
     {
         try
         {
             fixture1.admin.reanudarTarea(fixture1.tareas.get(3), fixture1.colaboradores.get(3));
             assertEquals("No se reaunda la tarea","abierta",fixture1.tareas.get(3).getEstado().devolverestado());
         }
         catch( final Exception e )
         {
             fail("reanudarTarea lanza excepcion");
         }
     }
}
