import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Aventure } from '../common/aventure.model';
import { Scene } from '../common/scene.model';
import { Personnage } from '../common/personnage.model';
import { Observable, tap } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AventureService {
  private baseUrl ='http://localhost:8081'

  httpClient = inject(HttpClient);

  getAventures() {
    const url = `${this.baseUrl}/aventure/all`;
    return this.traceExchange(
      'Chargement des aventures',
      url,
      undefined,
      this.httpClient.get<Aventure[]>(url),
    );
  }

  createAventure(titre:string) {
    const url = `${this.baseUrl}/aventure/creer`;
    const body = { titre };
    return this.traceExchange(
      'Création d’une aventure',
      url,
      body,
      this.httpClient.post<string>(url, body),
    );
  }

    addObjectif(idAventure: string, description: string) {
    return this.httpClient.post(`${this.baseUrl}/${idAventure}/objectif`, { description });
  }

  addPersonnage(idAventure: string, personnage: Personnage) {
    return this.httpClient.post(`${this.baseUrl}/${idAventure}/personnage`, personnage);
  }

  addScene(idAventure: string, scene: Scene) {
    const url = `${this.baseUrl}/aventure/${idAventure}/scene`;
    return this.traceExchange(
      'Ajout d’une scène',
      url,
      scene,
      this.httpClient.post(url, scene),
    );
  }

  private traceExchange<T>(
    operation: string,
    url: string,
    requestBody: unknown,
    request: Observable<T>,
  ): Observable<T> {
    console.info(`[AventureService] ${operation} — requête`, { url, body: requestBody });

    return request.pipe(
      tap({
        next: (response) =>
          console.info(`[AventureService] ${operation} — réponse`, { url, body: response }),
        error: (error: unknown) =>
          console.error(`[AventureService] ${operation} — erreur`, {
            url,
            requestBody,
            error,
          }),
      }),
    );
  }

}
