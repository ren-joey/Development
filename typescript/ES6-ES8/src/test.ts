console.log('********** BASIC TEST **********');

interface Objects {
    [key: string]: any
}

/**
Lexical arguments
同時可以不進行任何宣告取得參數
function test() {
  var a = () => {
    arguments 為固定參數不可改變
    for(let number of arguments){
      ...
    }
  }
}
*/
function test(...args: number[]): void {

    var a = () => {
        for (let number of args) {
            console.log(number);
        }
    }
    a();

    // Computed (dynamic) property names
    // 動態 json key
    args.forEach((item, key) => {
        let o = {
            [item + '' + key]: item
        };

        console.log(o);
    });

}

test(1, 3, 5, 7);

// list matching
var [a, , b] = [1, 2, 3];
console.log(a === 1);
console.log(b === 3);

// Can be used in parameter position
// 變數位置自動對應
var test2 = ({ name: myname, age: myage }: Objects) => {
    console.log(`${myname} ${myage}`);
}

test2({ name: 'joey', age: 30 });

// Destructuring + defaults arguments
function rx({ x, y, w = 10, h = 10 }: Objects) {
    return x + y + w + h;
}

console.log(rx({ x: 1, y: 2 }));

// Iterator Generator Function
function* makeRangeIteratorMy(...args: any[]): any {
    let n = 0;
    for (let i of args) {
        n += 1;
        yield i;
    }
    return n;
}

var it = makeRangeIteratorMy(1, 10, 2);

var result = it.next();
while (!result.done) {
    console.log(result.value); // 1 3 5 7 9
    result = it.next();
}

console.log("Iterated over sequence of size: ", result.value);