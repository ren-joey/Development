console.log('********** MAP SET TEST **********');

// Set
var set = new Set();
set.add('joey').add('shawn').add('lucas');
console.log(set.size); // 3
console.log(set.has('joey')); // true

// Map
var map = new Map();
map.set('hello', '42');
map.set('gg', '30');
console.log(map.get('gg'));


