/**
 * Created by surgeStudio on 16/2/24.
 */
$(function(){  //此行等同$(document).ready(function(){});
    $('#test01').attr({'class':'thisName','id':'thisId'}).addClass('thisNameTest').removeClass('thisName');
    $('<p/>',{'id':'testPdom'})
        //.load('data/testdata.txt')  //load功能要在伺服器端才能正常運作
        .appendTo('#thisId').html('我的文字')
        .css({'color':'#6c6c6c'})
        .hover(function(){
            $(this).stop().animate({'opacity':'0.5'},200);
        },function(){
            $(this).stop().animate({'opacity':'1'},200);
        });
    //互動式網站前台 page 5-14

    var contains_1 = $('div:contains(1)'); //選取所有包含1的div並放進contains_1
    var contains_1_together = '', contains_2_together = '';
    var contains_2 = $('div:contains(2)');
    for(var i = 0 ; i < contains_1.length ; i ++ ){
        contains_1_together += contains_1[i].id; //將陣列中抓到的所有包含1的div的id輸出成一串字元放進contains_1_together
    }
    for(var j = 0 ; j <contains_2.length ; j ++ ){
        contains_2_together += contains_2[j].id;
    }
    alert('包含1的div有'+ contains_1_together +'。包含2的div有'+ contains_2_together);
});