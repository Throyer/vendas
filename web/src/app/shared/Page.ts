export class Page<T> {

  content: T[];
  last: boolean;
  first: boolean;
  empty: boolean;
  size: number;
  number: number;
  totalPages: number;
  totalElements: number;
  numberOfElements: number;

  constructor({
    content,
    last,
    first,
    empty,
    size,
    number,
    totalPages,
    totalElements,
    numberOfElements }) {
      this.content = content;
      this.last = last;
      this.first = first;
      this.empty = empty;
      this.size = size;
      this.number = number;
      this.totalPages = totalPages;
      this.totalElements = totalElements;
      this.numberOfElements= numberOfElements;
  }
}
