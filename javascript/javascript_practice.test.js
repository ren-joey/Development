// object call by reference
const jsTest = require('./javascript_practice');

let __ = new jsTest();

test('object oriented delete key', () => {
    let a = {a: 0, b: 2};
    __.objectTest(a)
    Object.keys(a);
    expect(a.length).toBeFalsy();
});

test('dynamic arguments and map return', () => {
    let res = __.dynamicArguments(4, 2, 5, 6);

    expect(res.length).toBeTruthy();
    expect(res[0]).toBeGreaterThan(2);
    expect(res[1]).toBeGreaterThan(5);
    expect(res[2]).toBeGreaterThan(6);
});

test('labeled statement should break', () => {
    expect(__.labeledStatement(true)).toBeTruthy();
    expect(__.labeledStatement(false)).toBeFalsy();
});

test('try catch the error return by throw function', () => {
    expect(__.tryCatchThrow(1)).toBe(1);
    expect(__.tryCatchThrow('test')).toBe('test');
});