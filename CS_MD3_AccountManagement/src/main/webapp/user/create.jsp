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

                            <div class="row my-3">
                                <div class="col">
                                    <h4 class="header-title">Create User</h4>
                                </div>
                                <div class="col-auto d-flex">

                                </div>
                            </div>

                            <div class="row justify-content-center">
                                <div class="col-md-6">
                                    <form method="post">
                                        <div class="form-group row">
                                            <label for="name" class="col-lg-2 col-form-label">Name</label>
                                            <div class="col-lg-10">
                                                <input class="form-control" type="text" name="name" id="name" size="45">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label for="email" class="col-lg-2 col-form-label">Email</label>
                                            <div class="col-lg-10">
                                                <input class="form-control" type="email" name="email" id="email" size="45">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label for="email" class="col-lg-2 col-form-label">Email</label>
                                            <div class="col-lg-10">
                                                <select id="country" name="id_country" class="form-control">
                                                    <c:forEach var="country" items='${requestScope["data"]}'>
                                                        <option value="${country.id}">${country.getName()}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="text-right">
                                            <button type="submit" class="btn btn-primary">Submit</button>
                                        </div>
                                    </form>
                                </div>
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