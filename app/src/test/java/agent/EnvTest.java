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
    assertFalse(env.getLeftTile().isDirty(), "Error in Tile constructor");
    assertFalse(env.getRightTile().isDirty(), "Error in Tile constructor");
    assertFalse(env.hasDirtyTile(), "Error initializing Tiles.");
  }
}
