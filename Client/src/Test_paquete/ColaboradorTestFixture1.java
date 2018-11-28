package Test_paquete;

import java.util.ArrayList;

import java.util.Date;

import modelo.Administrador;
import modelo.BaseDeDatos;
import modelo.CerradaState;
import modelo.Cliente;
import modelo.Colaborador;
import modelo.HayTareaAbiertaException;
import modelo.PausadaState;
import modelo.Servicio;
import modelo.Tarea;
import modelo.TareaRepetidaException;

public class ColaboradorTestFixture1
{
    public Administrador admin=new Administrador();
    public Colaborador colab=new Colaborador();
    public Colaborador colab1=new Colaborador("Pilar","Pilar@gmail.com","4567893","12332","svhbjdlk","Colaborador");
    public Colaborador colab2=new Colaborador("Guillermo","Guille@gmail.com","67890","4r567890","s4e5r68t79uo","Colaborador");
    public Colaborador colab3=new Colaborador("Oscar","Oscar@gmail.com","23456","765123","bg3yvr8","Colaborador");
    public Colaborador colab4=new Colaborador("Gustavo","Gustavo@gmail.com","094582","095456789","wg0wr3389","Colaborador");
    public BaseDeDatos bdd=new BaseDeDatos();
    public ArrayList<Tarea> tareas=new ArrayList<Tarea>();
    
    public ColaboradorTestFixture1()
    {
    }

    public void setUp() throws HayTareaAbiertaException, TareaRepetidaException
    {
        this.bdd.setAdmin(admin);
        Cliente cli1=new Cliente("Juan","juan@gmail.com","4324234","2121321312","123","grupo1");
        Cliente cli2=new Cliente("Fran","fran@gmail.com","1234234","2134536546","222","grupo3");
        Cliente cli3=new Cliente("Nico","nico@gmail.com","54354234","12111112","333","grupo2");
        Cliente cli4=new Cliente("Pedro","pedro@gmail.com","1124234","0123212","443","grupo2");
        Cliente cli5=new Cliente("Watson","Watson@gmail.com","34567","43902","52c52","grupo1");
        Cliente cli6=new Cliente("Lucrecia","Lucrecia@gmail.com","345234","434231","524455","grupo1");
        Cliente cli7=new Cliente("Jeremias","Jeremias@gmail.com","4567890","12908","09876545","grupo2");
        Cliente cli8=new Cliente("Claudio","Claudio@gmail.com","45678","54345","657828i","grupo3");
        Cliente cli9=new Cliente("Adolfo","adolfo@gmail.com","345678","655432","4r3r21","grupo2");
        this.bdd.getClientes().add(cli1);
        this.bdd.getClientes().add(cli2);
        this.bdd.getClientes().add(cli3);
        this.bdd.getClientes().add(cli4);
        this.bdd.getClientes().add(cli5);
        this.bdd.getClientes().add(cli6);
        this.bdd.getClientes().add(cli7);
        this.bdd.getClientes().add(cli8);
        this.bdd.getClientes().add(cli9);
        Servicio s1=new Servicio("Limpiar","Porhora",52);
        Servicio s2=new Servicio("Cocinar","Fijo",100);
        Servicio s3=new Servicio("Barrer","Fijo",150);
        Servicio s4=new Servicio("Barrer","Fijo",150);
        Servicio s5=new Servicio("Investigar","Fijo",5200);
        Servicio s6=new Servicio("Rellenar","Porhora",52);
        Servicio s7=new Servicio("Procesar","Fijo",1000);
        Servicio s8=new Servicio("Transportar","Fijo",1500);
        Servicio s9=new Servicio("Pasear","Porhora",89);
        this.bdd.getServicios().add(s1);
        this.bdd.getServicios().add(s2);
        this.bdd.getServicios().add(s3);
        this.bdd.getColaboradores().add(colab);
        this.bdd.getColaboradores().add(colab1);
        this.bdd.getColaboradores().add(colab2);
        this.bdd.getColaboradores().add(colab3);
        this.bdd.getColaboradores().add(colab4);
        Tarea t1=new Tarea(s5,cli5,colab);
        Tarea t2=new Tarea(s6,cli6,colab);
        Tarea t3=new Tarea(s7,cli7,colab);
        Tarea t4=new Tarea(s8,cli8,colab);
        Tarea t5=new Tarea(s9,cli9,colab);
        Tarea t6=new Tarea(s1,cli1,colab1);
        this.tareas.add(t1);
        this.tareas.add(t2);
        this.tareas.add(t3);
        this.tareas.add(t4);
        this.tareas.add(t5);
        this.colab.crearTarea(s8, cli8);
        //this.colab.cerrarTarea(this.colab.getTareas().get(cli8));
        this.colab.getTareas().get(cli8).setFechacierre(new Date(118,10,20));
        this.colab.getTareas().get(cli8).setEstado(new CerradaState(this.colab.getTareas().get(cli8)));
        this.colab.setTareaActiva(false);
        this.colab.getTareas().get(cli8).setFechainicio(new Date(118,10,1));
        this.colab.crearTarea(s9, cli9);
        //this.colab.cerrarTarea(this.colab.getTareas().get(cli9));
        this.colab.getTareas().get(cli9).setFechacierre(new Date(118,10,30));
        this.colab.getTareas().get(cli9).setEstado(new CerradaState(this.colab.getTareas().get(cli9)));
        this.colab.setTareaActiva(false);
        this.colab.getTareas().get(cli9).setFechainicio(new Date(118,10,1));
        this.colab.crearTarea(s7,cli7);
        this.colab.pausarTarea(this.colab.getTareas().get(cli7));
        this.colab.crearTarea(s5,cli5);
        this.colab.getTareas().get(cli5).setFechainicio(new Date(118,10,1));
        //this.colab.crearTarea(s6,cli6);
        this.colab1.crearTarea(s1,cli1);
        //this.colab1.cerrarTarea(this.colab1.getTareas().get(cli1));
        this.colab1.getTareas().get(cli1).setFechacierre(new Date(118,10,10));
        this.colab1.getTareas().get(cli1).setEstado(new CerradaState(this.colab1.getTareas().get(cli1)));
        this.colab1.setTareaActiva(false);
        this.colab1.getTareas().get(cli1).setFechainicio(new Date(118,10,1));
        this.colab1.crearTarea(s5,cli5);
        this.colab2.crearTarea(s7,cli7);
        this.colab2.pausarTarea(this.colab2.getTareas().get(cli7));
        this.colab2.getTareas().get(cli7).setFechainicio(new Date(118,10,1));
    }

    public void tearDown()
    {
        this.bdd.getClientes().clear();
        this.bdd.getGrupos().clear();
        this.bdd.getServicios().clear();
        this.bdd.getColaboradores().clear();
        this.tareas.clear();
    }
}
