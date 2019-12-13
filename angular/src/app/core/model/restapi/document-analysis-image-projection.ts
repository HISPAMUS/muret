import {Image} from '../entities/image';
import {Part} from '../entities/part';

// special projection
export interface DocumentAnalysisImageProjection extends Image {
  projectPath: string;
  width: number;
  height: number;
  manuscriptType: 'eHandwritten' | 'ePrinted';
  notationType: 'eMensural' | 'eModern';
}
