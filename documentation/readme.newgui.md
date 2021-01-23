#MuRET technical documentation
*NOTE: see diagram below see the [semantics of some UML diagram element styles used](uml_style.md).*

The front end has been developed using **Angular** with **Redux**. The following diagrams depict the interaction between components and [how the *ngrx store* is managed](../angular/redux.md).

## Routing and permissions
The routing mechanism has been used. All elements are grouped into components, each one with its own routing.
Guards are used to prevent unauthorized users from entering restricted pages.

```puml
// ***** GUARD MECHANISM SEQUENCE DIAGRAM ****
@startuml
actor User
participant "/documents/collections" as urlCollections <<URL>>
participant AppRoutingModule

AuthGuardService -\\ Store: select(selectIsAuthenticated) <<async subscription>>
note right: This ngrx select will be invoked each time \n the store changes its value
Store -> AuthState: isAuthenticated
return
Store -\\ AuthGuardService
AuthGuardService --> AuthGuardService: setIsAuthenticated
 
User -> urlCollections: Go to any page in MuRET
urlCollections -> AppRoutingModule: search route starting with "documents"
AppRoutingModule -> AuthGuardService: canActivate
return

alt User has permissions
    AppRoutingModule --> DocumentsModule: <<forward request>>
    DocumentsModule --> DocumentsRoutingModule: search route /collections
    return
    control CollectionsComponent
    DocumentsModule --> CollectionsComponent
else User has not permissions
    control LoginComponent
    AppRoutingModule --> LoginComponent
end
@enduml
```

## Main AppComponent
The main angular component just takes care of notifying the store when the page has been refreshed to reload session data as a means of not loosing the state of the application.
Everything else is delegated to the `LayoutComponent`.
```puml
@startuml
[AppComponent] *-> [LayoutComponent]
[AppComponent] *--> Router
[AppComponent] *--> Store
@enduml
```

```puml
@startuml
AppComponent -\\ Router: subscribe() <<async subscription>>
Router -\\ AppComponent: refresh event
create Refresh
AppComponent -> Refresh
return r
AppComponent -> Store: dispatch(r)
note right: This will reload session data into the store
@enduml
```


## Model
The following class diagram contains the whole hierarchy, however it's not always fully populated, it depends on the different actions in individual modules.

```puml
@startuml


entity Entity {
    id: number
}
note top of Entity : To minimize the number of lines in the diagram\nall classes deriving Entity are drawn with an E inside a circle as this class Entity

class User {
    username: string
}

entity Document {
  name: string
  path: string
  thumbnailBase64Encoding: string
  comments: string
  imagesOrdering: string
  notationType: string
  manuscriptType: string
  composer: string
}
entity Collection {
  name[0..1]: string
  comments[0..1]: string
  parentId[0..1]: number
  thumbnailBase64Encoding[0..1]: string
}

entity Image {
  documentId: number
  filename: string
}


entity Page {
}


entity Part {
  name: string
  comments[0..1]: string
}

entity Region {
  notationType[0..1]: string 
}

note right of Region::notationType
  When it's different from the document notation type
end note


class BoundingBox {
  id [0..1]: number 
  fromX: number
  fromY: number
  toX: number
  toY: number    
}


entity AgnosticSymbol {
  positionInStaff: string
  agnosticSymbolType: string
  approximateX[0..1]: number;
  comments[0..1]: string
}

class Strokes {
}

class Point {
  time: number
  x: number
  y: number
}

entity RegionType {
  name: string
  hexargb: string
  help: string
}

entity RegionInteractionType {
    name: string
}

class Permissions {
    permission: string
}


enum EnumState {
    doublechecked
    done
    inprogress
} 
class State {
  comments: string
}


Document *--> "*" Image
Document *--> "*" Part
Document *-> "*" State
Collection *-- "*" Document
Collection *--> "*" Collection: "subcollections"

Image *-> "*" Page
Image *--> "*" State
Image -> Part 

note right of BoundingBox::id
  We may associate to a symbol, region or page
end note


Page *--> "0..1" BoundingBox
Page "0..1" *- "*" Region
Page --> "0..1" Part 

Region *--> "0..1" BoundingBox
Region *--> "*" AgnosticSymbol
Region *-> "0..1" RegionType

AgnosticSymbol *--> "0..1" BoundingBox
AgnosticSymbol *--> "0..1" Strokes
AgnosticSymbol *--> "0..1" Part


Strokes *-> "*" Stroke: strokeList
Stroke *-> "*" Point: points


RegionType --> "0..1" RegionInteractionType


Permissions -> Collection

State *--> EnumState

User --> "*" Document
User --> "*" Permissions

@enduml
```



## CoreState
This *Redux* class contains information used along the whole application. 

**TODO Decir qué se rellena de la jerarquía en cada llamada**

```puml
@startuml


class UserState {
  permissionsData: any
  userList: string[]
}

class ServerStatusState {
    status: string
}

class APIRestServerError {
  status[0..1]: number
  message[0..1]: string
  detailedMessage[0..1]: string
  url[0..1]: string
  caller[0..1]: any
} 

CoreState *-> "0..1" RouterReducerState
CoreState *--> UserState
CoreState *--> ServerStatusState
CoreState *--> FontsState

UserState *--> User: loggedInUser

FontsState *--> SVGSet: "svgAgnosticOrSemanticSymbolsSet"
FontsState *--> APIRestServerError

@enduml
```



## LayoutComponent
This component is in charge of displaying the common information of the application: menu bar and status bar.  
The `RouterOutlet` renders the component selected by the active routing module, i.e., the active page.

```puml
@startuml
[LayoutComponent] *-> [ServerStateComponent]
[LayoutComponent] *--> [AvatarComponent]
[LayoutComponent] *--> [RouterOutlet]
@enduml
```
The `AvatarComponent` displays the current logged user information. 
`ServerStateComponent` shows server-side information state.

## Home page
After the user logs in and the guard allows to enter as depicted above in diagram in [routing and permissions](#routing-and-permissions)), the following sequence is followed:

```puml
@startuml
actor User
participant "/" as urlRoot <<URL>>
participant AppRoutingModule 
participant DocumentsRoutingModule
 
User -> urlRoot: Go to home page 
urlRoot -> AppRoutingModule: search route "/"
AppRoutingModule --> DocumentsRoutingModule: <<forward request>> 
note right: The AuthGuard allows the login
DocumentsRoutingModule --> HomeModule
control HomeComponent
HomeModule --> HomeComponent
@enduml
```


