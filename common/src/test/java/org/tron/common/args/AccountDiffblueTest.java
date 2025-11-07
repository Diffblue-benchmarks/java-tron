package org.tron.common.args;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.AccountType;

public class AccountDiffblueTest {
  /**
   * Test {@link Account#setAddress(byte[])}.
   * <ul>
   *   <li>Given {@link Account} (default constructor) AccountName is {@code Dr Jane Doe}.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Account#setAddress(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Account.setAddress(byte[])"})
  public void testSetAddress_givenAccountAccountNameIsDrJaneDoe_whenNull() {
    // Arrange
    Account account = new Account();
    account.setAccountName("Dr Jane Doe");
    account.setAccountType("ASSETISSUE");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> account.setAddress(null));
  }

  /**
   * Test {@link Account#setAddress(byte[])}.
   * <ul>
   *   <li>Given {@link Account} (default constructor).</li>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Account#setAddress(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Account.setAddress(byte[])"})
  public void testSetAddress_givenAccount_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    Account account = new Account();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> account.setAddress("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link Account#setAddress(byte[])}.
   * <ul>
   *   <li>Given {@link Account} (default constructor).</li>
   *   <li>When empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Account#setAddress(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Account.setAddress(byte[])"})
  public void testSetAddress_givenAccount_whenEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new Account()).setAddress(new byte[]{}));
  }

  /**
   * Test {@link Account#getBalance()}.
   * <ul>
   *   <li>Given {@link Account} (default constructor) Balance is {@code 42}.</li>
   *   <li>Then return forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Account#getBalance()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long Account.getBalance()"})
  public void testGetBalance_givenAccountBalanceIs42_thenReturnFortyTwo() {
    // Arrange
    Account account = new Account();
    account.setBalance("42");

    // Act and Assert
    assertEquals(42L, account.getBalance());
  }

  /**
   * Test {@link Account#setBalance(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then {@link Account} (default constructor) Balance is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Account#setBalance(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Account.setBalance(String)"})
  public void testSetBalance_when42_thenAccountBalanceIsFortyTwo() {
    // Arrange
    Account account = new Account();

    // Act
    account.setBalance("42");

    // Assert
    assertEquals(42L, account.getBalance());
  }

  /**
   * Test {@link Account#setBalance(String)}.
   * <ul>
   *   <li>When {@code Balance}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Account#setBalance(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Account.setBalance(String)"})
  public void testSetBalance_whenBalance_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new Account()).setBalance("Balance"));
  }

  /**
   * Test {@link Account#getAccountName()}.
   * <ul>
   *   <li>Given {@link Account} (default constructor).</li>
   *   <li>Then return {@link ByteString#EMPTY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Account#getAccountName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ByteString Account.getAccountName()"})
  public void testGetAccountName_givenAccount_thenReturnEmpty() {
    // Arrange and Act
    ByteString actualAccountName = (new Account()).getAccountName();

    // Assert
    assertSame(actualAccountName.EMPTY, actualAccountName);
  }

  /**
   * Test {@link Account#setAccountName(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Account#setAccountName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Account.setAccountName(String)"})
  public void testSetAccountName_whenEmptyString_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new Account()).setAccountName(""));
  }

  /**
   * Test {@link Account#getAccountType()}.
   * <ul>
   *   <li>Given {@link Account} (default constructor) AccountType is {@code ASSETISSUE}.</li>
   *   <li>Then return {@code AssetIssue}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Account#getAccountType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Protocol.AccountType Account.getAccountType()"})
  public void testGetAccountType_givenAccountAccountTypeIsAssetissue_thenReturnAssetIssue() {
    // Arrange
    Account account = new Account();
    account.setAccountType("ASSETISSUE");

    // Act and Assert
    assertEquals(AccountType.AssetIssue, account.getAccountType());
  }

  /**
   * Test {@link Account#getAccountType()}.
   * <ul>
   *   <li>Given {@link Account} (default constructor) AccountType is {@code CONTRACT}.</li>
   *   <li>Then return {@code Contract}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Account#getAccountType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Protocol.AccountType Account.getAccountType()"})
  public void testGetAccountType_givenAccountAccountTypeIsContract_thenReturnContract() {
    // Arrange
    Account account = new Account();
    account.setAccountType("CONTRACT");

    // Act and Assert
    assertEquals(AccountType.Contract, account.getAccountType());
  }

  /**
   * Test {@link Account#getAccountType()}.
   * <ul>
   *   <li>Given {@link Account} (default constructor) AccountType is {@code NORMAL}.</li>
   *   <li>Then return {@code Normal}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Account#getAccountType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Protocol.AccountType Account.getAccountType()"})
  public void testGetAccountType_givenAccountAccountTypeIsNormal_thenReturnNormal() {
    // Arrange
    Account account = new Account();
    account.setAccountType("NORMAL");

    // Act and Assert
    assertEquals(AccountType.Normal, account.getAccountType());
  }

  /**
   * Test {@link Account#getAccountType()}.
   * <ul>
   *   <li>Given {@link Account} (default constructor).</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Account#getAccountType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Protocol.AccountType Account.getAccountType()"})
  public void testGetAccountType_givenAccount_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new Account()).getAccountType());
  }

  /**
   * Test {@link Account#setAccountType(String)}.
   * <ul>
   *   <li>When {@code 3}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Account#setAccountType(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Account.setAccountType(String)"})
  public void testSetAccountType_when3_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new Account()).setAccountType("3"));
  }

  /**
   * Test {@link Account#setAccountType(String)}.
   * <ul>
   *   <li>When {@code ASSETISSUE}.</li>
   *   <li>Then {@link Account} (default constructor) AccountType is {@code AssetIssue}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Account#setAccountType(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Account.setAccountType(String)"})
  public void testSetAccountType_whenAssetissue_thenAccountAccountTypeIsAssetIssue() {
    // Arrange
    Account account = new Account();

    // Act
    account.setAccountType("ASSETISSUE");

    // Assert
    assertEquals(AccountType.AssetIssue, account.getAccountType());
  }

  /**
   * Test {@link Account#setAccountType(String)}.
   * <ul>
   *   <li>When {@code CONTRACT}.</li>
   *   <li>Then {@link Account} (default constructor) AccountType is {@code Contract}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Account#setAccountType(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Account.setAccountType(String)"})
  public void testSetAccountType_whenContract_thenAccountAccountTypeIsContract() {
    // Arrange
    Account account = new Account();

    // Act
    account.setAccountType("CONTRACT");

    // Assert
    assertEquals(AccountType.Contract, account.getAccountType());
  }

  /**
   * Test {@link Account#setAccountType(String)}.
   * <ul>
   *   <li>When {@code NORMAL}.</li>
   *   <li>Then {@link Account} (default constructor) AccountType is {@code Normal}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Account#setAccountType(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Account.setAccountType(String)"})
  public void testSetAccountType_whenNormal_thenAccountAccountTypeIsNormal() {
    // Arrange
    Account account = new Account();

    // Act
    account.setAccountType("NORMAL");

    // Assert
    assertEquals(AccountType.Normal, account.getAccountType());
  }

  /**
   * Test {@link Account#setAccountType(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Account#setAccountType(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Account.setAccountType(String)"})
  public void testSetAccountType_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new Account()).setAccountType(null));
  }

  /**
   * Test {@link Account#isAccountType(String)}.
   * <ul>
   *   <li>When {@code 3}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Account#isAccountType(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Account.isAccountType(String)"})
  public void testIsAccountType_when3_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new Account()).isAccountType("3"));
  }

  /**
   * Test {@link Account#isAccountType(String)}.
   * <ul>
   *   <li>When {@code ASSETISSUE}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Account#isAccountType(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Account.isAccountType(String)"})
  public void testIsAccountType_whenAssetissue_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new Account()).isAccountType("ASSETISSUE"));
  }

  /**
   * Test {@link Account#isAccountType(String)}.
   * <ul>
   *   <li>When {@code CONTRACT}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Account#isAccountType(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Account.isAccountType(String)"})
  public void testIsAccountType_whenContract_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new Account()).isAccountType("CONTRACT"));
  }

  /**
   * Test {@link Account#isAccountType(String)}.
   * <ul>
   *   <li>When {@code NORMAL}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Account#isAccountType(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Account.isAccountType(String)"})
  public void testIsAccountType_whenNormal_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new Account()).isAccountType("NORMAL"));
  }

  /**
   * Test {@link Account#isAccountType(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Account#isAccountType(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Account.isAccountType(String)"})
  public void testIsAccountType_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new Account()).isAccountType(null));
  }

  /**
   * Test {@link Account#getAccountTypeByString(String)}.
   * <ul>
   *   <li>When {@code 3}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Account#getAccountTypeByString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Protocol.AccountType Account.getAccountTypeByString(String)"})
  public void testGetAccountTypeByString_when3_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new Account()).getAccountTypeByString("3"));
  }

  /**
   * Test {@link Account#getAccountTypeByString(String)}.
   * <ul>
   *   <li>When {@code ASSETISSUE}.</li>
   *   <li>Then return {@code AssetIssue}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Account#getAccountTypeByString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Protocol.AccountType Account.getAccountTypeByString(String)"})
  public void testGetAccountTypeByString_whenAssetissue_thenReturnAssetIssue() {
    // Arrange, Act and Assert
    assertEquals(AccountType.AssetIssue, (new Account()).getAccountTypeByString("ASSETISSUE"));
  }

  /**
   * Test {@link Account#getAccountTypeByString(String)}.
   * <ul>
   *   <li>When {@code CONTRACT}.</li>
   *   <li>Then return {@code Contract}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Account#getAccountTypeByString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Protocol.AccountType Account.getAccountTypeByString(String)"})
  public void testGetAccountTypeByString_whenContract_thenReturnContract() {
    // Arrange, Act and Assert
    assertEquals(AccountType.Contract, (new Account()).getAccountTypeByString("CONTRACT"));
  }

  /**
   * Test {@link Account#getAccountTypeByString(String)}.
   * <ul>
   *   <li>When {@code NORMAL}.</li>
   *   <li>Then return {@code Normal}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Account#getAccountTypeByString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Protocol.AccountType Account.getAccountTypeByString(String)"})
  public void testGetAccountTypeByString_whenNormal_thenReturnNormal() {
    // Arrange, Act and Assert
    assertEquals(AccountType.Normal, (new Account()).getAccountTypeByString("NORMAL"));
  }

  /**
   * Test {@link Account#getAccountTypeByString(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Account#getAccountTypeByString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Protocol.AccountType Account.getAccountTypeByString(String)"})
  public void testGetAccountTypeByString_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new Account()).getAccountTypeByString(null));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Account}
   *   <li>{@link Account#getAddress()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Account.<init>()", "byte[] Account.getAddress()"})
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertNull((new Account()).getAddress());
  }
}
