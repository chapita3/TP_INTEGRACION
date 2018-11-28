package Test_paquete;

import java.util.ArrayList;

import modelo.Administrador;
import modelo.BaseDeDatos;
import modelo.Cliente;
import modelo.Colaborador;
import modelo.GrupoClientes;
import modelo.Servicio;

public class AdministradorTestFixture3
{
    public Administrador admin=new Administrador();
    
    public AdministradorTestFixture3()
    {
        this.admin.setBdd(new BaseDeDatos());
    }

    public void setUp()
    {
        this.admin.getBdd().setAdmin(admin);
        Cliente c1= new Cliente("Juan","juan@gmail.com","4324234","2121321312","123","grupo1");
        this.admin.getBdd().getClientes().add(c1);
        Servicio s1= new Servicio("Limpiar","Fijo",100);
        this.admin.getBdd().getServicios().add(s1);
        Colaborador col1= new Colaborador("Pilar","pili@gmail.com","111111111","111A","1234","Colaborador");
        this.admin.getBdd().getColaboradores().add(col1);
        GrupoClientes g1=new GrupoClientes();
        g1.setNombre("grupo1");
        this.admin.getBdd().getGrupos().add(g1);
    }

    public void tearDown()
    {
        this.admin.getBdd().getClientes().clear();
        this.admin.getBdd().getColaboradores().clear();
        this.admin.getBdd().getGrupos().clear();
        this.admin.getBdd().getServicios().clear();
    }
}
