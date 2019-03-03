export interface ServerError {
  status: number;
  error: string;
  message?: string;
  path: string;
}
