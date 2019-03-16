import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CrudToolbarComponent } from './crud-toolbar.component';

describe('CrudToolbarComponent', () => {
  let component: CrudToolbarComponent;
  let fixture: ComponentFixture<CrudToolbarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CrudToolbarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CrudToolbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
