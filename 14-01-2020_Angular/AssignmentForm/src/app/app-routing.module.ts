import { SecondCompComponent } from './components/second-comp/second-comp.component';
import { FirstCompComponent } from './components/first-comp/first-comp.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


const routes: Routes = [
  {path: 'Form', component: FirstCompComponent},
  {path: 'Details', component: SecondCompComponent},
  {path: '', component: FirstCompComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
