import { ComponentFixture, TestBed } from '@angular/core/testing';
import { QuillModule } from 'ngx-quill';
import { SceneForm } from './scene-form';

describe('SceneForm', () => {
  let component: SceneForm;
  let fixture: ComponentFixture<SceneForm>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SceneForm, QuillModule],
    }).compileComponents();

    fixture = TestBed.createComponent(SceneForm);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
