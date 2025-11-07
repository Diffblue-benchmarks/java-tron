package org.tron.common.zksnark;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.tron.core.exception.ZksnarkException;

public class MerklePathDiffblueTest {
  /**
   * Method under test: {@link MerklePath#encode()}
   */
  @Test
  public void testEncode() throws ZksnarkException {
    // Arrange
    ArrayList<List<Boolean>> authenticationPath = new ArrayList<>();

    // Act and Assert
    assertArrayEquals(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0},
        (new MerklePath(authenticationPath, new ArrayList<>())).encode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MerklePath#MerklePath(List, List)}
   *   <li>{@link MerklePath#getAuthenticationPath()}
   *   <li>{@link MerklePath#getIndex()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    ArrayList<List<Boolean>> authenticationPath = new ArrayList<>();
    ArrayList<Boolean> index = new ArrayList<>();

    // Act
    MerklePath actualMerklePath = new MerklePath(authenticationPath, index);
    List<List<Boolean>> actualAuthenticationPath = actualMerklePath.getAuthenticationPath();
    List<Boolean> actualIndex = actualMerklePath.getIndex();

    // Assert
    assertTrue(actualAuthenticationPath.isEmpty());
    assertTrue(actualIndex.isEmpty());
    assertSame(authenticationPath, actualAuthenticationPath);
    assertSame(index, actualIndex);
  }
}
