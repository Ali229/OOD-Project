import {Component, OnInit} from '@angular/core';
import {ResourcesService} from '../services/resources.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  private agentList: Agent[];
  selectedOption: string;

  constructor(private resService: ResourcesService) {
  }

  ngOnInit() {
    this.resService.getAllAgentsObservable().subscribe((response: Agent[]) => {
      this.agentList = response;
    });
  }

  login() {
    localStorage.setItem('agent', this.selectedOption);
  }

}
