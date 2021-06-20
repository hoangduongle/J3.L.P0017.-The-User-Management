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
    </head>
    <body>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-12 col-lg-10 col-xl-8 mx-auto">
                    <h2 class="h3 mb-4 page-title">User Information</h2>

                    <div class="tab-content" id="myTabContent">
                        <div class="tab-pane fade show active" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                            <form action="update" method="POST">
                                <div class="row mt-5 align-items-center">
                                    <div class="col-md-3 text-center mb-5">
                                        <div class="avatar avatar-xl">
                                            <img src="${requestScope.INFO.getPhoto()}" alt="..." class="avatar-img rounded-circle" />
                                        </div>
                                    </div>
                                </div>
                                <hr class="my-4" />
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label for="UserName">User Name</label>
                                        <input type="text" id="UserName" name="username" class="form-control" placeholder="${requestScope.INFO.getUserName()}" />
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="Phone">Phone</label>
                                        <input name="phone" type="text" id="Phone" class="form-control" placeholder="${requestScope.INFO.getPhone()}" />
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label for="inputEmail4">Email</label>
                                        <input name="email" type="email" class="form-control" id="inputEmail4" placeholder="${requestScope.INFO.getEmail()}" />
                                    </div>
                                    <div class="form-group col-md-4">
                                        <label for="inputState5">Status</label>
                                        <select name="status" id="inputState5" class="form-control">
                                            <option <c:if test="${requestScope.INFO.isStatus()}">selected</c:if>>Active</option>
                                            <option <c:if test="${!requestScope.INFO.isStatus()}">selected</c:if>>In-active</option>
                                            </select>
                                        </div>
                                        <div class="form-group col-md-2">
                                            <label for="inputZip5">Role ID</label>
                                            <select name="roleid" id="inputZip5" class="form-control">
                                                <option <c:if test="${requestScope.INFO.getRoleID() == 1}">selected</c:if>>Admin</option>
                                            <option <c:if test="${requestScope.INFO.getRoleID() == 2}">selected</c:if>>Member</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="inputAddress5">Photo URL</label>
                                        <input name="photo" type="text" class="form-control" id="inputAddress5" placeholder="${requestScope.INFO.getPhoto()}" />
                                </div>
                                <hr class="my-4" />
                                <div class="row mb-4">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label for="inputPassword5">New Password</label>
                                            <input name="password" type="password" class="form-control" id="inputPassword5" />
                                        </div>
                                        <div class="form-group">
                                            <label for="inputPassword6">Confirm Password</label>
                                            <input name="repassword" type="password" class="form-control" id="inputPassword6" />
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <p class="mb-2">Password requirements</p>
                                        <p class="small text-muted mb-2">To create a new password, you have to meet all of the following requirements:</p>
                                        <ul class="small text-muted pl-4 mb-0">
                                            <li>Minimum 8 character</li>
                                            <li>At least one special character</li>
                                            <li>At least one number</li>
                                            <li>Can’t be the same as a previous password</li>
                                        </ul>
                                    </div>
                                </div>
                                <div style="position: relative; bottom: 14px">
                                    <input type="hidden" name="userid" value="${requestScope.INFO.getUserID()}"/>
                                    <button type="submit" class="btn btn-primary">Save Change</button>
                                    <a href="manage" class="btn btn-dark">Back</a>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <script type="text/javascript"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <script>
        
//        swal("${requestScope.MESS}", "Please try again!", "warning");
        
    </script>

</body>
</html>
