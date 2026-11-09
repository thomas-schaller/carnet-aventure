import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SceneForm } from './scene-form';

describe('SceneForm', () => {
  let component: SceneForm;
  let fixture: ComponentFixture<SceneForm>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SceneForm],
    }).compileComponents();

    fixture = TestBed.createComponent(SceneForm);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
