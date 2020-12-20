import { Component, OnInit } from '@angular/core';
import {SimpleModalComponent} from 'ngx-simple-modal';
import {InputModel} from '../input-dialog/input-dialog.component';
import {AlignmentPreviewStaff} from '../../core/model/restapi/alignment-preview';

export type onLinkClickType = () => void;

export interface LinksModel {
  title: string;
  message?: string;
  /**
   * key = text, value = value
   */
  links?: Map<string, string>;
  /**
   * key = text, value = function
   */
  onClickLinks?: Map<string, onLinkClickType>;
}

@Component({
  selector: 'app-links-modal-dialog',
  templateUrl: './links-modal-dialog.component.html',
  styleUrls: ['./links-modal-dialog.component.css']
})
export class LinksModalDialogComponent extends SimpleModalComponent<LinksModel, void> implements InputModel {
  // TODO: add explicit constructor

  title: string;
  message?: string;
  links?: Map<string, string>;
  onClickLinks?: Map<string, onLinkClickType>;

  invoke(value: onLinkClickType) {
    value();
  }
}

/* Example */
/*
showLinks(staff: AlignmentPreviewStaff) {
  const links: Map<string, onLinkClickType> = new Map<string, onLinkClickType>();

  const linkFullImagePreview: onLinkClickType = () => this.previewImage(staff.imageID);
  const linkStaffPreview: onLinkClickType = () => this.previewCroppedImage(staff.imageID, staff.boundingBox);
  const linkStaffSemantic: onLinkClickType = () => this.openSemanticImage(staff.id);

  links.set('Full image preview', linkFullImagePreview);
  links.set('Staff preview', linkStaffPreview);
  links.set('Edit staff semantic', linkStaffSemantic);
  this.dialogsService.showLinks('Staff', '', null, links);
}
*/
