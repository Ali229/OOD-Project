import {Component, OnInit, ViewChild} from '@angular/core';
import {ModalDirective} from 'angular-bootstrap-md';

@Component({
  selector: 'app-maketrip',
  templateUrl: './maketrip.component.html',
  styleUrls: ['./maketrip.component.scss']
})
export class MaketripComponent implements OnInit {
  @ViewChild('travelersModal') public travelersModal: ModalDirective;

  constructor() {
  }

  ngOnInit() {
  }

  showTravelersModal() {
    this.travelersModal.show();
  }
}
