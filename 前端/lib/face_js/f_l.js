//<script type="text/javascript" src='./js/stopExecutionOnTimeout.js?t=1'></script>
//	<script type="text/javascript" src="./js/jquery-2.1.1.min.js"></script>
//	<script type="text/javascript" src="./js/jquery-ui.min.js"></script>
//	<script type="text/javascript" src="http://pv.sohu.com/cityjson?ie=utf-8"></script>  
//
//	<script>
//
//	 $("#login").click(function(){
//				var userName=$("#userName").val();
//				var password=$("#password").val();
//			 	$.ajax({
//					url:"<%=basePath%>admin/login",
//					type:"post",
//					data:{
//						"userName":userName,
//						"password":password,
//						"ip":returnCitySN.cip,
//						},
//					dataType:"json",
//					success:function(result){
//						$("#msg").html(result.msg);
//						if(result.state!=2 ){
//						
//						$("#in").hide();
//						}else{
//						$("#user").html("欢迎你:"+result.data.userName);
//						}
//						
//					
//						
//						/* $("#data").html("上次登录IP:"+result.data.username);
//						$("#data").html("上次登录时间:"+result.data.username); */
//						/*  $("#data").after("<a href='jsp/manage/index.jsp' class='submit'>返回</a>"); */
//						/* if (result.state != 2) {
//							$("#sub").after("<a href="jsp/manage/index.jsp" class="submit">返回</a>");
//						} else {
//							$("#sub").after("<a href="jsp/manage/index.jsp" class="submit">进入系统</a>");
//						} */
//	    
//					},
//					error:function(){
//						alert("登录异常");
//					}
//				}); 
//			}); 
//	$('input[type="submit"]').click(function () {
//	
//	 
//	    $('.login').addClass('test');
//	    setTimeout(function () {
//	        $('.login').addClass('testtwo');
//	    }, 300);
//	    setTimeout(function () {
//	        $('.authent').show().animate({ right: -320 }, {
//	            easing: 'easeOutQuint',
//	            duration: 600,
//	            queue: false
//	        });
//	        $('.authent').animate({ opacity: 1 }, {
//	            duration: 200,
//	            queue: false
//	        }).addClass('visible');
//	    }, 500);
//	    setTimeout(function () {
//	        $('.authent').show().animate({ right: 90 }, {
//	            easing: 'easeOutQuint',
//	            duration: 600,
//	            queue: false
//	        });
//	        $('.authent').animate({ opacity: 0 }, {
//	            duration: 200,
//	            queue: false
//	        }).addClass('visible');
//	        $('.login').removeClass('testtwo');
//	    }, 2500);
//	    setTimeout(function () {
//	        $('.login').removeClass('test');
//	        $('.login div').fadeOut(123);
//	    }, 2800);
//	    setTimeout(function () {
//	        $('.success').fadeIn();
//	    }, 3200);
//	    
//	});
//	$('input[type="text"],input[type="password"]').focus(function () {
//	    $(this).prev().animate({ 'opacity': '1' }, 200);
//	});
//	$('input[type="text"],input[type="password"]').blur(function () {
//	    $(this).prev().animate({ 'opacity': '.5' }, 200);
//	});
//	$('input[type="text"],input[type="password"]').keyup(function () {
//	    if (!$(this).val() == '') {
//	        $(this).next().animate({
//	            'opacity': '1',
//	            'right': '30'
//	        }, 200);
//	    } else {
//	        $(this).next().animate({
//	            'opacity': '0',
//	            'right': '20'
//	        }, 200);
//	    }
//	});
//	var open = 0;
//	$('.tab').click(function () {
//	    $(this).fadeOut(200, function () {
//	        $(this).parent().animate({ 'left': '0' });
//	    });
//	});
//	</script>
//	<script src="./js/canva_moving_effect.js"></script>
