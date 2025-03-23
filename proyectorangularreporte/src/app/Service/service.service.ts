import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Reporte } from '../Modelo/Reporte';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(private http:HttpClient) { }

  Url = "http://localhost:7575/reportes/";

  getReportes(){
    return this.http.get<Reporte[]>(this.Url+'listar');
  }

  createReporte(reporte:Reporte){
    return this.http.post<Reporte>('http://localhost:7575/Reportes',reporte);
  }

  getReporteId(id:number){
    return this.http.get<Reporte>(this.Url+id);
  }

  updateReporte(reporte:Reporte){
    return this.http.put<Reporte>(this.Url+reporte.id,reporte);
  }

  deleteReporte(reporte:Reporte){
    return this.http.delete<Reporte>(this.Url+reporte.id);
  }
}
