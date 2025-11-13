package org.tron.core.net.peer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
   * <p>Method under test: {@link Item#Item(Sha256Hash, InventoryType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Item.<init>(Sha256Hash, InventoryType)"})
  public void testNewItem() {
    // Arrange and Act
    Item actualItem = new Item(null, InventoryType.TRX);

    // Assert
    assertNull(actualItem.getHash());
    assertEquals(InventoryType.TRX, actualItem.getType());
  }
}
