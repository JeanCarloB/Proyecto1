/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1.presentation.register;

import com.mycompany.proyecto1.logic.Cliente;
import com.mycompany.proyecto1.logic.Usuario;

/**
 *
 * @author Kevin
 */
public class Model {
    Cliente currentC;
    Usuario current;

    public Model() {
        this.reset();
    }
    
    public void reset(){
        setCurrent(new Usuario());
        setCurrentC(new Cliente());
    }
    
    public Usuario getCurrent() {
        return current;
    }

    public void setCurrent(Usuario current) {
        this.current = current;
    }

    public Cliente getCurrentC() {
        return currentC;
    }

    public void setCurrentC(Cliente currentC) {
        this.currentC = currentC;
    }
    
   
}

