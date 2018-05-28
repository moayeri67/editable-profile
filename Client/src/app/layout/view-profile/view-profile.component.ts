import {Component, OnInit} from '@angular/core';
import {routerTransition} from '../../router.animations';
import {Router} from '@angular/router';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {SecurityException} from '../../shared/services/security/security.exception';
import {ProfileService} from "../../shared/services/profile/profile.service";
import {ProfileDTO} from "../profile/profile.dto";


@Component({
               selector: 'app-view-profile',
               templateUrl: './view-profile.component.html',
               styleUrls: ['./view-profile.component.scss'],
               animations: [routerTransition()]
           })
export class ViewProfileComponent implements OnInit
{
    displayName: string;
    birthday: string;
    gender: string;
    ethnicity: string;
    religion: string;
    height: number;
    figure: string;
    aboutMe: string;
    location: string;
    profileForm: FormGroup;
    image: string;

    constructor(private formBuilder: FormBuilder,
                private router: Router,
                private profileService: ProfileService)
    {
    }

    ngOnInit()
    {
        this.buildForm();

        this.profileService.getImage().subscribe((file) =>
                                                 {
                                                     this.image = file;
                                                 },
                                                 (this.errorHandling),
                                                 () => console.log('calling getAllGenders complete'));

        this.profileService.getProfile().subscribe((profile: ProfileDTO) =>
                                                   {
                                                       this.displayName = profile.displayName;
                                                       this.birthday = profile.birthday;
                                                       this.gender = profile.gender;
                                                       this.ethnicity = profile.ethnicity;
                                                       this.religion = profile.religion;
                                                       this.height = profile.height;
                                                       this.figure = profile.figure;
                                                       this.aboutMe = profile.aboutMe;
                                                       this.location = profile.location;
                                                   },
                                                   (this.errorHandling),
                                                   () => console.log('calling getProfile complete'));
    }

    buildForm()
    {
        this.profileForm = this.formBuilder.group({
                                                      displayName: ['', [Validators.required]],
                                                      realName: ['', [Validators.required]],
                                                      birthday: ['', [Validators.required]],
                                                      gender: ['', [Validators.required]],
                                                      ethnicity: [''],
                                                      religion: [''],
                                                      figure: [''],
                                                      maritalStatus: ['', [Validators.required]],
                                                      occupation: [''],
                                                      aboutMe: [''],
                                                      location: ['', [Validators.required]]
                                                  });
    }

    private errorHandling(error: any)
    {
        const exp: SecurityException = JSON.parse(error);

        if (exp.status === 401) {
            this.router.navigate(['/login']);

            localStorage.removeItem('token');
        }
    }
}
