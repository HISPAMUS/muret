import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClassifiersComponent } from './classifiers.component';

describe('ClassifiersComponent', () => {
  let component: ClassifiersComponent;
  let fixture: ComponentFixture<ClassifiersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ClassifiersComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ClassifiersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
