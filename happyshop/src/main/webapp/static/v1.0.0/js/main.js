$(document).ready(function(){
	initMenu();
	initTab();
	initBgIndex();
	document.onkeydown = rewriteKeydown;//重写键盘事件，防止退格退回到登陆页
	changeLastLiCss();//修改submenu里面的最后一个li的css为li1
});

//修改submenu里面的最后一个li的css为li1
function changeLastLiCss(){
	$(".submenu").each(function(){
		var menuObj = $(this);
		var lastLiObj = menuObj.find("ul > li").last();
		lastLiObj.attr('class','li1');
	})
}

//重写键盘事件，防止退格退回到登陆页
function rewriteKeydown(e) {
    var code;   
    if (!e) var e = window.event;   
    if (e.keyCode) code = e.keyCode;
    else if (e.which) code = e.which;   
    if (((event.keyCode == 8) &&                                                    //BackSpace    
         ((event.srcElement.type != "text" &&    
         event.srcElement.type != "textarea" &&    
         event.srcElement.type != "password") ||    
         event.srcElement.readOnly == true))) {
        event.keyCode = 0;    
        event.returnValue = false;
    }
    //alert(e.keyCode);
    return true;   
}
//流量统计连接
function flowmeter()
{
	var siteId="80975231";
	var password="4235808620";
	var url="http://wss.cnzz.com/user/companion/phpcms_login.php?site_id="+siteId+"&password="+password;
	addTab('流量分析',url);
}
//初始化菜单
function initMenu(){
	$(".ban1:visible:first").next(".submenu").slideToggle("slow");
	
	$(".ban1").click(function(){
		//$(this).next(".submenu").siblings(".submenu").hide();
		$(this).next(".submenu").slideToggle("normal");
	});		
						
}

//tab初始化
function initTab(){ 
	$('#tab_area').tabs({
		fit:true,
		border:false,
	    onSelect:function(title){
 			updateTab(title,true);	
	    } 		
	});
}
//初始化后台页面 bgIndex
function initBgIndex(){
	var url="/SysLogin!initBgIndex.do";
addTab('主页面',url);

}

//添加tab
function addTab(title,url,closable){
	var tabArea = $('#tab_area');
	if('N'==closable){
		closable = false;
	}else{
		closable = true;
	}
	var isExist = tabArea.tabs('exists',title);//tab是否已存在
	if(isExist){
		tabArea.tabs('select', title);
//		updateTab(title);//更新tab
	}else{
//        var content = '<iframe scrolling="auto" id="'+url+'" src="'+url+'" frameborder="0" style="width:100%;height:100%;"></iframe>';
        tabArea.tabs('add',{
        	iframeUrl:url,
            title:title,
            closable:closable,
            selected:false
        });
	}
	
	//关闭其他tab
	$('.tabs-inner span').each(function(i,n){
        var t = $(n).text();
        if(t != title && t!='主页面' && t!='库存报表'){
    	   closeTab(t);
        }
     }); 
}

//更新tab
function updateTab(title,closable){
	var tabArea = $('#tab_area');
	var isExist = tabArea.tabs('exists',title);//tab是否已存在
	if(isExist){
	    var tab = $('#tab_area').tabs('getTab', title);
	    var url = tab.panel('options').iframeUrl;
	    var content = '<iframe scrolling="auto" src="'+url+'" frameborder="0" style="width:100%;height:100%;"></iframe>';
		$('#tab_area').tabs('update', {
			tab: tab,
			options:{
				title:title,
				closable:closable,
				content:content
			}
		});		
	}
}

//关闭tab
function closeTab(title){
	var tabArea = $('#tab_area');
	tabArea.tabs('close', title);
} 		

//退出系统
function logout(){
	if (confirm("您确定要退出吗？")){
		window.parent.location.href= ctx+'/SysLogin!logout.do';
	}
}
//备份数据
function backupData(){
	if (!confirm("你确定备份数据吗?")){
		return;
	}
	$.ajax({
		  type: "POST",
		  async: false,
		  cache: false,
		  url: ctx+"/databaseBackup!backUp.do?1=1",
		  success : function(returnData){ 
				var data = returnData.split(",");
				var flag = data[0];
				if(flag == 'true'){
					alert('数据备份成功!\r 备份文件的位置:\r'+data[1]);
				}else{
					alert('数据备份失败');
				}
			},
			error : function(){
				alert('数据备份失败');
		 	} 
	});
}