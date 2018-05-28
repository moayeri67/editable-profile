import {Component, OnInit} from '@angular/core';
import {routerTransition} from '../../router.animations';
import {Router} from '@angular/router';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {SecurityException} from '../../shared/services/security/security.exception';
import {AttributeService} from "../../shared/services/attributes/attribute.service";
import {Gender} from "../../shared/services/attributes/gender";
import {City} from "../../shared/services/attributes/city"
import {Ethnicity} from "../../shared/services/attributes/ethnicity";
import {Figure} from "../../shared/services/attributes/figure";
import {MaritalStatus} from "../../shared/services/attributes/maritalStatus";
import {Religion} from "../../shared/services/attributes/religion";
import {HttpEventType, HttpResponse} from "@angular/common/http";
import {IProfile} from "./profile.interface";
import {Token} from "../../shared/services/security/token";
import {ProfileService} from "../../shared/services/profile/profile.service";


@Component({
               selector: 'app-profile',
               templateUrl: './profile.component.html',
               styleUrls: ['./profile.component.scss'],
               animations: [routerTransition()]
           })
export class ProfileComponent implements OnInit
{
    genders: Gender[];
    cities: City[];
    ethnicities: Ethnicity[];
    figures: Figure[];
    maritalStatus: MaritalStatus[];
    religions: Religion[];
    profileForm: FormGroup;
    selectedFiles: FileList;
    currentFileUpload: File;
    progress: { percentage: number } = {percentage: 0}
    image: string;

    constructor(private formBuilder: FormBuilder,
                private router: Router,
                private profileService: ProfileService,
                private attributeService: AttributeService)
    {
    }

    ngOnInit()
    {
        this.buildForm();

        this.attributeService.getAllGenders().subscribe((genders: Gender[]) =>
                                                        {
                                                            this.genders = genders;
                                                        },
                                                        (this.errorHandling),
                                                        () => console.log('calling getAllGenders complete'));

        this.attributeService.getAllCities().subscribe((cities: City[]) =>
                                                       {
                                                           this.cities = cities;
                                                       },
                                                       (this.errorHandling),
                                                       () => console.log('calling getAllCities complete'));

        this.attributeService.getAllEthnicities().subscribe((ethnicities: Ethnicity[]) =>
                                                            {
                                                                this.ethnicities = ethnicities;
                                                            },
                                                            (this.errorHandling),
                                                            () => console.log('calling getAllEthnicities complete'));

        this.attributeService.getAllFigures().subscribe((figures: Figure[]) =>
                                                        {
                                                            this.figures = figures;
                                                        },
                                                        (this.errorHandling),
                                                        () => console.log('calling getAllFigures complete'));

        this.attributeService.getAllMaritalStatus().subscribe((maritalStatus: MaritalStatus[]) =>
                                                              {
                                                                  this.maritalStatus = maritalStatus;
                                                              },
                                                              (this.errorHandling),
                                                              () => console.log('calling getAllMaritalStatus complete'));

        this.attributeService.getAllReligions().subscribe((religions: Religion[]) =>
                                                          {
                                                              this.religions = religions;
                                                          },
                                                          (this.errorHandling),
                                                          () => console.log('calling getAllReligions complete'));
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

    selectFile(event)
    {
        const file = event.target.files.item(0)

        if (file.type.match('image.*')) {
            this.selectedFiles = event.target.files;
        }
        else {
            alert('invalid format');
        }
    }

    upload()
    {
        this.progress.percentage = 0;
        this.currentFileUpload = this.selectedFiles.item(0);
        this.profileService.uploadImage(this.currentFileUpload).subscribe(event =>
                                                                          {
                                                                              if (event.type === HttpEventType.UploadProgress) {
                                                                                  this.progress.percentage = Math.round(100 * event.loaded / event.total);
                                                                              }
                                                                              else if (event instanceof HttpResponse) {
                                                                                  console.log('File is completely uploaded !');
                                                                              }
                                                                          });
    }


    submit({value, valid}: { value: IProfile, valid: boolean })
    {
        let token: Token = JSON.parse(localStorage.getItem('token'));

        value.userId = token.userId;
        value.gender = value.gender - 1;
        value.ethnicity = value.ethnicity - 1;
        value.religion = value.religion - 1;
        value.figure = value.figure - 1;
        value.maritalStatus = value.maritalStatus - 1;

        this.profileService.uploadProfile(value).subscribe((result: boolean) =>
                                                           {
                                                           },
                                                           (err: any) =>
                                                           {
                                                               const exp: SecurityException = JSON.parse(err);
                                                               alert(exp.message);
                                                               if (exp instanceof SecurityException) {
                                                                   alert('error from signup component');
                                                               }
                                                           },
                                                           () => this.router.navigate(['/view-profile']));
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
