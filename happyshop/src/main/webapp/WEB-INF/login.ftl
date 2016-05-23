<#assign base=request.contextPath>
<!doctype html>
<html>
<head>
<title>管理员登录</title>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<meta http-equiv="Cache-Control" content="no-cache" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<link rel="stylesheet" type="text/css" href="${base}/static/v1.0.0/css/login.css" />
<link rel="stylesheet" type="text/css" href="${base}/static/v1.0.0/css/index.css" />
<script type="text/javascript" src="${base}/static/v1.0.0/js/common/jquery.js"></script>
<script type="text/javascript" src="${base}/static/v1.0.0/js/common/jquery.form.js"></script>
<script type="text/javascript" src="${base}/static/v1.0.0/js/login/login.js"></script>
</head>

<body>
	<div class="whole">
		<div class="headbg"></div>
		<div class="middle">
			<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td>
						<div class="left">
							<img src="${base}/imgs/picture.gif" width="478" height="380" />
						</div>
					</td>
					<td>
						<div class="line"></div>
					</td>
					<td>
						<div class="right">
							<div class="login">
								<form action="${base}/SysLogin!login.do" name="loginForm" id="loginForm" method="post"
									onsubmit="return checkForm();">
									<s:hidden id="errorInfo" name="errorInfo"></s:hidden>
									<!-- 登陆信息 -->
									<div class="loginfont">登陆&nbsp;欢乐购-网上商城系统</div>
									<table align="left" width="100%" border="0" cellspacing="0" cellpadding="0" style="line-height: 2.5em;">
										<tr>
											<td width="25%" align="right"><font size="2.75em">用户名：</font>
											</td>
											<td><input name="sysUser.code" type="text" class="text" id="UserName"
												style="width: 120px; height: 1.45em;" />&nbsp;&nbsp;<span id="showmsgUserA"></span></td>
										</tr>
										<tr>
											<td align="right"><font size="2.75em">密&nbsp;&nbsp;&nbsp;码：</font>
											</td>
											<td><input name="sysUser.pwd" type="password" class="text" id="password"
												style="width: 120px; height: 1.45em;" /></td>
										</tr>
										<tr>
											<td align="right"><font size="2.75em">验证码：</font></td>
											<td><input name="checkA" type="text" class="text" id="code" size="4"
												style="width: 60px; height: 1.45em;" />&nbsp;&nbsp;&nbsp;&nbsp; <span id="showcheckA"
												style="background-image: url(${base}/Images/fuzzy.jpg);"></span>&nbsp;&nbsp;&nbsp;<a href="#"
												onclick="showcheck()"><font size="2.75em" color="blue">看不清</font> </a></td>
										</tr>
										<tr>
											<td colspan="2">
												<div class="user" style="margin-top: 20px;">
													<ul>
														<li class="li1"></li>
														<li class="li5"><input name="submit" type="submit" class="buttun" value=""
															style="background-image:url(${base}/imgs/loginbtn.gif); border:0; height:24px; width:68px;" />
														</li>
														<li class="li5"><input name="clear" type="reset" class="buttun" value=""
															style="background-image:url(${base}/imgs/clear.gif); border:0; height:24px; width:68px;" />
														</li>
													</ul>
												</div>
											</td>
										</tr>
									</table>

								</form>
							</div>
						</div>
					</td>
				</tr>
			</table>
		</div>

		<div class="foot">
			<div class="footfont">
				<a href="http://www.xxxxxx.com"><span style="font-size: 12">XXXXXX有限公司</span> </a><span> Copyright @
					2011-2015</span>
			</div>
			<div class="footbg"></div>
		</div>
	</div>
</body>
</html>
