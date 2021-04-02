import {Component, OnDestroy, OnInit, EventEmitter, Output} from '@angular/core';
import {DialogsService} from "../../../../../../shared/services/dialogs.service";
import {Store} from "@ngrx/store";
import {ImageRecognitionState} from "../../../../store/state/image-recognition.state";
import {Subscription} from "rxjs";
import {Region} from "../../../../../../core/model/entities/region";
import {
  selectImageRecognitionNotation,
  selectImageRecognitionSelectedAgnosticSymbols,
  selectImageRecognitionSelectedNotationSymbol,
  selectImageRecognitionSelectedRegion
} from "../../../../store/selectors/image-recognition.selector";
import {
  ImageRecognitionSelectAgnosticSymbols, ImageRecognitionSelectNotationSymbol,
  ImageRecognitionSendSemanticEncoding
} from "../../../../store/actions/image-recognition.actions";
import {AgnosticSymbol} from "../../../../../../core/model/entities/agnostic-symbol";
import {NgbTooltipConfig} from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: 'app-semantic-kern-mens-grid',
  templateUrl: './semantic-kern-mens-grid.component.html',
  styleUrls: ['./semantic-kern-mens-grid.component.css']
})
export class SemanticKernMensGridComponent implements OnInit, OnDestroy {
  @Output() linkingModeChanged = new EventEmitter<boolean>();

  defaultColDef: { resizable: boolean; editable: boolean };
  rowData = [
  ];

  columnDefs = [
    {headerName: '**smens/**skern', field: 'smens' },
    {headerName: 'Agnostic symbols', field: 'agnosticSymbols' }
  ];

  private gridApi;
  private gridColumnApi;

  private regionSubscription: Subscription;
  private selectedRegion: Region;
  private notationSubscription: Subscription;
  private selectedNotationSymbolSubscription: Subscription;
  private selectedAgnosticSymbolsSubscription: Subscription;
  //agnosticIDs: number[];
  agnosticIDMap: Map<number, number>; // key = agnostic ID, value = usable ID (the one drawn in the agnostic view to identify the object visually)
  agnosticGridRow: Map<number, number>; // key = agnostic ID, value = row in the grid
  private selectedAgnosticSymbols: AgnosticSymbol[];
  linkingMode: boolean = false;

  constructor(private dialogsService: DialogsService, private store: Store<ImageRecognitionState>, public config: NgbTooltipConfig) {
    config.placement = 'left';
    config.triggers = 'hover';

    this.defaultColDef = {
      editable: true,
      resizable: true
    };
  }

  onGridReady(params) {
    this.gridApi = params.api;
    this.gridColumnApi = params.columnApi;
  }

  ngOnInit(): void {
    this.regionSubscription = this.store.select(selectImageRecognitionSelectedRegion).subscribe(next => {
      if (next) {
        this.selectedRegion = next;
        if (this.selectedRegion.semanticEncoding) {
          this.registerAgnosticIDS(next.symbols);
        }
      }
    });

    this.notationSubscription = this.store.select(selectImageRecognitionNotation).subscribe(next => {
      if (this.gridApi) {
        this.gridApi.setRowData([]);
      }
      if (next) {
        this.drawSemanticEncoding(next.semanticEncoding);
      }
    });

    this.selectedNotationSymbolSubscription = this.store.select(selectImageRecognitionSelectedNotationSymbol).subscribe(next => {
      this.onNotationSymbolSelected(next);
    });

    this.selectedAgnosticSymbolsSubscription = this.store.select(selectImageRecognitionSelectedAgnosticSymbols).subscribe(next => {
      //TODO sólo seleccionamos el primero para aplicar modificaciones, guardamos todos para el enlace de ids con el semántico (ver linkSemanticToAgnostic)
      this.selectedAgnosticSymbols = next;
      if (next && next.length > 0 && !this.linkingMode) {
        this.onAgnosticSymbolSelected(next[0].id); //TODO seleccionar varios símbolos
      }
    });
  }


  ngOnDestroy(): void {
    this.regionSubscription.unsubscribe();
    this.selectedNotationSymbolSubscription.unsubscribe();
    this.selectedAgnosticSymbolsSubscription.unsubscribe();
    this.notationSubscription.unsubscribe();
  }

