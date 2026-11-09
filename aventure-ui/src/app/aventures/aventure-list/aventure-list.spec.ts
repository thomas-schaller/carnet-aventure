import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AventureList } from './aventure-list';

describe('AventureList', () => {
  let component: AventureList;
  let fixture: ComponentFixture<AventureList>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AventureList],
    }).compileComponents();

    fixture = TestBed.createComponent(AventureList);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
