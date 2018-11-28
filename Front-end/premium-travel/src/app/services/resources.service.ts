import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ResourcesService {

  private readonly backendAddress: string = 'http://localhost:8080/premium-travel-backend/';   // 'https://premium-travel.markzeagler.com/resources/';

  constructor(private http: HttpClient) {

  }

  getGETJSONHeaders() {
    return {
      headers: new HttpHeaders({
        'Cache-Control': 'no-cache',
        'Access-Control-Allow-Origin': '*',
        'Accept': '*/*'
      })
    };
  }

  getPOSTPUTJSONHeaders() {
    return {
      headers: new HttpHeaders({
        'Cache-Control': 'no-cache',
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': '*'
      })
    };
  }

  public getAllTravelersObservable() {
    return this.http.get(this.backendAddress + 'traveller', this.getGETJSONHeaders());
  }

  public getAllAgentsObservable() {
    return this.http.get(this.backendAddress + 'travel-agent', this.getGETJSONHeaders());
  }

  public getAllPlacesObservable() {
    return this.http.get(this.backendAddress + 'place', this.getGETJSONHeaders());
  }

  public getAllPaymentPersonsObservable() {
    return this.http.get(this.backendAddress + 'person', this.getGETJSONHeaders());
  }

  public getItineraryObservable() {
    return this.http.get(this.backendAddress + 'trip/{trip-id}/itinerary', this.getGETJSONHeaders());
  }

  public getAgent(id: string) {
    return this.http.get(this.backendAddress + 'travel-agent/' + id, this.getPOSTPUTJSONHeaders());
  }

  public createAgent(firstName: string, lastName: string, phoneNumber: string) {
    return this.http.post(this.backendAddress + 'travel-agent', {
      'firstName': firstName,
      'lastName': lastName,
      'phoneNumber': phoneNumber
    }, this.getPOSTPUTJSONHeaders());
  }

  public createTrip() {
    return this.http.get(this.backendAddress + 'trip', this.getPOSTPUTJSONHeaders());
  }
}
