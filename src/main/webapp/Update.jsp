<%@ page import="java.sql.*" %>
<%@ page import="main.java.com.registration.*" %>
<%@ page import="main.java.com.registration.dbconnection.*" %>
<% Class.forName("com.mysql.jdbc.Driver"); %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Update data</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round|Open+Sans">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

 <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <!-- Font Icon -->
    <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">

    <!-- Main css -->
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<%@ include file="Navbar.jsp" %>
  <%
    String id = request.getParameter("id");
           Connection connection = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/javaproject", "root", "123456");
           Statement statement = connection.createStatement() ;
           ResultSet resultSet = statement.executeQuery("SELECT p.partyId, firstName, lastName, address, city," +
                                                         " zip, state, country, phone,userLoginId FROM party p," +
                                                         " userlogin u WHERE p.partyId = u.partyId AND p.partyId ="+id);

           while(resultSet.next()){
    %>
 <div class="main">

        <!-- Sign up form -->
        <section class="signup">
            <div class="container">
                <div class="signup-content">
                    <div class="signup-form">
                        <h2 class="form-title">Update Profile</h2>
                            <form method="get" action="UpdateServlet" class="register-form" id="register-form">
                                 <div class="form-group">
                                  <label><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="hidden" name="partyId" value="<%=resultSet.getInt("partyId") %>">
                                </div>

                                <div class="form-group">
                                <label><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="firstName" value="<%=resultSet.getString("firstName") %>">
                                </div>

                                <div class="form-group">
                               <label><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="lastName" value="<%=resultSet.getString("lastName") %>">
                                </div>

                                <div class="form-group">
                                <label><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="address" value="<%=resultSet.getString("address") %>">
                                </div>

                                <div class="form-group">
                                <label><i class="zmdi zmdi-city"></i></label>
                                <input type="text" name="city" value="<%=resultSet.getString("city") %>">
                                </div>

                                <div class="form-group">
                                <label><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="zip" value="<%=resultSet.getString("zip") %>">
                                </div>

                                <div class="form-group">
                                <label><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="state" value="<%=resultSet.getString("state") %>">
                                </div>

                                <div class="form-group">
                                <label><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="country" value="<%=resultSet.getString("country") %>">
                                </div>

                                <div class="form-group">
                                <label><i class="zmdi zmdi-phone"></i></label>
                                <input type="text" name="phone" value="<%=resultSet.getString("phone") %>">
                                </div>

                                <div class="form-group">
                                <label><i class="zmdi zmdi-email"></i></label>
                                <input type="email" name="email" value="<%=resultSet.getString("userLoginId") %>">
                                </div>
                                <div class="form-group form-button">
                                         <input type="submit" name="update" id="signup" class="form-submit" value="Update"/>
                                </div>
                            </form>
                    </div>
                </div>
            </div>
        </section>
 </div>
<%
}
%>
</body>
</html>