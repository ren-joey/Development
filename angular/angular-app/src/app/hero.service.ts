import { Injectable } from '@angular/core';
import { Hero } from './hero';
import { HEROES } from './mock-heroes';
import { MessageService } from './message.service';
import { Observable } from 'rxjs';
import { of } from 'rxjs/observable/of';

@Injectable()
export class HeroService {

    // 將 HEROES 設計成一個可觀察的對象
    getHeroes(): Observable<Hero[]> {
        // TODO: send the message _after_ fetching the heroes
        this.messageService.add('HeroService: fetched heroes');

        return of(HEROES);
    }

    // 在 constructor 的引述參數中加入 private name: class.name
    // 意味著該 class 將會被注入
    constructor(private messageService: MessageService) { }
}
