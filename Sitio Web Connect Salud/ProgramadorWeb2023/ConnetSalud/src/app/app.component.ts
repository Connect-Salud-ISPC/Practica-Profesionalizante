import { Component, OnInit, HostListener } from '@angular/core';
import { AuthService } from './components/services/auth.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  title = 'ConnetSalud';

  constructor(private authService: AuthService) {}

  @HostListener('window:beforeunload', ['$event'])
  unloadHandler(event: Event) {
    this.authService.logout();
  }
}

