import {Component, OnInit} from '@angular/core';
import {ResourcesService} from '../services/resources.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  private agentList: Agent[];

  constructor(private resService: ResourcesService) {
  }

  ngOnInit() {
    this.resService.getAllAgentsObservable().subscribe((response: Agent[]) => {
      this.agentList = response;
      console.log(this.agentList);
    });
  }

}
