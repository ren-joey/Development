console.log('***** T04_class *****');

class Car {

    mark: string;
    color: string;
    model: string;
    price: number;

    constructor(mark: string, color: string, model: string, price: number, public publicScope: string) {
        this.mark = mark;
        this.color = color;
        this.model = model;
        this.price = price;

        if( publicScope != "" && publicScope != null && typeof publicScope != typeof undefined ){
            console.log(`you asign a public scope: ${publicScope}`);
        }
    }

    info (){
        console.log(`car: ${this.mark} ${this.model} ${this.color} ${this.price}`);
    }

}

var mycar = new Car('bmw', 'black', 'X6', 1600000, 'test');
console.log(mycar.publicScope);
mycar.info();
