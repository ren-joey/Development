var pl,fi;
var al,a1,a2,a3,ac;
var fpage,cio,c1,cio1,c2,cio2,c3,cio3,c4,cio4,c5,cio5,c6,cio6;
var navs,pb,nb,xb,ua,da,ss,sc1,sc2,sc3,sc4,sc5,sc6;
var eh4,nsew,circles,small;


$(function () {
    /* --- define --- */
    pl = $('#preloader');
    fi = $('#first-image'); eh4 = $('#contact-email h4');
    al = $('.about-me > span'); a1 = $('.about-me-1'); a2 = $('.about-me-2'); a3 = $('.about-me-3'); ac = 1;
    fpage = $('#fullpage'); pb = $('#prev'); nb = $('#next'); xb = $('.xback'); navs = $('nav'); ua = $('#up-arrow'); da = $('#down-arrow'); ss = $('.screenshot'); sc1 = $('.ten-thousand-screen'); sc2 = $('.kohanaiki-screen'); sc3 = $('.mr-c-screen'); sc4 = $('.nathan-adelson-screen'); sc5 = $('.mountainside-screen'); sc6 = $('.ocean-d-v-screen');
    cio = $('.check-it-out'); c1 = $('.case-1'); cio1 = $('#ten-thousand-case'); c2 = $('.case-2'); cio2 = $('#kohanaiki-case'); c3 = $('.case-3'); cio3 = $('#mr-c-case'); c4 = $('.case-4'); cio4 = $('#nathan-adelson-case'); c5 = $('.case-5'); cio5 = $('#mountainside-case'); c6 = $('.case-6'); cio6 = $('#ocean-d-v-case');
    nsew = $('#nsew'); circles = $('#circles'); small = $('#small-cross');

    /* --- ABOUT ME CAROUSEL --- */
    setInterval(function(){
        if(ac === 1){
            al.not(a1).removeClass('on');
            a1.addClass('on');
            ac++;
        }
        else if(ac === 2){
            al.not(a2).removeClass('on');
            a2.addClass('on');
            ac++;
        }
        else{
            al.not(a3).removeClass('on');
            a3.addClass('on');
            ac = 1;
        }
    },3000);

    /* --- FULLPAGE.JS --- tkmnm*/
    fpage.fullpage({
        scrollingSpeed: 1200,
        easingcss3: "cubic-bezier(.23, 1, .32, 1)",
        continuousVertical: true,
        normalScrollElements: '.content',
        onLeave: function(index, nextIndex, direction){
            var leavingSection = $(this);

            //after leaving Ten Thousand c1
            if(index === 1 && direction === 'down') {
              //
                c1.add(cio1).removeClass('active');
                c2.add(cio2).addClass('active');
                pb.add(nb).add(cio).removeClass('bg-light-gray');
                navs.addClass('bg-white');
                ua.add(da).removeClass('bg-white');
                ua.add(da).add(xb).addClass('bg-gray');
                $('.swipe-bg.bg-light-gray').removeClass('active');
                $('nav .swipe-bg.bg-sand, .swipe-bg.bg-white').addClass('active');
                ss.add(sc2).addClass('active');
            }

            else if(index === 1 && direction === 'up') {
              //
                c1.add(cio1).removeClass('active');
                c6.add(cio6).addClass('active');
                $('h1, nav h2, ul li').removeClass('white').addClass('light-gray');
                $('.swipe-bg.bg-white, .swipe-bg.bg-blue, .swipe-bg.bg-copper, .swipe-bg.bg-gray').removeClass('active');
                $('nav .swipe-bg.bg-gray, .swipe-bg.bg-light-gray').addClass('active');
                sc6.addClass('active');
                TweenMax.fromTo(small, 3, {css:{rotation:60}}, {css:{rotation:0}, ease:Elastic.easeOut.config(1, .4), easeParams:[1], delay: 2, repeat: 4, repeatDelay: 3});
                TweenMax.fromTo(nsew, 1.8, {css:{rotation:-30}}, {css:{rotation:0}, ease:Back.easeOut, easeParams:[1], delay: 2, repeat: 4, repeatDelay: 4.2});
                TweenMax.fromTo(circles, 5, {css:{rotation:-400}}, {css:{rotation:0}, ease:Back.easeOut, easeParams:[1], delay: 2, repeat: 4, repeatDelay: 1});
            }

            //after leaving Kohanaiki c2
            else if(index === 2 && direction === 'down') {
                c2.add(cio2).removeClass('active');
                c3.add(cio3).addClass('active');
                $('h1, nav h2, ul li').removeClass('white').addClass('light-gray');
                $('ul li').removeClass('white').addClass('red');
                ua.add(da).removeClass('bg-gray');
                ua.add(da).add(xb).addClass('bg-white');
                $('nav .swipe-bg.bg-sand, .swipe-bg.bg-white').removeClass('active');
                $('nav .swipe-bg.bg-white, .swipe-bg.bg-red').addClass('active');
                sc3.addClass('active');
                eh4.removeClass('white').addClass('gray');
            }

            else if(index === 2 && direction === 'up') {
                c2.add(cio2).removeClass('active');
                c1.add(cio1).addClass('active');
                $('nav .swipe-bg.bg-sand, .swipe-bg.bg-white').removeClass('active');
                $('.swipe-bg.bg-light-gray').addClass('active');
                $('h1, nav h2, ul li').removeClass('white').addClass('light-gray');
                $('ul li').removeClass('white').addClass('light-gray');
                ua.add(da).add(xb).add(xb).removeClass('bg-gray');
                ua.add(da).add(xb).addClass('bg-white');
                ss.add(sc2).removeClass('active');
            }

            //after leaving Mr. C Hotel c3
            else if(index === 3 && direction === 'down') {
                c3.add(cio3).removeClass('active');
                c4.add(cio4).addClass('active');
                $('ul li').removeClass('red').addClass('gold');
                sc4.addClass('active');
                $('.swipe-bg.bg-red').removeClass('active');
                $('.swipe-bg.bg-teal, .swipe-bg.bg-gold').addClass('active');

            }

            else if(index === 3 && direction === 'up') {
                c3.add(cio3).removeClass('active');
                c2.add(cio2).addClass('active');
                pb.add(nb).add(xb).add(cio).removeClass('bg-white');
                $('ul li').removeClass('red').addClass('light-gray');
                ua.add(da).removeClass('bg-white');
                ua.add(da).add(xb).addClass('bg-gray');
                $('nav .swipe-bg.bg-white, .swipe-bg.bg-red').removeClass('active');
                $('nav .swipe-bg.bg-sand, .swipe-bg.bg-white').addClass('active');
                sc3.removeClass('active');
                sc2.addClass('active');
                eh4.removeClass('gray').addClass('white');
            }

            //after leaving Nathan Adelson c4
            else if(index === 4 && direction ==='down') {
                c4.add(cio4).removeClass('active');
                c5.add(cio5).addClass('active');
                pb.add(nb).add(cio).removeClass('bg-white');
                navs.addClass('bg-blue');
                $('ul li').removeClass('gold').addClass('white');
                $('.swipe-bg.bg-teal, .swipe-bg.bg-gold').removeClass('active');
                $('.swipe-bg.bg-blue, .swipe-bg.bg-copper, .swipe-bg.bg-gray').addClass('active');
                $('h1, nav h2, ul li').removeClass('light-gray').addClass('white');
                sc5.addClass('active');
                eh4.removeClass('gray').addClass('white');
                TweenMax.fromTo(small, 3, {css:{rotation:60}}, {css:{rotation:0}, ease:Elastic.easeOut.config(1, .4), easeParams:[1], delay: 2, repeat: 4, repeatDelay: 3});
                TweenMax.fromTo(nsew, 1.8, {css:{rotation:-30}}, {css:{rotation:0}, ease:Back.easeOut, easeParams:[1], delay: 2, repeat: 4, repeatDelay: 4.2});
                TweenMax.fromTo(circles, 5, {css:{rotation:-400}}, {css:{rotation:0}, ease:Back.easeOut, easeParams:[1], delay: 2, repeat: 4, repeatDelay: 1});
            }

            else if(index === 4 && direction === 'up') {
                c4.add(cio4).removeClass('active');
                c3.add(cio3).addClass('active');
                $('ul li').removeClass('gold').addClass('red');
                $('.swipe-bg.bg-teal, .swipe-bg.bg-gold').removeClass('active');
                $('.swipe-bg.bg-red').addClass('active');
                sc3.addClass('active');
                sc4.removeClass('active');
            }

            //after leaving Mountainside c5
            else if(index === 5 && direction ==='down') {
              //
                c5.add(cio5).removeClass('active');
                c6.add(cio6).addClass('active');
                pb.add(nb).add(cio).removeClass('bg-copper');
                navs.removeClass('bg-blue').addClass('bg-gray');
                $('h1, nav h2, ul li').removeClass('white').addClass('light-gray');
                $('.swipe-bg.bg-white, .swipe-bg.bg-blue, .swipe-bg.bg-copper, .swipe-bg.bg-gray').removeClass('active');
                $('nav .swipe-bg.bg-gray, .swipe-bg.bg-light-gray').addClass('active');
                //sc2.add(sc3).add(sc4).add(sc5).removeClass('active');
                sc5.removeClass('active');
                sc6.addClass('active');
            }

            else if(index === 5 && direction === 'up') {
                c5.add(cio5).removeClass('active');
                c4.add(cio4).addClass('active');
                pb.add(nb).add(cio).removeClass('bg-copper');
                navs.removeClass('bg-blue').addClass('bg-white');
                $('.swipe-bg.bg-blue, .swipe-bg.bg-copper, .swipe-bg.bg-gray, .swipe-bg.bg-light-gray').removeClass('active');
                $('.swipe-bg.bg-teal, .swipe-bg.bg-gold').addClass('active');
                $('h1, nav h2, ul li').removeClass('white');
                $('h1, nav h2').addClass('light-gray');
                $('ul li').addClass('gold');
                sc5.removeClass('active');
                sc4.addClass('active');
                eh4.removeClass('white').addClass('gray');
            }

            //after leaving ocean d v c6
            else if(index === 6 && direction ==='down') {
              //
                c6.add(cio6).removeClass('active');
                c1.add(cio1).addClass('active');
                pb.add(nb).add(cio).removeClass('bg-copper');
                navs.removeClass('bg-blue').addClass('bg-gray');
                $('h1, nav h2, ul li').removeClass('white').addClass('light-gray');
                $('.swipe-bg.bg-white, .swipe-bg.bg-blue, .swipe-bg.bg-copper, .swipe-bg.bg-gray').removeClass('active');
                $('nav .swipe-bg.bg-gray, .swipe-bg.bg-light-gray').addClass('active');
                sc2.add(sc3).add(sc4).add(sc5).add(sc6).removeClass('active');
            }

            else if(index === 6 && direction === 'up') {
              //
                c6.add(cio6).removeClass('active');
                c5.add(cio5).addClass('active');
                pb.add(nb).add(cio).removeClass('bg-copper');
                navs.removeClass('bg-blue').addClass('bg-white');
                $('.swipe-bg.bg-blue, .swipe-bg.bg-copper, .swipe-bg.bg-gray, .swipe-bg.bg-light-gray').removeClass('active');
                $('.swipe-bg.bg-teal, .swipe-bg.bg-gold').addClass('active');
                $('h1, nav h2, ul li').removeClass('white');
                $('h1, nav h2').addClass('light-gray');
                $('ul li').addClass('gold');
                sc6.removeClass('active');
                sc5.addClass('active');
                eh4.removeClass('white').addClass('gray');
            }

        }
    });

    /* --- fullpage switch button --- */
    $('#arrows')
        .on('click', '#prev' ,function(){
        $.fn.fullpage.moveSectionUp();})
        .on('click', '#next' ,function(){
        $.fn.fullpage.moveSectionDown();
    });

    /* --- preloader damaged --- */
    $(window).on('load', function () {
        pl.removeClass('active');
        fi.removeClass('first-image');
        setTimeout(
            function(){
                c1.add(eh4).addClass('active');
                pl.fadeOut('slow');
            }, 2000);
        $('body').css({'overflow':'visible'});
    });

    /* --- PAGE TRANSITIONS --- */
    $(document).on('click', '.check-it-out a', function() {
        $('.laptop, .check-it-out, #case-numbers span, #case-outof span, #case-hashtags, nav, #case-title').addClass('out');
        $('.right-half').addClass('open');
        $('.accent-image').addClass('close');
        $('#up-arrow, #down-arrow').addClass('turn');
    });

    $(document).on('click', '.check-it-out.out', function() {
        $('.laptop, .check-it-out, #case-numbers span, #case-outof span, #case-hashtags, nav, #case-title').removeClass('out');
        $('.right-half').removeClass('open');
        $('.accent-image').removeClass('close');
        $('#up-arrow, #down-arrow').removeClass('turn');
    });

    /* --- COMPASS --- */

    $(document).on('click', '.check-it-out a#mountainside-case', function() {

        TweenMax.fromTo(small, 3, {css:{rotation:60}}, {css:{rotation:0}, ease:Elastic.easeOut.config(1, .4), easeParams:[1], delay: 2, repeat: 4, repeatDelay: 3});
        TweenMax.fromTo(nsew, 1.8, {css:{rotation:-30}}, {css:{rotation:0}, ease:Back.easeOut, easeParams:[1], delay: 2, repeat: 4, repeatDelay: 4.2});
        TweenMax.fromTo(circles, 5, {css:{rotation:-400}}, {css:{rotation:0}, ease:Back.easeOut, easeParams:[1], delay: 2, repeat: 4, repeatDelay: 1});

    });
});
