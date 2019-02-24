import {Image} from '../entities/image';

// special projection
export interface DocumentAnalysisImageProjection extends Image {
  projectPath: string;
  width: number;
  height: number;
  manuscriptType: 'eHandwritten' | 'ePrinted';
  notationType: 'eMensural' | 'eModern';
}
