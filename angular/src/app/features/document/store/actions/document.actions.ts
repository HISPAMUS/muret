import { Action } from '@ngrx/store';
import {Document} from '../../../../core/model/entities/document';
import {Image} from '../../../../core/model/entities/image';
import {DocumentStatistics} from '../../../../core/model/restapi/document-statistics';
import {AlignmentPreview} from '../../../../core/model/restapi/alignment-preview';
import {BoundingBox} from '../../../../core/model/entities/bounding-box';
import {APIRestServerError} from '../../../../core/model/restapi/apirest-server-error';
import {SectionImages} from "../../../../core/model/restapi/section-images";
import {Section} from "../../../../core/model/entities/section";
import {PartsInImage} from "../../../../core/model/restapi/parts-in-image";
import {NumberArray} from "../../../../core/model/restapi/number-array";
import {ImagesInNewPart} from "../../../../core/model/restapi/images-in-new-part";
import {ImagesVisibility} from "../../../../core/model/restapi/images-visibility";
import {ExportActionTypes} from "../../../export/store/actions/export.actions";

export enum DocumentActionTypes {
  DocumentLogOpen = '[Document] Open',
  DocumentLogOpenSuccess = '[Document] Open success',
  DocumentGetOverview = '[Document] Get Overview',
  DocumentGetOverviewSuccess = '[Document] Get Overview success',
  DocumentMoveImagesToSection = '[Document] Move image to section',
  DocumentMoveImagesToSectionSuccess = '[Document] Move image to section success',
  DocumentCreateSection = '[Document] Create section',
  DocumentCreateSectionSuccess = '[Document] Create section success',
  DocumentMoveImagesToDefaultSection = '[Document] Move images to default section',
  DocumentMoveImagesToDefaultSectionSuccess = '[Document] Move images to default section success',
  DocumentRenameSection = '[Document] Rename section',
  DocumentRenameSectionSuccess = '[Document] Rename section success',
  DocumentDeleteSection = '[Document] Delete section',
  DocumentDeleteSectionSuccess = '[Document] Delete section success',
  DocumentReorderSections = '[Document] Reorder sections',
  DocumentReorderSectionsSuccess = '[Document] Reorder sections success',
  DocumentGetSection = '[Document] Get section',
  DocumentGetSectionSuccess = '[Document] Get section success',
  DocumentReorderImages = '[Document] Reorder images',
  DocumentReorderImagesSuccess = '[Document] Reorder images success',
  DocumentGetPartsInImages = '[Document] Get parts in images',
  DocumentGetPartsInImagesSuccess = '[Document] Get parts in images success',
  DocumentLinkImagesToPart = '[Document] Link images to part',
  DocumentLinkImagesToPartSuccess = '[Document] Link images to part success',
  DocumentLinkImagesToNewPart = '[Document] Link images to new part',
  DocumentLinkImagesToNewPartSuccess = '[Document] Link images to part new success',
  DocumentUnlinkImagesFromPart = '[Document] Unlink images from part',
  DocumentUnlinkImagesFromPartSuccess = '[Document] Unlink images from part success',

  DocumentChangeImagesVisibility = '[Document] Change images visibility',
  DocumentChangeImagesVisibilitySuccess = '[Document] Change images visibility success',

  //DocumentSelectImagesForExport = '[Document] Select images',

  DocumentDownloadActionLogs = '[Document] Download action logs',
  DocumentDownloadActionLogsSuccess = '[Document] Download action logs success',

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
  DocumentGetCroppedImageSuccess = '[Document] Get cropped image success'
}

export class DocumentLogOpen implements Action {
  public readonly type = DocumentActionTypes.DocumentLogOpen;
  constructor(public documentID: number) {}
}

