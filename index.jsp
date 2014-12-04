<%-- 
    Document   : index
    Created on : 2014-12-3, 13:14:13
    Author     : qiuyuan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Bootstrap 3, from LayoutIt!</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">

	<!--link rel="stylesheet/less" href="less/bootstrap.less" type="text/css" /-->
	<!--link rel="stylesheet/less" href="less/responsive.less" type="text/css" /-->
	<!--script src="js/less-1.3.3.min.js"></script-->
	<!--append ‘#!watch’ to the browser URL, then refresh the page. -->
	
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet">

  <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
  <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
  <![endif]-->

  <!-- Fav and touch icons -->
  <link rel="apple-touch-icon-precomposed" sizes="144x144" href="img/apple-touch-icon-144-precomposed.png">
  <link rel="apple-touch-icon-precomposed" sizes="114x114" href="img/apple-touch-icon-114-precomposed.png">
  <link rel="apple-touch-icon-precomposed" sizes="72x72" href="img/apple-touch-icon-72-precomposed.png">
  <link rel="apple-touch-icon-precomposed" href="img/apple-touch-icon-57-precomposed.png">
  <link rel="shortcut icon" href="img/favicon.png">
  
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/scripts.js"></script>
</head>

<body>
    <div class="header">This is header</div>
<div class="container">
        
	<div class="row clearfix">
		
		<div class="col-md-5 column">
			<form action="checkname" method="POST">
				<div class="form-group">
					 <label for="exampleInputEmail1">Email address</label><input type="text" class="form-control" id="exampleInputEmail1" name="username"/>
				</div>
				<div class="form-group">
					 <label for="exampleInputPassword1">Password</label><input type="password" class="form-control" id="exampleInputPassword1" name="password"/>
				</div>
				
				<div class="checkbox">
					 <label><input type="checkbox" /> Remember me </label>
                                
				</div> 
                            <div> 
                <p class="bottom">Don't have a username?<strong><a href="register.jsp"> Signing up</a></strong> is easy.</p>
            </div>   
                            <button type="submit" class="btn btn-default">Submit</button>
			</form>
                    <div>         <%
    if(null!=request.getAttribute("error"))
    {
        out.println(request.getAttribute("error"));
    }
    %>  </div>
		</div>
	</div>
</div>
</body>
</html>
