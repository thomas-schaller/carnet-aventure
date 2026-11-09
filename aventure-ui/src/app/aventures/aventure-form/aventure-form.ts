import { Component, inject, ChangeDetectionStrategy } from '@angular/core';
import { TextareaModule } from 'primeng/textarea';
import { AventureStore } from '../aventure.store';
import { Button } from 'primeng/button';
import { FormControl, ReactiveFormsModule } from '@angular/forms';
import { Card } from 'primeng/card';

@Component({
  selector: 'app-aventure-form',
  imports: [TextareaModule, Button, ReactiveFormsModule, Card],
  templateUrl: './aventure-form.html',
  changeDetection: ChangeDetectionStrategy.Eager,
  styleUrl: './aventure-form.scss',
})
export class AventureForm {
  titre = new FormControl('');
  private store = inject(AventureStore);

  submit() {
    if (!this.titre.value) return;
    this.store.createAventure(this.titre.value);
    this.titre.reset();
  }
}
