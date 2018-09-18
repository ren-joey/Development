console.log('********** MAP SET TEST **********');
var set = new Set();
set.add('joey').add('shawn').add('lucas');
console.log(set.size);
console.log(set.has('joey'));
var map = new Map();
map.set('hello', '42');
map.set('gg', '30');
console.log(map.get('gg'));
var promise = new Promise(function (resolve, reject) {
    setTimeout(function () {
        console.log('********** PROMISE TEST **********');
    }, 0);
    setTimeout(function () {
        console.log('2');
    }, 1000);
    setTimeout(function () {
        console.log('1');
    }, 2000);
    setTimeout(function () {
        resolve('foo');
    }, 3000);
});
promise.then(function (value) {
    console.log(value);
});
var __generator = (this && this.__generator) || function (thisArg, body) {
    var _ = { label: 0, sent: function() { if (t[0] & 1) throw t[1]; return t[1]; }, trys: [], ops: [] }, f, y, t, g;
    return g = { next: verb(0), "throw": verb(1), "return": verb(2) }, typeof Symbol === "function" && (g[Symbol.iterator] = function() { return this; }), g;
    function verb(n) { return function (v) { return step([n, v]); }; }
    function step(op) {
        if (f) throw new TypeError("Generator is already executing.");
        while (_) try {
            if (f = 1, y && (t = op[0] & 2 ? y["return"] : op[0] ? y["throw"] || ((t = y["return"]) && t.call(y), 0) : y.next) && !(t = t.call(y, op[1])).done) return t;
            if (y = 0, t) op = [op[0] & 2, t.value];
            switch (op[0]) {
                case 0: case 1: t = op; break;
                case 4: _.label++; return { value: op[1], done: false };
                case 5: _.label++; y = op[1]; op = [0]; continue;
                case 7: op = _.ops.pop(); _.trys.pop(); continue;
                default:
                    if (!(t = _.trys, t = t.length > 0 && t[t.length - 1]) && (op[0] === 6 || op[0] === 2)) { _ = 0; continue; }
                    if (op[0] === 3 && (!t || (op[1] > t[0] && op[1] < t[3]))) { _.label = op[1]; break; }
                    if (op[0] === 6 && _.label < t[1]) { _.label = t[1]; t = op; break; }
                    if (t && _.label < t[2]) { _.label = t[2]; _.ops.push(op); break; }
                    if (t[2]) _.ops.pop();
                    _.trys.pop(); continue;
            }
            op = body.call(thisArg, _);
        } catch (e) { op = [6, e]; y = 0; } finally { f = t = 0; }
        if (op[0] & 5) throw op[1]; return { value: op[0] ? op[1] : void 0, done: true };
    }
};
console.log('********** BASIC TEST **********');
function test() {
    var args = [];
    for (var _i = 0; _i < arguments.length; _i++) {
        args[_i] = arguments[_i];
    }
    var a = function () {
        for (var _i = 0, args_1 = args; _i < args_1.length; _i++) {
            var number = args_1[_i];
            console.log(number);
        }
    };
    a();
    args.forEach(function (item, key) {
        var _a;
        var o = (_a = {},
            _a[item + '' + key] = item,
            _a);
        console.log(o);
    });
}
test(1, 3, 5, 7);
var _a = [1, 2, 3], a = _a[0], b = _a[2];
console.log(a === 1);
console.log(b === 3);
var test2 = function (_a) {
    var myname = _a.name, myage = _a.age;
    console.log(myname + " " + myage);
};
test2({ name: 'joey', age: 30 });
function rx(_a) {
    var x = _a.x, y = _a.y, _b = _a.w, w = _b === void 0 ? 10 : _b, _c = _a.h, h = _c === void 0 ? 10 : _c;
    return x + y + w + h;
}
console.log(rx({ x: 1, y: 2 }));
function makeRangeIteratorMy() {
    var _i, n, _a, args_2, i;
    var args = [];
    for (_i = 0; _i < arguments.length; _i++) {
        args[_i] = arguments[_i];
    }
    return __generator(this, function (_b) {
        switch (_b.label) {
            case 0:
                n = 0;
                _a = 0, args_2 = args;
                _b.label = 1;
            case 1:
                if (!(_a < args_2.length)) return [3, 4];
                i = args_2[_a];
                n += 1;
                return [4, i];
            case 2:
                _b.sent();
                _b.label = 3;
            case 3:
                _a++;
                return [3, 1];
            case 4: return [2, n];
        }
    });
}
var it = makeRangeIteratorMy(1, 10, 2);
var result = it.next();
while (!result.done) {
    console.log(result.value);
    result = it.next();
}
console.log("Iterated over sequence of size: ", result.value);
