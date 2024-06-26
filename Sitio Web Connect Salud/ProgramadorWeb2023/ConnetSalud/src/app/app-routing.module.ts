import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './components/guard/auth.guard';

import {
  InicioComponent,
  PlanesComponent,
  ContactoComponent,
  RecetasComponent,
  LoginComponent,
  RegisterComponent,
  MonitoreodepesoComponent,
  GuiadealimentacionComponent,
  TurnosComponent,
  CarritoComponent,
  ListCitasComponent,
  EditCitasComponent,
  ListUsersComponent,
  PerfilComponent,
  EditUsersComponent,
} from "./components/index.paginas"

const routes: Routes = [
  { path: 'inicio', component: InicioComponent },
  { path: 'planes', component: PlanesComponent },
  { path: 'contacto', component: ContactoComponent },
  { path: 'recetas', component: RecetasComponent, canActivate:[AuthGuard] },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'monitoreodepeso', component: MonitoreodepesoComponent, canActivate:[AuthGuard]},
  { path: 'guiadealimentacion', component: GuiadealimentacionComponent, canActivate:[AuthGuard]},
  { path: 'turnos', component: TurnosComponent, canActivate:[AuthGuard]},
  { path: 'carrito', component: CarritoComponent},
  { path: 'list-citas', component: ListCitasComponent, canActivate:[AuthGuard]},
  { path: 'edit-citas', component: EditCitasComponent, canActivate:[AuthGuard]},
  { path: 'edit/:id_paciente', component:EditCitasComponent, canActivate:[AuthGuard]},
  { path: 'list-users', component: ListUsersComponent, canActivate:[AuthGuard]},
  { path: 'edit-users', component: EditUsersComponent, canActivate:[AuthGuard]},
  { path: 'edit-users/:id', component:EditUsersComponent, canActivate:[AuthGuard]},
  { path: 'perfil', component: PerfilComponent, canActivate:[AuthGuard]},
  { path: '**', pathMatch: 'full', redirectTo: 'inicio' },
];
export const app_routing = RouterModule.forRoot(routes, { useHash:true });