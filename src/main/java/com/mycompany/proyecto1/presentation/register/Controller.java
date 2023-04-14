/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1.presentation.register;

/**
 *
 * @author Kevin
 */

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterController", urlPatterns = {"/presentation/register/show"})
public class Controller extends HttpServlet {

  protected void processRequest(HttpServletRequest request, 
                                HttpServletResponse response)
         throws ServletException, IOException {
      
        request.setAttribute("model", new Model()); 
        
        String viewUrl="";
        switch(request.getServletPath()){
            case "/presentation/register/show":
                viewUrl=this.show(request);
                break;              
            
        }
        request.getRequestDispatcher(viewUrl).forward( request, response); 
  }
  
    public String show(HttpServletRequest request){
            return this.showAction(request);
        }

    public String showAction(HttpServletRequest request){
        return "/presentation/register/View.jsp"; 
    }   
}