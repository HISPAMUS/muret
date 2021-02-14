import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReorderSectionsComponent } from './reorder-sections.component';

describe('ReorderSectionsComponent', () => {
  let component: ReorderSectionsComponent;
  let fixture: ComponentFixture<ReorderSectionsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReorderSectionsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReorderSectionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
