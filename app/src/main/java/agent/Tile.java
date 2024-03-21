package agent;

import java.util.Random;

/** Stores the tile information. */
public class Tile {
  /** Determines if a tile is currently dirty. */
  private boolean dirty;

  /** Used to generate random numbers for setting Tile status. */
  private static final Random RANDOM = new Random();

  /** Default constructor for a Tile. */
  public Tile() {
    this.dirty = false;
  }

  /**
   * Set the dirty status of this Tile based on probability.
   *
   * @param prob The integer probability that this Tile will become dirty. This number is expected
   *     to be between 0 and 100.
   */
  public void randSetStatus(int prob) {
    if (this.isDirty()) {
      return;
    }

    int value = RANDOM.nextInt(100);
    if (prob > value) {
      this.dirty = true;
    }
  }

  /**
   * Get the dirty status of this Tile.
   *
   * @return true if this Tile is dirty, false otherwise.
   */
  public boolean isDirty() {
    return this.dirty;
  }
}
