package agent;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TileTest {
  private Tile tile;

  @BeforeEach
  public void init() {
    tile = new Tile();
  }

  @Test
  public void testConstructor() {
    assertFalse(tile.getStatus(), "Tile status improperly set.");
  }

  @Test
  public void testSetRandStatus() {
    tile.randSetStatus(0);
    assertFalse(tile.getStatus(), "Incorrect random function, zero probability change.");

    tile.randSetStatus(100);
    assertTrue(tile.getStatus(), "Incorrect random function, 100 probability no change.");

    tile.randSetStatus(0);
    assertTrue(tile.getStatus(), "Value should not change if already dirty.");
  }
}
