import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SceneCard } from './scene-card';

describe('SceneCard', () => {
  let component: SceneCard;
  let fixture: ComponentFixture<SceneCard>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SceneCard],
    }).compileComponents();

    fixture = TestBed.createComponent(SceneCard);
    fixture.componentRef.setInput('scene', {
      titre: 'La clairière',
      description: '<p>Un vieux sentier traverse la forêt.</p>',
      numeroScene: 1,
    });
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should display the scene title, number, and description', () => {
    const content = fixture.nativeElement.textContent as string;

    expect(content).toContain('La clairière');
    expect(content).toContain('Scène 1');
    expect(content).toContain('Un vieux sentier traverse la forêt.');
  });
});
