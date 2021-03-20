import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PartsInImageComponentComponent } from './parts-in-image-component.component';

describe('PartsInImageComponentComponent', () => {
  let component: PartsInImageComponentComponent;
  let fixture: ComponentFixture<PartsInImageComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PartsInImageComponentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PartsInImageComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
