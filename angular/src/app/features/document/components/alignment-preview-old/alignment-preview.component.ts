import {Component, OnDestroy, OnInit} from '@angular/core';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Store} from '@ngrx/store';
import {DocumentState} from '../../store/state/document.state';
import {DialogsService} from '../../../../shared/services/dialogs.service';
import {DocumentGetAlignmentPreview, DocumentResetServerError} from '../../store/actions/document.actions';
import {Subscription} from 'rxjs';
import {
  AlignmenPreviewTimeSignature,
  AlignmentPreview,
  AlignmentPreviewItemWithDuration,
  AlignmentPreviewPart,
  AlignmentPreviewPitch, AlignmentPreviewProblem, AlignmentPreviewStaff
} from '../../../../core/model/restapi/alignment-preview';
import {selectAlignmentPreview} from '../../store/selectors/document.selector';
import {Shape} from '../../../../svg/model/shape';
import {Text} from '../../../../svg/model/text';
import {Rectangle} from '../../../../svg/model/rectangle';
import {Line} from '../../../../svg/model/line';
import {ImageFilesService} from '../../../../core/services/image-files.service';
import {Lightbox, LightboxConfig} from 'ngx-lightbox';
import {DomSanitizer} from '@angular/platform-browser';
import {BoundingBox} from '../../../../core/model/entities/bounding-box';
import {ShowErrorService} from '../../../../core/services/show-error.service';

@Component({
  selector: 'app-alignment-preview',
  templateUrl: './alignment-preview.component.html',
  styleUrls: ['./alignment-preview.component.css']
})
export class AlignmentPreviewComponent implements OnInit, OnDestroy {
  private documentID: number;
  private alignmentPreview: AlignmentPreview;
  private alignmentPreviewSubscription: Subscription;

  zoomFactor = 1; // TODO Iconos para zoom
  selectedShapeID: number;
  /**
   * key = staff id
   */
  shapes: Map<number, Shape[]>;

  pianoRollWidth: number;

  /**
   * key = staff id, value = width
   */
  staffWidth: Map<number, number>;
  private PITCH_SCALE = 2;
  STAVES_HEIGHT = 12 * 4 * this.PITCH_SCALE; // 4 octaves
  pianoRollBuilt = false;
  private TIME_SCALE = 10;
  private NOTE_BAR_HEIGHT = 3;
  private PITCH_MARGIN = 12; // margin to the top of the staff
  private serverErrorSubscription: Subscription;

  constructor(private route: ActivatedRoute, private store: Store<DocumentState>, private router: Router,
              private dialogsService: DialogsService,
              private imageFilesService: ImageFilesService,
              private lightbox: Lightbox,
              private lighboxConfig: LightboxConfig,
              private sanitizer: DomSanitizer, private showErrorService: ShowErrorService
              ) {
  }

  ngOnInit(): void {
    this.route.paramMap.subscribe((params: ParamMap) => {
      this.documentID = +this.route.snapshot.paramMap.get('id'); // + converts the string to number
      this.store.dispatch(new DocumentGetAlignmentPreview(this.documentID));
    });

    this.alignmentPreviewSubscription = this.store.select(selectAlignmentPreview).subscribe(next => {
      this.alignmentPreview = next;
      this.constructPianoRoll();
    });

    /*this.serverErrorSubscription = this.store.select(selectDocumentAPIRestErrorSelector).subscribe(next => {
      if (next) {
        this.showErrorService.showServerError(next);
        this.store.dispatch(new DocumentResetServerError());
      }
    });*/
  }

  ngOnDestroy(): void {
    this.alignmentPreviewSubscription.unsubscribe();
    this.serverErrorSubscription.unsubscribe();
  }

  private constructPianoRoll() {
    this.shapes = new Map<number, Shape[]>(); // key = staff id
    this.staffWidth = new Map<number, number>(); // key = staff id
    this.pianoRollWidth = 0;
    if (this.alignmentPreview) {
      this.alignmentPreview.parts.forEach(part => {
        this.constructPianoRollForPart(part);
      });
      this.pianoRollBuilt = true;
    }
  }

