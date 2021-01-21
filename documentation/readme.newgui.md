#MuRET technical documentation
*NOTE: see diagram below see the [semantics of some UML diagram element styles used](uml_style.md).*

The front end has been developed using **Angular** with **Redux**. The following diagrams depict the interaction between components and [how the *ngrx store* is managed](../angular/redux.md).
The routing mechanism has been used. All elements are grouped into components, each one with its own routing. 
Guards are used to prevent unauthorized users from entering restricted pages. 

```puml
// ***** GUARD MECHANISM SEQUENCE DIAGRAM ****
@startuml
actor User
participant "/documents/collections" as urlCollections <<URL>>
participant AppRoutingModule

AuthGuardService -\\ Store: select(selectIsAuthenticated) <<async>>
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




