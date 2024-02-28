### Proposal
- This project is trying to reproduce the classic game Bomberman but with some personal
  features. The game asks players to kill enemyNPCs by placing bombs in a designed map maze.
  The bombs will explode in vertical and horizontal directions after some time and not only can
  destroy boxes but also kill players. The player can pick up props from destroyed boxes to get
  arms such as speeding up. The player will be killed if they get caught up in a bomb's explosion
  (even the bomb is placed by itself) so the player should be cautious of not getting involved in any
  explosion.
  I’d like to create a human player vs AI players mode and explore about strategy design pattern.

### Design
- The final design I use is shown below. I use strategy pattern to separate
elements and their corresponding setters, and set all the elements that could be drawn on the panel.
This also make panel become an intermedia, so classes can borrow methods from other classes
without the need to initiate objects of those classes, instead, the borrowers only need to instantiate
the panel since panel has instances of all classes.
<img src="/Design.png" width="600">


### How to Play
- Use `WASD` to control player’s movement and use `SPACE` to drop
bomb. The enemies will only place bombs when they are intersecting with you, but they have a
larger moving speed, and they can also pick up props. Your goal is to kill all enemies by
placing bombs and avoid being killed by them.
<img src="/MainPage.png" width="600">


