import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SignupRoutingModule } from './signup-routing.module';
import { SignupComponent } from './signup.component';
import {ReactiveFormsModule} from "@angular/forms";
import {AuthService} from "../shared/services/security/auth.service";

@NgModule({
  imports: [
    CommonModule,
    SignupRoutingModule,
    ReactiveFormsModule,
  ],
  declarations: [SignupComponent],
  providers: [AuthService]
})
export class SignupModule { }
