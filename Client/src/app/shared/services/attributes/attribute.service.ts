import { Injectable } from '@angular/core';
import {Http, Headers, URLSearchParams, RequestOptions, Response} from '@angular/http';

import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/toPromise';
import 'rxjs/add/observable/throw';

import {WebServiceInfo} from '../webService.info';
import {Token} from "../security/token";
import {Gender} from "./gender";
import {City} from "./city";
import {Ethnicity} from "./ethnicity";
import {Figure} from "./figure";
import {MaritalStatus} from "./maritalStatus";
import {Religion} from "./religion";

@Injectable()
export class AttributeService {
    private headers;
    private options;

    constructor(private http: Http) {

    }

    getAllGenders(): Observable<Gender[]>{
        this.headers = new Headers();
        let token: Token = JSON.parse(localStorage.getItem('token'));
        console.log('tokenId' + token.tokenId);
        this.headers.append('Content-Type', 'application/json');
        this.headers.append('X-Auth-Token', token.tokenId);
        this.options = new RequestOptions({headers: this.headers});
        return this.http.get(WebServiceInfo.webServiceUrl + 'getAllGenders', this.options)
            .map(this.extractData)
            .catch(this.errorHandling);
    }

    getAllCities(): Observable<City[]>{
        this.headers = new Headers();
        let token: Token = JSON.parse(localStorage.getItem('token'));
        console.log('tokenId' + token.tokenId);
        this.headers.append('Content-Type', 'application/json');
        this.headers.append('X-Auth-Token', token.tokenId);
        this.options = new RequestOptions({headers: this.headers});
        return this.http.get(WebServiceInfo.webServiceUrl + 'getAllCities', this.options)
            .map(this.extractData)
            .catch(this.errorHandling);
    }

    getAllEthnicities(): Observable<Ethnicity[]>{
        this.headers = new Headers();
        let token: Token = JSON.parse(localStorage.getItem('token'));
        console.log('tokenId' + token.tokenId);
        this.headers.append('Content-Type', 'application/json');
        this.headers.append('X-Auth-Token', token.tokenId);
        this.options = new RequestOptions({headers: this.headers});
        return this.http.get(WebServiceInfo.webServiceUrl + 'getAllEthnicities', this.options)
            .map(this.extractData)
            .catch(this.errorHandling);
    }

    getAllFigures(): Observable<Figure[]>{
        this.headers = new Headers();
        let token: Token = JSON.parse(localStorage.getItem('token'));
        console.log('tokenId' + token.tokenId);
        this.headers.append('Content-Type', 'application/json');
        this.headers.append('X-Auth-Token', token.tokenId);
        this.options = new RequestOptions({headers: this.headers});
        return this.http.get(WebServiceInfo.webServiceUrl + 'getAllFigures', this.options)
            .map(this.extractData)
            .catch(this.errorHandling);
    }

    getAllMaritalStatus(): Observable<MaritalStatus[]> {
        this.headers = new Headers();
        let token: Token = JSON.parse(localStorage.getItem('token'));
        console.log('tokenId' + token.tokenId);
        this.headers.append('Content-Type', 'application/json');
        this.headers.append('X-Auth-Token', token.tokenId);
        this.options = new RequestOptions({headers: this.headers});
        return this.http.get(WebServiceInfo.webServiceUrl + 'getAllMaritalStatus', this.options)
            .map(this.extractData)
            .catch(this.errorHandling);
    }

    getAllReligions(): Observable<Religion[]>{
        this.headers = new Headers();
        let token: Token = JSON.parse(localStorage.getItem('token'));
        console.log('tokenId' + token.tokenId);
        this.headers.append('Content-Type', 'application/json');
        this.headers.append('X-Auth-Token', token.tokenId);
        this.options = new RequestOptions({headers: this.headers});
        return this.http.get(WebServiceInfo.webServiceUrl + 'getAllReligions', this.options)
            .map(this.extractData)
            .catch(this.errorHandling);
    }

    private extractUrl(res: Response) {
        return res.url;
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
