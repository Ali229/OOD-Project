import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ResourcesService {

  private readonly backendAddress: string = 'https://premium-travel.markzeagler.com/resources/';

  constructor(private http: HttpClient) {

  }

  public getAllAgentsObservable() {
    return this.http.get(this.backendAddress + 'travel-agent');
  }

  public getAgent(id: string) {
    return this.http.get(this.backendAddress + 'travel-agent/' + id);
  }

  public createAgent(firstName: string, lastName: string, phoneNumber: string) {
    return this.http.post(this.backendAddress + 'travel-agent', {
      'firstName': firstName,
      'lastName': lastName,
      'phoneNumber': phoneNumber
    });
  }
}
