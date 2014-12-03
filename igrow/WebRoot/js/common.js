//文本框回车搜索方法
function keydownsearch(evt){
			evt = (evt) ? evt : ((window.event) ? window.event : "")
			keyCode = evt.keyCode ? evt.keyCode : (evt.which ? evt.which : evt.charCode);
			if (keyCode == 13) {
				commonSearch();//搜索事件
			}
} 

//重置
function resetSaveForm(){
	 	var vform= $("#saveForm").Validform();
	 	vform.resetForm();
} 

 
Date.prototype.setISO8601 = function (string) {  
    var regexp = "([0-9]{4})(-([0-9]{2})(-([0-9]{2})" +  
        "(T([0-9]{2}):([0-9]{2})(:([0-9]{2})(\.([0-9]+))?)?" +  
        "(Z|(([-+])([0-9]{2}):([0-9]{2})))?)?)?)?";  
    if(string)  
    {  
        var d = string.match(new RegExp(regexp));  
       
        var offset = 0;  
        var date = new Date(d[1], 0, 1);  
        if (d[3]) {  
            date.setMonth(d[3] - 1);  
        }  
        if (d[5]) {  
            date.setDate(d[5]);  
        }  
        if (d[7]) {  
            date.setHours(d[7]);  
        }  
        if (d[8]) {  
            date.setMinutes(d[8]);  
        }  
        if (d[10]) {  
            date.setSeconds(d[10]);  
        }  
        if (d[12]) {  
            date.setMilliseconds(Number("0." + d[12]) * 1000);  
        }  
        if (d[14]) {  
            offset = (Number(d[16]) * 60) + Number(d[17]);  
            offset *= ((d[15] == '-') ? 1 : -1);  
        }  
        return date;  
    }  
    else  
    {  
        return;  
    }  
}  



String.prototype.replaceAll = function(s1,s2) { 
    return this.replace(new RegExp(s1,"gm"),s2); 
}

//人民币金额转大写程序 JavaScript版     
//CopyRight Bardo QI     
    
function numToCny(num){     
    var capUnit = ['万','亿','万','圆',''];     
    var capDigit = { 2:['角','分',''], 4:['仟','佰','拾','']};     
    var capNum=['零','壹','贰','叁','肆','伍','陆','柒','捌','玖'];     
    if (((num.toString()).indexOf('.') > 16)||(isNaN(num)))      
        return '';     
    num = (Math.round(num*100)/100).toString();     
    num =((Math.pow(10,19-num.length)).toString()).substring(1)+num;     
    var i,ret,j,nodeNum,k,subret,len,subChr,CurChr=[];     
    for (i=0,ret='';i<5;i++,j=i*4+Math.floor(i/4)){     
        nodeNum=num.substring(j,j+4);     
        for(k=0,subret='',len=nodeNum.length;((k<len) && (parseInt(nodeNum.substring(k))!=0));k++){     
            CurChr[k%2] = capNum[nodeNum.charAt(k)]+((nodeNum.charAt(k)==0)?'':capDigit[len][k]);     
            if (!((CurChr[0]==CurChr[1]) && (CurChr[0]==capNum[0])))     
                if(!((CurChr[k%2] == capNum[0]) && (subret=='') && (ret=='')))     
                    subret += CurChr[k%2];     
        }     
        subChr = subret + ((subret=='')?'':capUnit[i]);     
        if(!((subChr == capNum[0]) && (ret=='')))     
            ret += subChr;     
    }     
    ret=(ret=='')? capNum[0]+capUnit[3]: ret;       
    return ret;     
}   

