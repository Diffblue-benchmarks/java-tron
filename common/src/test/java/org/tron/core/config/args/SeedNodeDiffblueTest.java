package org.tron.core.config.args;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class SeedNodeDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link SeedNode}
   *   <li>{@link SeedNode#setAddressList(List)}
   *   <li>{@link SeedNode#getAddressList()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    SeedNode actualSeedNode = new SeedNode();
    ArrayList<InetSocketAddress> addressList = new ArrayList<>();
    actualSeedNode.setAddressList(addressList);
    List<InetSocketAddress> actualAddressList = actualSeedNode.getAddressList();

    // Assert that nothing has changed
    assertTrue(actualAddressList.isEmpty());
    assertSame(addressList, actualAddressList);
  }
}
