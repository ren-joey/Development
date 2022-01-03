module.exports = {
  name : 'Module',
  version : '1.0.1',
  f : function(){
    console.log('Hello Module');
  }
}

// exports.name = 'Module';
//
// exports.version = '1.0.0';
//
// exports.f = function(){
//   console.log('Hello Module');
// }

var b = 100;

// module.exports 跟 exports 兩種方法的效果都依樣，前者可以一次export多個prop，後者一次一個
// 除了exports裡面被指定要輸出的prop以外，其他定義的prop(如var b = 100;)都是屬於private，僅供這個檔案使用
