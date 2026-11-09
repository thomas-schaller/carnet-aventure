import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Aventure } from '../common/aventure.model';
import { Scene } from '../common/scene.model';
import { Personnage } from '../common/personnage.model';

@Injectable({
  providedIn: 'root',
})
export class AventureService {
  private baseUrl ='http://localhost:8081'

  httpClient = inject(HttpClient);

  getAventures() {
    return this.httpClient.get<Aventure[]>(`${this.baseUrl}/aventure/all`)
  }

  createAventure(titre:string) {
    return this.httpClient.post<string>(`${this.baseUrl}/aventure/creer`, { titre });
  }

    addObjectif(idAventure: string, description: string) {
    return this.httpClient.post(`${this.baseUrl}/${idAventure}/objectif`, { description });
  }

  addPersonnage(idAventure: string, personnage: Personnage) {
    return this.httpClient.post(`${this.baseUrl}/${idAventure}/personnage`, personnage);
  }

  addScene(idAventure: string, scene: Scene) {
    return this.httpClient.post(`${this.baseUrl}/${idAventure}/scene`, scene);
  }

}
