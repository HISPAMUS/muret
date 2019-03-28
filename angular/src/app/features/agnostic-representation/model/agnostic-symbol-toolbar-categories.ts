import {AgnosticSymbolToolbarCategory} from './agnostic-symbol-toolbar-category';

/**
 * @deprecated
 */

export const AGNOSTIC_SYMBOL_TOOLBAR_CATEGORIES: Map<string, AgnosticSymbolToolbarCategory[]> =
  new Map(
    [
      ['eMensural',
        [{name: 'Frequent notes', agnosticSymbolTypes: [
            'note.doubleWhole',
            'note.longa_down',
            'note.longa_up',
            'note.longaBlack_down',
            'note.longaBlack_up',
            'note.breve',
            'note.breveBlack',
            'note.whole',
            'note.wholeBlack',
            'note.half_down',
            'note.half_up',
            'note.quarter_down',
            'note.quarter_up',
            'note.eighthVoid_down',
            'note.eighthVoid_up',
            'note.eighth_down',
            'note.eighth_up',
            'note.eighthCut_down',
            'note.eighthCut_up'
          ]},
          {name: 'Unfrequent notes', agnosticSymbolTypes: [
              'note.quadrupleWholeStem_down',
              'note.quadrupleWholeStem_up',
              'note.tripleWholeStem_down',
              'note.tripleWholeStem_up',
              'note.doubleWholeStem_down',
              'note.doubleWholeStem_up',
              'note.doubleWholeBlackStem_down',
              'note.doubleWholeBlackStem_up',
              'note.sixteenthVoid_down',
              'note.sixteenthVoid_up',
              'note.sixteenth_down',
              'note.sixteenth_up'
            ]},
        {name: 'Beamed notes', agnosticSymbolTypes: [
            'note.beamedRight1_down',
            'note.beamedBoth1_down',
            'note.beamedLeft1_down',
            'note.beamedRight1_up',
            'note.beamedBoth1_up',
            'note.beamedLeft1_up',
            'note.beamedRight2_down',
            'note.beamedBoth2_down',
            'note.beamedLeft2_down',
            'note.beamedRight2_up',
            'note.beamedBoth2_up',
            'note.beamedLeft2_up'
          ]},
        {name: 'Rests', agnosticSymbolTypes: [
            'rest.longa3',
            'rest.longa2',
            'rest.breve',
            'rest.whole',
            'rest.half',
            'rest.seminima',
            'rest.fusa',
            'rest.semifusa'
          ]},
        {name: 'Clefs', agnosticSymbolTypes: [
            'clef.G',
            'clef.C',
            'clef.F',
            'clef.Fpetrucci',
          ]},
        {name: 'Time Signatures', agnosticSymbolTypes: [
            'metersign.C',
            'metersign.CZ',
            'metersign.Ccut',
            'metersign.CcutZ',
            'metersign.Cdot',
            'metersign.O',
            'metersign.Odot'
          ]},
        {name: 'Accidentals', agnosticSymbolTypes: ['accidental.flat', 'accidental.natural', 'accidental.sharp']},
        {name: 'Other', agnosticSymbolTypes: [
            'dot',
            'custos',
            'verticalLine',
            'fermata.above',
            'fermata.below',
            'slur.end',
            'slur.start',
            'ligature',
            'signumCongruentiae',
            'smudge',
            'colon',
            'inkBlot',
          ]},
        ]
      ]]
  );
