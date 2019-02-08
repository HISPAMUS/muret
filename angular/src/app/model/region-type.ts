export class RegionType {
  id: number;
  name: string;
  hexargb: string; // without the #

  constructor(id: number, name: string, hexargb: string) {
    this.id = id;
    this.name = name;
    this.hexargb = hexargb;
  }
}
