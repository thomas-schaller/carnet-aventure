import { Injectable, signal, computed, effect, inject } from '@angular/core';
import { AventureService } from './aventure.service';
import { Aventure } from '../common/aventure.model';
import { Scene } from '../common/scene.model';
import { tap } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class AventureStore {

    
  // STATE
  private _aventures = signal<Aventure[]>([]);
  private _loading = signal(false);
  private _selectedId = signal<string | null>(null);

  // SELECTORS (computed)
  aventures = computed(() => this._aventures());
  loading = computed(() => this._loading());

  selectedAventure = computed(() =>
    this._aventures().find(a => a.id === this._selectedId())
  );
  
constructor(private service: AventureService) {
  effect(() => {
    this.loadAll();
  });
}

  // ACTIONS

  loadAll() {
    this._loading.set(true);

    this.service.getAventures().subscribe({
      next: (data) => {
        this._aventures.set(data);
        this._loading.set(false);
        const selectedAventure = data.find((aventure) => aventure.id === this._selectedId());
        console.info('[AventureStore] Liste des aventures mise à jour', {
          nombre: data.length,
          selectedId: this._selectedId(),
          selectedFound: Boolean(selectedAventure),
          nombreScenesSelectionnee: selectedAventure?.scenes?.length ?? 0,
          titresScenesSelectionnee: selectedAventure?.scenes?.map((scene) => scene.titre) ?? [],
        });
      },
      error: (error) => {
        this._loading.set(false);
        console.error('[AventureStore] Échec du chargement des aventures', error);
      }
    });
  }

  resetSelected() {
    this._selectedId.set(null);
  }

  select(id: string) {
    this._selectedId.set(id);
  }

  createAventure(titre: string) {
    return this.service.createAventure(titre).pipe(
      tap((id) => {
        console.info('[AventureStore] Identifiant reçu pour la nouvelle aventure', { id });
        this.select(id);
        this.loadAll();
      }),
    );
  }

  deleteAventure(id: string) {
    this.service.deleteAventure(id).subscribe({
      next: () => {
        console.info('[AventureStore] Aventure supprimée avec succès', { id });
        if (this._selectedId() === id) {
          this.resetSelected();
        }
        this.loadAll();
      },
      error: (error) => {
        console.error('[AventureStore] Échec de la suppression de l’aventure', { id, error });
      }
    });
  }

  addScene(scene: Scene) {
    const aventureId = this._selectedId();
    if (!aventureId) {
      console.error("Impossible d'ajouter la scène : aucune aventure n'est sélectionnée");
      return;
    }

    console.info('[AventureStore] Envoi d’une scène à l’aventure sélectionnée', { aventureId });
    this.service.addScene(aventureId, scene).subscribe({
      next: () => this.loadAll(),
      error: (error) => console.error("Erreur lors de l'ajout de la scène", error),
    });
  }

  addPersonnage(personnage: any) {
     if (!this._selectedId()) return;
    this.service.addPersonnage(this._selectedId()!, personnage).subscribe(() => {
      this.loadAll();
    });
  }

  addObjectif(description: string) {
    if (!this._selectedId()) return;
    this.service.addObjectif(this._selectedId()!, description).subscribe(() => {
      this.loadAll();
    });
  }
}
