$(function() {

    /* --- FULLPAGE.JS --- */

    var shapes = $("ellipse"),
        svgImg = $('.svg-img'),
        btn = $('#btn'),
        ps = $('#page-scroll'),
        psA = $('#ps-arrow'),
        tl, svgAni, btnAni, psAni;
        tl = new TimelineMax({repeat:-1});
        svgAni = new TimelineMax;
        btnAni =  TweenMax.fromTo(btn,2,{scale:0.95},{scale:1,ease:Linear.easeNone,repeat:-1,yoyo:true});
        if($(window).width() < 1200){
            TweenMax.set(ps,{bottom:'0',opacity:'1'});
            psAni = TweenMax.from(ps,1,{bottom:'0',opacity:'1'});
        }else {
            psAni = TweenMax.fromTo(ps,1,{bottom:'10%',opacity:'0.2'},{bottom:'5%',opacity:'0.6',repeat:-1,ease:Linear.easeNone,yoyo:true});
        }

        $(window).resize(function () {
            if($(window).width() < 1200){
                TweenMax.set(ps,{bottom:'0',opacity:'1'});
                psAni = TweenMax.from(ps,1,{bottom:'0',opacity:'1'});
            }else {
                psAni = TweenMax.fromTo(ps,1,{bottom:'10%',opacity:'0.2'},{bottom:'5%',opacity:'0.6',repeat:-1,ease:Linear.easeNone,yoyo:true});}
        });

    btnAni.pause();
    psAni.pause();
    tl.staggerFromTo(shapes, 2, {drawSVG:'0'},{drawSVG:'100%',ease:Linear.easeNone}, 1)
        .staggerTo(shapes,2,{drawSVG:'100% 100%',ease:Linear.easeNone},1,"-=1");
    svgAni.from(svgImg,2,{opacity:0,delay:1.5})
        .fromTo('#Crafticons_Simple_Set',1,{'fill-opacity':0.2},{'fill-opacity':1,repeat:-1,yoyo:true,ease:Linear.easeNone});

    $('#fullpage').fullpage({

        // anchors: ['ten-thousand-residences', 'mr-c-hotel', 'deciding-tomorrow-today', 'mountainside-northstar'],
        scrollingSpeed: 1200,
        easingcss3: "cubic-bezier(.23, 1, .32, 1)",
        onLeave: function(index, nextIndex, direction){
            var leavingSection = $(this);

            //after leaving Ten Thousand
            if(index == 1 && direction =='down') {
                $('.page-1').removeClass('active');
                $('.page-2').addClass('active');
                tl.stop();svgAni.stop();psAni.play(0);
                psA.css({'stroke':'#e32d7c','stroke-opacity':'1'});
                ps.css({'z-index':'4'});
            }
            else if(index == 1 && direction == 'up') {
            }

            if(index == 2 && direction =='down') {
                $('.page-2').removeClass('active');
                $('.page-3').addClass('active');
                $('#page-header').addClass('active');
                psA.css({'stroke':'white'});
                ps.css({'z-index':'2'});
            }
            else if(index == 2 && direction == 'up') {
                $('.page-2').removeClass('active');
                $('.page-1').addClass('active');
                tl.play(0);svgAni.play(0);psAni.pause();
                psA.css({'stroke-opacity':'0'});
                ps.css({'z-index':'2'});
            }

            if(index == 3 && direction =='down') {
                $('.page-3').removeClass('active');
                $('.page-4').addClass('active');
                btnAni.play(0);psAni.pause();
                psA.css({'stroke-opacity':'0'});
            }
            else if(index == 3 && direction == 'up') {
                $('.page-3').removeClass('active');
                $('.page-2').addClass('active');
                $('#page-header').removeClass('active');
                psA.css({'stroke':'#e32d7c'});
                ps.css({'z-index':'4'});
            }

            if(index == 4 && direction == 'up') {
                $('.page-4').removeClass('active');
                $('.page-3').addClass('active');
                btnAni.pause();psAni.play(0);
                psA.css({'stroke-opacity':'1'});
                $('.p4-btn').removeClass('closed');
                //showForm(false);
            }
        }

    });

    // function showForm(bool){
    //     if(bool){
    //         btnAni.reverse();
    //         $('#google-iframe').addClass('active');
    //         $('.p4-btn').addClass('closed');
    //     }else{
    //         $('#google-iframe').removeClass('active')
    //     }
    // }

    $('#scroll-down').on('click',function () {
        $.fn.fullpage.moveSectionDown();
    });

    $('#scroll-up').on('click',function () {
        $.fn.fullpage.moveSectionUp();
    });

    $('.p4-btn').on('click',function(){
        //showForm(true);
        window.location.href = 'https://docs.google.com/forms/d/e/1FAIpQLSdwJapG2Y4CL59j_oGb1QhoHSCAYfh-hCM9zps2PMsr82LtgA/viewform?embedded=true';
    });
});