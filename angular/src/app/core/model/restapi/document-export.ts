export enum DocumentExportType {
  mei_score, mei_parts_facsimile, musicxml, mensurstrich_svg
}

export interface DocumentExport {
  file: string | Blob;
  fileExtension: string;
  type: DocumentExportType;
}
