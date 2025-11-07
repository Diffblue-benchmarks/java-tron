package org.tron.core.capsule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class TxOutputCapsuleDiffblueTest {
  /**
   * Method under test: {@link TxOutputCapsule#validate()}
   */
  @Test
  public void testValidate() {
    // Arrange, Act and Assert
    assertTrue((new TxOutputCapsule(42L, "42")).validate());
  }

  /**
   * Method under test: {@link TxOutputCapsule#getData()}
   */
  @Test
  public void testGetData() {
    // Arrange, Act and Assert
    assertEquals(0, (new TxOutputCapsule(42L, "42")).getData().length);
  }
}
