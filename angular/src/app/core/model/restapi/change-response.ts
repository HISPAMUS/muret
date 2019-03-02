export interface ChangeResponse<T> {
  ok: boolean;
  errorMessage?: string;
  content?: T;
}
