<%-- 
    Document   : View
    Created on : Apr 13, 2023, 7:08:29 PM
    Author     : Kevin
--%>
<%@page import="com.mycompany.proyecto1.presentation.register.Model"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head> 
         <meta charset="UTF-8">
  <title>Formulario</title>
  <link rel="stylesheet" href="style.css">
        <%@ include file="/presentation/Head.jsp" %>
   </head> 
    <body >

        <%@ include file="/presentation/Header.jsp" %>
        
        <% Model model= (Model) request.getAttribute("model"); %>
        <% Map<String,String> errores = (Map<String,String>) request.getAttribute("errores"); %>
        <% Map<String,String[]> form = (errores==null)?this.getForm(model):request.getParameterMap();%>

        <form method="POST" action="presentation/register/create">
  <div class="fila">
    <label for="cedula">Cédula:</label>
    <input class="<%=erroneo("cedulaFld",errores)%>" type="text" id="cedula" 
           name="cedulaFld" value="<%=form.get("cedulaFld")[0]%>" title="<%=title("cedulaFld",errores)%>">
  </div>

  <div class="fila">
    <label for="nombre">Nombre:</label>
    <input class="<%=erroneo("nombreFld",errores)%>" type="text" id="nombre" 
           name="nombreFld" value="<%=form.get("nombreFld")[0]%>" title="<%=title("nombreFld",errores)%>">
  </div>

  <div class="fila">
    <label for="telefono">Teléfono:</label>
    <input class="<%=erroneo("telefonoFld",errores)%>" type="text" id="telefono" 
           name="telefonoFld" value="<%=form.get("telefonoFld")[0]%>" title="<%=title("telefonoFld",errores)%>">
  </div>

  <div class="fila">
    <label for="correo">Correo:</label>
    <input class="<%=erroneo("correoFld",errores)%>" type="email" id="correo" 
           name="correoFld" value="<%=form.get("correoFld")[0]%>" title="<%=title("correoFld",errores)%>">
  </div>

  <div class="fila">
    <label for="tarjeta">Tarjeta:</label>
    <input class="<%=erroneo("tarjetaFld",errores)%>" type="text" id="tarjeta" 
           name="tarjetaFld" value="<%=form.get("tarjetaFld")[0]%>" title="<%=title("tarjetaFld",errores)%>">
  </div>

  <div class="fila">
    <label for="clave">Contraseña:</label>
    <input class="<%=erroneo("claveFld",errores)%>" type="text" id="clave" 
           name="claveFld" value="" title="<%=title("claveFld",errores)%>">
  </div>

  <div class="fila">
    <label for="admin">¿Es admin?</label>
    <input type="checkbox" id="admin" 
           name="adminFld" value="true">
  </div>

  <div class="fila">
    <button type="submit">Enviar</button>
    <button type="reset">Limpiar</button>
  </div>
</form>
        <%@ include file="/presentation/Footer.jsp" %>                  
    </body>
</html>

<%!
    private String erroneo(String campo, Map<String,String> errores){
      if ( (errores!=null) && (errores.get(campo)!=null) )
        return "is-invalid";
      else
        return "";
    }

    private String title(String campo, Map<String,String> errores){
      if ( (errores!=null) && (errores.get(campo)!=null) )
        return errores.get(campo);
      else
        return "";
    }

    private Map<String,String[]> getForm(Model model){
       Map<String,String[]> values = new HashMap<>();
       model.reset();
       values.put("cedulaFld", new String[]{model.getCurrent().getCedula()});
       values.put("nombreFld", new String[]{model.getCurrent().getNombre()});
       values.put("telefonoFld", new String[]{model.getCurrent().getTelefono()});
       values.put("correoFld", new String[]{model.getCurrent().getCorreo()});
       values.put("tarjetaFld", new String[]{model.getCurrent().getTarjeta()});
       values.put("claveFld", new String[]{model.getCurrent().getUsuario().getClave()});
       
       return values;
    }
%> 