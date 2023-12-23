import {Component, OnInit} from '@angular/core';
import {SecurityService} from "./service/secutity.service";
import {KeycloakService} from "keycloak-angular";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit{
  title = 'customer-frontend-angular-app';

  constructor(private keycloak: KeycloakService, public secService:SecurityService) {
  }
  ngOnInit(): void {
  }

  async login() {
    await this.keycloak.login({
      redirectUri: window.location.origin
    });
  }

  logout() {
    this.keycloak.logout(window.location.origin)
  }
}
