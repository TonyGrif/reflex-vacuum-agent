package agent;

public class Environment {
  /** Two Tiles making up the Environment. Left Tile is the 0 element and Right is the 1 element. */
  private Tile[] tiles;

  /** Default constructor for an Environment object. */
  public Environment() {
    tiles = new Tile[2];
    this.tiles[0] = new Tile();
    this.tiles[1] = new Tile();
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
