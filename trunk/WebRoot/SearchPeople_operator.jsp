<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="java.text.*" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<%
	String result = request.getParameter("result");
	String message="";
	if(result != null){
		message = request.getAttribute("message").toString();;
	}
	Calendar cal = Calendar.getInstance();
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	Date time = cal.getTime();
	time.setDate(1);
	String startTime = format.format(time);
	time.setMonth(time.getMonth() + 1);
	time.setDate(0);
	String endTime = format.format(time);
	
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>生产物流统计系统</title>

<!--                       CSS                       -->

<!-- Reset Stylesheet -->
<link rel="stylesheet" href="resources/css/reset.css" type="text/css"
	media="screen" />

<!-- Main Stylesheet -->
<link rel="stylesheet" href="resources/css/style.css" type="text/css"
	media="screen" />

<!-- Invalid Stylesheet. This makes stuff look pretty. Remove it if you want the CSS completely valid -->
<link rel="stylesheet" href="resources/css/invalid.css" type="text/css"
	media="screen" />

<!-- Colour Schemes
	  
		Default colour scheme is green. Uncomment prefered stylesheet to use it.
		
		<link rel="stylesheet" href="resources/css/blue.css" type="text/css" media="screen" />
		
		<link rel="stylesheet" href="resources/css/red.css" type="text/css" media="screen" />  
	 
		-->

<!-- Internet Explorer Fixes Stylesheet -->

<!--[if lte IE 7]>
			<link rel="stylesheet" href="resources/css/ie.css" type="text/css" media="screen" />
		<![endif]-->
		<script type="text/javascript">
			function loadTime(){
				document.getElementsByName("startTime")[0].value = "<%=startTime%>";
				document.getElementsByName("endTime")[0].value = "<%=endTime%>";
				
			}
		</script>

<!--                       Javascripts                       -->

<!-- jQuery -->
<script type="text/javascript"
	src="resources/scripts/jquery-1.3.2.min.js"></script>

<!-- jQuery Configuration -->
<script type="text/javascript"
	src="resources/scripts/simpla.jquery.configuration.js"></script>

<!-- Facebox jQuery Plugin -->
<script type="text/javascript" src="resources/scripts/facebox.js"></script>

<!-- jQuery WYSIWYG Plugin -->
<script type="text/javascript" src="resources/scripts/jquery.wysiwyg.js"></script>

<!-- jQuery Datepicker Plugin -->
<script type="text/javascript"
	src="resources/scripts/jquery.datePicker.js"></script>
<script type="text/javascript" src="resources/scripts/jquery.date.js"></script>
<script type="text/javascript" src="resources/scripts/My97DatePicker/WdatePicker.js"></script>
<!--[if IE]><script type="text/javascript" src="resources/scripts/jquery.bgiframe.js"></script><![endif]-->


<!-- Internet Explorer .png-fix -->

<!--[if IE 6]>
			<script type="text/javascript" src="resources/scripts/DD_belatedPNG_0.0.7a.js"></script>
			<script type="text/javascript">
				DD_belatedPNG.fix('.png_bg, img, li');
			</script>
		<![endif]-->

</head>

<body onload=loadTime()>
	<div id="body-wrapper">
		<!-- Wrapper for the radial gradient background -->

		<jsp:include flush="true" page="banner_operator.jsp"></jsp:include>

	<div id="main-content">
		<!-- Main Content Section with everything -->

		<!-- Page Head -->
		<h2>员工生产情况查询</h2>
		<p id="page-intro">Staff production queries</p>



		<div class="clear"></div>
		<!-- End .clear -->

		<div class="content-box">
			<!-- Start Content Box -->

			<div class="content-box-header">

				<h3>Search Box</h3>


				<div class="clear"></div>

			</div>
			<!-- End .content-box-header -->

			<div class="content-box-content">
			<div align="center">
					<label>
						<%=message%>
					</lable>
				</div>

				<div id="login-content">

						<s:form action="SearchPp" target="_blank" namespace="/">

							<p>
								 <s:textfield name="staNo" label="工号"></s:textfield>
								<s:textfield name="startTime" label="起始时间(YYYY-MM-DD)"
									onClick="WdatePicker()"></s:textfield>
								<s:textfield name="endTime" label="截止时间(YYYY-MM-DD)"
									onClick="WdatePicker()"></s:textfield>
							</p>

							<div class="clear"></div>
								
						
						 <s:submit cssClass="button" value="确定"/>
						</s:form>
					</div>
			</div>





		</div>
		<!-- End #main-content -->
		<jsp:include flush="true" page="footer.jsp"></jsp:include>
		</div>
	</div>
</body>


<!-- Download From www.exet.tk-->
</html>
