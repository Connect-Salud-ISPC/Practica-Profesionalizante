import { Component } from '@angular/core';
import { AuthStateService } from '../services/auth-state.service';

@Component({
  selector: 'app-inicio',
  templateUrl: './inicio.component.html',
  styleUrls: ['./inicio.component.css']
})
export class InicioComponent {
  isLoggedIn = false;
  
  constructor(private authService: AuthStateService) { 
    this.isLoggedIn = this.authService.isUserLoggedIn(); 
  }
}
