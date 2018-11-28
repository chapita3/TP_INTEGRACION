package Test_paquete;

import java.util.Date;

import modelo.Tarea;

import org.junit.After;
import org.junit.Assert;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

public class AbiertaStateTest
{
    AbiertaStateTestFixture1 fixture=new AbiertaStateTestFixture1();
    public AbiertaStateTest()
    {
    }

    @Before
    public void setUp() throws Exception
    {
        this.fixture.setUp();
    }

    @After
    public void tearDown() throws Exception
    {
    }

    /**
     * @see AbiertaState#abrir()
     */
   

    /**
     * @see AbiertaState#pausado()
     */
    @Test
    public void testPausado()
    {
        try
        {
            this.fixture.t1.getEstado().pausado();
            System.out.print(this.fixture.t1.getEstado().devolverestado());
            Assert.assertTrue("El estado debe ser Pausado ", this.fixture.t1.getEstado().devolverestado().equals("pausada"));
        }
        catch(final Exception e)
        {
            fail("Crear una tarea nueva dispara excepcion "+e.getMessage());
        }
    }

    /**
     * @see AbiertaState#cerrar()
     */
    @Test
    public void testCerrar()
    { 
        try
        {
            this.fixture.t1.getEstado().cerrar();
            Date d=new Date();
            Tarea t = (Tarea) this.fixture.t1;
            long horas= (d.getTime() - t.getFechacierre().getTime())/3600000;
            Assert.assertTrue("El estado debe ser Pausado "+horas,horas<3);
            Assert.assertEquals("El estado debe ser Pausado ", this.fixture.t1.getEstado().devolverestado(),"cerrada");
        }
        catch(final Exception e)
        {
            fail("Crear una tarea nueva dispara excepcion");
        }
    }

    /**
     * @see AbiertaState#devolverestado()
     */
    @Test
    public void testDevolverestado()
    {
        try
        {
            Assert.assertEquals("Deberia tenes este msj", this.fixture.t1.getEstado().devolverestado(),"abierta");
        }
        catch(Exception e)
        {
            fail("Crear una tarea nueva dispara excepcion");
        }
        
    }
}