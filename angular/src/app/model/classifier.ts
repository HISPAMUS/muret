export class Classifier {
  id: number;
  value: string;
  description: string;

  constructor(id: number, value: string, description: string) {
    this.id = id;
    this.value = value;
    this.description = description;
  }
}
