<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>登陆页面</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- SUI js,css -->
<link href="sui/css/sui.css" rel="stylesheet">
<link href="sui/css/sui-all.css" rel="stylesheet">
<link href="sui/css/sui-append.css" rel="stylesheet">
<link href="sui/css/sui-extends.css" rel="stylesheet">
<link href="sui/css/sui-responsive.css" rel="stylesheet">
<link href="sui/css/doc-css/animate.css" rel="stylesheet">
<!-- <link href="sui/css/doc-css/docs.css" rel="stylesheet"> -->
<script type="text/javascript" src="sui/js/jquery.js"></script>
<script type="text/javascript" src="sui/js/sui.min.js"></script>
<!-- *** -->
</head>
<body style="padding-top: 200px;">
	<div class="content">
		<div class="grid-demo">
			<div class="sui-row">
				<div class="span6"></div>
				<div class="span4">
					<form class="sui-form form-horizontal" action="htUserInfo.do?method=login" method="POST">
						<div class="control-group">
							<label for="inputEmail" class="control-label">用户名：</label>
							<div class="controls">
								<input id="inputEmail" placeholder="用户名" type="text" name="userName">
							</div>
						</div>
						<div class="control-group">
							<label for="inputPassword" class="control-label">密码：</label>
							<div class="controls">
								<input id="inputPassword" placeholder="密码" type="password" name="password">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label"></label>
							<div class="controls">
								<label data-toggle="checkbox" class="checkbox-pretty inline">
									<input name="remember-me" type="checkbox"><span>记住我</span>
								</label>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label"></label>
							<div class="controls">
								<button type="submit" class="sui-btn btn-primary">登录</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>