export class DocumentLogOpenSuccess implements Action {
  public readonly type = DocumentActionTypes.DocumentLogOpenSuccess;
  constructor() {}
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


export class DocumentMoveImagesToDefaultSection implements Action {
  public readonly type = DocumentActionTypes.DocumentMoveImagesToDefaultSection;
  constructor(public documentID: number) {}
}

export class DocumentMoveImagesToDefaultSectionSuccess implements Action {
  public readonly type = DocumentActionTypes.DocumentMoveImagesToDefaultSectionSuccess;
  constructor(public section: Section) {}
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
  constructor(public ordering: NumberArray) {}
}

export class DocumentReorderSectionsSuccess implements Action {
  public readonly type = DocumentActionTypes.DocumentReorderSectionsSuccess;
  constructor(public ordering: NumberArray) {}
}


export class DocumentGetSection implements Action {
  public readonly type = DocumentActionTypes.DocumentGetSection;
  constructor(public id: number) {}
}

export class DocumentGetSectionSuccess implements Action {
  public readonly type = DocumentActionTypes.DocumentGetSectionSuccess;
  constructor(public section: Section) {}
}


export class DocumentReorderImages implements Action {
  public readonly type = DocumentActionTypes.DocumentReorderImages;
  constructor(public ordering: NumberArray) {}
}

export class DocumentReorderImagesSuccess implements Action {
  public readonly type = DocumentActionTypes.DocumentReorderImagesSuccess;
  constructor(public ordering: NumberArray) {}
}

export class DocumentGetPartsInImages implements Action {
  public readonly type = DocumentActionTypes.DocumentGetPartsInImages;
  constructor(public documentID: number) {}
}

export class DocumentGetPartsInImagesSuccess implements Action {
  public readonly type = DocumentActionTypes.DocumentGetPartsInImagesSuccess;
  constructor(public partsInImages: PartsInImage[]) {}
}

/**
 * We use this action here, in document and not in other PartsActions, in order to update the document overview
 */
export class DocumentLinkImagesToPart implements Action {
  public readonly type = DocumentActionTypes.DocumentLinkImagesToPart;
  constructor(public imageIDs: NumberArray, public partID: number) {}
}

export class DocumentLinkImagesToPartSuccess implements Action {
  public readonly type = DocumentActionTypes.DocumentLinkImagesToPartSuccess;
  constructor(public partsInImages: PartsInImage[]) {}
}

export class DocumentLinkImagesToNewPart implements Action {
  public readonly type = DocumentActionTypes.DocumentLinkImagesToNewPart;
  constructor(public imageIDs: NumberArray, public partName: string) {}
}

export class DocumentLinkImagesToNewPartSuccess implements Action {
  public readonly type = DocumentActionTypes.DocumentLinkImagesToNewPartSuccess;
  constructor(public imagesInNewPart: ImagesInNewPart) {}
}

export class DocumentUnlinkImagesFromPart implements Action {
  public readonly type = DocumentActionTypes.DocumentUnlinkImagesFromPart;
  constructor(public imageIDs: NumberArray) {}
}

export class DocumentUnlinkImagesFromPartSuccess implements Action {
  public readonly type = DocumentActionTypes.DocumentUnlinkImagesFromPartSuccess;
  constructor(public partsInImages: PartsInImage[]) {}
}


export class DocumentChangeImagesVisibility implements Action {
  public readonly type = DocumentActionTypes.DocumentChangeImagesVisibility;
  constructor(public imageIDs: NumberArray, public hidden: boolean) {}
}

export class DocumentChangeImagesVisibilitySuccess implements Action {
  public readonly type = DocumentActionTypes.DocumentChangeImagesVisibilitySuccess;
  constructor(public imagesVisibility: ImagesVisibility) {}
}

export class DocumentExportMEI implements Action {
  public readonly type = DocumentActionTypes.DocumentExportMEI;
  constructor(public optionalPartID: number, public selectedImages: NumberArray) {}
}

export class DocumentExportMEISuccess implements Action {
  public readonly type = DocumentActionTypes.DocumentExportMEISuccess;
  constructor(public mei: string) {}
}

export class DocumentExportMEIPartsFacsimile implements Action {
  public readonly type = DocumentActionTypes.DocumentExportMEIPartsFacsimile;
  constructor(public selectedImages: NumberArray, public forMeasuringPolyphony: boolean) {}
}

export class DocumentExportMEIPartsFacsimileSuccess implements Action {
  public readonly type = DocumentActionTypes.DocumentExportMEIPartsFacsimileSuccess;
  constructor(public mei: string) {}
}

/*
export class DocumentSelectImagesForExport implements Action {
  public readonly type = DocumentActionTypes.DocumentSelectImagesForExport;
  constructor(public imagesID: NumberArray) {}
}*/



export class DocumentDownloadActionLogs implements Action {
  public readonly type = DocumentActionTypes.DocumentDownloadActionLogs;
  constructor(public documentID: number) {}
}

export class DocumentDownloadActionLogsSuccess implements Action {
  public readonly type = DocumentActionTypes.DocumentDownloadActionLogsSuccess;
  constructor(public payload: Blob) {}
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
  DocumentLogOpen | DocumentLogOpenSuccess |
  DocumentGetOverview | DocumentGetOverviewSuccess |
  DocumentMoveImagesToSection | DocumentMoveImagesToSectionSuccess |
  DocumentCreateSection | DocumentCreateSectionSuccess |
  DocumentRenameSection | DocumentRenameSectionSuccess |
  DocumentMoveImagesToDefaultSection | DocumentMoveImagesToDefaultSectionSuccess |
  DocumentDeleteSection | DocumentDeleteSectionSuccess |
  DocumentReorderSections | DocumentReorderSectionsSuccess |
  DocumentGetSection | DocumentGetSectionSuccess |
  DocumentReorderImages | DocumentReorderImagesSuccess |
  DocumentGetPartsInImages | DocumentGetPartsInImagesSuccess |
  DocumentLinkImagesToPart | DocumentLinkImagesToPartSuccess |
  DocumentLinkImagesToNewPart | DocumentLinkImagesToNewPartSuccess |
  DocumentUnlinkImagesFromPart |   DocumentUnlinkImagesFromPartSuccess |
  DocumentChangeImagesVisibility | DocumentChangeImagesVisibilitySuccess |
  DocumentDownloadActionLogs | DocumentDownloadActionLogsSuccess |
  //DocumentSelectImagesForExport |

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