  private addText(staffShapes: Shape[], value: string, x: number, y: number, color: string, size: number): Text {
    const t: Text = new Text();
    t.text = value;
    t.fromX = x;
    t.fromY = y;
    t.fillColor = color;
    t.fontSize = size;
    staffShapes.push(t);
    return t;
  }

  private addRectangle(staffShapes: Shape[], fromX: number, fromY: number, width: number, height: number, strokeColor: string,
                       fillColor: string) {
    const rect: Rectangle = new Rectangle();
    rect.fromX = fromX;
    rect.fromY = fromY;
    rect.width = width;
    rect.height = height;
    rect.fillColor = fillColor;
    rect.strokeColor = strokeColor;
    staffShapes.push(rect);
  }

  private addLine(staffShapes: Shape[], x: number, fromY: number, toY: number, color: string, strokeWidth: number) {
    const line: Line = new Line();
    line.fromX = x;
    line.toX = x;
    line.fromY = fromY;
    line.toY = toY;
    line.strokeColor = color;
    line.strokeWidth = strokeWidth;
    staffShapes.push(line);
  }


  private constructPianoRollForPart(part: AlignmentPreviewPart) {
    // it is reused along staves in the same part
    let lastMeasureDuration: number;
    // used for staves that don't complete the measure in orderEntities to correctly draw the measure lines
    let pendingMeasureTimeFromPreviousStaff = 0;

    part.staves.forEach(staff => {
      const staffShapes: Shape[] = [];
      this.shapes.set(staff.id, staffShapes);

      let staffTimeEndsAt = 0;

      if (staff.items && staff.items.length > 0) {
        // first compute the vertical center
        let minPitch = 127;
        let maxPitch = 0;

        if (staff.items && staff.items.length > 0) {
          staff.items.forEach(item => {
            if (item.type === 'note') {
              const noteItem: AlignmentPreviewPitch = item as AlignmentPreviewPitch;
              minPitch = Math.min(minPitch, noteItem.midiPitch);
              maxPitch = Math.max(minPitch, noteItem.midiPitch);
            }
          });
        }

        let lastMeasureDurationChangeTime = pendingMeasureTimeFromPreviousStaff;
        // TODO colores
        staff.items.forEach(item => {
          let endTime = item.time;
          switch (item.type) {
            case 'fermata':
              // TODO
              break;
            case 'keyChange':
              this.addText(staffShapes, item.description, item.time * this.TIME_SCALE, this.STAVES_HEIGHT - 20, 'green', 12);
              break;
            case 'timeSignatureChange':
              this.addText(staffShapes, item.description, item.time * this.TIME_SCALE, this.STAVES_HEIGHT, 'pink', 14);
              if (lastMeasureDurationChangeTime > 0) {
                this.drawMeasureLines(staffShapes, lastMeasureDurationChangeTime, item.time, lastMeasureDuration);
              }
              lastMeasureDuration = (item as AlignmenPreviewTimeSignature).measureDuration;
              lastMeasureDurationChangeTime = item.time;
              break;
            case 'barline':
              this.addLine(staffShapes, item.time, 0, this.STAVES_HEIGHT, 'blue', 3); // TODO grosor
              break;
            case 'rest':
              const restItem: AlignmentPreviewItemWithDuration = item as AlignmentPreviewItemWithDuration;
              endTime = restItem.time + restItem.duration;
              // TODO dur ahora 20 arriba y abajo
              // TODO color según figura - algo si tiene puntillos
              // 10 para la altura
              this.addRectangle(staffShapes, restItem.time * this.TIME_SCALE, this.STAVES_HEIGHT / 3,
                restItem.duration * this.TIME_SCALE, this.STAVES_HEIGHT / 6, 'gray', 'lightgray');
              break;
            case 'note':
              const noteItem: AlignmentPreviewPitch = item as AlignmentPreviewPitch;
              endTime = noteItem.time + noteItem.duration;
              const pitch = noteItem.midiPitch;
              const y = (maxPitch - pitch + this.PITCH_MARGIN) * this.PITCH_SCALE; // recall 0 is the top
              // TODO color según figura - algo si tiene puntillos
              this.addRectangle(staffShapes, noteItem.time * this.TIME_SCALE, y, noteItem.duration * this.TIME_SCALE, this.NOTE_BAR_HEIGHT, 'yellow', 'red');
              break;
            default:
            // TODO Error
          }
          staffTimeEndsAt = Math.max(staffTimeEndsAt, endTime);
        });
        const staffDuration = staffTimeEndsAt;
        this.staffWidth.set(staff.id, staffDuration * this.TIME_SCALE);

        if (staffTimeEndsAt) {
          this.pianoRollWidth = Math.max(this.pianoRollWidth, staffTimeEndsAt * this.TIME_SCALE);
          if (!lastMeasureDurationChangeTime) {
            lastMeasureDurationChangeTime = 0;
          }
          pendingMeasureTimeFromPreviousStaff =
            this.drawMeasureLines(staffShapes, lastMeasureDurationChangeTime, staffTimeEndsAt, lastMeasureDuration);
        }
      }
    });
  }

