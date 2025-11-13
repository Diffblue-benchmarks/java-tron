package org.tron.core.store;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.db2.common.WrappedByteArray;

public class AccountAssetStoreDiffblueTest {
  /**
   * Test {@link AccountAssetStore#convert(Map)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link AccountAssetStore#convert(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map AccountAssetStore.convert(Map)"})
  public void testConvert_thenReturnSizeIsOne() throws UnsupportedEncodingException {
    // Arrange
    WrappedByteArray wrappedByteArray = mock(WrappedByteArray.class);
    when(wrappedByteArray.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    WrappedByteArray wrappedByteArray2 = mock(WrappedByteArray.class);
    when(wrappedByteArray2.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    HashMap<WrappedByteArray, WrappedByteArray> map = new HashMap<>();

    map.put(wrappedByteArray, wrappedByteArray2);

    // Act
    Map<byte[], byte[]> actualConvertResult = AccountAssetStore.convert(map);

    // Assert
    verify(wrappedByteArray).getBytes();
    verify(wrappedByteArray2).getBytes();
    assertEquals(1, actualConvertResult.size());
  }

  /**
   * Test {@link AccountAssetStore#convert(Map)}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link AccountAssetStore#convert(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map AccountAssetStore.convert(Map)"})
  public void testConvert_thenReturnSizeIsTwo() throws UnsupportedEncodingException {
    // Arrange
    WrappedByteArray wrappedByteArray = mock(WrappedByteArray.class);
    when(wrappedByteArray.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    WrappedByteArray wrappedByteArray2 = mock(WrappedByteArray.class);
    when(wrappedByteArray2.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    WrappedByteArray wrappedByteArray3 = mock(WrappedByteArray.class);
    when(wrappedByteArray3.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    WrappedByteArray wrappedByteArray4 = mock(WrappedByteArray.class);
    when(wrappedByteArray4.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    HashMap<WrappedByteArray, WrappedByteArray> map = new HashMap<>();

    map.put(wrappedByteArray3, wrappedByteArray4);

    map.put(wrappedByteArray, wrappedByteArray2);

    // Act
    Map<byte[], byte[]> actualConvertResult = AccountAssetStore.convert(map);

    // Assert
    verify(wrappedByteArray3).getBytes();
    verify(wrappedByteArray4).getBytes();
    verify(wrappedByteArray).getBytes();
    verify(wrappedByteArray2).getBytes();
    assertEquals(2, actualConvertResult.size());
  }

  /**
   * Test {@link AccountAssetStore#convert(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AccountAssetStore#convert(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map AccountAssetStore.convert(Map)"})
  public void testConvert_whenHashMap_thenReturnEmpty() {
    // Arrange and Act
    Map<byte[], byte[]> actualConvertResult = AccountAssetStore.convert(new HashMap<>());

    // Assert
    assertTrue(actualConvertResult.isEmpty());
  }
}
