import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Reporte } from 'src/app/Modelo/Reporte';
import { ServiceService } from 'src/app/Service/service.service';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {

  reporte:Reporte = new Reporte();
  
  constructor(private router:Router, private service:ServiceService) { }

  ngOnInit() {
  }
  modelReporte = new Reporte();

  Guardar(reporte:Reporte){
    this.service.createReporte(reporte).subscribe(data=>{
      alert("AGREGÓ CORRECTAMENTE EL REGISTRO");
      this.router.navigate(["listar"]);
    })
  }
}
