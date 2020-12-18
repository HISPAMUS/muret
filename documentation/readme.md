#MuRET technical documentation

## Angular
```puml
@startuml
left to right direction
'top to bottom direction

package "auth" {
    [LoginComponent]
    [ResetPasswordComponent]
}

package "breadcrumb" {
    [BreadcrumbComponent]
}

package "core" {
}

package "Layout" {
    [LayoutComponent]
    indicator )-- [LayoutComponent]
}

@enduml
```

```puml
@startuml
left to right direction
'top to bottom direction
package "Shared" {
[CrudToolbarComponent]
 onDelete -- [CrudToolbarComponent]
 onClear -- [CrudToolbarComponent]
 modeChange -- [CrudToolbarComponent]
 onZoomIn -- [CrudToolbarComponent]
 onZoomOut -- [CrudToolbarComponent]
 onZoomFit -- [CrudToolbarComponent]
 onAddComment -- [CrudToolbarComponent]
 onDeleteAll -- [CrudToolbarComponent]
 
 [StateComponent]
 state )-- [StateComponent]
 
 [AgnosticOrSemanticToolbarComponent]
 filters )-- [AgnosticOrSemanticToolbarComponent]
 filter )-- [AgnosticOrSemanticToolbarComponent]
 svgAgnosticSemanticSymbolSet )-- [AgnosticOrSemanticToolbarComponent]
 mode )-- [AgnosticOrSemanticToolbarComponent]
 frequentSymbols )-- [AgnosticOrSemanticToolbarComponent]
 agnosticOrSemanticSymbolSelected -- [AgnosticOrSemanticToolbarComponent]
 pitchUp -- [AgnosticOrSemanticToolbarComponent]
 pitchDown -- [AgnosticOrSemanticToolbarComponent]
 classifierChanged -- [AgnosticOrSemanticToolbarComponent]
 
 [ConfirmDialogComponent]
 [ConfirmDialogWarningComponent]
 [AlertComponent]
 [InputDialogComponent]
 [LinksModalDialogComponent]
 [OptionsDialogComponent]
 
}
@enduml
```

```puml
@startuml
left to right direction
'top to bottom direction
package "SVG" {
    [ShapeComponent]
    selected )-- [ShapeComponent]
    editing )-- [ShapeComponent]
    shape )-- [ShapeComponent]

    [ShapeComponent] <|-- [LineComponent]   
    appLine )-- [LineComponent]
    
    [ShapeComponent] <|-- [PolylinesComponent]
    appPolylines )-- [PolylinesComponent]
    
    [ShapeComponent] <|-- [RectangleComponent]
    appRectangle )-- [RectangleComponent]
            
    [ShapeComponent] <|-- [TextComponent]
    appText )-- [TextComponent]
   
    [SvgCanvasComponent]
    backgroundImage )-- [SvgCanvasComponent]
    shapes )-- [SvgCanvasComponent]
    zoomFactor )-- [SvgCanvasComponent]
    crop )-- [SvgCanvasComponent]
    nextShapeToAdd )-- [SvgCanvasComponent]
    viewPortHeight )-- [SvgCanvasComponent]
    viewPortWidth )-- [SvgCanvasComponent]
    isAgnostic )-- [SvgCanvasComponent]
    
    
    
}

@enduml
```

```puml
@startuml
left to right direction
'top to bottom direction

package "features" {
    package "about" {
        [AboutComponent]
    }
    package "admin-dashboard" {
        [AdminDashboardComponent]
        [PermissionsComponent]
        [RegisterComponent]
        [RegisterModelComponent]
    }
    package "agnostic-representation" {
        [AgnosticRepresentationComponent]
        [AgnosticStaffComponent]
        regionCropped )-- [AgnosticStaffComponent]
        svgAgnosticSymbolSet )-- [AgnosticStaffComponent]
        modeChange -- [AgnosticStaffComponent]
        commentClicked -- [AgnosticStaffComponent]
        
        [AgnosticToolbarComponent]
        note left of [AgnosticToolbarComponent] : TODO -- merge with AgnosticOrSemanticToolBarComponent
        [AgnosticToolbarIconComponent]
        buttonWidth )-- [AgnosticToolbarIconComponent]
        buttonHeight )-- [AgnosticToolbarIconComponent]
        symbolViewBox )-- [AgnosticToolbarIconComponent]
        symbolPathD )-- [AgnosticToolbarIconComponent]
        symbolTransform )-- [AgnosticToolbarIconComponent]
        symbolID )-- [AgnosticToolbarIconComponent]
        positionInStaff )-- [AgnosticToolbarIconComponent]
        note left of [AgnosticToolbarIconComponent] : TODO -- move to AgnosticOrSemanticToolBarComponent
        
        [ImagePreviewComponent]
        imageID )-- [ImagePreviewComponent]
        selectedRegion -- [ImagePreviewComponent]
    }    
    package "document" {
        [AlignmentPreviewComponent]
        [DocumentComponent]
        [DocumentScoreViewerAndExporterComponent]

        [ImageThumbnailComponent]
        document )-- [ImageThumbnailComponent]
        image )-- [ImageThumbnailComponent]
        usesOfParts )-- [ImageThumbnailComponent]
        documentPath )-- [ImageThumbnailComponent]
                
        [InstrumentsComponent]
        [MEIScoreViewerComponent]
        [UploadImagesComponent]
    }       
    package "document-analysis" {
        [DocumentAnalysisComponent]
        [ImageDocument]
        imageID )-- [ImageDocument]
        shapes )-- [ImageDocument]
        zoomFactor )-- [ImageDocument]
        crop )-- [ImageDocument]
        nextShapeToDraw )-- [ImageDocument]
        isAgnostic )-- [ImageDocument]
        note left of [ImageDocument] : TODO - view relation ImageDocument and ImagePreviewDocument - see wrong line to imageID
        svgShapeCreated -- [ImageDocument]
        svgShapeChanged -- [ImageDocument]
        selectedShapeIDChange -- [ImageDocument]
        modeChange -- [ImageDocument]
        mode )-- [ImageDocument]
        selectedShapeID )-- [ImageDocument]
    }         
    package "documents" {
        [CollectionsComponent]
        [DocumentsComponent]
    }     
    package "export" {
        [TrainingSetsComponent]
    }      
    package "home" {
        [HomeComponent]
    }       
    package "new-document" {
        [NewDocumentComponent]
    }    
    package "parts" {
        [PartSelectionComponent]
        label )-- [PartSelectionComponent]
        parts )-- [PartSelectionComponent]
        clearPart -- [PartSelectionComponent]
        selectPart -- [PartSelectionComponent]
        createPart -- [PartSelectionComponent]
    }  
    
    package "semantic-representation" {
        [NotationComponent]
        notation )-- [NotationComponent]
        
        [SemanticRepresentationComponent]
    }                               
}

@enduml
```


## Spring
