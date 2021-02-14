import { Action } from '@ngrx/store';
import {Document} from '../../../../core/model/entities/document';
import {Image} from '../../../../core/model/entities/image';
import {DocumentStatistics} from '../../../../core/model/restapi/document-statistics';
import {AlignmentPreview} from '../../../../core/model/restapi/alignment-preview';
import {BoundingBox} from '../../../../core/model/entities/bounding-box';
import {APIRestServerError} from '../../../../core/model/restapi/apirest-server-error';
import {SectionImages} from "../../../../core/model/restapi/section-images";
import {Section} from "../../../../core/model/entities/section";
import {Ordering} from "../../../../core/model/restapi/ordering";

export enum DocumentActionTypes {
  DocumentGetOverview = '[Document] Get Overview',
  DocumentGetOverviewSuccess = '[Document] Get Overview success',
  DocumentMoveImagesToSection = '[Document] Move image to section',
  DocumentMoveImagesToSectionSuccess = '[Document] Move image to section success',
  DocumentCreateSection = '[Document] Create section',
  DocumentCreateSectionSuccess = '[Document] Create section success',
  DocumentRenameSection = '[Document] Rename section',
  DocumentRenameSectionSuccess = '[Document] Rename section success',
  DocumentDeleteSection = '[Document] Delete section',
  DocumentDeleteSectionSuccess = '[Document] Delete section success',
  DocumentReorderSections = '[Document] Reorder sections',
  DocumentReorderSectionsSuccess = '[Document] Reorder sections success',


  // revisado hasta aquí
  ResetDocumentServerError = '[Document] Reset Server error',
  DocumentServerError = '[Document] Server error',
  DocumentGetDocument = '[Document] Get document',
  DocumentGetDocumentSuccess = '[Document] Get document success',
  DocumentGetImages = '[Document] Get images',
  DocumentGetImagesSuccess = '[Document] Get images success',
  DocumentExportMEI = '[Document] Export MEI',
  DocumentExportMEISuccess = '[Document] Export MEI success',
  DocumentExportMEIPartsFacsimile = '[Document] Export MEI parts and facsimile',
  DocumentExportMEIPartsFacsimileSuccess = '[Document] Export MEI parts and facsimile success',
  DocumentExportMensurstrich = '[Document] Export mensurstrich',
  DocumentExportMensurstrichSuccess = '[Document] Export mensurstrich success',
  DocumentExportMusicXML = '[Document] Export MusicXML',
  DocumentExportMusicXMLSuccess = '[Document] Export MusicXML success',
  DocumentGetDocumentStatistics = '[Document] Get document statistics',
  DocumentGetDocumentStatisticsSuccess = '[Document] Get document statistics success',
  DocumentGetAlignmentPreview = '[Document] Get alignment preview',
  DocumentGetAlignmentPreviewSuccess = '[Document] Get alignment preview success',
  DocumentGetCroppedImage = '[Document] Get cropped image',
  DocumentGetCroppedImageSuccess = '[Document] Get cropped image success',
}


export class DocumentGetOverview implements Action {
  public readonly type = DocumentActionTypes.DocumentGetOverview;
  constructor(public documentID: number) {}
}

export class DocumentGetOverviewSuccess implements Action {
  public readonly type = DocumentActionTypes.DocumentGetOverviewSuccess;
  constructor(public documentOverview: Document) {}
}

export class DocumentMoveImagesToSection implements Action {
  public readonly type = DocumentActionTypes.DocumentMoveImagesToSection;
  constructor(public sectionImages: SectionImages) {}
}

export class DocumentMoveImagesToSectionSuccess implements Action {
  public readonly type = DocumentActionTypes.DocumentMoveImagesToSectionSuccess;
  constructor(public sectionImages: SectionImages) {}
}

export class DocumentCreateSection implements Action {
  public readonly type = DocumentActionTypes.DocumentCreateSection;
  constructor(public documentID: number, public name: string) {}
}

export class DocumentCreateSectionSuccess implements Action {
  public readonly type = DocumentActionTypes.DocumentCreateSectionSuccess;
  constructor(public section: Section) {}
}

export class DocumentRenameSection implements Action {
  public readonly type = DocumentActionTypes.DocumentRenameSection;
  constructor(public section: Section) {}
}

export class DocumentRenameSectionSuccess implements Action {
  public readonly type = DocumentActionTypes.DocumentRenameSectionSuccess;
  constructor(public section: Section) {}
}


export class DocumentDeleteSection implements Action {
  public readonly type = DocumentActionTypes.DocumentDeleteSection;
  constructor(public sectionID: number) {}
}

export class DocumentDeleteSectionSuccess implements Action {
  public readonly type = DocumentActionTypes.DocumentDeleteSectionSuccess;
  constructor(public sectionID: number) {}
}

export class DocumentReorderSections implements Action {
  public readonly type = DocumentActionTypes.DocumentReorderSections;
  constructor(public ordering: Ordering) {}
}

export class DocumentReorderSectionsSuccess implements Action {
  public readonly type = DocumentActionTypes.DocumentReorderSectionsSuccess;
  constructor(public ordering: Ordering) {}
}

// revisado hasta aquí


export class DocumentResetServerError implements Action {
  public readonly type = DocumentActionTypes.ResetDocumentServerError;
  constructor() {}
}


