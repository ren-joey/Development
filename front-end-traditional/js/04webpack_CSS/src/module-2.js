import _ from 'lodash';
import './module-2.css';
import $ from 'jquery';

export default function(){
  var el = document.querySelector('#module-2');
  var el_test = $('#module-2');
  el.textContent = _.join(['This', 'is', '#module-2'], ' ');
  el_test.html(el_test.html() + '<br>');
}
