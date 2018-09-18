var car = {
    color: 'black',
    info: function () {
        setTimeout(() => {
            console.log('***** T03_arrowFunction *****');
            console.log(`this car's color is ${this.color}`);
        });
    }
}

car.info();