export class DocumentServerError implements Action {
  public readonly type = DocumentActionTypes.DocumentServerError;
  constructor(public error: APIRestServerError) {}
}



export class DocumentGetDocument implements Action {
  public readonly type = DocumentActionTypes.DocumentGetDocument;
  constructor(public documentID: number) {}
}

export class DocumentGetDocumentSuccess implements Action {
  public readonly type = DocumentActionTypes.DocumentGetDocumentSuccess;
  constructor(public document: Document) {}
}

export class DocumentGetImages implements Action {
  public readonly type = DocumentActionTypes.DocumentGetImages;
  constructor(public documentID: number) {}
}

export class DocumentGetImagesSuccess implements Action {
  public readonly type = DocumentActionTypes.DocumentGetImagesSuccess;
  constructor(public images: Image[]) {}
}

export class DocumentExportMEI implements Action {
  public readonly type = DocumentActionTypes.DocumentExportMEI;
  constructor(public documentID: number, public partID: number, public selectedImages: Array<number>) {}
}

export class DocumentExportMEISuccess implements Action {
  public readonly type = DocumentActionTypes.DocumentExportMEISuccess;
  constructor(public mei: string) {}
}

export class DocumentExportMEIPartsFacsimile implements Action {
  public readonly type = DocumentActionTypes.DocumentExportMEIPartsFacsimile;
  constructor(public documentID: number, public selectedImages: Array<number>, public forMeasuringPolyphony: boolean) {}
}

export class DocumentExportMEIPartsFacsimileSuccess implements Action {
  public readonly type = DocumentActionTypes.DocumentExportMEIPartsFacsimileSuccess;
  constructor(public mei: string) {}
}

export class DocumentExportMensurstrich implements Action {
  public readonly type = DocumentActionTypes.DocumentExportMensurstrich;
  constructor(public documentID: number, public selectedImages: Array<number>) {}
}

export class DocumentExportMensurstrichSuccess implements Action {
  public readonly type = DocumentActionTypes.DocumentExportMensurstrichSuccess;
  constructor(public payload: Blob) {}
}

export class DocumentExportMusicXML implements Action {
  public readonly type = DocumentActionTypes.DocumentExportMusicXML;
  constructor(public documentID: number, public selectedImages: Array<number>) {}
}

export class DocumentExportMusicXMLSuccess implements Action {
  public readonly type = DocumentActionTypes.DocumentExportMusicXMLSuccess;
  constructor(public payload: Blob) {}
}

export class DocumentGetDocumentStatistics implements Action {
  public readonly type = DocumentActionTypes.DocumentGetDocumentStatistics;
  constructor(public documentID: number) {}
}

export class DocumentGetDocumentStatisticsSuccess implements Action {
  public readonly type = DocumentActionTypes.DocumentGetDocumentStatisticsSuccess;
  constructor(public documentStatistics: DocumentStatistics) {}
}

/*export class PreflightCheck implements Action {
  public readonly type = DocumentActionTypes.PreflightCheck;
  constructor(public documentID: number, public selectedImages: Array<number>) {}
}

export class PreflightCheckSuccess implements Action {
  public readonly type = DocumentActionTypes.PreflightCheckSuccess;
  constructor(public preflightCheckResult: PreflightCheckResult) {}
}*/

export class DocumentGetAlignmentPreview implements Action {
  public readonly type = DocumentActionTypes.DocumentGetAlignmentPreview;
  constructor(public documentID: number) {}
}

export class DocumentGetAlignmentPreviewSuccess implements Action {
  public readonly type = DocumentActionTypes.DocumentGetAlignmentPreviewSuccess;
  constructor(public alignmentPreview: AlignmentPreview) {}
}


export class DocumentGetCroppedImage implements Action {
  public readonly type = DocumentActionTypes.DocumentGetCroppedImage;
  constructor(public imageID: number, public boundingBox: BoundingBox) {}
}

export class DocumentGetCroppedImageSuccess implements Action {
  public readonly type = DocumentActionTypes.DocumentGetCroppedImageSuccess;
  constructor(public url: string) {}
}

export type DocumentActions =
  DocumentGetOverview | DocumentGetOverviewSuccess |
  DocumentMoveImagesToSection | DocumentMoveImagesToSectionSuccess |
  DocumentCreateSection | DocumentCreateSectionSuccess |
  DocumentRenameSection | DocumentRenameSectionSuccess |
  DocumentDeleteSection | DocumentDeleteSectionSuccess |
  DocumentReorderSections | DocumentReorderSectionsSuccess |
  // revisado hasta aquí
  DocumentResetServerError | DocumentServerError |
  DocumentGetDocument | DocumentGetDocumentSuccess | DocumentGetImages | DocumentGetImagesSuccess | DocumentExportMEI | DocumentExportMEISuccess |
  DocumentExportMEIPartsFacsimile | DocumentExportMEIPartsFacsimileSuccess |
  DocumentExportMensurstrich | DocumentExportMensurstrichSuccess |
  DocumentExportMusicXML | DocumentExportMusicXMLSuccess |
  DocumentGetDocumentStatistics | DocumentGetDocumentStatisticsSuccess |
  // PreflightCheck | PreflightCheckSuccess |
  DocumentGetAlignmentPreview | DocumentGetAlignmentPreviewSuccess |
  DocumentGetCroppedImage | DocumentGetCroppedImageSuccess;
