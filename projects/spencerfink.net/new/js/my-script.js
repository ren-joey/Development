$( document ).ready(function() {

/* --- ABOUT ME CAROUSEL --- */

	setInterval(function aboutSwap() {

		var aboutnumber = Math.floor(Math.random() * 7) + 1;

		if ( aboutnumber == 1 ) {
			$('.about-me-2, .about-me-3, .about-me-4, .about-me-5, .about-me-6, .about-me-7').removeClass('on');
			$('.about-me-1').addClass('on');
		}
		else if ( aboutnumber == 2 ) {
			$('.about-me-1, .about-me-3, .about-me-4, .about-me-5, .about-me-6, .about-me-7').removeClass('on');
			$('.about-me-2').addClass('on');
		}
		else if ( aboutnumber == 3 ) {
			$('.about-me-1, .about-me-2, .about-me-4, .about-me-5, .about-me-6, .about-me-7').removeClass('on');
			$('.about-me-3').addClass('on');
		}
		else if ( aboutnumber == 4 ) {
			$('.about-me-1, .about-me-2, .about-me-3, .about-me-5, .about-me-6, .about-me-7').removeClass('on');
			$('.about-me-4').addClass('on');
		}
		else if ( aboutnumber == 5 ) {
			$('.about-me-1, .about-me-2, .about-me-3, .about-me-4, .about-me-6, .about-me-7').removeClass('on');
			$('.about-me-5').addClass('on');
		}
		else if ( aboutnumber == 6 ) {
			$('.about-me-1, .about-me-2, .about-me-3, .about-me-4, .about-me-5, .about-me-7').removeClass('on');
			$('.about-me-6').addClass('on');
		}
		else {
			$('.about-me-1, .about-me-2, .about-me-3, .about-me-4, .about-me-5, .about-me-6').removeClass('on');
			$('.about-me-7').addClass('on');
		}

	}, 5000);

/* --- FULLPAGE.JS --- */

	$('#fullpage').fullpage({

		// anchors: ['ten-thousand-residences', 'mr-c-hotel', 'deciding-tomorrow-today', 'mountainside-northstar'],
		scrollingSpeed: 1200,
		easingcss3: "cubic-bezier(.23, 1, .32, 1)",
		continuousVertical: true,
		normalScrollElements: '.content',
        onLeave: function(index, nextIndex, direction){
            var leavingSection = $(this);

            //after leaving Ten Thousand
            if(index == 1 && direction =='down') {
				$('#ten-thousand-case, .case-1').removeClass('active');
				$('#kohanaiki-case, .case-2').addClass('active');
				$('#prev, #next, .check-it-out').removeClass('bg-light-gray');
				$('nav').addClass('bg-white');
				$('#up-arrow, #down-arrow').removeClass('bg-white');
				$('#up-arrow, #down-arrow, .xback').addClass('bg-gray');
				$('.swipe-bg.bg-light-gray').removeClass('active');
				$('nav .swipe-bg.bg-sand, .swipe-bg.bg-white').addClass('active');
				$('.screenshot .kohanaiki-screen').addClass('active');	
            }

            else if(index == 1 && direction == 'up') {
				$('#ten-thousand-case, .case-1').removeClass('active');
				$('#mountainside-case, .case-5').addClass('active');
				$('#prev, #next, .check-it-out').removeClass('bg-light-gray');	
				$('h1, nav h2, ul li').removeClass('light-gray');
				$('h1, nav h2, ul li').addClass('white');
				$('.swipe-bg.bg-light-gray, .swipe-bg.bg-gray').removeClass('active');
				$('nav .swipe-bg.bg-white, .swipe-bg.bg-blue, .swipe-bg.bg-copper, .swipe-bg.bg-gray').addClass('active');
				$('.mountainside-screen').addClass('active');	
				var nsew = document.getElementById("nsew"),
				circles = document.getElementById("circles"),
				small = document.getElementById("small-cross");
				TweenMax.fromTo(small, 3, {css:{rotation:60}}, {css:{rotation:0}, ease:Elastic.easeOut.config(1, .4), easeParams:[1], delay: 2, repeat: 4, repeatDelay: 3});
				TweenMax.fromTo(nsew, 1.8, {css:{rotation:-30}}, {css:{rotation:0}, ease:Back.easeOut, easeParams:[1], delay: 2, repeat: 4, repeatDelay: 4.2});
				TweenMax.fromTo(circles, 5, {css:{rotation:-400}}, {css:{rotation:0}, ease:Back.easeOut, easeParams:[1], delay: 2, repeat: 4, repeatDelay: 1});
            }

            //after leaving Kohanaiki
            else if(index == 2 && direction =='down') {
				$('#kohanaiki-case, .case-2').removeClass('active');
				$('#mr-c-case, .case-3').addClass('active');
				$('h1, nav h2, ul li').removeClass('white');
				$('h1, nav h2, ul li').addClass('light-gray');
				$('ul li').removeClass('white');
				$('ul li').addClass('red');
				$('#up-arrow, #down-arrow, .xback').removeClass('bg-gray');
				$('#up-arrow, #down-arrow').addClass('bg-white');
				$('nav .swipe-bg.bg-sand, .swipe-bg.bg-white').removeClass('active');
				$('nav .swipe-bg.bg-white, .swipe-bg.bg-red').addClass('active');
				$('.mr-c-screen').addClass('active');
				$('#contact-email h4').removeClass('white');
				$('#contact-email h4').addClass('gray');
			}

            else if(index == 2 && direction =='up') {
				$('#kohanaiki-case, .case-2').removeClass('active');
				$('#ten-thousand-case, .case-1').addClass('active');
				$('nav .swipe-bg.bg-sand, .swipe-bg.bg-white').removeClass('active');
				$('.swipe-bg.bg-light-gray').addClass('active');
				$('h1, nav h2, ul li').removeClass('white');
				$('h1, nav h2, ul li').addClass('light-gray');	
				$('ul li').removeClass('white');
				$('ul li').addClass('light-gray');
				$('#up-arrow, #down-arrow, .xback').removeClass('bg-gray');
				$('#up-arrow, #down-arrow').addClass('bg-white');
				$('.screenshot .kohanaiki-screen').removeClass('active');
			}

            //after leaving Mr. C Hotel
            else if(index == 3 && direction =='down') {
				$('#mr-c-case, .case-3').removeClass('active');
				$('#nathan-adelson-case, .case-4').addClass('active');
				$('ul li').removeClass('red');
				$('ul li').addClass('gold');
				$('.nathan-adelson-screen').addClass('active');
				$('.swipe-bg.bg-red').removeClass('active');
				$('.swipe-bg.bg-teal, .swipe-bg.bg-gold').addClass('active');

            }

            else if(index == 3 && direction == 'up') {
				$('#mr-c-case, .case-3').removeClass('active');
				$('#kohanaiki-case, .case-2').addClass('active');
				$('#prev, #next, .check-it-out, nav').removeClass('bg-white');
				$('ul li').removeClass('red');
				$('ul li').addClass('light-gray');
				$('#up-arrow, #down-arrow').removeClass('bg-white');
				$('#up-arrow, #down-arrow, .xback').addClass('bg-gray');
				$('nav .swipe-bg.bg-white, .swipe-bg.bg-red').removeClass('active');
				$('nav .swipe-bg.bg-sand, .swipe-bg.bg-white').addClass('active');
				$('.mr-c-screen').removeClass('active');
				$('#contact-email h4').removeClass('gray');
				$('#contact-email h4').addClass('white');
            }

            //after leaving Nathan Adelson
            else if(index == 4 && direction =='down') {
				$('#nathan-adelson-case, .case-4').removeClass('active');
				$('#mountainside-case, .case-5').addClass('active');
				$('#prev, #next, .check-it-out').removeClass('bg-white');
				$('nav').addClass('bg-blue');
				$('ul li').removeClass('gold');
				$('ul li').addClass('white');
				$('.swipe-bg.bg-teal, .swipe-bg.bg-gold').removeClass('active');
				$('.swipe-bg.bg-blue, .swipe-bg.bg-copper, .swipe-bg.bg-gray').addClass('active');
				$('h1, nav h2, ul li').removeClass('light-gray');
				$('h1, nav h2, ul li').addClass('white');	
				$('.mountainside-screen').addClass('active');
				$('#contact-email h4').removeClass('gray');
				$('#contact-email h4').addClass('white');
				
				var nsew = document.getElementById("nsew"),
				circles = document.getElementById("circles"),
				small = document.getElementById("small-cross");
				TweenMax.fromTo(small, 3, {css:{rotation:60}}, {css:{rotation:0}, ease:Elastic.easeOut.config(1, .4), easeParams:[1], delay: 2, repeat: 4, repeatDelay: 3});
				TweenMax.fromTo(nsew, 1.8, {css:{rotation:-30}}, {css:{rotation:0}, ease:Back.easeOut, easeParams:[1], delay: 2, repeat: 4, repeatDelay: 4.2});
				TweenMax.fromTo(circles, 5, {css:{rotation:-400}}, {css:{rotation:0}, ease:Back.easeOut, easeParams:[1], delay: 2, repeat: 4, repeatDelay: 1});
            }

            else if(index == 4 && direction == 'up') {
				$('#nathan-adelson-case, .case-4').removeClass('active');
				$('#mr-c-case, .case-3').addClass('active');
				$('ul li').removeClass('gold');
				$('ul li').addClass('red');
				$('.swipe-bg.bg-teal, .swipe-bg.bg-gold').removeClass('active');
				$('.swipe-bg.bg-red').addClass('active');
				$('.mr-c-screen').addClass('active');	
				$('.nathan-adelson-screen').removeClass('active');
            }

            //after leaving Mountainside
            else if(index == 5 && direction =='down') {
				$('#mountainside-case, .case-5').removeClass('active');
				$('#ten-thousand-case, .case-1').addClass('active');
				$('#prev, #next, .check-it-out').removeClass('bg-copper');
				$('nav').removeClass('bg-blue');
				$('nav').addClass('bg-gray');
				$('h1, nav h2, ul li').removeClass('white');
				$('h1, nav h2, ul li').addClass('light-gray');
				$('.swipe-bg.bg-white, .swipe-bg.bg-blue, .swipe-bg.bg-copper, .swipe-bg.bg-gray').removeClass('active');
				$('nav .swipe-bg.bg-gray, .swipe-bg.bg-light-gray').addClass('active');
				$('.kohanaiki-screen, .mr-c-screen, .nathan-adelson-screen, .mountainside-screen').removeClass('active');
            }

            else if(index == 5 && direction == 'up') {
				$('#mountainside-case, .case-5').removeClass('active');
				$('#nathan-adelson-case, .case-4').addClass('active');
				$('#prev, #next, .check-it-out').removeClass('bg-copper');
				$('nav').removeClass('bg-blue');
				$('nav').addClass('bg-white');
				$('.swipe-bg.bg-blue, .swipe-bg.bg-copper, .swipe-bg.bg-gray, .swipe-bg.bg-light-gray').removeClass('active');
				$('.swipe-bg.bg-teal, .swipe-bg.bg-gold').addClass('active');	
				$('h1, nav h2, ul li').removeClass('white');
				$('h1, nav h2').addClass('light-gray');
				$('ul li').addClass('gold');
				$('.mountainside-screen').removeClass('active');
				$('.nathan-adelson-screen').addClass('active');
				$('#contact-email h4').removeClass('white');
				$('#contact-email h4').addClass('gray');
            }

        }

	});

	$(document).on('click', '#prev', function() {
  		$.fn.fullpage.moveSectionUp();
	});
	$(document).on('click', '#next', function() {
  		$.fn.fullpage.moveSectionDown();
	});

/* --- PRELOADER --- */

	$(window).load(function() {
   		$('#preloader').removeClass('active');
   		$('#first-image').removeClass('first-image');
	   setTimeout(
	   	function(){
	   $('.case-1, #contact-email h4').addClass('active');
	   $('#preloader').fadeOut('slow');
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

		var nsew = document.getElementById("nsew"),
		circles = document.getElementById("circles"),
		small = document.getElementById("small-cross");

		TweenMax.fromTo(small, 3, {css:{rotation:60}}, {css:{rotation:0}, ease:Elastic.easeOut.config(1, .4), easeParams:[1], delay: 2, repeat: 4, repeatDelay: 3});
		TweenMax.fromTo(nsew, 1.8, {css:{rotation:-30}}, {css:{rotation:0}, ease:Back.easeOut, easeParams:[1], delay: 2, repeat: 4, repeatDelay: 4.2});
		TweenMax.fromTo(circles, 5, {css:{rotation:-400}}, {css:{rotation:0}, ease:Back.easeOut, easeParams:[1], delay: 2, repeat: 4, repeatDelay: 1});

	});

});