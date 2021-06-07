<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
<link rel="stylesheet" href="./css/csstable.css">
<link rel="stylesheet" href="./css/sidebar.css">
 <link href='https://fonts.googleapis.com/css?family=Open+Sans:300' rel='stylesheet' type='text/css'>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">

<title>Insert title here</title>
</head>
<body>
<jsp:include page="sidebar.jsp"/>
<div class="main">
<div class="container">
 <center><h1>Listes des docteurs</h1></center> <br><br>

<form action="./ChercherDoc" method="POST">
             
                <input type="text" value=""  placeholder="Entrer le prenom du docteur." name="txtprenomdoc">
            
               
                <input type="text" value=""  placeholder="Entrer l'Id du docteur." name="txtid">
             
                <input name='btnajouter' type='submit' value='chercher' class="btn btn-primary"  />
            </form>
            <br>
  <div class="row">
  
    <div class="col-12">
         <table class="table table-bordered">

  <thead class="table-dark" >
    <tr>
      <th scope="col">#</th>
      <th scope="col">nom</th>
      <th scope="col">prenom</th>
      <th scope="col">email</th>
      <th scope="col">specialisation </th>
      <th scope="col">numero</th>
      <th scope="col">adresse</th>
      <th scope="col">Action</th>
     

    </tr>
  </thead>
   
   <tbody>
   <c:forEach items= "${listD}"  var="doc">
    <tr>
    
      <td>${doc.id}</td>
      <td>${doc.nom}</td>
      <td>${doc.prenom}</td>
      <td>${doc.email}</td>
      <td>${doc.specialisation}</td>
      <td>${doc.numero}</td>
      <td>${doc.adresse}</td>
      <td><a href='SupprimerDoc?id=${doc.id }' class="btn btn-danger"><i class="fa fa-trash-o" aria-hidden="true"></i></a>
     <a href='ModifierSelectDoc?id=${doc.id }' class="btn btn-success"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></a></td> 
      
    </tr>
    </c:forEach>
  </tbody>
   
</table>
</div>
</div>
  </div>
</div>

</body>
</html>