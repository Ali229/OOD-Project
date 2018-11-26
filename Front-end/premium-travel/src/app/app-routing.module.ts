import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {MaketripComponent} from './maketrip/maketrip.component';
import {MainpageComponent} from './mainpage/mainpage.component';

const routes: Routes = [
  {path: '', component: MainpageComponent},
  {path: 'maketrip', component: MaketripComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
export const routingComponents = [MaketripComponent]
