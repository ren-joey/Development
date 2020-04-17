/**
 * Created by surgeStudio on 16/3/3.
 */
function window_control(){
    window_control_co();
    $(window).resize(function(){
       window_control_co();
    });
}

function window_control_co(){
    var window_height = $(window).height(),
        window_width = $(window).width(),
        target = $(' .testBoxCss');
    target.css({'height':window_height * 0.5 , 'width': window_width * 0.5});
    alert('window resize worked!');
}

function window_click(){
    $(' .testBoxCss').on('click',function(){
        alert('window click worked!');
    })
}