  addRow() {
    const newItem = {
      smens: '!Insert here'
    };

    const selectedNode = this.gridApi.getSelectedNodes();

    const index = selectedNode[0].childIndex;
    const res = this.gridApi.updateRowData({
      add: [newItem],
      addIndex: index + 1 // selectedNode.childIndex
    });

  }

  insertFirstRow() {
    const newItem = {
      smens: '!Insert here'
    };

    const res = this.gridApi.updateRowData({
      add: [newItem],
      addIndex: 0
    });

  }

  removeSelectedRow() {
    const selectedData = this.gridApi.getSelectedRows();
    const res = this.gridApi.updateRowData({ remove: selectedData });
    this.sendSemanticEncoding();
  }


  /**
   * Converts 2,3 to 30404,304123
   * (i.e. the 'usable' ids to the actual ones
   */
  /*private convertToSymbolIDS(agnosticSymbols: string) {
    if (agnosticSymbols) {
      let result: string = null;
      const usableIDS: string [] = agnosticSymbols.split(',');
      usableIDS.forEach(id => {
        if (result) {
          result = result + ',' + this.agnosticIDs[id];
        } else {
          result = this.agnosticIDs[id];
        }
      });
      return result;
    } else {
      return null;
    }
  }*/

  /**
   * It builds the semantic encoding from the grid. It replaces the 'usable' id for the actual one
   */
  private getSemanticEncoding() {
    let result = '';
    this.gridApi.forEachNode(node => {
      if (node.data.agnosticSymbols) {
        //result += (node.data.smens + '@' + this.convertToSymbolIDS(node.data.agnosticSymbols) + '\n');
        result += (node.data.smens + '@' + node.data.agnosticSymbols.split(',') + '\n');
      } else {
        result += (node.data.smens + '\n');
      }
    });
    // console.log(result);
    return result;
  }

  sendSemanticEncoding() {
    this.store.dispatch(new ImageRecognitionSendSemanticEncoding(this.selectedRegion, this.getSemanticEncoding(), false, 'verovio')); // TODO
  }


  clearSemanticEncoding() {
    this.dialogsService.showConfirmation('Clear semantic encoding?', 'This action cannot be undone')
      .subscribe((isConfirmed) => {
        if (isConfirmed) {
          this.store.dispatch(new ImageRecognitionSendSemanticEncoding(this.selectedRegion, '', false, 'verovio'));
        }
      });
  }

  private findAgnosticID(agnosticSymbolIDs: string) {
    let result: string;
    if (agnosticSymbolIDs && this.agnosticIDMap) {
      const IDS: string[] = agnosticSymbolIDs.split(',');
      IDS.forEach(id => {
        const simpleID = this.agnosticIDMap.get(Number(id));
        if (result) {
          result = result + ',' + simpleID;
        } else {
          result = '' + simpleID;
        }
      });
    }

    return result;

  }

  private drawSemanticEncoding(semanticEncoding: string) {
    this.agnosticGridRow = new Map<number, number>();
    const newItems = [];
    const lines = semanticEncoding.split('\n');
    let rowNumber = 0;
    lines.forEach(line => {
      if (line.length > 0) {
        const columns = line.split('@');
        const agnosticIDS = columns[1];
        newItems.push({
          smens: columns[0],
          agnosticSymbols: agnosticIDS, // this.findAgnosticID(agnosticIDS) // replaces the actual symbol ID for a more usable one
        });

        if (agnosticIDS) {
          const IDS: string[] = agnosticIDS.split(',');
          IDS.forEach(id => {
            this.agnosticGridRow.set(+id, rowNumber);
          });
        }
        rowNumber++;
      }
    });
    if (this.gridApi) {
      this.gridApi.setRowData(newItems);
    }
  }

  private registerAgnosticIDS(next: AgnosticSymbol[]) {
    //this.agnosticIDs = new Array();
    this.agnosticIDMap = new Map<number, number>();
    let cont = 0;
    if (next) {
      next.forEach(value => {
        //this.agnosticIDs.push(value.id);
        this.agnosticIDMap.set(value.id, cont);
        cont++;
      });
    }
  }
  onCellValueChanged($event: any) {
    this.sendSemanticEncoding();
  }

