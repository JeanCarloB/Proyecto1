/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1.logic;

import com.mycompany.proyecto1.data.ClienteDao;
import com.mycompany.proyecto1.data.PolizaDao;
import com.mycompany.proyecto1.data.RelDatabase;
import com.mycompany.proyecto1.data.UsuarioDao;
import java.util.List;

/**
 *
 * @author ribre
 */
public class Service {
    private static Service uniqueInstance;
    
    public static Service instance(){
        if (uniqueInstance == null){
            uniqueInstance = new Service();
        }
        return uniqueInstance; 
    }
    RelDatabase relDatabase;
    UsuarioDao usuarioDao;
    ClienteDao clienteDao;
    PolizaDao polizaDao;
    
    
    
    //    HashMap<String,Usuario> usuarios;
//    HashMap<String,Cliente> clientes;
//    HashMap<String,Poliza> polizas;
//    HashMap<String,List<String>> favoritas;

    private Service(){
        relDatabase = new RelDatabase();
        usuarioDao = new UsuarioDao(relDatabase);
        clienteDao = new ClienteDao(relDatabase);
        polizaDao = new PolizaDao(relDatabase);
        
        //        usuarios = new HashMap();
//        usuarios.put("111", new Usuario("111","111",1));
//        usuarios.put("222", new Usuario("222","222",1));
//        usuarios.put("333", new Usuario("333","333",2));
//        
//        clientes = new HashMap(); 
//        clientes.put("111", new Cliente("111","J.Perez",usuarios.get("111")));
//        clientes.put("222", new Cliente("222","B.Banner",usuarios.get("222")));
//        clientes.put("333", new Cliente("333","L.Kjero",usuarios.get("333")));
//        
//        polizas = new HashMap(); 
//        polizas.put("1-111-11", new Poliza("1-111-11",100.0,clientes.get("111")));
//        polizas.put("1-222-22", new Poliza("1-222-22",200.0,clientes.get("111")));        
//        polizas.put("2-111-11", new Poliza("2-111-11",150.0,clientes.get("222")));
//
//        //HashMap<String,List<String>> favoritas;
//        favoritas = new HashMap(); 
//        favoritas.put("111", Arrays.asList(new String[]{"2-111-11"}));
//        favoritas.put("222", Arrays.asList(new String[]{"1-111-11","1-222-22"}));
}
    public Usuario usuarioFind(String cedula, String clave) throws Exception {
    Usuario usuario = usuarioDao.read(cedula);
    if (usuario.getClave().equals(clave)) {
        return usuario;
    } else {
        return null;
    }
}

    
    public Cliente clienteFind(Usuario usuario) throws Exception{
        return clienteDao.read(usuario.getCedula());
    }
    public List<Poliza> cuentasFind(Cliente cliente) throws Exception{
        List<Poliza> polizas = polizaDao.findByCliente(cliente);
        for(Poliza e:polizas) e.setCliente(cliente);
        cliente.setPolizas(polizas);
        return polizas;
    }
    
    public void clienteUpdate(Cliente cliente) throws Exception{
        clienteDao.update(cliente);
    }
     public Poliza polizaFind(String numero) throws Exception{
        return polizaDao.read(numero);
    } 
    
     public void clienteCreate(Cliente cliente) throws Exception{
       clienteDao.create(cliente);
     }
     
     public void usuarioCreate(Usuario usuario) throws Exception{
       usuarioDao.create(usuario);
     }
}
