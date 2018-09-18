console.log('***** T05_extends *****');

class Moto extends Car {

    info() {
        console.log(`moto: ${this.mark} ${this.model} ${this.color} ${this.price}`);
    }

    superInfo() {
        super.info();
    }

}

var mymoto = new Moto("KYMCO", "RACING 150", "black", 89000, "public test");
mymoto.info();
mymoto.superInfo();
console.log(mymoto.publicScope);
