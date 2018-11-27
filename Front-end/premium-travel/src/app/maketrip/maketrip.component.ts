import {Component, OnInit, ViewChild} from '@angular/core';
import {ModalDirective} from 'angular-bootstrap-md';

@Component({
  selector: 'app-maketrip',
  templateUrl: './maketrip.component.html',
  styleUrls: ['./maketrip.component.scss']
})
export class MaketripComponent implements OnInit {
  @ViewChild('travelersModal') public travelersModal: ModalDirective;
  @ViewChild('packageModal') public packageModal: ModalDirective;
  @ViewChild('paymentPersonModal') public paymentPersonModal: ModalDirective;
  @ViewChild('paymentTypeModal') public paymentTypeModal: ModalDirective;
  travelers: boolean;
  packages: boolean;
  paymentPerson: boolean;
  paymentType: boolean;

  constructor() {
  }

  ngOnInit() {
    this.stateTraveler();
  }

  showTravelersModal() {
    this.travelersModal.show();
  }

  showPackageModal() {
    this.packageModal.show();
  }

  showPaymentPersonModal() {
    this.paymentPersonModal.show();
  }

  showPaymentTypeModal() {
    this.paymentTypeModal.show();
  }

  stateTraveler() {
    this.travelers = true;
    this.packages = false;
    this.paymentPerson = false;
    this.paymentType = false;
  }

  statePackage() {
    this.travelersModal.hide();
    this.travelers = false;
    this.packages = true;
    this.paymentPerson = false;
    this.paymentType = false;
  }

  statePaymentPerson() {
    this.packageModal.hide();
    this.travelers = false;
    this.packages = false;
    this.paymentPerson = true;
    this.paymentType = false;
  }

  statePaymentType() {
    this.paymentPersonModal.hide();
    this.travelers = false;
    this.packages = false;
    this.paymentPerson = false;
    this.paymentType = true;
  }

  stateMadeTrip() {
    this.paymentTypeModal.hide();
    this.travelers = false;
    this.packages = false;
    this.paymentPerson = false;
    this.paymentType = false;
  }
}