  //TODO The selectionManager behaviour should be refactored to another object
  // The notation component takes the selected element from the binded this.selectedSemanticSymbolID
  // The **skern / **smens grid / matrix is selected using the selectGridRow method
  // In orderEntities to select the agnostic element, the this.selectedAgnosticSymbolID field is used, but the

  onGridRowSelected($event: any) {
    this.linkingMode = false;
    this.onLinkingModeChanged(false);
    if ($event && $event.node.selected) {
      this.store.dispatch(new ImageRecognitionSelectNotationSymbol('L' + $event.rowIndex));
      this.selectAgnosticSymbolRelatedToLine($event.rowIndex);
    }
  }

  onNotationSymbolSelected(notationSymbolID: string) {
    if (this.gridApi) {
      if (notationSymbolID) {
        const selectedLine = notationSymbolID.substr(1);
        this.selectGridRow(+selectedLine);
      } else {
        this.clearGridSelection();
      }
    }
  }

  onAgnosticSymbolSelected(agnosticID: number) {
    if (agnosticID && this.agnosticGridRow) {
      const line = this.agnosticGridRow.get(agnosticID);
      if (line) {
        // this way the grid and the semantic notation are selected
        this.store.dispatch(new ImageRecognitionSelectNotationSymbol('L' + line));
        // this.selectGridRow(line);
      } else {
        // deselect
        this.store.dispatch(new ImageRecognitionSelectNotationSymbol(null));
      }
    }
  }

  private clearGridSelection() {
    this.gridApi.deselectAll();
  }

  private selectGridRow(selectedLine: number) {
    if (this.gridApi) {
      const rowNode = this.gridApi.getRowNode(selectedLine);
      if (rowNode) {
        rowNode.setSelected(true);
      }
    }

  }

  private selectAgnosticSymbolRelatedToLine(rowIndex: number) {
    let symbolSelected: boolean = false;
    this.agnosticGridRow.forEach((rowNumber, agnosticID) => {
      if (rowIndex === rowNumber) {
        const selectedAgnosticSymbol = this.selectedRegion.symbols.find(symbol => symbol.id == +agnosticID);
        if (selectedAgnosticSymbol) {
          symbolSelected = true;
          this.store.dispatch(new ImageRecognitionSelectAgnosticSymbols([selectedAgnosticSymbol]))
        } else {
          throw new Error('Agnostic ID not found: ' + agnosticID);
        }
        return;
      }
    });
    if (!symbolSelected) {
      // deselect
      this.store.dispatch(new ImageRecognitionSelectAgnosticSymbols([]));
    }
  }

  linkSemanticToAgnostic() {
    const selectedNodes = this.gridApi.getSelectedNodes();
    if (selectedNodes && this.selectedAgnosticSymbols) {
      const agnosticIDS: string = this.selectedAgnosticSymbols.map(value => value.id).join(',');
      if (agnosticIDS !== selectedNodes[0].data.agnosticSymbols) {
        selectedNodes[0].data.agnosticSymbols = agnosticIDS;
        this.sendSemanticEncoding();
      }
    }
  }

  unlinkSemanticToAgnostic() {
    const selectedNodes = this.gridApi.getSelectedNodes();
    if (selectedNodes && this.selectedAgnosticSymbols) {
      selectedNodes[0].data.agnosticSymbols = null;
      this.sendSemanticEncoding();
    }
  }

  hasAgnosticSymbolsSelected() {
    return this.selectedAgnosticSymbols && this.selectedAgnosticSymbols.length > 0;
  }

  onLinkingModeChanged(newMode: boolean) {
    if (this.linkingMode != newMode) {
      this.linkingMode = newMode;
      if (!this.linkingMode) {
        this.linkSemanticToAgnostic();
      }
      this.emitLinkingModeChange();
    }
  }

  hasRowSelected() {
    if (this.gridApi) {
      const selectedNodes = this.gridApi.getSelectedNodes();
      return selectedNodes && selectedNodes.length > 0;
    } else {
      return false;
    }
  }

  private emitLinkingModeChange() {
    this.linkingModeChanged.emit(this.linkingMode);
  }
}
