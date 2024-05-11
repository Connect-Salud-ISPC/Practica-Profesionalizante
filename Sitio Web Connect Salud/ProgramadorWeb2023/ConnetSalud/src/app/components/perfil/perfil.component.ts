import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
@Component({
  selector: 'app-perfil',
  templateUrl: './perfil.component.html',
  styleUrls: ['./perfil.component.css']
})
export class PerfilComponent implements OnInit {
  profile: any = {};
  isLoading: boolean = false;
  updateSuccess: boolean = false;
  updateError: boolean = false;
  editing: boolean = false;
  constructor(private userService: UserService) { }
  ngOnInit(): void {
    this.loadProfile();
  }
  loadProfile(): void {
    this.isLoading = true;
    this.userService.getUser().subscribe(
      data => {
        this.profile = data;
        this.isLoading = false;
      },
      error => {
        console.error('Error al cargar el perfil', error);
        this.isLoading = false;
      }
    );
  }
  updateProfile() {
    this.editing = true;
  }
  startEdit(): void {
    this.editing = true;
  }
  cancelEdit() {
    this.editing = false;
    this.loadProfile(); // Recargar los datos originales si se cancela la edición
  }
  saveChanges() {
    this.userService.updateProfile(this.profile).subscribe({
      next: (data) => {
        this.updateSuccess = true;
        this.editing = false;
        // Actualizar datos del perfil si es necesario
        this.profile = data;
      },
      error: (error) => {
        console.error('Error al actualizar el perfil', error);
        this.updateError = true;
      }
    });
  }
}