import {Component, OnDestroy, OnInit} from '@angular/core';
import {FormBuilder, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {NewDocumentState} from '../../store/state/new-document.state';
import {Store} from '@ngrx/store';
import {CreateDocument, CreateDocumentReset, GetCollections} from '../../store/actions/new-document.actions';
import {Observable, Subscription} from 'rxjs';
import {selectNewDocumentCollections, selectNewDocument} from '../../store/selectors/new-document.selector';
import {User} from '../../../../core/model/entities/user';
import {selectAuthState} from '../../../../auth/store/selectors/auth.selector';
import {Collection} from '../../../../core/model/entities/collection';

@Component({
  selector: 'app-new-document',
  templateUrl: './new-document.component.html',
  styleUrls: ['./new-document.component.css']
})
export class NewDocumentComponent implements OnInit, OnDestroy {
  imgSrc: string;
  createDocumentSuccessSubscription: Subscription;
  authSubscription: Subscription;
  collections$: Observable<Collection[]>;
  private serverErrorSubscription: Subscription;

  newDocumentForm = this.fb.group({
    name: ['', Validators.required],
    composer: [''],
    notationType: ['eMensural', Validators.required],
    manuscriptType: ['eHandwritten', Validators.required],
    comments: [''],
    collections: [Validators.required]
  });
  user: User;

  constructor(private fb: FormBuilder, private store: Store<NewDocumentState>, private router: Router) {
    this.authSubscription = this.store.select(selectAuthState).subscribe(next => {
      this.user = {
        id: next.userID, // actually, we just need now the ID
        username: next.username
      };
    });
  }

  ngOnInit() {
    this.store.dispatch(new CreateDocumentReset());
    this.store.dispatch(new GetCollections());
    this.collections$ = this.store.select(selectNewDocumentCollections);

    this.createDocumentSuccessSubscription = this.store.select(selectNewDocument).subscribe(next => {
      if (next) {
        this.router.navigate(['/document', next.id]);
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

    const cp = new CreateDocument(
      this.user,
      this.newDocumentForm.controls.name.value,
      this.newDocumentForm.controls.composer.value,
      this.newDocumentForm.controls.notationType.value,
      this.newDocumentForm.controls.manuscriptType.value,
      this.newDocumentForm.controls.comments.value, this.imgSrc,
      this.newDocumentForm.controls.collections.value
    );
    this.store.dispatch(cp);
  }

  ngOnDestroy(): void {
    this.createDocumentSuccessSubscription.unsubscribe();
    this.authSubscription.unsubscribe();
    this.serverErrorSubscription.unsubscribe();
  }
}
