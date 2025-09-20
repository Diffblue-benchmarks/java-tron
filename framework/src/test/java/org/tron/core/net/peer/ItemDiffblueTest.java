package org.tron.core.net.peer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.utils.Sha256Hash;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.Inventory;
import org.tron.protos.Protocol.Inventory.InventoryType;

public class ItemDiffblueTest {
  /**
   * Test {@link Item#Item(Sha256Hash, InventoryType)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Hash is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Item#Item(Sha256Hash, InventoryType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Item.<init>(Sha256Hash, InventoryType)"})
  public void testNewItem_whenNull_thenReturnHashIsNull() {
    // Arrange and Act
    Item actualItem = new Item(null, InventoryType.TRX);

    // Assert
    assertNull(actualItem.getHash());
    assertEquals(InventoryType.TRX, actualItem.getType());
  }
}
