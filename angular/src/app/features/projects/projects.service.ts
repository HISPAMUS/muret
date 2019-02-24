import {Injectable, OnInit} from '@angular/core';
import {UserService} from '../../shared/services/user.service';
import {Observable, of} from 'rxjs';
import {User} from '../../shared/entities/user';

@Injectable() // non-singleton
export class ProjectsService {
  user$: Observable<User>;

  constructor(private userService: UserService) {
    this.user$ = this.userService.getCurrentUserProjection();
  }
}
