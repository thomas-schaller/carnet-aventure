import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AventureDetails } from './aventure-details';

describe('AventureDetails', () => {
  let component: AventureDetails;
  let fixture: ComponentFixture<AventureDetails>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AventureDetails],
    }).compileComponents();

    fixture = TestBed.createComponent(AventureDetails);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
