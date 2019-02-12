#Services
##SessionDataService
This service contains the data used along the user session, such as the user object itself,
the currently loaded project and the image being processed.

As a rule of thumb, we should avoid having two objects referencing the same tuple in database. 
For example, when a project is retrieved in [ProjectService](#proyectservice), the
lazily loaded project object in [SessionDataService](#sessionDataService) is filled rather
than loading a new one. This helps in mantaining updated all elements in the interface without
creating unnecessary coupling.

##AuthService
It sends the post request to authenticate to _spring_, which, if success, it sets into _SessionDataService_ 
a _User_ object containing the minimum data about the _Projects_ and _Permissions_. 

##RestClientService
This service contains common utilities and data to access the REST API. 

##ProjectService
**TO-DO Describir**

#Components
**TODO: UML class and sequence diagram**

##1. Login
It just delegates to the [AuthService](#authservice) the authentication. When user gets authenticated, 
he/she is moved to the static [StartupComponent](#startupcomponent).    

##2. Startup
It is just a static view with a [NEW](#3-newprojectform) and [OPEN](#4-projects) buttons

##3. NewProjectForm
**TODO**

##4. Projects
By accessing to the user information in [SessionDataService](#sessionDataService),
it shows the projects the user has created and those that can be acccessed with possible 
restricted permissions to the user (**TODO: this is not fully implemented yet**).
When project is opened, the route takes to the [Project](#5-project) view.

##5. Project 
It allows the edition of the composer value, project comments and status.  
A list of [image thumbnail components](#6-imagethumbnail) is shown.  

It loads the project from the [ProjectService](#projectservice) given the *project_id* in the route params.

##6. ImageThumbnail


