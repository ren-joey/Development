var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
        return extendStatics(d, b);
    }
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
console.log("***** T01_variablesType *****");
function personInfomation(name, age) {
    console.log("my name is " + name + ", i'm " + age + " years old");
}
personInfomation("joey", 30);
console.log('***** T02_interface_return *****');
function personInformationVoid(person) {
    console.log("my name is " + person.name + ", i'm " + person.age + " years old");
}
personInformationVoid({ name: 'joey', age: 30 });
function personInformationReturn(person) {
    var str = "reutrn: " + person.name + ", " + person.age;
    return str;
}
var a = personInformationReturn({ name: 'axe', age: 31 });
console.log(a);
var car = {
    color: 'black',
    info: function () {
        var _this = this;
        setTimeout(function () {
            console.log('***** T03_arrowFunction *****');
            console.log("this car's color is " + _this.color);
        });
    }
};
car.info();
console.log('***** T04_class *****');
var Car = (function () {
    function Car(mark, color, model, price, publicScope) {
        this.publicScope = publicScope;
        this.mark = mark;
        this.color = color;
        this.model = model;
        this.price = price;
        if (publicScope != "" && publicScope != null && typeof publicScope != typeof undefined) {
            console.log("you asign a public scope: " + publicScope);
        }
    }
    Car.prototype.info = function () {
        console.log("car: " + this.mark + " " + this.model + " " + this.color + " " + this.price);
    };
    return Car;
}());
var mycar = new Car('bmw', 'black', 'X6', 1600000, 'test');
console.log(mycar.publicScope);
mycar.info();
console.log('***** T05_extends *****');
var Moto = (function (_super) {
    __extends(Moto, _super);
    function Moto() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    Moto.prototype.info = function () {
        console.log("moto: " + this.mark + " " + this.model + " " + this.color + " " + this.price);
    };
    Moto.prototype.superInfo = function () {
        _super.prototype.info.call(this);
    };
    return Moto;
}(Car));
var mymoto = new Moto("KYMCO", "RACING 150", "black", 89000, "public test");
mymoto.info();
mymoto.superInfo();
console.log(mymoto.publicScope);
