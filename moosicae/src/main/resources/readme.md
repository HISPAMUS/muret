** IM4 Design principles

The object oriented design patterns have been used when possible and if not adapted.

--- TODO
A score is a collection of parts. A part is a collection of voices.
All usual elements such as notes or clefs belong to a voice. 

The score contains also a collection of staves (or staff groups).
An element such as a note knows the staff to which it belongs, but the staff has not a collection of notes.
The clef knows the staff where it is located, but the staff does not contain a list of clefs.

When required, an iterator that browses any collection and filters what it needs is built. In IM3, we had everything
in two collections (one for the staff, the other for the voice), but it was too expensive to maintain.

Everything has been modeled as interfaces to keep the client model close to variation. 
The collections are returned as arrays in order to encapsulate the implemented collection and
avoid changing the collection from outside the class.
--- END TODO 
* Import / export
We are using a slightly version of the visitor pattern to include the context and the output type. 
This pattern forces the exporters to include a method for each new type.

