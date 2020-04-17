/**
 * Created by surgeStudio on 16/2/24.
 */
$(function(){  //此行等同$(document).ready(function(){});

    var divFallin = setInterval(divFallinFunc,500); //瀑布式佈局依序載入練習

    var a = 0;

    function divFallinFunc(){
        var className = 'class_num';
        $('<div/>',{'class':className + a + ' origin_css'}).appendTo('body').animate({'opacity':'1','margin-top':'0px'},1000);
        a++;
        if(a>=10)
        {setTimeout(function(){clearInterval(divFallin);},10);}
    }
});


