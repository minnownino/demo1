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
<div class="container">
	<div class="row clearfix">
		<div class="col-md-6 column">
			<form role="form" method ="post" action = "getdisease_equipment">
				<div class="form-group">
                                    <h3>Please choose your disease</h3>
					 <label for="exampleInputEmail1"></label>
                                         <input type="checkbox" name="disease" value="a" />
                                         Thermometer
                                         <br/>
                                         <label for="exampleInputEmail1"></label>
                                         <input type="checkbox" name="disease" value="b" />
                                         Thermometer
                                         <br/>
                                         <label for="exampleInputEmail1"></label>
                                         <input type="checkbox" name="disease" value="c" />
                                         Thermometer
                                         <br/>
                                         <label for="exampleInputEmail1"></label>
                                         <input type="checkbox" name="disease" value="d" />
                                         Thermometer
                                         <br/>
                                         <label for="exampleInputEmail1"></label>
                                         <input type="checkbox" name="disease" value="e" />
                                         Thermometer
                                         <br/>
                                         <label for="exampleInputEmail1"></label>
                                         <input type="checkbox" name="disease" value="f" />
                                         Thermometer
                                         <br/>
                                         <label for="exampleInputEmail1"></label>
                                         <input type="checkbox" name="disease" value="g" />
                                         Thermometer
                                         <br/>
                                         <label for="exampleInputEmail1">Anything else? </label>
                                         <input type="text" name="others" value="" />
                                          
				</div>
				<div class="form-group">
					 <h3>Please choose your disease</h3>
					 <label for="exampleInputEmail1"></label>
                                         <input type="checkbox" name="disease" value="a" />
                                         Thermometer
                                         <br/>
                                         <label for="exampleInputEmail1"></label>
                                         <input type="checkbox" name="disease" value="b" />
                                         Thermometer
                                         <br/>
                                         <label for="exampleInputEmail1"></label>
                                         <input type="checkbox" name="disease" value="c" />
                                         Thermometer
                                         <br/>
                                         <label for="exampleInputEmail1"></label>
                                         <input type="checkbox" name="disease" value="d" />
                                         Thermometer
                                         <br/>
                                         <label for="exampleInputEmail1"></label>
                                         <input type="checkbox" name="disease" value="e" />
                                         Thermometer
                                         <br/>
                                         <label for="exampleInputEmail1"></label>
                                         <input type="checkbox" name="disease" value="f" />
                                         Thermometer
                                         <br/>
                                         <label for="exampleInputEmail1"></label>
                                         <input type="checkbox" name="disease" value="g" />
                                         Thermometer
                                         <br/>
                                         <label for="exampleInputEmail1">Anything else? </label>
                                         <input type="text" name="others" value="" />
				</div>
                                <div class="col-md-6_1 column">
                                        <form role="form">
                                                <div class="form-box">
                                                         <label for="exampleInputEmail1">Personal Description</label>
                                                         <textarea name="description" rows="4" cols="20" class="form-control" id="exampleInputEmail1">
                                                         </textarea>
                                                </div>

                                                <div class="checkbox">
                                                </div> 
                                        </form>
                                </div>
                                        <button type="submit" class="btn btn-default">Submit</button> 
				</div>
				
			</form>
		</div>
	</div>
	<div class="row clearfix">
		<div class="col-md-12 column">
		</div>
	</div>
</div>
</body>
</html>
