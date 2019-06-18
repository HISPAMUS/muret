import {Component, OnDestroy, OnInit} from '@angular/core';
import {FormBuilder, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {NewProjectState} from '../../store/state/new-project.state';
import {Store} from '@ngrx/store';
import {CreateProject, CreateProjectReset, GetCollections} from '../../store/actions/new-project.actions';
import {Observable, Subscription} from 'rxjs';
import {selectCollections, selectNewProject} from '../../store/selectors/new-project.selector';
import {User} from '../../../../core/model/entities/user';
import {selectAuthState} from '../../../../auth/store/selectors/auth.selector';
import {Collection} from '../../../../core/model/entities/collection';

@Component({
  selector: 'app-new-project',
  templateUrl: './new-project.component.html',
  styleUrls: ['./new-project.component.css']
})
export class NewProjectComponent implements OnInit, OnDestroy {
  imgSrc: string;
  createProjectSuccessSubscription: Subscription;
  authSubscription: Subscription;
  collections$: Observable<Collection[]>;

  newProjectForm = this.fb.group({
    name: ['', Validators.required],
    composer: [''],
    notationType: ['eMensural', Validators.required],
    manuscriptType: ['eHandwritten', Validators.required],
    comments: [''],
    collections: [Validators.required]
  });
  user: User;

  constructor(private fb: FormBuilder, private store: Store<NewProjectState>, private router: Router) {
    this.authSubscription = this.store.select(selectAuthState).subscribe(next => {
      this.user = {
        id: next.userID, // actually, we just need now the ID
        username: next.username
      };
    });
  }

  ngOnInit() {
    this.store.dispatch(new CreateProjectReset());
    this.store.dispatch(new GetCollections());
    this.collections$ = this.store.select(selectCollections);

    this.createProjectSuccessSubscription = this.store.select(selectNewProject).subscribe(next => {
      if (next) {
        this.router.navigate(['/project', next.id]);
      }}
    );
  }

  onReset() {
  }

  onSelect($event: any) {
    this.imgSrc = $event;
  }

  onSubmit() {
    if (!this.user) {
      throw new Error('User not selected yet!');
    }

    const cp = new CreateProject(
      this.user,
      this.newProjectForm.controls.name.value,
      this.newProjectForm.controls.composer.value,
      this.newProjectForm.controls.notationType.value,
      this.newProjectForm.controls.manuscriptType.value,
      this.newProjectForm.controls.comments.value, this.imgSrc,
      this.newProjectForm.controls.collections.value
    );
    this.store.dispatch(cp);
  }

  ngOnDestroy(): void {
    this.createProjectSuccessSubscription.unsubscribe();
    this.authSubscription.unsubscribe();
  }
}
