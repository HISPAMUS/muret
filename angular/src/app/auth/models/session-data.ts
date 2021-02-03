import {Role} from "./role";

const KEY = 'ioweuroweihfdsc';

export class SessionData {
  userID: string;
  username: string;
  accessToken: string;
  roles: Role[];


  constructor(userID: string, username: string, accessToken: string, roles: Role[]) {
    this.userID = userID;
    this.username = username;
    this.accessToken = accessToken;
    this.roles = roles;
  }

  public static saveSessionData(data: SessionData) {
    sessionStorage.setItem(KEY, JSON.stringify(data));
  }

  public static loadSessionData(): SessionData {
    const value = sessionStorage.getItem(KEY);
    if (value) {
      return JSON.parse(value);
    } else {
      return null;
    }
  }

  public static clearSessionData() {
    sessionStorage.removeItem(KEY);
  }
}
