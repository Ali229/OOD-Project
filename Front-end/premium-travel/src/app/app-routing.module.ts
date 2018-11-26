import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {MaketripComponent} from './maketrip/maketrip.component';
import {MainpageComponent} from './mainpage/mainpage.component';
import {LoginComponent} from './login/login.component';

const routes: Routes = [
  {path: '', component: LoginComponent},
  {path: 'home', component: MainpageComponent},
  {path: 'maketrip', component: MaketripComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}

export const routingComponents = [LoginComponent, MainpageComponent, MaketripComponent];
