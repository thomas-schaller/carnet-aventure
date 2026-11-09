import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AventureCard } from './aventure-card';

describe('AventureCard', () => {
  let component: AventureCard;
  let fixture: ComponentFixture<AventureCard>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AventureCard],
    }).compileComponents();

    fixture = TestBed.createComponent(AventureCard);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
