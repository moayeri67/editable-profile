import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ProfileRoutingModule} from './profile-routing.module';
import {ProfileComponent} from './profile.component';
import {ReactiveFormsModule} from '@angular/forms';
import {AttributeService} from "../../shared/services/attributes/attribute.service";
import {ProfileService} from "../../shared/services/profile/profile.service"
import {HttpClientModule} from "@angular/common/http";

@NgModule({
  imports: [
    CommonModule,
    ProfileRoutingModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  declarations: [ProfileComponent],
  providers: [AttributeService,ProfileService]
})
export class ProfileModule { }
