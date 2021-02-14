package es.ua.dlsi.grfia.im3ws.muret.controller;

import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.grfia.im3ws.configuration.MURETConfiguration;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.alignmentPreview.*;
import es.ua.dlsi.grfia.im3ws.muret.entity.*;
import es.ua.dlsi.grfia.im3ws.muret.model.NotationModel;
import es.ua.dlsi.grfia.im3ws.muret.repository.*;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.score.*;
import es.ua.dlsi.im3.omr.encoding.semantic.SemanticEncoding;
import es.ua.dlsi.im3.omr.encoding.semantic.SemanticSymbol;
import es.ua.dlsi.im3.omr.encoding.semantic.SemanticSymbolType;
import es.ua.dlsi.im3.omr.encoding.semantic.semanticsymbols.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

// !!! Important: no controller should throw any exception

//TODO This reaches the region level, we are not supporting yet the assignment of individual symbols to different parts
/**
 * @author drizo
 */
@RequestMapping("alignment")
@RestController
public class AlignmentController extends MuRETBaseController {
    private final DocumentRepository documentRepository;
    private final NotationModel notationModel;

    public AlignmentController(MURETConfiguration muretConfiguration, DocumentRepository documentRepository, ImageRepository imageRepository, PageRepository pageRepository, RegionRepository regionRepository, SymbolRepository symbolRepository) {
        super(muretConfiguration, imageRepository, pageRepository, regionRepository, symbolRepository);
        this.documentRepository = documentRepository;
        this.notationModel = new NotationModel();
    }

    @GetMapping(path={"preview/{documentID}"})
    @Transactional
    public AlignmentPreview getAlignmentPreview(@PathVariable("documentID") Integer documentID) {
        try {
            Optional<Document> documentOptional = documentRepository.findById(documentID);
            if (!documentOptional.isPresent()) {
                throw new IM3WSException("Cannot find a document with ID " + documentID);
            }

            try {
                return constructAlignmentPreview(documentOptional.get());
            } catch (IM3Exception e) {
                throw new IM3WSException(e);
            }
        } catch (Throwable e) {
            throw ControllerUtils.createServerError(this, "Cannot export", e);

        }
    }

    private AlignmentPreview constructAlignmentPreview(Document document) throws IM3WSException, IM3Exception {
        AlignmentPreview alignmentPreview = new AlignmentPreview();
        HashMap<Long, AlignmentPreviewPart> alignmentPreviewPartHashMap = new HashMap<>(); // key = part id

        if (document.getParts() == null) {
            AlignmentPreviewProblem problem = new AlignmentPreviewProblem();
            problem.setProblem("Current document has not any part created yet");
            alignmentPreview.add(problem);
        } else {
            for (Part part : document.getParts()) {
                AlignmentPreviewPart alignmentPreviewPart = new AlignmentPreviewPart();
                alignmentPreview.add(alignmentPreviewPart);
                alignmentPreviewPart.setId(part.getId());
                alignmentPreviewPart.setName(part.getName());

                alignmentPreviewPartHashMap.put(part.getId(), alignmentPreviewPart);
            }

            for (Image image : document.getImages()) {
                AlignmentPreviewImage alignmentPreviewImage = new AlignmentPreviewImage();
                alignmentPreviewImage.setId(image.getId());
                alignmentPreviewImage.setFilename(image.getFilename());
                alignmentPreview.add(alignmentPreviewImage);

                AlignmentPreviewPart imagePart = null;
                if (image.getPart() != null) {
                    imagePart = alignmentPreviewPartHashMap.get(image.getPart().getId());
                    if (imagePart == null) {
                        throw new IM3WSException("The part with id #" + image.getPart().getId() + " should be already inserted");
                    }
                }

                int nPage = 0;
                for (Page page : image.getSortedPages()) {
                    nPage++; // first is #1

                    int nStaff = 0;
                    for (Region region : page.getSortedStaves()) {
                        nStaff++; // first is #1
                        AlignmentPreviewPart regionPart = imagePart;
                        if (region.getPart() != null) {
                            regionPart = alignmentPreviewPartHashMap.get(region.getPart().getId());
                            if (regionPart == null) {
                                throw new IM3WSException("The part with id #" + region.getPart().getId() + " should be already inserted");
                            }
                        }
                        if (regionPart == null) {
                            AlignmentPreviewProblem alignmentPreviewProblem = new AlignmentPreviewProblem();
                            alignmentPreviewProblem.setImageID(image.getId());
                            alignmentPreviewProblem.setRegionID(region.getId());
                            alignmentPreviewProblem.setProblem("Neither the region or the image has a linked part");
                            alignmentPreview.add(alignmentPreviewProblem);
                        } else {
                            AlignmentPreviewStaff alignmentPreviewStaff = new AlignmentPreviewStaff();
                            regionPart.add(alignmentPreviewStaff);
                            fillAlignmentPreviewStaff(alignmentPreview, alignmentPreviewStaff, document, region, image.getId(), nPage, nStaff);
                        }
                    }
                }


            }
        }
        return alignmentPreview;
    }

