import { Injectable, inject } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface FlightResponse {
  id: string;
  flightNumber: string;
  origin: string;
  destination: string;
  departureTime: string;
  price: number;
}

@Injectable({
  providedIn: 'root'
})
export class Flights {
  private http = inject(HttpClient);
  private apiUrl = 'http://localhost:8181/api/v1/flights/search';

  searchFlights(origin: string, destination: string): Observable<FlightResponse[]> {
    const params = new HttpParams()
      .set('origin', origin)
      .set('destination', destination);
    
    return this.http.get<FlightResponse[]>(this.apiUrl, { params });
  }
}