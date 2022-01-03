import _ from 'lodash';

export default function(){
  var el = document.querySelector('#module-1');
  el.textContent = _.join(['This', 'is', '#module-1'], ' ');
}

export var n = 50;
