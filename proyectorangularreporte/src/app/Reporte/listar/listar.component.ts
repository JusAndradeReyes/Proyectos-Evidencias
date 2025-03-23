import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Reporte } from 'src/app/Modelo/Reporte';
import { ServiceService } from 'src/app/Service/service.service';

@Component({
  selector: 'app-listar',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.css']
})
export class ListarComponent implements OnInit {

  reportes:Reporte[];
  constructor( private service:ServiceService, private router:Router) { }

  ngOnInit() {
    this.service.getReportes().subscribe(data=>{
      this.reportes=data;
    })
  }

  Editar(reporte:Reporte):void{
    localStorage.setItem("id",reporte.id.toString());
    this.router.navigate(["edit"]);
  }

  Eliminar(reporte:Reporte):void{
    this.service.deleteReporte(reporte).subscribe(data=>{
      alert("ELIMINÓ CORRECTAMENTE EL REGISTRO");
      this.reportes = this.reportes.filter(p=> p != reporte);
    })
  }
}
