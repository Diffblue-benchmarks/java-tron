package org.tron.core.config.args;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SeedNodeDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link SeedNode}
   *   <li>{@link SeedNode#setAddressList(List)}
   *   <li>{@link SeedNode#getAddressList()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SeedNode.<init>()", "List SeedNode.getAddressList()", "void SeedNode.setAddressList(List)"})
  public void testGettersAndSetters() {
    // Arrange and Act
    SeedNode actualSeedNode = new SeedNode();
    ArrayList<InetSocketAddress> addressList = new ArrayList<>();
    actualSeedNode.setAddressList(addressList);
    List<InetSocketAddress> actualAddressList = actualSeedNode.getAddressList();

    // Assert
    assertTrue(actualAddressList.isEmpty());
    assertSame(addressList, actualAddressList);
  }
}
