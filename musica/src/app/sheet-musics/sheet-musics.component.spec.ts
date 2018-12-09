import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SheetMusicsComponent } from './sheet-musics.component';

describe('SheetMusicsComponent', () => {
  let component: SheetMusicsComponent;
  let fixture: ComponentFixture<SheetMusicsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SheetMusicsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SheetMusicsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
