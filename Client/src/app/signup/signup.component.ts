import { Component, OnInit } from '@angular/core';
import { routerTransition } from '../router.animations';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {AuthService} from "../shared/services/security/auth.service";
import {IUserRegister} from "./signup.interface";
import {SecurityException} from "../shared/services/security/security.exception";

@Component({
    selector: 'app-signup',
    templateUrl: './signup.component.html',
    styleUrls: ['./signup.component.scss'],
    animations: [routerTransition()]
})
export class SignupComponent implements OnInit {
    registrationForm: FormGroup;

    constructor(private formBuilder: FormBuilder,
                private router: Router,
                private authService: AuthService) { }

    ngOnInit() {
        this.buildForm();
    }

    buildForm(){
        this.registrationForm = this.formBuilder.group({
                                                            username: ['', Validators.required],
                                                            password: ['', Validators.required],
                                                            email: ['', Validators.required],
                                                            height: ['', Validators.required]
                                                       });
    }

    submit({value, valid}: {value: IUserRegister, valid: boolean}){
        this.authService.register(value)
            .subscribe((result: boolean) => {
                            this.router.navigate(['/login']);
                       },
                       (err: any) => {
                           const exp: SecurityException = JSON.parse(err);
                           alert(exp.message);
                           if (exp instanceof SecurityException) {
                               alert('error from signup component');
                           }
                       },
                       () => this.router.navigate(['/login']) );
    }
}
