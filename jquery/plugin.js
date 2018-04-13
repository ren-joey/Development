

(function ($) {
  $.fn.swipeTags = function(options){
    var settings = $.extend({
      color: 'blue',
      bgc: 'yellow',
      pl: '5rem',
      fz: '6rem'
    }, options);

    return this.css({
      'background-color': settings.bgc,
      'color': settings.color,
      'padding': settings.pl,
      'font-size': settings.fz
    });
  }
}( jQuery ));
