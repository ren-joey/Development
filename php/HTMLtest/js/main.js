/**
 * Created by surgeStudio on 16/2/24.
 */

$(document).ready(function(){

    var loopingInterval01 = setInterval(loopingFunc01,50);  //可以同時有多個setInterval執行
    var loopingInterval02 = setInterval(loopingFunc02,200);
    setTimeout(function(){  //可以同時有多個setTimeout執行
        clearInterval(loopingInterval01);   //設定500毫秒後停止命名為loopingInterval01的setInterval
    },500);
    setTimeout(function(){
        clearInterval(loopingInterval02);
    },2000);

    $('<div/>',{'id':'testdiv01','onclick':'test01(event)'}).appendTo('body');  //將div放進body標籤中，並將其id定義如{}中顯示
    $('#testdiv01').css({'height':'50px','width':'50px','background-color':'#6c6c6c','opacity':'0.2'});
});

function loopingFunc01(){
    //alert('123');    測試looping會妨礙其他編輯，先隱藏起來
}

function loopingFunc02(){
    //alert('456');
}

$(document).click(function(event) {  //event(自定義)為本次html事件中，HTML傳進的DOM位置。也就是滑鼠所點擊的地方。
    alert(event.pageX);
});

function test01(event){
    x=event.clientX;
    y=event.clientY;
    if(event.altKey == true){
        alert('your X coordination is : ' + event.clientX + 'your Y coordination is : ' + y + 'alt'); //可以先帶入x再帶進alert，也可以直接將event.clientX寫進alert中
    }else if(event.altKey == false){
        alert('your X coordination is : ' + x + 'your Y coordination is : ' + y);
    }

}