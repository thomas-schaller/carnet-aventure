import { Component, ChangeDetectionStrategy } from '@angular/core';
import { FormControl, ReactiveFormsModule } from '@angular/forms';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { QuillModule } from 'ngx-quill';
@Component({
  selector: 'app-scene-form',
  imports: [ReactiveFormsModule, MatCardModule, MatFormFieldModule, MatInputModule, MatButtonModule, QuillModule],
  templateUrl: './scene-form.html',
  changeDetection: ChangeDetectionStrategy.Eager,
  styleUrl: './scene-form.scss',
})
export class SceneForm {
  titre = new FormControl('');
  description = new FormControl('');
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
    throw new Error('Method not implemented.');
  }
}
