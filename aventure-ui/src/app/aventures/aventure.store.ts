import { Injectable, signal, computed, effect, inject } from '@angular/core';
import { AventureService } from './aventure.service';
import { Aventure } from '../common/aventure.model';

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
      },
      error: () => this._loading.set(false)
    });
  }

  resetSelected() {
    this._selectedId.set(null);
  }

  select(id: string) {
    this._selectedId.set(id);
  }

  createAventure(titre: string) {
    this.service.createAventure(titre).subscribe(id => {
      this.loadAll(); // refresh simple
      this.select(id); // select the new aventure
    });
  }

  addScene(scene: any) {
    if (!this._selectedId()) return;
    this.service.addScene(this._selectedId()!, scene).subscribe(() => {
      this.loadAll();
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
