package org.tron.core.net.service.nodepersist;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DBNodesDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link DBNodes}
   *   <li>{@link DBNodes#setNodes(List)}
   *   <li>{@link DBNodes#getNodes()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DBNodes.<init>()", "List DBNodes.getNodes()", "void DBNodes.setNodes(List)"})
  public void testGettersAndSetters() {
    // Arrange and Act
    DBNodes actualDbNodes = new DBNodes();
    ArrayList<DBNode> nodes = new ArrayList<>();
    actualDbNodes.setNodes(nodes);
    List<DBNode> actualNodes = actualDbNodes.getNodes();

    // Assert
    assertTrue(actualNodes.isEmpty());
    assertSame(nodes, actualNodes);
  }
}
