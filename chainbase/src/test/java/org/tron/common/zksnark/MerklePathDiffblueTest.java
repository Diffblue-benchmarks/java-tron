package org.tron.common.zksnark;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class MerklePathDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MerklePath#MerklePath(List, List)}
   *   <li>{@link MerklePath#getAuthenticationPath()}
   *   <li>{@link MerklePath#getIndex()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void MerklePath.<init>(List, List)",
    "List MerklePath.getAuthenticationPath()",
    "List MerklePath.getIndex()"
  })
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
