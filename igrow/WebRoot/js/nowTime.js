	//获取当前时间
	function current(){ 
		var d=new Date(),str=''; 
		str += d.getFullYear() + '年'; 
		if((d.getMonth()+1) < 10){
			str +=  '0' + (d.getMonth()+1) +'月';
		}else{
			str += (d.getMonth()+1) + '月';
		}
		
		if(d.getDate() < 10){
			str += '0' +  d.getDate() + '日　'; 
		}else{
			str +=d.getDate()+'日　'; 
		}
		
		if(d.getHours() < 10){
			str += '0' +  d.getHours() + ':';
		}else{
			str += d.getHours() + ':';
		}
		
		if(d.getMinutes() < 10){
			str += '0' + d.getMinutes() + ':'; 
		}else{
			str += d.getMinutes() + ':'; 
		}
		 
		if(d.getSeconds() < 10){
			str += '0' + d.getSeconds(); 
		}else{
			str += d.getSeconds(); 
		}
		return str; 
	} 
	//显示当前时间
	function showTime(){ 
		$(".nowTime").html(current)
	} 
	//初始化当前时间
	$(function(){
		showTime();
	});
	//动态显示当前时间
	setInterval("showTime()",1000); 
	
