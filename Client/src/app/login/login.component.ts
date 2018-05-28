import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import { routerTransition } from '../router.animations';
import {AuthService} from '../shared/services/security/auth.service';
import {IUserLogin} from './login.interface';
import {Token} from '../shared/services/security/token';
import {SecurityException} from '../shared/services/security/security.exception';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.scss'],
    animations: [routerTransition()]
})
export class LoginComponent implements OnInit {
    loginForm: FormGroup;

    constructor(private formBuilder: FormBuilder,
                private router: Router,
                private authService: AuthService) {
    }

    ngOnInit() {
        this.buildForm();
    }

    buildForm() {
        this.loginForm = this.formBuilder.group({
                                                    username: ['', [Validators.required]],
                                                    password: ['', [Validators.required]]
                                                });
    }

    submit({ value, valid }: { value: IUserLogin, valid: boolean }) {
        this.authService.login(value)
            .subscribe((token: Token) => {
                           localStorage.setItem('token', JSON.stringify(token));
                       },
                       (err: any) => {
                           const exp: SecurityException = JSON.parse(err);
                           alert(exp.message);
                           if (exp instanceof SecurityException) {
                               alert('error from login component');
                           }
                       },
                       () => this.router.navigate(['/view-profile']) );
    }
}
