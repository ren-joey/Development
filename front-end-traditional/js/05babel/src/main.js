import m1, {n} from './module-1.js';
import m2 from './module-2.js';
import $ from 'jquery';

window.onload = function(){
  console.log(n);
  m1();
  m2();

  //babel new variable
  let x; //block scoped限定變數，只能在這個function中存活
  for(let i=0; i<10; i++){
    x = 'foo';
  }
  const y = 10; //定義變數，不能被改變

  //babel arrow function
  let target = [1,2];
  let nums = target.map((para, order) => String(para) + ',' + String(order));
  //map 第一個傳入值para是參數定義的值，地案個傳入的是參數的順序
  //map 的作法類似foreach，只是 map 會開啟一個新的 array 再把算好的資料丟進目標李
  //foreach 則是直接改變原本的變數
  $('<div/>',{
    text: nums
  }).appendTo('body');

  var user = {
    name: 'Bob',
    friends: ['Alice', 'John'],
    greet: function(){
      this.friends.forEach(f => {
        console.log('Arrow Function: ' + _.join(['Hi', f, ',', 'I\'m', this.name], ' '));
      });
    }
    //使用arrow function可以確定 this 的 owner就是 user，不必再額外呼叫 bind(user)
  }
  user.greet();

  //Default, Rest and Spread
  function defaultFunc(x, y = 12){
    //如果y沒有pass過來，預設值為12
    return x + y;
  }
  console.log('Default: ' + defaultFunc(3));

  function restFunc(x, ...y){
    //...y會將第一個x以外的所有para全部包成一個array
    return x + ',' + _.join(y, ',');
  }
  console.log('Rest: ' + restFunc(3, 'Hello', true));

  function spreadFunc(x, y, z){
    return x + y + z;
  }
  //...[]會自動將array裡面的para對應到x, y, z不需要一個一個指派
  console.log('Spread: ' + spreadFunc(...[5, 2, 3]));

  //Destructuring
  let {name: n, friends: f} = user;
  let a = new Array;
  a.push(n,f);
  console.log('Destructuring: ' + _.join(a, ','));
  //將user裡面的name property跟friends property抽出，並且丟入n跟f之中

  let [prop1, , prop2 = 3] = [1, 2];
  //將右邊的值丟進對應排序的名稱，沒有定義的名稱就略過，沒有值可以丟入的名稱也可以設定預設值
  //prop1 = 1, prop2 = 3  (2被跳過，因為沒有對應名稱，prop2因為沒有值放入變成預設值3)

  function doCareProperty({name = 'joey'}){return name;}
  console.log('doCareProperty: ' + doCareProperty(user));
  //特別針對name這個prop來做篩選，如果user沒有name就預設給他joey，如果有就回傳name

  //Template String Literals
  let tempName = 'Bob', tempScore = 3.1416, tempStr = `${tempName} gets a score ${tempScore.toFixed(2)}`;
  console.log('templateString: ' + tempStr);

  //Enhanced Object Literals
  function enhancedObject(){
    let name = 'Bob';
    let user = {
      name, //此寫法等同 name:name,
      greet() { //無須寫成 greet: function(){...}
        return `I\'m ${this.name}`;
      },
      ['isOlderThan' + (() => 18)()]:true //可以用[]來定義一個複合的名稱
    }
    console.log('enhancedObject: ' + user.greet())
  }
  enhancedObject();

  // classes
  class userClasses{ //跟 function userClasses() 是一樣的意思
    constructor(name, version){
      this.name = name;
      this.version = version;
    }
    greet(){
      return `I\'am ${this.name}. version: ${this.version}`;
    }
    static yell(){
      return 'Ahh...';
    }
  }
  let userClassesProp = new userClasses('Bob', '1.1');
  console.log('userClassesProp: ' + userClassesProp.greet());
  console.log('UserStatic: ' + userClasses.yell());

  //inheritance
  class Vip extends userClasses{ //Vip會繼承userClasses所有的內容
    constructor (name, title){
      super(name); //super會繼承userClasses對name的處理
      this.title = title;
    }
    pay(){
      console.log('vip.pay(): Waiting for pay.');
    }
    greet(){ //複寫userClasses
      return `Hello, ${this.title}${this.name}.`
    }
  }
  let vipProp = new Vip('Bob', 'Mr.');
  console.log('vipProp(inheritance): ' + vipProp.greet());
  console.log('vipStatic: ' + Vip.yell());

  // symbols
  let symbolProp = Symbol('key');
  // symbol type 永遠沒辦法被取代，他是一個全新的typeof，所有的symbol之間都不互相等於
  // console.log(symbolProp) -> Symbol(key)
  // 要使用symbol必須安裝polyfill
  // https://www.youtube.com/watch?v=-0_EJQIakhI&list=PLlPcwHqLqJDkPXpTPlMh8NtCUC-LWYb-f&index=13

  // Iterators
  let arrIterator = [3, 5, 7];
  arrIterator.foo = 'bar';
  console.log('Iterator(in): ');
  for(let i in arrIterator){ // Iterator > in 會依序print出array裡面每一個數值的order
    console.log(i);
  }
  console.log('Iterator(of): ');
  for(let i of arrIterator){ // Iterator > of 會直接將array裡面的每個數值print出來
    console.log(i);
  }

  // Iterators & Generators
  let generatorsUser = {
    name: 'Bob',
    friends: ['Joey', 'Axe', 'Jason'],
    [Symbol.iterator]: function*(){
      for (let i; i < this.friends.length; i++){
        yield this.friends[i];
      }
    }
  }
  for(let f of generatorsUser){
    console.log('Iterators & Generators: ' + f);
  }
  //https://www.youtube.com/watch?v=MhA2RXzXeyM&list=PLlPcwHqLqJDkPXpTPlMh8NtCUC-LWYb-f&index=14

  //ES7 practice
  class ES7_user {
    nickname = 'Andy';
    runtimes = 1;
    sayHi = () => {
      console.log(`Hi, I\'m ${this.nickname}. runtimes: ${this.runtimes++}`);
      if(this.runtimes >= 10){
        clearInterval(runLoop);
        return;
      }
    }

    static privilage = 7;
    static canRead = function(){
      return ES7_user.privilage >=3 ;
    }
  }
  let ES7_userProp = new ES7_user;
  console.log(ES7_user.canRead());
  let runLoop = setInterval(ES7_userProp.sayHi, 1000);
}
