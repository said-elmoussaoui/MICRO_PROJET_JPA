<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Accueil</title>
    <style type="text/css">
        body{
            margin:0px;
            padding:0px;
            background-color: steelblue ;
            text-align: center;
            align-itmes:center;}
        *{
            font-family:monospace;
        }
        .all{
            height:200px;
            width:500px;

        }

        a{
            text-decoration:none;
            border:solid 1px blue;
            height:30px;
            width:200px;
            display:flex;
            justify-content:center;
            align-itmes:center;
            background-color:blue;
            color:white;
            font-weight:bold;
            margin-top:20px;
        }
        .title{
            font-weight:bold;
            color: coral;
            font-size:14pt;
        }

    </style>
</head>
<body>
<center>

<div class="all">
    <h3 class="title">Bienvenue chez SEBO , Veuillez vous identifier ou vous inscrire : </h3>
    <center>
    <div classs="btn">
        <a href="Identifier.jsp">S'identifier</a>
        <a href="sinscrire.jsp">S'inscrire</a>
    </div>
    </center>
</div>
</center>
</body>
</html>