package org.tron.core.net.peer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import org.junit.Test;
import org.tron.common.utils.Sha256Hash;
import org.tron.protos.Protocol;

public class ItemDiffblueTest {
  /**
   * Method under test: {@link Item#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Item item = new Item(mock(Sha256Hash.class), Protocol.Inventory.InventoryType.TRX);

    // Act and Assert
    assertNotEquals(item, new Item(null, Protocol.Inventory.InventoryType.TRX));
  }

  /**
   * Method under test: {@link Item#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new Item(mock(Sha256Hash.class), Protocol.Inventory.InventoryType.TRX), "42");
  }

  /**
   * Method under test:
   * {@link Item#Item(Sha256Hash, Protocol.Inventory.InventoryType)}
   */
  @Test
  public void testNewItem() {
    // Arrange and Act
    Item actualItem = new Item(null, Protocol.Inventory.InventoryType.TRX);

    // Assert
    assertNull(actualItem.getHash());
    assertEquals(Protocol.Inventory.InventoryType.TRX, actualItem.getType());
  }
}
