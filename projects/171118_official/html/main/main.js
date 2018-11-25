$(function(){
  // page default set
  lanChange();

  // event listener
  $('.project-item').on('click',function(){
    projectOpen(this, $(this).attr('title'), true);
  });

  $('#lan-change').on('click', '.lan-en', function(){lanChange('tw')})
                  .on('click', '.lan-tw', function(){lanChange('en')});
});

var target, projectTitle, projectInfo = $('.project-info'), mainHeader = $('#header');
function projectOpen(obj, title, bool){
  if(obj) target = $(obj);
  if(title) projectTitle = title;
  if(bool){
    target.add(projectInfo).addClass('on');
    mainHeader.addClass('off');
    $('.menu-icon').on('click',function(){
      projectOpen('', '', false);
    });
  }
  else{
    target.add(projectInfo).removeClass('on');
    mainHeader.removeClass('off');
    $('.menu-icon').off('click');
  }
}

function lanChange(lan){
  switch (lan) {
    case 'tw':
      $('.lan-en').fadeOut(300);
      setTimeout(function(){$('.lan-tw').fadeIn(300);},300);
      break;
    case 'en':
      $('.lan-tw').fadeOut(300);
      setTimeout(function(){$('.lan-en').fadeIn(300);},300);
      break;
    default:
    $('.lan-tw').hide();
      break;
  }
}
