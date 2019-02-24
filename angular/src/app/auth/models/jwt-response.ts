export interface JwtResponse {
  userID: number;
  accessToken?: string;
  type?: string;
  username?: string;
  authorities?: string[];
}
