import { Component, inject, input, ChangeDetectionStrategy } from '@angular/core';
import { Scene } from '../../common/scene.model';

@Component({
  selector: 'app-scene-card',
  imports: [],
  templateUrl: './scene-card.html',
  changeDetection: ChangeDetectionStrategy.Eager,
  styleUrl: './scene-card.scss',
})
export class SceneCard {
  scene = input.required<Scene>();
}
