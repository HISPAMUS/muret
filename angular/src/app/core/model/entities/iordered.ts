export interface IOrdered {
  ordering: number;
}

export function compareOrdering(a: IOrdered, b: IOrdered): number {
  return a.ordering - b.ordering;
}
