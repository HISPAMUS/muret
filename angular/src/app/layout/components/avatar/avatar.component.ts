import { Component, OnInit } from '@angular/core';
import {Observable} from "rxjs";
import {selectAuthUsername} from "../../../auth/store/selectors/auth.selector";
import {Store} from "@ngrx/store";
import {CoreState} from "../../../core/store/state/core.state";

@Component({
  selector: 'app-avatar',
  templateUrl: './avatar.component.html',
  styleUrls: ['./avatar.component.css']
})
export class AvatarComponent implements OnInit {
  username$: Observable<string>;

  constructor(private store: Store<CoreState>) { }

  ngOnInit(): void {
    this.username$ = this.store.select(selectAuthUsername);
  }

}
