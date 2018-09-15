import { Component, OnInit } from '@angular/core';
import { Hero } from '../hero';

// 此程式碼在導入依賴注入的虛擬 data 後關閉
// import { HEROES } from '../mock-heroes';

import { HeroService } from '../hero.service';

@Component({
    selector: 'app-heroes',
    templateUrl: './heroes.component.html',
    styleUrls: ['./heroes.component.css']
})

export class HeroesComponent implements OnInit {

    selectedHero: Hero;
    heroes: Hero[];

    constructor( private heroService: HeroService ) {
        // 注入 service
    }

    getHeroes(): void {
        // 訂閱 heroService 中的可觀察對象，如果觀察到有回傳值，就將該值更新到 this.heroes
        this.heroService.getHeroes().subscribe( (heroes) => this.heroes = heroes);
    }

    onSelect(hero: Hero): void {
        this.selectedHero = hero;
    }

    ngOnInit() {
        // 此程式碼在改由 selectedHero 選定 hero 對象後關閉
        // this.hero = new Hero(1, "Windstorm");

        // 此程式碼在導入依賴注入的虛擬 data 後關閉
        // this.heroes = HEROES;

        this.getHeroes();
    }

}
