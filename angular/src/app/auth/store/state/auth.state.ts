export interface AuthState {
  isAuthenticated: boolean;
  userID: number | null;
  username: string | null;
  errorMessage: string | null;
  accessToken: string | null;
  roles: string[];
}

export const initialAuthState: AuthState = {
  isAuthenticated: false,
  userID: null,
  username: null,
  errorMessage: null,
  accessToken: null,
  roles: []
};
