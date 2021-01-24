# MuRET technical documentation
The front end has been developed using **Angular** with **Redux**. The following diagrams depict the interaction between components and [how the *ngrx store* is managed](../angular/redux.md).

## Model
The following class diagram contains the whole hierarchy, however it's not always fully populated, it depends on the different actions in individual modules.

![Model class diagram](puml/angular/model_class.svg)


## Routing and permissions
The routing mechanism has been used. All elements are grouped into components, each one with its own routing.
Guards are used to prevent unauthorized users from entering restricted pages.

![Guard mechanism sequence diagram](puml/angular/guard_sequence.svg)


## Main AppComponent
The main angular component just takes care of notifying the store when the page has been refreshed to reload session data as a means of not loosing the state of the application.
Everything else is delegated to the `LayoutComponent`.

![AppComponent class diagram](puml/angular/appcomponent_class.svg)
![AppComponent sequence diagram](puml/angular/appcomponent_sequence.svg)


## Authentication

![Authentication sequence](puml/angular/authentication_sequence.svg)


**Hereafter, rather than using sequence diagrams, the following information wil be used in order to summarize the Redux tuples.**

| **Action** | **`AuthService` method** | **API Rest method** | **`AuthState` properties on succes** | **Properties on failure** | 
| --- | ----------- | ----------- | ----------- | ----- | 
| `LogIn(c: Credentials)` | `attemptAuth$(c: Credentials)` | `/auth/login` | `isAuthenticated`, `accessToken`, `userID`,  `username`, `roles`, reset `errorMessage`. <br> It sets `SessionData` with these data| `errorMessage`| 
| `LogOut()` |  |  | Clears `SessionData` | |  
| `GetStatus()` |  |  |  | 
| `Refresh()`: it invokes `RefreshLogged` |  |  |  | 
| `RefreshLogged(s: SessionData)` |  | `isAuthenticated`, `accessToken`, `userID`,  `username`, `roles` are set from `SessionData` if present |  | 
| `ResetPassword(r: ResetPWD)` | `resetPassword$(r: ResetPWD)` | `/users/resetpwd` | `passwordresetmess=0` | `passwordresetmess=1` |
|  |  |  |  |  | 

![Auth store component](puml/angular/auth_store_component.svg)


## Core store
This *Redux* class contains information used along the whole application.

![Authentication sequence](puml/angular/corestore_class.svg)

The ``APIRestServerError`` is used to record the last API rest call error reported by the different services.  

## User store
| ** Action** | **`UserService` method** | **API Rest method** | **`User State` properties** | **Comments** |
| --- | ----------- | ----------- | ----------- | ----- |
| `GetUser(userID: number)` | `getUserProjection$(userID: number)` | `/users/user/excerpt` | `loggedInUser: User` from [IUserProjection](spring.md#projections)  | 
| `GetUsersPermissions()` |`getUsersPermissions$()` | `/users/userPermissions` |  `permissionsData: any` | 
| `GetUsers()` | `getUsersPermissions$()` | `/users/allUsers` | `userList: any` | 
|  |  |  |  |  |

**TODO hacer tipo de dato para permissionsData y userList, que no sean string, any -- hacer también las proyecciones ** 

![User store component](puml/angular/user_store_component.svg)

## LayoutComponent
This component is in charge of displaying the common information of the application: menu bar and status bar.  
The `RouterOutlet` renders the component selected by the active routing module, i.e., the active page.

![LayoutComponent component diagram](puml/angular/layout_component.svg)


The `AvatarComponent` displays the current logged user information. 
`ServerStateComponent` shows server-side information state.

## Home page
After the user logs in and the guard allows to enter as depicted above in diagram in [routing and permissions](#routing-and-permissions)), the following sequence is followed:

![Home sequence](puml/angular/home_sequence.svg)



