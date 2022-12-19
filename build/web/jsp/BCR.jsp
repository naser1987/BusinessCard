<%-- 
    Document   : newjsp
    Created on : Dec 16, 2022, 11:32:42 PM
    Author     : Naser
--%>

<%@page import="model.BusinessCard"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Business Card Details</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="css/Style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="img">
            <img src="images/Business.png" alt=""/>
        </div>
        <%
            BusinessCard bc = (BusinessCard) request.getAttribute("BCR");
        %>
        <form action="Cont" method="post" >
            <input type="hidden" name="cmd" value="BCU"/>
            <input type="hidden" name="id" value="<%=bc.getId()%>"/>
            <div >
                <table class='btntab table table-hover table-dark'>
                    <tr>
                        <th>Name</th>
                        <td><input type="text" name="name" value="<%= bc.getName()%> "/> </td>
                    </tr>
                    <tr>
                        <th>Telephone</th>
                        <td><input type="text" name="tel" value="<%= bc.getTel()%> "/></td>
                    </tr>
                    <tr>
                        <th>Email</th>
                        <td><input type="text" name="email" value="<%= bc.getEmail()%> "/></td>
                    </tr>
                    <tr>
                        <th>Address</th>
                        <td><input type="text" name="address" value="<%= bc.getAddress()%> "/></td>
                    </tr>
                </table>
            </div>
            <div class='f bg-dark'>
                <a href="Cont?cmd=BCRA" class="btn btn-secondary btn-sm">Back</a>
                <a href="Cont?cmd=BCD&id=<%=bc.getId()%>" class="btn btn-secondary btn-sm">Delete</a>
                <input type="submit" value="Update" class="btn btn-secondary btn-sm"/>
            </div> 
        </form>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

    </body>
</html>
