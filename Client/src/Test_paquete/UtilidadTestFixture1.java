package Test_paquete;


import modelo.Administrador;
import modelo.Utilidad;

public class UtilidadTestFixture1
{
    Utilidad utilidad=Utilidad.getUtilidad();;
    public UtilidadTestFixture1()
    {
    }

    public void setUp()
    {
       Administrador admin=this.utilidad.getBdd().getAdmin();   
        admin.crearColaborador("c1", "email", "telefono", "id", "123","a");
        admin.crearColaborador("c2", "email", "telefono", "id2", "contrasena","b");
        admin.crearColaborador("c3", "email", "telefono", "id3", "contrasena","c");
    }

    public void tearDown()
    {
        this.utilidad.getBdd().getColaboradores().clear();
    }
}
