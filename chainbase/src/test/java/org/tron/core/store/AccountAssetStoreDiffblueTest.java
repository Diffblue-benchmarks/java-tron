package org.tron.core.store;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.Test;
import org.tron.core.db2.common.WrappedByteArray;

public class AccountAssetStoreDiffblueTest {
  /**
   * Method under test: {@link AccountAssetStore#convert(Map)}
   */
  @Test
  public void testConvert() {
    // Arrange and Act
    Map<byte[], byte[]> actualConvertResult = AccountAssetStore.convert(new HashMap<>());

    // Assert
    assertTrue(actualConvertResult.isEmpty());
  }

  /**
   * Method under test: {@link AccountAssetStore#convert(Map)}
   */
  @Test
  public void testConvert2() {
    // Arrange
    HashMap<WrappedByteArray, WrappedByteArray> map = new HashMap<>();
    map.computeIfPresent(null, mock(BiFunction.class));

    // Act
    Map<byte[], byte[]> actualConvertResult = AccountAssetStore.convert(map);

    // Assert
    assertTrue(actualConvertResult.isEmpty());
  }
}
