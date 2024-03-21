package agent;

/** Maintains the state of the Environment. */
public class Environment {
  /** Two Tiles making up the Environment. Left Tile is the 0 element and Right is the 1 element. */
  private final Tile[] tiles;

  /** Default constructor for an Environment object. */
  public Environment() {
    tiles = new Tile[2];
    this.tiles[0] = new Tile();
    this.tiles[1] = new Tile();
  }

  /**
   * Update the Tiles with a probability of becoming dirty.
   *
   * @param prob the probability the Tiles will become dirty.
   */
  public void updateTiles(int prob) {
    this.getLeftTile().randSetStatus(prob);
    this.getRightTile().randSetStatus(prob);
  }

  /**
   * Get the left Tile of this Environment.
   *
   * @return the first Tile object.
   */
  public Tile getLeftTile() {
    return this.tiles[0];
  }

  /**
   * Get the right Tile of this Environment.
   *
   * @return the second Tile object.
   */
  public Tile getRightTile() {
    return this.tiles[1];
  }

  /**
   * Determine if this Environment has a dirty Tile.
   *
   * @return true if at least one of the Tiles is dirty, otherwise returns false.
   */
  public boolean hasDirtyTile() {
    return this.getLeftTile().isDirty() || this.getRightTile().isDirty();
  }
}
