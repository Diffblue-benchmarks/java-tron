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
   * <p>
   * Method under test: {@link AccountStateCallBackUtils#exe()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AccountStateCallBackUtils.exe()"})
  public void testExe() {
    // Arrange, Act and Assert
    assertFalse((new AccountStateCallBackUtils()).exe());
  }

  /**
   * Test new {@link AccountStateCallBackUtils} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link AccountStateCallBackUtils}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AccountStateCallBackUtils.<init>()"})
  public void testNewAccountStateCallBackUtils() {
    // Arrange, Act and Assert
    assertTrue((new AccountStateCallBackUtils()).trieEntryList.isEmpty());
  }

  /**
   * Test TrieEntry {@link TrieEntry#build(byte[], byte[])}.
   * <p>
   * Methods under test:
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
  @MethodsUnderTest({"void TrieEntry.<init>()", "TrieEntry TrieEntry.build(byte[], byte[])",
      "byte[] TrieEntry.getData()", "byte[] TrieEntry.getKey()", "TrieEntry TrieEntry.setData(byte[])",
      "TrieEntry TrieEntry.setKey(byte[])"})
  public void testTrieEntryBuild() throws UnsupportedEncodingException {
    // Arrange
    TrieEntry trieEntry = new TrieEntry();
    TrieEntry setDataResult = trieEntry.setData("AXAXAXAX".getBytes("UTF-8"));
    TrieEntry setKeyResult = setDataResult.setKey("AXAXAXAX".getBytes("UTF-8"));
    byte[] key = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act
    TrieEntry actualBuildResult = setKeyResult.build(key, data);

    // Assert
    byte[] data2 = actualBuildResult.getData();
    assertSame(data, data2);
    byte[] key2 = actualBuildResult.getKey();
    assertSame(key, key2);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), data2);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), key2);
  }
}
