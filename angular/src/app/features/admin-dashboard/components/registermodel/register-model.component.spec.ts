import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { RegisterModelComponent } from './register-model.component';

describe('RegistermodelComponent', () => {
  let component: RegisterModelComponent;
  let fixture: ComponentFixture<RegisterModelComponent>;

  beforeEach(waitForAsync(() => {
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
