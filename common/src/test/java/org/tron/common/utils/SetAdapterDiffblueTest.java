package org.tron.common.utils;

import static org.junit.Assert.assertTrue;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class SetAdapterDiffblueTest {
  /**
   * Method under test: {@link SetAdapter#SetAdapter(Map)}
   */
  @Test
  public void testNewSetAdapter() {
    // Arrange and Act
    SetAdapter<Object> actualObjectSet = new SetAdapter<>(new HashMap<>());

    // Assert
    assertTrue(actualObjectSet.isEmpty());
  }
}
