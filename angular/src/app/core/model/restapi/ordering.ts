import {NumberPair} from "./number-pair";

export interface Ordering {
  // JSON does not stringfy correctly maps
  //pairs: Map<number, number>; // key = id, value = ordering
  idsSequence: number[] //sequence of ids
}
