import { Component, inject, signal, Signal, ChangeDetectionStrategy } from '@angular/core';
import { Aventure } from '../../common/aventure.model';
import { AventureCard } from '../aventure-card/aventure-card';
import { AventureForm } from '../aventure-form/aventure-form';
import { AventureStore } from '../aventure.store';

@Component({
  selector: 'app-aventure-list',
  imports: [AventureCard, AventureForm],
  templateUrl: './aventure-list.html',
  changeDetection: ChangeDetectionStrategy.Eager,
  styleUrl: './aventure-list.scss',
})
export class AventureList {
  store = inject(AventureStore);
}
