package org.tron.core.store;

import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AccountAssetStoreDiffblueTest {
  /**
   * Test {@link AccountAssetStore#convert(Map)}.
   * <p>
   * Method under test: {@link AccountAssetStore#convert(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map AccountAssetStore.convert(Map)"})
  public void testConvert() {
    // Arrange and Act
    Map<byte[], byte[]> actualConvertResult = AccountAssetStore.convert(new HashMap<>());

    // Assert
    assertTrue(actualConvertResult.isEmpty());
  }
}
