import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Reporte } from 'src/app/Modelo/Reporte';
import { ServiceService } from 'src/app/Service/service.service';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {

  constructor(private router:Router,private service:ServiceService) { }

  ngOnInit() {
    this.Editar();
  }

  modelReporte:Reporte = new Reporte();

  Editar(){
    let id = localStorage.getItem("id");
    this.service.getReporteId(+id).subscribe(data=>{
      this.modelReporte = data;
    })
  }

  Actualizar(reporte:Reporte){
    this.service.updateReporte(reporte).subscribe(data=>{
      alert("MODIFICÓ CORRECTAMENTE EL REGISTRO");
      this.router.navigate(["listar"]);
    })
  }
}
