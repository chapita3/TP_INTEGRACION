package Test_paquete;

import modelo.Administrador;
import modelo.BaseDeDatos;

public class AdministradorTestFixture2
{
    public Administrador admin=new Administrador();
    
    public AdministradorTestFixture2()
    {
        this.admin.setBdd(new BaseDeDatos());
    }

    public void setUp()
    {
        this.admin.getBdd().setAdmin(admin);
        this.admin.getBdd().getClientes().clear();
        this.admin.getBdd().getColaboradores().clear();
        this.admin.getBdd().getGrupos().clear();
        this.admin.getBdd().getServicios().clear();
    }

    public void tearDown()
    {
        this.admin.getBdd().getClientes().clear();
        this.admin.getBdd().getColaboradores().clear();
        this.admin.getBdd().getGrupos().clear();
        this.admin.getBdd().getServicios().clear();
    }
}
