import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistermodelComponent } from './registermodel.component';

describe('RegistermodelComponent', () => {
  let component: RegistermodelComponent;
  let fixture: ComponentFixture<RegistermodelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegistermodelComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegistermodelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
