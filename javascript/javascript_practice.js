// object call by reference

class jsTest {

    constructor() {

    }

    objectTest(obj) {
        for(var key in obj){
            delete obj[key];
        }
    }

    dynamicArguments(sum, ...numbers) {
        return numbers.map(val => val * sum);
    }

    labeledStatement(bool) {
        FALSE: {
            if(bool) break FALSE;
            return 0;
        }
        return 1;
    }

    tryCatchThrow(...args) {
        try {
            args = (args.length == 1) ? args[0]: args;
            throwArgument(args);
        } catch(e) {
            return e;
        }
    }
}
module.exports = jsTest;

function throwArgument(data) {
    throw data;
}