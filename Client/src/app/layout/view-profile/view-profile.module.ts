import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ViewProfileRoutingModule} from './view-profile-routing.module';
import {ViewProfileComponent} from './view-profile.component';
import {ReactiveFormsModule} from '@angular/forms';
import {AttributeService} from "../../shared/services/attributes/attribute.service";
import {HttpClientModule} from "@angular/common/http";
import {ProfileService} from "../../shared/services/profile/profile.service";

@NgModule({
  imports: [
    CommonModule,
    ViewProfileRoutingModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  declarations: [ViewProfileComponent],
  providers: [AttributeService, ProfileService]
})
export class ViewProfileModule { }
