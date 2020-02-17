export interface APIRestServerError {
  status?: number;
  message?: string;
  detailedMessage?: string;
  url?: string;
  /**
   * used to trace the call that generated the error
   */
  caller?: any;
}
