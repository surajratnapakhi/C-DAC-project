import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DashboardComponent } from './pages/components/dashboard/dashboard.component';
import { EditComponent } from './pages/components/edit/edit.component';
import { LandingpageComponent } from './pages/components/landingpage/landingpage.component';
import { LoginComponent } from './pages/components/login/login.component';
import { RegisterComponent } from './pages/components/register/register.component';

const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    component: LoginComponent
  },
  {
    path: 'landing',
    component: LandingpageComponent,
   
  },

  // {
  //   path: 'login',
  //   component: LoginComponent,
   
  // },
  {
    path: 'register',
    component: RegisterComponent,
   
  },
  {
    path: 'dashboard',
    component: DashboardComponent,
   
  },
  {
    path: 'edit/:id',
    component: EditComponent,
   
  },
  { path: '**', redirectTo: '' }

];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
