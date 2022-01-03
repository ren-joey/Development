import _ from 'lodash';
import './module-1.css';
import $ from 'jquery';

export default function(){
  var el_test = $('#module-1');
  var el = document.querySelector('#module-1');
  let el_string = _.join(['This', 'is', '#module-1'], ' ');
  el.textContent = `${el_string}`;
  el_test.html(el_test.html() + '<br>');
}

export var n = 50;
