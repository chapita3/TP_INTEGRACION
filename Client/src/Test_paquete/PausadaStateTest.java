package Test_paquete;

import org.junit.After;
import org.junit.Assert;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

public class PausadaStateTest
{
    PausadaStateTestFixture fixture=new PausadaStateTestFixture();
    public PausadaStateTest()
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
    @Test
    public void testAbrir()
    {
        try
        {
            this.fixture.t1.getEstado().abrir();
            Assert.assertEquals("El estado debe ser Pausado ", this.fixture.t1.getEstado().devolverestado(),"abierta");
        }
        catch(final Exception e)
        {
            fail("Crear una tarea nueva dispara excepcion");
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
            Assert.assertEquals("Deberia tenes este msj", this.fixture.t1.getEstado().devolverestado(),"pausada");
        }
        catch(Exception e)
        {
            fail("Crear una tarea nueva dispara excepcion");
        }
        
    }
}