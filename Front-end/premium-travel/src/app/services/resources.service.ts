import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ResourcesService {

  private readonly backendAddress: string = 'https://premium-travel.markzeagler.com/resources/';

  constructor(private http: HttpClient) {

  }

  getGETJSONHeaders() {
    return {
      headers: new HttpHeaders({
        'Cache-Control': 'no-cache',
        'Authorization': 'Bearer ' + localStorage.getItem('auth_token'),
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
        'Authorization': 'Bearer ' + localStorage.getItem('auth_token'),
        'Access-Control-Allow-Origin': '*'
      })
    };
  }

  public getAllAgentsObservable() {
    return this.http.get(this.backendAddress + 'travel-agent', this.getGETJSONHeaders());
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
}
