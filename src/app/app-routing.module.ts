import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AboutComponent } from './components/core/about/about.component';
import { AutorComponent } from './components/core/autor/autor.component';
import { HomeComponent } from './components/core/home/home.component';
import { PreduzeceComponent } from './components/preduzece/preduzece.component';
import { RadnikComponent } from './components/radnik/radnik.component';
import { SektorComponent } from './components/sektor/sektor.component';


const routes: Routes = [
  {path: 'preduzece', component: PreduzeceComponent},
  {path: 'sektor', component: SektorComponent},
  {path: 'radnik', component: RadnikComponent},
  {path: 'home', component:HomeComponent},
  {path: 'about', component:AboutComponent},
  {path: 'author', component:AutorComponent},
  {path: '',redirectTo:'/home',pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
