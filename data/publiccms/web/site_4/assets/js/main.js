var userId;
function comment(){
	if (CMS_PATH) {
		var csrf;
		$.ajax({url:CMS_PATH+"getcsrf.html?userId="+userId,async:false,success:function(data){
			csrf=data.csrf;
		}});
		if(csrf){
			$('.comment-text-box input[name=_csrf]').val(csrf);
			return true;
		}
	}
	return false;
}
$(function(){
	// 登陆状态显示
	if (CMS_PATH) {
		$.ajaxSetup({xhrFields: {withCredentials: true}});
		$.getJSON(CMS_PATH+'loginStatus', function(data){
			if(data.id){
				userId=data.id;
				$('.user-login').hide();
				$('.nickname').text(data.nickname);
				$('.user-logout').show();
				if(data.superuser&&true==data.superuser){
					$('.user-logout .master').show();
				}
			}else{
				$('.user-login').show();
			}
		});
	}
	// 登陆链接增加返回地址
	if(0>window.location.href.indexOf('returnUrl')){
		$('a.user-login,a.user-logout,.user-login a').each(function(){
			$(this).prop('href',$(this).prop('href')+'?returnUrl='+encodeURIComponent(window.location.href));
		});		
	}
});