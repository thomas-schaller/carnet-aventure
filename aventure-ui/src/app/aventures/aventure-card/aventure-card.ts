import { Component, inject, input, ChangeDetectionStrategy } from '@angular/core';
import { Aventure } from '../../common/aventure.model';
import { Router } from '@angular/router';
import { MatCardModule } from '@angular/material/card';
@Component({
  selector: 'app-aventure-card',
  imports: [MatCardModule],
  templateUrl: './aventure-card.html',
  changeDetection: ChangeDetectionStrategy.Eager,
  styleUrl: './aventure-card.scss',
})
export class AventureCard {
  aventure = input.required<Aventure>();
  router = inject(Router);

  selectionAventure() {
    this.router.navigate(['/aventure', this.aventure().id]);
    console.log('selected aventure : ' + this.aventure().id);
  }
}