    private void fillAlignmentPreviewStaff(AlignmentPreview alignmentPreview, AlignmentPreviewStaff alignmentPreviewStaff, Document document, Region region, long imageID, int pageNumber, int staffOrder) throws IM3Exception {
        alignmentPreviewStaff.setId(region.getId());
        alignmentPreviewStaff.setPageNumber(pageNumber);
        alignmentPreviewStaff.setOrder(staffOrder);
        alignmentPreviewStaff.setBoundingBox(region.getBoundingBox());
        alignmentPreviewStaff.setImageID(imageID);

        fillStaffContents(alignmentPreview, document, region, alignmentPreviewStaff);
    }

    private void fillAlignmentPreviewDurItem(AtomFigure atomFigure, AlignmentPreviewItemWithDuration item) {
        item.setDuration(atomFigure.getDuration().getComputedTime());
        item.setFigures(atomFigure.getFigure());
        item.setDots(atomFigure.getDots());
    }

    private void fillAlignmentPreviewNote(ScientificPitch pitch, AlignmentPreviewPitch item) {
        item.setMidiPitch(pitch.computeMidiPitch());
    }


    private void fillStaffContents(AlignmentPreview alignmentPreview, Document document, Region region, AlignmentPreviewStaff alignmentPreviewStaff) {
        try {
            SemanticEncoding semanticEncoding = notationModel.importSemanticEncoding(document, region);

            double lastStaffTime = 0;
            for (SemanticSymbol symbol : semanticEncoding.getSymbols()) {
                SemanticSymbolType semanticSymbolType = symbol.getSymbol();
                AlignmentPreviewItem previewItem = null;
                double duration = 0;
                //TODO fermata
                if (semanticSymbolType instanceof SemanticNote) {
                    previewItem = new AlignmentPreviewPitch();
                    fillAlignmentPreviewDurItem((((SemanticNote) semanticSymbolType).getCoreSymbol()).getAtomFigure(), (AlignmentPreviewItemWithDuration) previewItem);
                    fillAlignmentPreviewNote((((SemanticNote) semanticSymbolType).getCoreSymbol()).getPitch(), (AlignmentPreviewPitch) previewItem);

                    previewItem.setType(AlignmentPreviewItemType.note);
                    duration = ((AlignmentPreviewPitch) previewItem).getDuration();
                } else if (semanticSymbolType instanceof SemanticRest) {
                    previewItem = new AlignmentPreviewItemWithDuration();
                    fillAlignmentPreviewDurItem((((SemanticRest) semanticSymbolType).getCoreSymbol()).getAtomFigure(), (AlignmentPreviewItemWithDuration) previewItem);

                    previewItem.setType(AlignmentPreviewItemType.rest);
                    duration = ((AlignmentPreviewItemWithDuration) previewItem).getDuration();
                } else if (semanticSymbolType instanceof SemanticLigature) {
                    for (Atom atom : ((SemanticLigature) semanticSymbolType).getCoreSymbol().getAtoms()) {
                        AlignmentPreviewPitch ligaturePreviewNote = new AlignmentPreviewPitch();
                        ligaturePreviewNote.setType(AlignmentPreviewItemType.note);
                        if (atom instanceof SimpleNote) {
                            fillAlignmentPreviewDurItem(((SimpleNote)atom).getAtomFigure(),ligaturePreviewNote);
                            fillAlignmentPreviewNote(((SimpleNote)atom).getPitch(), ligaturePreviewNote);
                            duration = atom.getDuration().getComputedTime();
                            ligaturePreviewNote.setTime(lastStaffTime);
                            lastStaffTime += duration;
                            alignmentPreviewStaff.add(ligaturePreviewNote);
                        } else {
                            throw new IM3WSException("Unsupported other thing than notes in a ligature, and found " + atom.getClass().getName());
                        }
                    }
                } else if (semanticSymbolType instanceof SemanticKeySignature) {
                    previewItem = new AlignmentPreviewItem();
                    previewItem.setDescription(semanticSymbolType.toKernSemanticString());
                    previewItem.setType(AlignmentPreviewItemType.keyChange);
                } else if (semanticSymbolType instanceof SemanticBarline) {
                    previewItem = new AlignmentPreviewItem();
                    previewItem.setType(AlignmentPreviewItemType.barline);
                } else if (semanticSymbolType instanceof SemanticTimeSignature) {
                    previewItem = new AlignmenPreviewTimeSignature();
                    previewItem.setDescription(semanticSymbolType.toKernSemanticString());
                    TimeSignature ts = (TimeSignature) ((SemanticTimeSignature)semanticSymbolType).getCoreSymbol();
                    fillPreviewItemTimeSignature(ts, (AlignmenPreviewTimeSignature) previewItem, semanticSymbolType);
                    previewItem.setType(AlignmentPreviewItemType.timeSignatureChange);
                }  // else clefs... not used

                if (previewItem != null) {
                    previewItem.setTime(lastStaffTime);
                    lastStaffTime += duration;
                    alignmentPreviewStaff.add(previewItem);
                }
            }

        } catch (Exception e) {
            AlignmentPreviewProblem problem = new AlignmentPreviewProblem();
            problem.setImageID(region.getPage().getImage().getId());
            problem.setRegionID(region.getId());
            problem.setProblem(e.getMessage());
            alignmentPreview.add(problem);

            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Cannot generate the alignment preview for region " + region.getId(), e);
        }
    }

    private void fillPreviewItemTimeSignature(TimeSignature ts, AlignmenPreviewTimeSignature item, SemanticSymbolType semanticSymbolType) {
        item.setMeasureDuration(ts.getDuration().getComputedTime());
    }

}
