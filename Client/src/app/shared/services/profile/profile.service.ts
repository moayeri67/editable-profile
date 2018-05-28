import { Injectable } from '@angular/core';
import {Http, Headers, RequestOptions, Response} from '@angular/http';

import {HttpClient, HttpRequest, HttpEvent} from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/toPromise';
import 'rxjs/add/observable/throw';

import {WebServiceInfo} from '../webService.info';
import {Token} from "../security/token";
import {IProfile} from "../../../layout/profile/profile.interface";
import {ProfileDTO} from "../../../layout/profile/profile.dto";

@Injectable()
export class ProfileService {
    private headers;
    private options;

    constructor(private http: Http,
                private httpClient: HttpClient) {
    }

    uploadImage(file: File): Observable<HttpEvent<{}>>{
        let formdata: FormData = new FormData();
        let token: Token = JSON.parse(localStorage.getItem('token'));

        formdata.append('file', file);
        formdata.append('userId', token.userId.toString());

        const req = new HttpRequest('POST', WebServiceInfo.webServiceUrl + 'uploadProfileImage', formdata, {
            reportProgress: true,
            responseType: 'text'
        });
        return this.httpClient.request(req);
    }

    uploadProfile(userProfile: IProfile): Observable<boolean>{
        this.headers = new Headers();
        let token: Token = JSON.parse(localStorage.getItem('token'));
        console.log('tokenId' + token.tokenId);
        this.headers.append('Content-Type', 'application/json');
        this.headers.append('X-Auth-Token', token.tokenId);
        const body = JSON.stringify(userProfile);
        this.options = new RequestOptions({headers: this.headers});

        return this.http.post(WebServiceInfo.webServiceUrl + 'updateProfile', body, this.options)
            .map(this.extractData)
            .catch(this.errorHandling);
    }

    getImage(): Observable<any>{
        let token: Token = JSON.parse(localStorage.getItem('token'));

        return this.http.get(WebServiceInfo.webServiceUrl + 'getImage/' + '?userId='+ token.userId)
            .map(this.extractUrl)
            .catch(this.errorHandling);
    }

    getProfile(): Observable<ProfileDTO>{
        this.headers = new Headers();
        let token: Token = JSON.parse(localStorage.getItem('token'));

        this.headers.append('Content-Type', 'application/json');
        this.headers.append('X-Auth-Token', token.tokenId);
        this.options = new RequestOptions({headers: this.headers});
        return this.http.get(WebServiceInfo.webServiceUrl + 'getProfileById/' + '?userId=' + token.userId, this.options)
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
