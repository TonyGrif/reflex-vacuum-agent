package agent;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EnvTest {
  private Environment env;

  @BeforeEach
  public void init() {
    env = new Environment();
  }

  @Test
  public void testConstructor() {
    assertFalse(env.getLeftTile().isDirty(), "Error in Tile constructor.");
    assertFalse(env.getRightTile().isDirty(), "Error in Tile constructor.");
    assertFalse(env.hasDirtyTile(), "Error initializing Tiles.");
  }

  @Test
  public void testDirtyCheck() {
    assertFalse(env.hasDirtyTile(), "Error initializing Tiles.");

    env.getRightTile().randSetStatus(100);
    assertTrue(env.hasDirtyTile(), "Error in update probability.");
    env.getLeftTile().randSetStatus(100);
    assertTrue(env.hasDirtyTile(), "Error in update probability.");

    Environment leftEnv = new Environment();
    leftEnv.getLeftTile().randSetStatus(100);
    assertTrue(env.hasDirtyTile(), "Error in update probability.");
  }

  @Test
  public void testUpdate() {
    env.updateTiles(0);
    assertFalse(env.getLeftTile().isDirty(), "Error in update probability.");
    assertFalse(env.getRightTile().isDirty(), "Error in update probability.");

    env.updateTiles(100);
    assertTrue(env.getLeftTile().isDirty(), "Error in update probability.");
    assertTrue(env.getRightTile().isDirty(), "Error in update probability.");
  }
}
