var _ = require('lodash');

var m = require('./module.js');

console.log(_.join(['Hello', 'Node'], ' '));

console.log(m.name);
console.log(m.version);
m.f();
