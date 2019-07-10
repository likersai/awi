$(document).ready(function() {
  $('#particles').particleground({
    dotColor: '#66f9cf',
    lineColor: '#a0eee1'
  });
  $('.intro').css({
    'margin-top': -($('.intro').height() / 2)
  });
});