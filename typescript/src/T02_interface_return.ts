console.log('***** T02_interface_return *****');

interface Person {
    name: string;
    age: number;
}

function personInformationVoid (person: Person): void{
    console.log(`my name is ${person.name}, i'm ${person.age} years old`);
}

personInformationVoid({name: 'joey', age: 30});

function personInformationReturn (person: Person): string{
    var str: string = `reutrn: ${person.name}, ${person.age}`;
    return str;
}

var a: string = personInformationReturn({name: 'axe', age: 31});
console.log(a);