import {User} from '../../model/entities/user';

export interface UserState {
  loggedInUser: User;
  permissionsData: any;
  userList: string[];
}

export const initialUserState: UserState = {
  loggedInUser: null,
  permissionsData: null,
  userList: null
};
