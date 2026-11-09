import { Component, inject, ChangeDetectionStrategy } from '@angular/core';
import { Button } from 'primeng/button';
import { AventureStore } from '../../aventures/aventure.store';
import { Router } from '@angular/router';
@Component({
  selector: 'app-navbar',
  imports: [Button],
  templateUrl: './navbar.html',
  changeDetection: ChangeDetectionStrategy.Eager,
  styleUrl: './navbar.scss',
})
export class Navbar {
  aventureStore = inject(AventureStore);
  router = inject(Router);
  reset() {
    this.aventureStore.resetSelected();
    this.router.navigate(['/']);
  }
}
