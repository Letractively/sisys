<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <% String error = request.getParameter("result");
	if(error == null) {
		error = "";
	} else if(error.equals("success")) {
		error = "修改成功！";
	} else if(error.equals("none")){
		error = "该批次不存在，请重试！";
	} else if(error.equals("false")){
		error = "修改失败！";
	} else if(error.equals("empty")) {
		error = "输入不能为空！";
	}
%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
 <head>
		
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		
<title>生产物流统计系统</title>
		
		<!--                       CSS                       -->
	  
		<!-- Reset Stylesheet -->
		<link rel="stylesheet" href="resources/css/reset.css" type="text/css" media="screen" />
	  
		<!-- Main Stylesheet -->
		<link rel="stylesheet" href="resources/css/style.css" type="text/css" media="screen" />
		
		<!-- Invalid Stylesheet. This makes stuff look pretty. Remove it if you want the CSS completely valid -->
		<link rel="stylesheet" href="resources/css/invalid.css" type="text/css" media="screen" />	
		
		<!-- Colour Schemes
	  
		Default colour scheme is green. Uncomment prefered stylesheet to use it.
		
		<link rel="stylesheet" href="resources/css/blue.css" type="text/css" media="screen" />
		
		<link rel="stylesheet" href="resources/css/red.css" type="text/css" media="screen" />  
	 
		-->
		
		<!-- Internet Explorer Fixes Stylesheet -->
		
		<!--[if lte IE 7]>
			<link rel="stylesheet" href="resources/css/ie.css" type="text/css" media="screen" />
		<![endif]-->
		
		<!--                       Javascripts                       -->
  
		<!-- jQuery -->
		<script type="text/javascript" src="resources/scripts/jquery-1.3.2.min.js"></script>
		
		<!-- jQuery Configuration -->
		<script type="text/javascript" src="resources/scripts/simpla.jquery.configuration.js"></script>
		
		<!-- Facebox jQuery Plugin -->
		<script type="text/javascript" src="resources/scripts/facebox.js"></script>
		
		<!-- jQuery WYSIWYG Plugin -->
		<script type="text/javascript" src="resources/scripts/jquery.wysiwyg.js"></script>
		
		<!-- jQuery Datepicker Plugin -->
		<script type="text/javascript" src="resources/scripts/jquery.datePicker.js"></script>
		<script type="text/javascript" src="resources/scripts/jquery.date.js"></script>
		<!--[if IE]><script type="text/javascript" src="resources/scripts/jquery.bgiframe.js"></script><![endif]-->

		
		<!-- Internet Explorer .png-fix -->
		
		<!--[if IE 6]>
			<script type="text/javascript" src="resources/scripts/DD_belatedPNG_0.0.7a.js"></script>
			<script type="text/javascript">
				DD_belatedPNG.fix('.png_bg, img, li');
			</script>
		<![endif]-->
		
	</head>
  
	<body><div id="body-wrapper"> <!-- Wrapper for the radial gradient background -->
	
		
		<jsp:include flush="true" page="banner_admin.jsp"></jsp:include>
	
	
		<div id="main-content"> <!-- Main Content Section with everything -->
			
			<!-- Page Head -->
			<h2>超期批次管理</h2>
			<p id="page-intro">Production Over the Period</p>
			
			
			
			<div class="clear"></div> <!-- End .clear -->
			
			<div class="content-box"><!-- Start Content Box -->
				
				<div class="content-box-header">
					
					<h3>Search Box</h3>

					
					<div class="clear"></div>
					
				</div> <!-- End .content-box-header -->
				
				<div class="content-box-content">
		
				<div id="login-content">
				
				<form action="modifyOutDue.action" method="get">
				
				<label>
					<%=error%>
				</label>
				
					<p>
						<label>产品编号</label>
						<input class="text-input" type="text" name="product.proNo"/>
					</p>
					<div class="clear"></div>
				
					<p>
						<label>批次号</label>
						<input class="text-input" type="text" name="batch.batchNo"/>
					</p>
					<div class="clear"></div>
				
					<p>
						<label>备注(可为空)</label>
						<textarea class="text-input" style="width:250px;height:50px" name="batch.note" ></textarea>
					</p>
					<div class="clear"></div>
				
					<p>
						<input type="submit" class="button" value="已处理"/>
					</p>

				</form>
			</div> <!-- End #login-content -->
						</div>
						
						
			
			
			
		</div> <!-- End #main-content -->
		
		<jsp:include flush="true" page="footer.jsp"></jsp:include>
	</div></body>
  

<!-- Download From www.exet.tk-->
</html>