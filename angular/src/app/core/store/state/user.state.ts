import {User} from '../../model/entities/user';

export interface UserState {
  loggedInUser: User;
}

export const initialUserState: UserState = {
  loggedInUser: null
};
