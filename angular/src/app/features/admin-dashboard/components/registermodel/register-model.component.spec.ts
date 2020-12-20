import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterModelComponent } from './register-model.component';

describe('RegistermodelComponent', () => {
  let component: RegisterModelComponent;
  let fixture: ComponentFixture<RegisterModelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegisterModelComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegisterModelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
