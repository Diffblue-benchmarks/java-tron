package org.tron.core.net.service.nodepersist;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class DBNodesDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link DBNodes}
   *   <li>{@link DBNodes#setNodes(List)}
   *   <li>{@link DBNodes#getNodes()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    DBNodes actualDbNodes = new DBNodes();
    ArrayList<DBNode> nodes = new ArrayList<>();
    actualDbNodes.setNodes(nodes);
    List<DBNode> actualNodes = actualDbNodes.getNodes();

    // Assert that nothing has changed
    assertTrue(actualNodes.isEmpty());
    assertSame(nodes, actualNodes);
  }
}
