package org.tron.core.db.accountstate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.tron.core.capsule.AccountCapsule;
import org.tron.core.store.DynamicPropertiesStore;
import org.tron.protos.Protocol;

public class AccountStateCallBackUtilsDiffblueTest {
  /**
   * Method under test:
   * {@link AccountStateCallBackUtils#accountCallBack(byte[], AccountCapsule)}
   */
  @Test
  public void testAccountCallBack() throws UnsupportedEncodingException {
    // Arrange
    AccountStateCallBackUtils accountStateCallBackUtils = new AccountStateCallBackUtils();
    byte[] key = "AXAXAXAX".getBytes("UTF-8");
    DynamicPropertiesStore dynamicPropertiesStore = mock(DynamicPropertiesStore.class);
    when(dynamicPropertiesStore.getActiveDefaultOperations()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    AccountCapsule item = new AccountCapsule(Protocol.Account.getDefaultInstance());
    item.setDefaultWitnessPermission(dynamicPropertiesStore);

    // Act
    accountStateCallBackUtils.accountCallBack(key, item);

    // Assert
    verify(dynamicPropertiesStore).getActiveDefaultOperations();
  }

  /**
   * Method under test: {@link AccountStateCallBackUtils#exe()}
   */
  @Test
  public void testExe() {
    // Arrange, Act and Assert
    assertFalse((new AccountStateCallBackUtils()).exe());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link AccountStateCallBackUtils}
   */
  @Test
  public void testNewAccountStateCallBackUtils() {
    // Arrange, Act and Assert
    assertTrue((new AccountStateCallBackUtils()).trieEntryList.isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AccountStateCallBackUtils.TrieEntry#build(byte[], byte[])}
   *   <li>default or parameterless constructor of
   * {@link AccountStateCallBackUtils.TrieEntry}
   *   <li>{@link AccountStateCallBackUtils.TrieEntry#setData(byte[])}
   *   <li>{@link AccountStateCallBackUtils.TrieEntry#setKey(byte[])}
   *   <li>{@link AccountStateCallBackUtils.TrieEntry#getData()}
   *   <li>{@link AccountStateCallBackUtils.TrieEntry#getKey()}
   * </ul>
   */
  @Test
  public void testTrieEntryBuild() throws UnsupportedEncodingException {
    // Arrange
    AccountStateCallBackUtils.TrieEntry trieEntry = new AccountStateCallBackUtils.TrieEntry();
    AccountStateCallBackUtils.TrieEntry setDataResult = trieEntry.setData("AXAXAXAX".getBytes("UTF-8"));
    AccountStateCallBackUtils.TrieEntry setKeyResult = setDataResult.setKey("AXAXAXAX".getBytes("UTF-8"));
    byte[] key = "AXAXAXAX".getBytes("UTF-8");
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act
    AccountStateCallBackUtils.TrieEntry actualBuildResult = setKeyResult.build(key, data);

    // Assert
    assertSame(data, actualBuildResult.getData());
    assertSame(key, actualBuildResult.getKey());
  }
}
