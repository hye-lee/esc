<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style>
/* Scroll top button */
#toTop {
	width: 40px;
	height: 40px;
	background-color: #ffe7c4;
	text-align: center;
	padding: 10px;
	line-height: 20px;
	position: fixed;
	bottom: 10px;
	right: 10px;
	cursor: pointer;
	display: none;
	color: #696763;
	font-size: 20px;
}

#toTop:before {
	font-style: normal;
	font-weight: normal;
	font-family: "fontello";
	content: "▲";
}

#social_footer p {
	font-size: 12px;
	color: #8c8c8c;
}

#social_footer ul {
	margin: 10px;
	padding: 0 0 10px 0;
	text-align: center;
	
}

#social_footer ul li {
	display: inline-block;
	margin: 0 5px 10px 5px;
}

#social_footer ul li a {
	color: #111;
	text-align: center;
	line-height: 34px;
	display: block;
	font-size: 16px;
	width: 35px;
	height: 35px;
	border: 1px solid rgba(255, 255, 255, 0.3);
	-webkit-border-radius: 50%;
	-moz-border-radius: 50%;
	border-radius: 50%;
}

#social_footer ul li a:hover {
	border: 1px solid #FFBB00;
	background: #FFBB00;
	color: #111;
}

.fa-angle-double-up:before {
  content: "\f102"; }


</style>  



<script>

/**
 * footer-reveal.js
 * 
 * Licensed under the MIT license.
 * http://www.opensource.org/licenses/mit-license.php
 * 
 * Copyright 2014 Iain Andrew
 * https://github.com/IainAndrew
 */

(function($) {

  $.fn.footerReveal = function(options) {

    var $this = $(this),
        $prev = $this.prev(),
        $win = $(window),

        defaults = $.extend ({
          shadow : true,
          shadowOpacity: 0.8,
          zIndex : -100
        }, options ),

        settings = $.extend(true, {}, defaults, options);

    if ($this.outerHeight() <= $win.outerHeight()) {
      $this.css({
        'z-index' : defaults.zIndex,
        position : 'fixed',
        bottom : 0
      });

      if (defaults.shadow) {
        $prev.css ({
          '-moz-box-shadow' : '0 20px 30px -20px rgba(0,0,0,' + defaults.shadowOpacity + ')',
          '-webkit-box-shadow' : '0 20px 30px -20px rgba(0,0,0,' + defaults.shadowOpacity +')',
          'box-shadow' : '0 20px 30px -20px rgba(0,0,0,' + defaults.shadowOpacity + ')'
        });
      }

      $win.on('load resize', function() {
        $this.css({
          'width' : $prev.outerWidth()
        });
        $prev.css({
          'margin-bottom' : $this.outerHeight()
        });
      });
    }

    return this;

  };

}) (jQuery);


$(function () {
	/* Scroll to top*/
	$(window).scroll(function () {
		if ($(this).scrollTop() != 0) {
			$('#toTop').fadeIn();
		} else {
			$('#toTop').fadeOut();
		}
	});
	$('#toTop').on("click", function () {
		$('body,html').animate({
			scrollTop: 0
		}, 500);
	});
});

if ($(window).width() >= 768) {
	$('footer.revealed').footerReveal({
	shadow: false,
	opacity:0.6,
	zIndex: 0
});
}

</script> 
	   <footer class="footer_top" style="text-align:center; margin-top:10px;">
	  
            	<ul style="padding-top:10px">
            		<i class="fa fa-phone"></i><font style="size:2em;">Tel:</font> <a href="tel://821072063488" id="phone">+821072063488</a>
					<i class="fa fa-envelope"></i><font>  Email: </font> <a href="mailto:hyelee52h@gmail.com" id="email_footer">hyelee52h@gmail.com</a>
				</ul>
					 
					 
               <div id="social_footer">
	               <ul>
	               		<li><a href="https://www.facebook.com/"><i class="fa fa-facebook" ></i></a></li>
						<li><a href="https://www.instagram.com"><i class="fa fa-instagram"></i></a></li>
						<li><a href="https://www.google.com"><i class="fa fa-google-plus"></i></a></li>
						<p>©Everything's Closet</p>
	               </ul>
					
			</div>
					
						
        </footer>
        
        <div id="toTop" class="fas fa-angle-double-up"></div>
        