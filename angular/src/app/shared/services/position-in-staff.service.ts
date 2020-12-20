import { Injectable } from '@angular/core';

@Injectable()
/**
 * Utilities for converting from/to position in staff and staff positions
 */
export class PositionInStaffService {

  constructor() {
  }

  public positionInStaffToLineSpace(positionInStaff: string): number {
    const value = Number(positionInStaff.substr(1));
    if (positionInStaff.charAt(0) === 'L') {
      return (value - 1) * 2;
    } else if (positionInStaff.charAt(0) === 'S') {
      return (value) * 2 - 1;
    } else {
      throw new Error('Invalid positionInStaff, it should start with L or S: ' + positionInStaff);
    }
  }

  public movePitch(positionInStaff: string, displacement: number): string {
    const lineSpace = this.positionInStaffToLineSpace(positionInStaff);
    return this.lineSpaceToPositionInStaff(lineSpace + displacement);
  }


  public lineSpaceToPositionInStaff(lineSpace: number): string {
    if (lineSpace % 2 === 0) {
      return 'L' + (lineSpace / 2 + 1);
    } else {
      return 'S' + ((lineSpace - 1 ) / 2 + 1);
    }
  }
}
