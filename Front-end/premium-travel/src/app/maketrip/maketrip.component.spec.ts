import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MaketripComponent } from './maketrip.component';

describe('MaketripComponent', () => {
  let component: MaketripComponent;
  let fixture: ComponentFixture<MaketripComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MaketripComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MaketripComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
