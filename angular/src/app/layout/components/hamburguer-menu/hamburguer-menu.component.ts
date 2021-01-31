import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-hamburguer-menu',
  templateUrl: './hamburguer-menu.component.html',
  styleUrls: ['./hamburguer-menu.component.css']
})
export class HamburguerMenuComponent implements OnInit {
  isMenuCollapsed = true;

  constructor() { }

  ngOnInit(): void {
  }

}
