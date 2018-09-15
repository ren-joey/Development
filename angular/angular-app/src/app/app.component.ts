import { Component } from '@angular/core';
import { HeroService } from './hero.service';
import { MessageService } from './message.service';

@Component({
  selector: 'app-root',
  providers: [HeroService, MessageService],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Tour of Heroes';
}
