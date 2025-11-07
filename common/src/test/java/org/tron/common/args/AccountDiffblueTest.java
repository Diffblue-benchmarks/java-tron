package org.tron.common.args;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.google.protobuf.ByteString;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.tron.protos.Protocol;

public class AccountDiffblueTest {
  /**
   * Method under test: {@link Account#setAddress(byte[])}
   */
  @Test
  public void testSetAddress() throws UnsupportedEncodingException {
    // Arrange
    Account account = new Account();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> account.setAddress("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link Account#setAddress(byte[])}
   */
  @Test
  public void testSetAddress2() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new Account()).setAddress(new byte[]{}));
  }

  /**
   * Method under test: {@link Account#setAddress(byte[])}
   */
  @Test
  public void testSetAddress3() {
    // Arrange
    Account account = new Account();
    account.setAccountName("Dr Jane Doe");
    account.setAccountType("ASSETISSUE");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> account.setAddress(null));
  }

  /**
   * Method under test: {@link Account#getBalance()}
   */
  @Test
  public void testGetBalance() {
    // Arrange
    Account account = new Account();
    account.setBalance("42");

    // Act and Assert
    assertEquals(42L, account.getBalance());
  }

  /**
   * Method under test: {@link Account#setBalance(String)}
   */
  @Test
  public void testSetBalance() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new Account()).setBalance("Balance"));
  }

  /**
   * Method under test: {@link Account#setBalance(String)}
   */
  @Test
  public void testSetBalance2() {
    // Arrange
    Account account = new Account();

    // Act
    account.setBalance("42");

    // Assert
    assertEquals(42L, account.getBalance());
  }

  /**
   * Method under test: {@link Account#getAccountName()}
   */
  @Test
  public void testGetAccountName() {
    // Arrange and Act
    ByteString actualAccountName = (new Account()).getAccountName();

    // Assert
    assertSame(actualAccountName.EMPTY, actualAccountName);
  }

  /**
   * Method under test: {@link Account#setAccountName(String)}
   */
  @Test
  public void testSetAccountName() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new Account()).setAccountName(""));
  }

  /**
   * Method under test: {@link Account#getAccountType()}
   */
  @Test
  public void testGetAccountType() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new Account()).getAccountType());
  }

  /**
   * Method under test: {@link Account#getAccountType()}
   */
  @Test
  public void testGetAccountType2() {
    // Arrange
    Account account = new Account();
    account.setAccountType("ASSETISSUE");

    // Act and Assert
    assertEquals(Protocol.AccountType.AssetIssue, account.getAccountType());
  }

  /**
   * Method under test: {@link Account#getAccountType()}
   */
  @Test
  public void testGetAccountType3() {
    // Arrange
    Account account = new Account();
    account.setAccountType("CONTRACT");

    // Act and Assert
    assertEquals(Protocol.AccountType.Contract, account.getAccountType());
  }

  /**
   * Method under test: {@link Account#getAccountType()}
   */
  @Test
  public void testGetAccountType4() {
    // Arrange
    Account account = new Account();
    account.setAccountType("NORMAL");

    // Act and Assert
    assertEquals(Protocol.AccountType.Normal, account.getAccountType());
  }

  /**
   * Method under test: {@link Account#setAccountType(String)}
   */
  @Test
  public void testSetAccountType() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new Account()).setAccountType("3"));
    assertThrows(IllegalArgumentException.class, () -> (new Account()).setAccountType(null));
  }

  /**
   * Method under test: {@link Account#setAccountType(String)}
   */
  @Test
  public void testSetAccountType2() {
    // Arrange
    Account account = new Account();

    // Act
    account.setAccountType("ASSETISSUE");

    // Assert
    assertEquals(Protocol.AccountType.AssetIssue, account.getAccountType());
  }

  /**
   * Method under test: {@link Account#setAccountType(String)}
   */
  @Test
  public void testSetAccountType3() {
    // Arrange
    Account account = new Account();

    // Act
    account.setAccountType("CONTRACT");

    // Assert
    assertEquals(Protocol.AccountType.Contract, account.getAccountType());
  }

  /**
   * Method under test: {@link Account#setAccountType(String)}
   */
  @Test
  public void testSetAccountType4() {
    // Arrange
    Account account = new Account();

    // Act
    account.setAccountType("NORMAL");

    // Assert
    assertEquals(Protocol.AccountType.Normal, account.getAccountType());
  }

  /**
   * Method under test: {@link Account#isAccountType(String)}
   */
  @Test
  public void testIsAccountType() {
    // Arrange, Act and Assert
    assertFalse((new Account()).isAccountType("3"));
    assertFalse((new Account()).isAccountType(null));
    assertTrue((new Account()).isAccountType("ASSETISSUE"));
    assertTrue((new Account()).isAccountType("CONTRACT"));
    assertTrue((new Account()).isAccountType("NORMAL"));
  }

  /**
   * Method under test: {@link Account#getAccountTypeByString(String)}
   */
  @Test
  public void testGetAccountTypeByString() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new Account()).getAccountTypeByString("3"));
    assertThrows(IllegalArgumentException.class, () -> (new Account()).getAccountTypeByString(null));
    assertEquals(Protocol.AccountType.AssetIssue, (new Account()).getAccountTypeByString("ASSETISSUE"));
    assertEquals(Protocol.AccountType.Contract, (new Account()).getAccountTypeByString("CONTRACT"));
    assertEquals(Protocol.AccountType.Normal, (new Account()).getAccountTypeByString("NORMAL"));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Account}
   *   <li>{@link Account#getAddress()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertNull((new Account()).getAddress());
  }
}
