package Test_paquete;


import org.junit.After;
import org.junit.Assert;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

public class CerradaStateTest
{
    CerradaStateTestFixture1 fixture=new CerradaStateTestFixture1();
    public CerradaStateTest()
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
     * @see CerradaState#devolverestado()
     */
    @Test
    public void testDevolverestado()
        {
            try
            {
                Assert.assertEquals("Deberia tenes este msj", this.fixture.t1.getEstado().devolverestado(),"cerrada");
            }
            catch(Exception e)
            {
                fail("Crear una tarea nueva dispara excepcion");
            }
            
        }
}