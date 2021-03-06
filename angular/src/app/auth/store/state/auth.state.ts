export interface AuthState {
  isAuthenticated: boolean;
  userID: number | null;
  username: string | null;
  errorMessage: string | null;
  accessToken: string | null;
  roles: string[];
  passwordresetmess: number
}

export const initialAuthState: AuthState = {
  isAuthenticated: false,
  userID: null,
  username: null,
  errorMessage: null,
  accessToken: null,
  roles: [],
  passwordresetmess : 0
};
