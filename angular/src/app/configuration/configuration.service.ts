import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {MessageService} from '../layout/components/messages/message.service';
import {environment} from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})


export class ConfigurationService {
  private urlConfiguration: string;
  public IM3WS_SERVER = environment.apiEndpoint;

  constructor(
    private http: HttpClient,
    private messageService: MessageService) {
  }
}
