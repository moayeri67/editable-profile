import { Injectable} from '@angular/core';
import {Http, Headers, RequestOptions, Response} from '@angular/http';

import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';

import {IUserLogin} from '../../../login/login.interface';
import {Token} from './token';
import {WebServiceInfo} from '../webService.info';
import {IUserRegister} from "../../../signup/signup.interface";

@Injectable()
export class AuthService {
    private headers;
    private options;

    constructor(private http: Http) {

    }

    login(userLogin: IUserLogin): Observable<Token> {
        this.headers = new Headers();
        this.headers.append('Access-Control-Allow-Credentials', 'true');
        this.headers.append('Content-Type', 'application/json');
        this.headers.append('Authorization', 'Basic ' + btoa(userLogin.username + ':' + userLogin.password));
        this.options = new RequestOptions({headers: this.headers});

        return this.http.get(WebServiceInfo.webServiceUrl + 'login' + '?username=' + userLogin.username, this.options)
            .map((res: Response) => {
                return res.json();
            })
            .catch((error) => {
                console.error('server error:', error);
                if (error instanceof Response) {
                    let errMessage = '';
                    try {
                        errMessage = JSON.stringify(error.json());
                    } catch (err) {
                        errMessage = error.statusText;
                    }
                    return Observable.throw(errMessage);
                }
                return Observable.throw(error || 'Node.js server error');
            });
    }

    register(userRegister: IUserRegister): Observable<boolean>{
        this.headers = new Headers();
        this.headers.append('Content-Type', 'application/json');
        this.options = new RequestOptions({headers: this.headers});

        const body = JSON.stringify(userRegister);

        return this.http.post(WebServiceInfo.webServiceUrl + 'signup', body, this.options)
            .map(this.extractData)
            .catch(this.errorHandling);
    }

    private extractData(res: Response) {
        const body = res.json();
        return body || [];
    }

    private errorHandling(error: any) {
        console.error('server error:', error);
        if (error instanceof Response) {
            let errMessage = '';
            try {
                errMessage = JSON.stringify(error.json());
            } catch (err) {
                errMessage = error.statusText;
            }
            return Observable.throw(errMessage);
        }
        return Observable.throw(error || 'Node.js server error');
    }
}
