import { Component, ChangeDetectionStrategy, inject } from '@angular/core';
import { FormControl, ReactiveFormsModule } from '@angular/forms';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { QuillModule } from 'ngx-quill';
import { AventureStore } from '../../aventures/aventure.store';
import { Scene } from '../../common/scene.model';
@Component({
  selector: 'app-scene-form',
  imports: [ReactiveFormsModule, MatCardModule, MatFormFieldModule, MatInputModule, MatButtonModule, QuillModule],
  templateUrl: './scene-form.html',
  changeDetection: ChangeDetectionStrategy.Eager,
  styleUrl: './scene-form.scss',
})
export class SceneForm {
  titre = new FormControl('', { nonNullable: true });
  description = new FormControl('', { nonNullable: true });
  private store = inject(AventureStore);

editorModules = {
    toolbar: [
      ['bold', 'italic', 'underline', 'strike'],
      [{ 'list': 'ordered'}, { 'list': 'bullet' }],
      [{ 'header': [1, 2, 3, false] }],
      ['clean'],
      ['link', 'image']
    ]
  };

  submit() {
    const scene: Scene = {
      titre: this.titre.value,
      description: this.description.value,
      numeroScene: 1,
    };
    console.info('[SceneForm] Soumission du formulaire', {
      titre: scene.titre,
      numeroScene: scene.numeroScene,
      longueurDescription: scene.description.length,
    });
    this.store.addScene(scene);

  }
}
