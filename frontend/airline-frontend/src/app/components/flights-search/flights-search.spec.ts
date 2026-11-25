import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FlightsSearch } from './flights-search';

describe('FlightsSearch', () => {
  let component: FlightsSearch;
  let fixture: ComponentFixture<FlightsSearch>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FlightsSearch],
    }).compileComponents();

    fixture = TestBed.createComponent(FlightsSearch);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
