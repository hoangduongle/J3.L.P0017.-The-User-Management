<%-- 
    Document   : userinfo
    Created on : Jun 1, 2021, 9:17:43 AM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <!--  This file has been downloaded from bootdey.com    @bootdey on twitter -->
        <!--  All snippets are MIT license http://bootdey.com/license -->
        <title>Edit Profile User</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="http://netdna.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="css/manage.css">
    </head>
    <style type="text/css">
        body{
            color: #8e9194;
            background-color: #f4f6f9;
        }
        .avatar-xl img {
            width: 170px;
            position: relative;
            left: 286px;
        }
        .rounded-circle {
            border-radius: 50% !important;
        }
        img {
            vertical-align: middle;
            border-style: none;
        }
        .text-muted {
            color: #aeb0b4 !important;
        }
        .text-muted {
            font-weight: 300;
        }
        .form-control {
            display: block;
            width: 100%;
            height: calc(1.5em + 0.75rem + 2px);
            padding: 0.375rem 0.75rem;
            font-size: 0.875rem;
            font-weight: 400;
            line-height: 1.5;
            color: #4d5154;
            background-color: #ffffff;
            background-clip: padding-box;
            border: 1px solid #eef0f3;
            border-radius: 0.25rem;
            transition: border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;
        }
    </style>
    <body>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-12 col-lg-10 col-xl-8 mx-auto">
                    <ul class="nav nav-tabs" id="myTab" role="tablist">
                        <li class="nav-item">
                            <a class="nav-link active" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="true">Profile</a>
                        </li>
                    </ul>
                    <div class="tab-content" id="myTabContent">
                        <div class="tab-pane fade show active" id="profile" role="tabpanel" aria-labelledby="profile-tab">

                            <div class="row mt-5 align-items-center">
                                <div class="col-md-3 text-center mb-5">
                                    <div class="avatar avatar-xl">
                                        <img src="${sessionScope.LOGIN_USER.getPhoto()}" alt="..." class="avatar-img rounded-circle" />
                                    </div>
                                </div>
                            </div>
                            <hr class="my-4" />
                            <div class="form-row">
                                <div class="form-group col-md-5">
                                    <label for="UserName">User Name</label>
                                    <input class="form-control" value="${sessionScope.LOGIN_USER.getUserName()}" readonly="true"/>
                                </div>
                                <div class="form-group col-md-5">
                                    <label for="Phone">Phone</label>
                                    <input class="form-control"value="${sessionScope.LOGIN_USER.getPhone()}" readonly="true"/>
                                </div>
                                <div class="form-group col-md-2">
                                    <label for="inputZip5">Role ID</label>
                                    <input type="text" class="form-control" id="inputZip5" value="Member" readonly="true"/>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-4">
                                    <label for="UserName">Email</label>
                                    <input class="form-control" value="${sessionScope.LOGIN_USER.getEmail()}" readonly="true"/>
                                </div>
                                <div class="form-group col-md-8">
                                    <label for="Phone">Photo URL</label>
                                    <input class="form-control"value="${sessionScope.LOGIN_USER.getPhoto()}" readonly="true"/>
                                </div>
                            </div>
                            <a href="history?userid=${sessionScope.LOGIN_USER.getUserID()}" class="btn btn-success">History Promotion</a>
                            <a href="logout" class="btn btn-dark">Logout</a>

                        </div>
                    </div>

                </div>
            </div>
        </div>
        <script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="http://netdna.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <script type="text/javascript"></script>
    </body>
</html>
