package org.tron.core.db.accountstate;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.db.accountstate.AccountStateCallBackUtils.TrieEntry;

public class AccountStateCallBackUtilsDiffblueTest {
  /**
   * Test {@link AccountStateCallBackUtils#exe()}.
   *
   * <p>Method under test: {@link AccountStateCallBackUtils#exe()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AccountStateCallBackUtils.exe()"})
  public void testExe() {
    // Arrange, Act and Assert
    assertFalse(new AccountStateCallBackUtils().exe());
  }

  /**
   * Test new {@link AccountStateCallBackUtils} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link AccountStateCallBackUtils}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AccountStateCallBackUtils.<init>()"})
  public void testNewAccountStateCallBackUtils() {
    // Arrange, Act and Assert
    assertTrue(new AccountStateCallBackUtils().trieEntryList.isEmpty());
  }

  /**
   * Test TrieEntry {@link TrieEntry#build(byte[], byte[])}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TrieEntry#build(byte[], byte[])}
   *   <li>default or parameterless constructor of {@link TrieEntry}
   *   <li>{@link TrieEntry#setData(byte[])}
   *   <li>{@link TrieEntry#setKey(byte[])}
   *   <li>{@link TrieEntry#getData()}
   *   <li>{@link TrieEntry#getKey()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void TrieEntry.<init>()",
    "TrieEntry TrieEntry.build(byte[], byte[])",
    "byte[] TrieEntry.getData()",
    "byte[] TrieEntry.getKey()",
    "TrieEntry TrieEntry.setData(byte[])",
    "TrieEntry TrieEntry.setKey(byte[])"
  })
  public void testTrieEntryBuild() throws UnsupportedEncodingException {
    // Arrange and Act
    TrieEntry actualTrieEntry = new TrieEntry();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    TrieEntry actualSetDataResult = actualTrieEntry.setData(data);
    byte[] key = "AXAXAXAX".getBytes("UTF-8");
    TrieEntry actualSetKeyResult = actualSetDataResult.setKey(key);
    byte[] key2 = "AXAXAXAX".getBytes("UTF-8");
    byte[] data2 = "AXAXAXAX".getBytes("UTF-8");
    TrieEntry actualTrieEntry2 = actualSetKeyResult.build(key2, data2);

    // Assert
    byte[] data3 = actualTrieEntry.getData();
    assertSame(data, data3);
    byte[] data4 = actualTrieEntry2.getData();
    assertSame(data2, data4);
    assertSame(data, actualSetDataResult.getData());
    assertSame(data, actualSetKeyResult.getData());
    byte[] key3 = actualTrieEntry.getKey();
    assertSame(key, key3);
    byte[] key4 = actualTrieEntry2.getKey();
    assertSame(key2, key4);
    assertSame(key, actualSetDataResult.getKey());
    assertSame(key, actualSetKeyResult.getKey());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), data3);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), data4);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), key3);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), key4);
  }
}
