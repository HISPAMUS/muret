export interface JwtResponse {
  userID: number;
  accessToken?: string;
  type?: string;
  username?: string;
  authorities?: string[];
  error: any; // TODO ¿qué contiene? - seguro que al menos el mensaje de error que se llama error
}