  /**
   * It returns the duration used for next measures for staves that don't complete the measure
   */
  private drawMeasureLines(staffShapes: Shape[], fromTime: any, toTime: number, measureDuration: number): number {
    let t = fromTime;
    for (; t <= toTime; t += measureDuration) {
      this.addLine(staffShapes, t * this.TIME_SCALE, 0, this.STAVES_HEIGHT, 'gray', 2);
    }
    const pendingDurationForNextMeasures = t - toTime;
    return pendingDurationForNextMeasures;
  }

  getWidth(staffID: number) {
    return this.staffWidth.get(staffID);
  }

  getShapes(staffID: number) {
    return this.shapes.get(staffID);
  }

  openProblemTarget(problem: AlignmentPreviewProblem) {
    if (problem.regionID) {
      this.openSemanticRegion(problem.imageID, problem.regionID);
    } else {
      this.openSemanticImage(problem.imageID);
    }
  }

  openSemanticRegion(imageID: number, regionID: number) {
    this.router.navigate(['semanticrepresentation', imageID, {region_id: regionID}]); // region_id is an optional parameter
  }

  openSemanticImage(imageID: number) {
    this.router.navigate(['semanticrepresentation', imageID]);
  }

  getProblemTitle(problem: AlignmentPreviewProblem) {
    if (problem.regionID) {
      return 'Region with ID #' + problem.regionID;
    } else if (problem.imageID) {
      return 'Image with ID #' + problem.imageID;
    } else {
      return '';
    }
  }

  trackByPartFn(index, item: AlignmentPreviewPart) {
    return item.id; // unique id corresponding to the item
  }

  trackByStaffFn(index, item: AlignmentPreviewStaff) {
    return item.id; // unique id corresponding to the item
  }

  // TODO algo de código repetido en ImageThumbnailComponent
  previewImage(imageID: number) {
    this.imageFilesService.getPreviewImageBlob$(null, imageID).subscribe(imageBlob => {
      const albums = []; // used by Lightbox

      const album = {
        src: this.sanitizer.bypassSecurityTrustResourceUrl(window.URL.createObjectURL(imageBlob)),
        caption: ''
      };

      albums.push(album);
      this.lightbox.open(albums);
      // window.open(window.URL.createObjectURL(imageBlob), 'Preview ' + this.image.filename, 'widthPercentage=1280,heightPercentage=720');
    });
  }



  // TODO algo de código repetido en ImageThumbnailComponent
  previewCroppedImage(imageID: number, boundingBox: BoundingBox) {
    this.imageFilesService.getCroppedMasterImageBlob$(imageID, boundingBox).subscribe(imageBlob => {
      const albums = []; // used by Lightbox

      const album = {
        src: this.sanitizer.bypassSecurityTrustResourceUrl(window.URL.createObjectURL(imageBlob)),
        caption: ''
      };

      albums.push(album);
      this.lightbox.open(albums);
      // window.open(window.URL.createObjectURL(imageBlob), 'Preview ' + this.image.filename, 'widthPercentage=1280,heightPercentage=720');
    });
  }
}
