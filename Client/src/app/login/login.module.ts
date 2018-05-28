import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';

import { LoginRoutingModule } from './login-routing.module';
import { LoginComponent } from './login.component';
import {ReactiveFormsModule} from '@angular/forms'
import {AuthService} from '../shared/services/security/auth.service';

@NgModule({
    imports: [
        CommonModule,
        LoginRoutingModule,
        ReactiveFormsModule,
    ],
    declarations: [LoginComponent],
    providers: [AuthService]
})
export class LoginModule {
}
