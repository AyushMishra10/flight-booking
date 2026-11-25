import { Component, inject, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
// Make sure this path matches your actual folder structure!
import { Flights, FlightResponse } from '../../services/flights';

// Angular Material Imports
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';

@Component({
  selector: 'app-flights-search', // Adjusted to match your likely generated name
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    MatCardModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatProgressSpinnerModule
  ],
  templateUrl: './flights-search.html', // Adjust if your file is named differently
  styleUrl: './flights-search.css'
})
export class FlightsSearchComponent {
  // 1. Explicitly tell TypeScript what we are injecting
  private flightService = inject(Flights);

  // Signals with explicit types
  origin = signal<string>('KUL');
  destination = signal<string>('DMK');
  flights = signal<FlightResponse[]>([]);
  isLoading = signal<boolean>(false);

  onSearch() {
    this.isLoading.set(true);
    
    this.flightService.searchFlights(this.origin(), this.destination()).subscribe({
      // 2. Explicitly type the 'data' parameter
      next: (data: FlightResponse[]) => {
        this.flights.set(data);
        this.isLoading.set(false);
      },
      // 3. Explicitly type the 'err' parameter (using 'unknown' is safest in strict TS)
      error: (err: unknown) => {
        console.error('Search failed', err);
        this.isLoading.set(false);
      }
    });
  }
}