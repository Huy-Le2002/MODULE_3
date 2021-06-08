<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Basic Tables | Uplon - Responsive Bootstrap 4 Admin Dashboard</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta content="Responsive bootstrap 4 admin template" name="description">
    <meta content="Coderthemes" name="author">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- App favicon -->
    <link rel="shortcut icon" href="assets\images\favicon.ico">

    <!-- App css -->
    <link href="assets\css\bootstrap.min.css" rel="stylesheet" type="text/css" id="bootstrap-stylesheet">
    <link href="assets\css\icons.min.css" rel="stylesheet" type="text/css">
    <link href="assets\css\app.min.css" rel="stylesheet" type="text/css" id="app-stylesheet">

</head>

<body>

<!-- Begin page -->
<div id="wrapper">

    <%@include file="../layout/topbar.jsp" %>

    <%@include file="../layout/leftside.jsp" %>

    <!-- ============================================================== -->
    <!-- Start Page Content here -->
    <!-- ============================================================== -->

    <div class="content-page">
        <div class="content">

            <!-- Start Content-->
            <div class="container-fluid">


                <div class="row">
                    <div class="col-lg-12">
                        <div class="card-box">

                            <form action="" method="get">
                                <div class="row my-3">
                                    <div class="col">
                                        <h4 class="header-title">Search</h4>
                                    </div>
                                    <div class="col-auto d-flex">
                                        <div class="input-group">
                                            <input type="hidden" name="action" value="find" />
                                            <input type="text" name="key" class="form-control" aria-label="Amount (to the nearest dollar)">
                                            <div class="input-group-append">
                                                <button type="submit" class="btn btn-primary">Search</button>
                                            </div>
                                        </div>
                                        <a href="/user?action=sort" class="btn btn-primary ml-3">Sort</a>
                                    </div>
                                </div>
                            </form>

                            <div class="table-responsive">
                                <table class="table mb-0">
                                    <thead class="thead-dark">
                                    <tr>
                                        <th>ID</th>
                                        <th>Name</th>
                                        <th>Email</th>
                                        <th>Country</th>
                                        <th>Actions</th>
                                    </tr>
                                    </thead>
                                    <tbody>

                                    <c:forEach var="user" items="${list}">
                                        <tr>
                                            <td scope="row"><c:out value="${user.id}"/></td>
                                            <td><c:out value="${user.name}"/></td>
                                            <td><c:out value="${user.email}"/></td>
                                            <td><c:out value="${user.countryName}"/></td>
                                            <td>
                                                <a href="/user?action=edit&id=${user.id}" class="btn btn-primary waves-effect waves-light">Edit</a>
                                                <a href="/user?action=delete&id=${user.id}" class="btn btn-danger waves-effect waves-light">Delete</a>
                                            </td>
                                        </tr>
                                    </c:forEach>


                                    </tbody>
                                </table>
                            </div>
                        </div>

                    </div>
                </div>
                <!-- end row -->



            </div> <!-- end container-fluid -->

        </div> <!-- end content -->



        <!-- Footer Start -->
        <footer class="footer">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        2016 - 2019 &copy; Uplon theme by <a href="">Coderthemes</a>
                    </div>
                </div>
            </div>
        </footer>
        <!-- end Footer -->

    </div>

    <!-- ============================================================== -->
    <!-- End Page content -->
    <!-- ============================================================== -->

</div>
<!-- END wrapper -->

<%@include file="../layout/rightside.jsp" %>



<!-- Vendor js -->
<script src="assets\js\vendor.min.js"></script>

<!-- App js -->
<script src="assets\js\app.min.js"></script>

</body>
</html>