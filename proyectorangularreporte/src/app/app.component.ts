import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'proyectorangularreporte';
  //DEFINE A DONDE REIRIGE CADA COMPONENTE
  constructor(private router:Router){}
    listar(){
      this.router.navigate(["listar"]);
    }
    add(){
      this.router.navigate(["add"]);
    }
}
