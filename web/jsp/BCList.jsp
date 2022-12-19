<%-- 
    Document   : BCList
    Created on : Dec 16, 2022, 10:14:55 PM
    Author     : Naser
--%>

<%@page import="model.BusinessCard"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Business Cards</title>
        <link href="css/Style.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        
    </head>
    <body>
        <%
            String msg = (String)request.getAttribute("msg");
            if(msg!=null){
        %>
            <h1 class="parent bg-dark">
                <%=msg%>
            </h1>
        <%}%>
        <div class="img">
            <img src="images/Business.png" alt=""/>
        </div>
        <div class='btntab bg-dark'>
            <a href="create.html" class="btn btn-secondary btn-sm" >Create Business Card</a>
            <a href="Cont?cmd=BCS" class="btn btn-secondary btn-sm" >Save Data</a>
        </div>
        <%
            ArrayList<BusinessCard> arr = (ArrayList<BusinessCard>) request.getAttribute("BCListArray");
        %>
        <div  class='btntab bg-dark'>
            <table class="table table-hover table-dark" >
                <thead>
                <th>Name</th>
                <th>Telephone</th>
                <th></th>
                </thead>
                <%
                    for (BusinessCard bc : arr) {
                %>
                <tr>
                    <td><%= bc.getName()%></td>
                    <td><%= bc.getTel()%></td>
                    <td><a href="Cont?cmd=BCR&id=<%=bc.getId()%>" class="btn btn-secondary btn-sm" >Show</a></td>
                </tr>  
                <% }%>
            </table>
        </div>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
