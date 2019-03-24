const KEY = 'ioweuroweihfdsc';

export class SessionData {
  userID: string;
  username: string;
  accessToken: string;
  roles: string[];


  constructor(userID: string, username: string, accessToken: string, roles: string[]) {
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
