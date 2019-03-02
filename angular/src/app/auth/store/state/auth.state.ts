export interface AuthState {
  isAuthenticated: boolean;
  userID: number | null;
  errorMessage: string | null;
  accessToken: string | null;
  roles: string[];
}

export const initialAuthState: AuthState = {
  isAuthenticated: false,
  userID: null,
  errorMessage: null,
  accessToken: null,
  roles: []
};
