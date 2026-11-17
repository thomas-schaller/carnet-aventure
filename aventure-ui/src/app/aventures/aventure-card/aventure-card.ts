import { Component, inject, input, ChangeDetectionStrategy } from '@angular/core';
import { Aventure } from '../../common/aventure.model';
import { Router } from '@angular/router';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { AventureStore } from '../aventure.store';
@Component({
  selector: 'app-aventure-card',
  imports: [MatCardModule,MatButtonModule],
  templateUrl: './aventure-card.html',
  changeDetection: ChangeDetectionStrategy.Eager,
  styleUrl: './aventure-card.scss',
})
export class AventureCard {

  aventure = input.required<Aventure>();
  router = inject(Router);
  private store = inject(AventureStore);

  selectionAventure() {
    this.router.navigate(['/aventure', this.aventure().id]);
    console.log('selected aventure : ' + this.aventure().id);
  }
  deleteAventure() {
    this.store.deleteAventure(this.aventure().id);
  }
}
