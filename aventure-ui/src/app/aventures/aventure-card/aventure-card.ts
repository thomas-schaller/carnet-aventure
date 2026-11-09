import { Component, inject, input, ChangeDetectionStrategy } from '@angular/core';
import { Aventure } from '../../common/aventure.model';
import { Card } from 'primeng/card';
import { Router } from '@angular/router';
@Component({
  selector: 'app-aventure-card',
  imports: [Card],
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
