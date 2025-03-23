import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddComponent } from './Reporte/add/add.component';
import { EditComponent } from './Reporte/edit/edit.component';
import { ListarComponent } from './Reporte/listar/listar.component';

const routes: Routes = [
  {path:'listar',component:ListarComponent},
  {path:'add',component:AddComponent},
  {path:'edit',component:EditComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
