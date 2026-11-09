import { Component, inject, ChangeDetectionStrategy } from '@angular/core';
import { Aventure } from '../../common/aventure.model';
import { ActivatedRoute } from '@angular/router';
import { AventureStore } from '../aventure.store';
import { SceneForm } from '../../scenes/scene-form/scene-form';
import { SceneCard } from '../../scenes/scene-card/scene-card';

@Component({
  selector: 'app-aventure-details',
  imports: [SceneForm, SceneCard],
  templateUrl: './aventure-details.html',
  changeDetection: ChangeDetectionStrategy.Eager,
  styleUrl: './aventure-details.scss',
})
export class AventureDetails {
  id!: string;
  aventure?: Aventure;

  private route = inject(ActivatedRoute);
  store = inject(AventureStore);

  ngOnInit() {
    this.id = this.route.snapshot.params['id'];
    this.store.select(this.id);
  }
}
