var promise = new Promise((resolve, reject) => {
    setTimeout(() => {
        console.log('********** PROMISE TEST **********');
    }, 0);
    setTimeout(() => {
        console.log('2');
    }, 1000);
    setTimeout(() => {
        console.log('1');
        reject('fail')
    }, 2000);
    setTimeout(() => {
        resolve('success');
    }, 3000);
});

promise.then((value) => {
    console.log(value);
});