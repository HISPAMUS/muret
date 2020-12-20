import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { CrudToolbarComponent } from './crud-toolbar.component';

describe('CrudToolbarComponent', () => {
  let component: CrudToolbarComponent;
  let fixture: ComponentFixture<CrudToolbarComponent>;

  beforeEach(waitForAsync(() => {
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
