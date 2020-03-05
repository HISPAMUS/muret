** IM4 Design principles

The object oriented design patterns have been used when possible and if not adapted.

A score is a collection of parts. A part is a collection of voices.
All usual elements such as notes or clefs belong to a voice. 

The score contains also a collection of staves (or staff groups), decomposed into layers.
An element such as a note know the layer to which it belongs, but the layer has not a collection of notes.
The clef knows the staff where it is located, but the staff does not contain a list of clefs.

When required, an iterator that browses any collection and filters what it needs is built. In IM3, we had everything
in two collections (one for the layer, the other for the voice), but it was too expensive to maintain.


* Import / export
We are using a slightly version of the visitor pattern to include the context and the output type. 
This pattern forces the exporters to include a method for each new type.

