package org.tron.common.utils;

import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SetAdapterDiffblueTest {
  /**
   * Test {@link SetAdapter#SetAdapter(Map)}.
   * <p>
   * Method under test: {@link SetAdapter#SetAdapter(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SetAdapter.<init>(Map)"})
  public void testNewSetAdapter() {
    // Arrange and Act
    SetAdapter<Object> actualObjectSet = new SetAdapter<>(new HashMap<>());

    // Assert
    assertTrue(actualObjectSet.isEmpty());
  }
}
