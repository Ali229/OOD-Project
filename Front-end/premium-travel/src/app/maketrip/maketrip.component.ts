import {Component, OnInit, ViewChild} from '@angular/core';
import {ModalDirective} from 'angular-bootstrap-md';
import {ResourcesService} from '../services/resources.service';

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
  travelersList: Traveler[];
  packageList: Package[];
  paymentPersonList: PaymentPerson[];
  addedTravelersList: Traveler[] = [];
  selectedTraveler: string;
  numOfTravelers = 0;


  constructor(private resService: ResourcesService) {
  }

  ngOnInit() {
    this.stateTraveler();
  }

  showTravelersModal() {
    this.resService.getAllTravelersObservable().subscribe((response: Traveler[]) => {
      this.travelersList = response;
    });
    this.travelersModal.show();
  }

  showPackageModal() {
    this.resService.getAllPlacesObservable().subscribe((response: Package[]) => {
      this.packageList = response;
    });
    this.packageModal.show();
  }

  showPaymentPersonModal() {
    this.resService.getAllPlacesObservable().subscribe((response: PaymentPerson[]) => {
      this.paymentPersonList = response;
    });
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

  addTravelerFromList(t: Traveler) {
    this.addedTravelersList.push(t);
    this.numOfTravelers++;
  }
}
