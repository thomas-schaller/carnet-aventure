import { Routes } from '@angular/router';
import { AventureList } from './aventures/aventure-list/aventure-list';
import { AventureDetails } from './aventures/aventure-details/aventure-details';

export const routes: Routes = [
  { path: '', component: AventureList },
  { path: 'aventure/:id', component: AventureDetails},
];
