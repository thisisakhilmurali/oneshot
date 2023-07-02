import { Player } from './player.model';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable()
export class PlayerService {
  playersChanged = new Subject<Player[]>();
  count: number = 7;
  private players: Player[] = [
    new Player(1, 'M S Dhoni', 'Wicket Keeper'),
    new Player(2, 'Virat Kohli', 'Batsman'),
    new Player(3, 'Jasprit Bumrah', 'Bowler'),
    new Player(4, 'Rohit Sharma', 'Batsman'),
    new Player(5, 'Rishabh Pant', 'Wicket Keeper'),
    new Player(6, 'T. Natarajan', 'Bowler'),
    new Player(7, 'R Ashwin', 'Bowler'),
  ];

  getPlayers() {
    return this.players.slice();
  }

  generateID() {
    this.count = this.count + 1;
    return this.count;
  }


  /* 
    Returns the player for a given player id
  */
  getPlayer(id: number) {
     return this.players.find(player => player.id === id);
  }

  /* 
    Adds the player to player list
  */
  addPlayer(player: Player) {
    player.id = this.generateID();
    this.players.push(player);
  }

  /* 
    Updates the player given the index and new changed values
  */
  updatePlayer(index: number, newPlayer: Player) {
    let player = this.players.findIndex(player => player.id === index);
    
    this.players[player].name = newPlayer.name;
    this.players[player].description = newPlayer.description;

  }

  /*
    Deletes a player from player list
  */
  deletePlayer(index: number) {
    const player = this.players.findIndex(player => player.id === index);
    this.players.splice(player, 1);
  }
}