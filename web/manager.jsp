<%-- 
    Document   : home
    Created on : May 26, 2021, 7:25:41 PM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Account Management</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css/home.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
              integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
              integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    </head>
    <style>
        body {
            color: #566787;
            background: #f5f5f5;
            font-family: 'Roboto', sans-serif;
        }

        .table-responsive {
            margin: 30px 0;
        }

        .table-wrapper {
            width: 850px;
            background: #fff;
            margin: 0 auto;
            padding: 20px 30px 5px;
            box-shadow: 0 0 1px 0 rgba(0, 0, 0, .25);
        }

        .table-title .btn-group {
            float: right;
        }

        .table-title .btn {
            min-width: 50px;
            border-radius: 5px;
            border: none;
            padding: 6px 12px;
            font-size: 95%;
            outline: none !important;
            height: 30px;
        }

        .table-title {
            min-width: 100%;
            border-bottom: 1px solid #e9e9e9;
            padding-bottom: 15px;
            margin-bottom: 5px;
            background: rgb(0, 50, 74);
            margin: -20px -31px 10px;
            padding: 15px 30px;
            color: #fff;
            position: relative;
        }

        .table-title h2 {
            margin: 2px 0 0;
            font-size: 24px;

        }

        table.table {
            min-width: 100%;
        }

        table.table tr th,
        table.table tr td {
            border-color: #e9e9e9;
            padding: 12px 15px;
            vertical-align: middle;
        }

        table.table tr th:first-child {
            width: 40px;
        }

        table.table tr th:last-child {
            width: 100px;
        }

        table.table-striped tbody tr:nth-of-type(odd) {
            background-color: #fcfcfc;
        }

        table.table-striped.table-hover tbody tr:hover {
            background: #f5f5f5;
        }

        table.table td a {
            color: #2196f3;
        }
        .table-striped .lb {
            min-width: 20px;
            border-radius: 4px;
            border: none;
            padding: 6px 6px;
            font-size: 85%;
            outline: none !important;
            height: 30px;
        }

        table.table td a.delete {
            color: #E34724;
        }

        .searchbar {
            margin-bottom: auto;
            margin-top: auto;
            height: 60px;
            background-color: #353b48;
            border-radius: 30px;
            padding: 10px;
        }

        .search_input {
            color: white;
            border: 0;
            outline: 0;
            background: none;
            width: 0;
            caret-color: transparent;
            line-height: 40px;
            transition: width 0.4s linear;
        }

        .searchbar:hover>.search_input {
            padding: 0 10px;
            width: 120px;
            caret-color: red;
            transition: width 0.4s linear;
        }

        .searchbar:hover>.search_icon {
            background: white;
            color: #e74c3c;
        }

        .search_icon {
            height: 40px;
            width: 40px;
            float: right;
            display: flex;
            justify-content: center;
            align-items: center;
            border-radius: 50%;
            color: white;
        }
        .form{
            position: relative;
            top: 12px;
        }
        #btnsearch{
            background-color: #353b48;
            border: none;
        }
        .btncreate{
            position: relative;
            top: 10px;
            left: 14px;
            color: turquoise;
        }

        .btncreate:hover{
            color: #fff;
            text-decoration: none;
        }

        #btnlogout{
            position: relative;
            right: 130px;
            bottom: 5px;
        }
        
        #btnpromotion{
            position: relative;
            top: 12px;
            text-decoration: none;
            color: #ffff00;
        }
        #btnpromotion:hover{
            color: #2196f3;
            text-decoration: none;
        }
    </style>

    <body>
        <script>
            function group() {
                document.getElementById("btnGroup").click();
               
            }
        </script>
        <div class="container-xl">
            <div class="table-responsive">
                <div class="table-wrapper">
                    <div class="table-title">
                        <div class="row">
                            <div class="col-sm-4">
                                <h2>Manage <b>User</b></h2>
                                 <a href="promotion" id="btnpromotion" class=" trigger-btn">Click to Open Promotion List</a>
                            </div>
                            <div class="col-sm-4">
                                <div class="d-flex justify-content-center h-100">
                                    <form action="search">
                                        <div class="searchbar">
                                            <input class="search_input" type="text" name="txt" value="${param.txt}" placeholder="Search...">
                                            <button type="submit" id="btnsearch" class="search_icon"><i class="fas fa-search"></i></button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <div class="col-sm-4">
                                
                                
                                <form action="group" method="post" class="form">
                                    <div class="btn-group" data-toggle="buttons">
                                        <label class="btn btn-info active " onclick="return group()">
                                            <input type="radio" name="tab" value="all" 
                                                   <c:if test="${requestScope.GROUP eq 'all'}">checked="checked"</c:if>
                                                       >All
                                            </label>
                                            <label class="btn btn-success mx-2" onclick="return group()">
                                                <input  type="radio" name="tab" value="admin"
                                                <c:if test="${requestScope.GROUP eq 'admin'}">checked="checked"</c:if>
                                                    >Admin
                                            </label>
                                            <label class="btn btn-warning" onclick="return group()">
                                                <input  type="radio" name="tab" value="member" 
                                                <c:if test="${requestScope.GROUP eq 'member'}">checked="checked"</c:if>
                                                    >Member
                                            </label>
                                        </div>
                                        <input type="submit" id="btnGroup" style="display: none">
                                    </form>
                                                    
                                                    
                                                    
                                    <a href="#myModal" id="btncreate" class="btncreate trigger-btn" data-toggle="modal">Click to Open Create Account</a>
                                </div>
                            </div>
                        </div>
                        <table class="table table-striped table-hover">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Name</th>
                                    <th>Email</th>
                                    <th>Phone</th>
                                    <th>Role</th>
                                    <th>Status</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="o" items="${sessionScope.LIST}">
                            <form action="manage" method="post">
                                <tr>
                                    <td>${o.getUserID()}</td>
                                    <td>${o.getUserName()}</td>
                                    <td>${o.getEmail()}</td>
                                    <td>${o.getPhone()}</td>
                                    <td>
                                        <c:if test="${o.getRoleID() == 1}">
                                            <label class="lb btn-success mx-2">Admin</label>
                                        </c:if>

                                        <c:if test="${o.getRoleID() == 2}">
                                            <label class="lb btn-warning mx-2">Member</label>
                                        </c:if>
                                    </td>
                                    <td>
                                        <c:if test="${o.isStatus()}">
                                            Active
                                        </c:if>

                                        <c:if test="${o.isStatus() == false}">
                                            Inactive
                                        </c:if>
                                    </td>
                                    <td>
                                        <!-- -->
                                        <c:if test="${o.getRoleID() == 2}">
                                            <a href="view?userID=${o.getUserID()}" class="view" title="View" data-toggle="tooltip"><i
                                                    class="material-icons">&#xE417;</i></a>
                                            <a href="delete?userID=${o.getUserID()}" class="delete" title="Delete" data-toggle="tooltip"><i
                                                    class="material-icons">&#xE872;</i></a>
                                            </c:if>
                                            <c:if test="${sessionScope.LOGIN_USER.getUserID() eq o.getUserID()}">
                                            <a href="view?userID=${o.getUserID()}" class="view" title="View" data-toggle="tooltip"><i
                                                    class="material-icons">&#xE417;</i></a>
                                            </c:if>
                                        <!-- -->
                                    </td>
                                </tr>
                            </form>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

            <div class="form-group">
                <form action="logout" >
                    <div id="btnlogout" class="d-flex flex-row-reverse">
                        <input type="submit" name="logout" value="Logout" class="btn btn-dark p-2" />
                    </div>
                </form>
            </div>

        </div>
        <!-- Modal HTML -->
        <div id="myModal" class="modal fade">
            <div class="modal-dialog modal-login">
                <div class="modal-content">
                    <form action="create" method="post">
                        <div class="modal-header">				
                            <h4 class="modal-title">Create New Account</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">	
                            <div class="form-group">
                                <label>Username</label>
                                <input name="username1" value="${param.username1}" type="text" class="form-control" required="required">
                            </div>
                            <div class="form-group">
                                <div class="clearfix">
                                    <label>Password</label>
                                </div>
                                <input name="password" type="password" class="form-control" required="required">
                            </div>
                            <div class="form-group">
                                <div class="clearfix">
                                    <label>Confirm Password</label>
                                </div>
                                <input name="repassword" type="password" class="form-control" required="required">
                            </div>

                            <div class="form-group">
                                <div class="clearfix">
                                    <label>Email</label>
                                </div>
                                <input name="email" value="${param.email}" type="email" class="form-control" >
                            </div>

                            <div class="form-group">
                                <div class="clearfix">
                                    <label>Phone</label>
                                </div>
                                <input name="phone" value="${param.phone}" type="text" class="form-control" >
                            </div>

                            <div class="form-group">
                                <div class="clearfix">
                                    <label>URL Photo</label>
                                </div>
                                <input name="photo" value="${param.photo}" type="text" class="form-control" >
                            </div>

                            <div class="form-group">
                                <div class="clearfix">
                                    <label>Role</label>
                                </div>

                                <select name="role">
                                    <option>Member</option>
                                    <option>Admin</option>
                                </select>

                            </div>
                        </div>
                        <div class="modal-footer justify-content-left">
                            <input type="submit" class="btn btn-primary" value="Create">
                            <input type="reset" class="btn btn-secondary" value="Reset">
                        </div>
                    </form>
                </div>
            </div>
        </div>    
        <script>
            <c:if test="${requestScope.MESS != null}">
            swal("${requestScope.MESS}", "Please try again!", "warning");
            </c:if>

            <c:if test="${requestScope.MESSOK != null}">
            swal("${requestScope.MESSOK}", "Click Button!", "success");
            </c:if>

            <c:if test="${requestScope.MODEL!=null}">
            document.getElementById("btncreate").click();
            </c:if>
        </script>
    </body>

</html>