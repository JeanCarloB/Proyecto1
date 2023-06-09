/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1.data;

import com.mycompany.proyecto1.logic.Modelo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ribre
 */
public class ModeloDao {
    RelDatabase db;

    public ModeloDao(RelDatabase db) {
        this.db = db;
    }
    
    public List<Modelo> findModelos() {
        List<Modelo> resultado = new ArrayList<>();
        try {
            String sql = "select * "
                    + "from "
                    + "Modelo e ";
            PreparedStatement stm = db.prepareStatement(sql);
            ResultSet rs = db.executeQuery(stm);
            while (rs.next()) {
                resultado.add(from(rs, "e"));
            }
        } catch (SQLException ex) {
        }
        return resultado;
    }
    
    public Modelo from(ResultSet rs, String alias) {
        try {
            Modelo e = new Modelo();
            e.setId(rs.getInt(alias + ".id"));
            e.setDescripcion(rs.getString(alias + ".descripcion"));
            return e;
        } catch (SQLException ex) {
            return null;
        }
    }

    public List<Modelo> readByMarca(Integer numero) {
       List<Modelo> resultado = new ArrayList<>();
        try {
            String sql = "select * "
                    + "from "
                    + "Modelo e "
                    + "where e.marca=?";
            PreparedStatement stm = db.prepareStatement(sql);
            stm.setString(1, ""+numero);
            ResultSet rs = db.executeQuery(stm);
            while (rs.next()) {
                resultado.add(from(rs, "e"));
            }
        } catch (SQLException ex) {
        }
        return resultado;
    }
}
