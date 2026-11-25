import { Component } from '@angular/core';
import { FlightsSearchComponent } from './components/flights-search/flights-search';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [FlightsSearchComponent],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected title = 'airline-frontend';
}