export interface PreflightCkeckRegionResult {
  regionID: number;
  messages: string[];
}

export interface PreflightCkeckImageResult {
  imageID: number;
  imageName: string;
  regionResults: Array<PreflightCkeckRegionResult>;
}

/**
 * @deprecated
 */
export interface PreflightCheckResult {
  preflightCkeckImageResults: Array<PreflightCkeckImageResult>;
}
