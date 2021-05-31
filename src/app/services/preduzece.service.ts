import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {PREDUZECE_URL} from '../app.constance';

@Injectable({
  providedIn: 'root'
})
export class PreduzeceService {

  constructor(private httpClient: HttpClient) { }

  public getAllPreduzeca(): Observable<any> {
    return this.httpClient.get(`${PREDUZECE_URL}`)
  }
}
