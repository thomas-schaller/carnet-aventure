import { Component, inject, ChangeDetectionStrategy } from '@angular/core';
import { FormControl, ReactiveFormsModule } from '@angular/forms';
import { Button } from 'primeng/button';
import { Card } from 'primeng/card';
import { TextareaModule } from 'primeng/textarea';
import { EditorModule } from 'primeng/editor';

@Component({
  selector: 'app-scene-form',
  imports: [TextareaModule, Button, ReactiveFormsModule, Card, EditorModule],
  templateUrl: './scene-form.html',
  changeDetection: ChangeDetectionStrategy.Eager,
  styleUrl: './scene-form.scss',
})
export class SceneForm {
  titre = new FormControl('');
  description = new FormControl('');

  submit() {
    throw new Error('Method not implemented.');
  }
}
