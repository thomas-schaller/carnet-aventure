import { Component, inject, ChangeDetectionStrategy } from '@angular/core';
import { AventureStore } from '../aventure.store';
import { FormControl, ReactiveFormsModule } from '@angular/forms';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';

@Component({
  selector: 'app-aventure-form',
  imports: [ReactiveFormsModule, MatCardModule, MatFormFieldModule, MatInputModule, MatButtonModule],
  templateUrl: './aventure-form.html',
  changeDetection: ChangeDetectionStrategy.Eager,
  styleUrl: './aventure-form.scss',
})
export class AventureForm {
  titre = new FormControl('');
  private store = inject(AventureStore);

  submit() {
    
    if (!this.titre.value) {
      console.warn("[AventureForm] Création ignorée : le titre est vide");
      return;
    }

    console.info("[AventureForm] Soumission du formulaire", { titre: this.titre.value });
    this.store.createAventure(this.titre.value).subscribe({
      next: (id) => {
        console.info("[AventureForm] Aventure créée", { id });
        this.titre.reset();
      },
      error: (error) => console.error("Erreur lors de la création de l'aventure", error),
    });
  }
}
