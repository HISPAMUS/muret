import {User} from '../../model/entities/user';

export interface UserState {
  loggedInUser: User;
  permissionsData: any;
}

export const initialUserState: UserState = {
  loggedInUser: null,
  permissionsData: null
};
