import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {MDBBootstrapModule} from 'angular-bootstrap-md';
import {AppComponent} from './app.component';
import {NavbarComponent} from './navbar/navbar.component';
import {AppRoutingModule, routingComponents} from './app-routing.module';
import {ResourcesService} from './services/resources.service';
import {HttpClientModule} from '@angular/common/http';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    routingComponents,
  ],
  imports: [
    MDBBootstrapModule.forRoot(),
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [
    ResourcesService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
