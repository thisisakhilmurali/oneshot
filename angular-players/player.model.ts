export class Player {
  public id: number;
  public name: string;
  public description: string;

  constructor(id: number, name: string, desc: string) {
    this.id = id;
    this.name = name;
    this.description = desc;
  }
}
