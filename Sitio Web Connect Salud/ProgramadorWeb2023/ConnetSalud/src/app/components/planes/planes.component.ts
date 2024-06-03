import { Component } from '@angular/core';
import { AuthStateService } from '../services/auth-state.service';

@Component({
  selector: 'app-planes',
  templateUrl: './planes.component.html',
  styleUrls: ['./planes.component.css']
})
export class PlanesComponent {
  isLoggedIn = false;
  
  constructor(private authService: AuthStateService) { 
    this.isLoggedIn = this.authService.isUserLoggedIn(); 
  }
}
