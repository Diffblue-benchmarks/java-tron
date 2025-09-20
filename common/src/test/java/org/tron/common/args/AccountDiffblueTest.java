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
import com.google.protobuf.ByteString.ByteIterator;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.AccountType;

public class AccountDiffblueTest {
  /**
   * Test {@link Account#setAddress(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link Account#setAddress(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Account.setAddress(byte[])"})
  public void testSetAddress_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new Account().setAddress("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link Account#setAddress(byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link Account#setAddress(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Account.setAddress(byte[])"})
  public void testSetAddress_whenEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Account().setAddress(new byte[] {}));
  }

  /**
   * Test {@link Account#getBalance()}.
   *
   * <ul>
   *   <li>Given {@link Account} (default constructor) Balance is {@code 42}.
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link Account#getBalance()}
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
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then {@link Account} (default constructor) Balance is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link Account#setBalance(String)}
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
   *
   * <ul>
   *   <li>When {@code Balance}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Account#setBalance(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Account.setBalance(String)"})
  public void testSetBalance_whenBalance_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Account().setBalance("Balance"));
  }

  /**
   * Test {@link Account#getAccountName()}.
   *
   * <ul>
   *   <li>Given {@link Account} (default constructor) AccountName is {@code Dr Jane Doe}.
   *   <li>Then return not Empty.
   * </ul>
   *
   * <p>Method under test: {@link Account#getAccountName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ByteString Account.getAccountName()"})
  public void testGetAccountName_givenAccountAccountNameIsDrJaneDoe_thenReturnNotEmpty() {
    // Arrange
    Account account = new Account();
    account.setAccountName("Dr Jane Doe");

    // Act
    ByteString actualAccountName = account.getAccountName();

    // Assert
    assertFalse(actualAccountName.isEmpty());
    ByteIterator iteratorResult = actualAccountName.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('D', iteratorResult.next().byteValue());
    assertEquals('r', iteratorResult.next().byteValue());
    assertEquals(' ', iteratorResult.next().byteValue());
    assertEquals('J', iteratorResult.next().byteValue());
    assertEquals('a', iteratorResult.next().byteValue());
    assertEquals("Dr Jane Doe", actualAccountName.toStringUtf8());
  }

  /**
   * Test {@link Account#getAccountName()}.
   *
   * <ul>
   *   <li>Given {@link Account} (default constructor).
   *   <li>Then return {@link ByteString#EMPTY}.
   * </ul>
   *
   * <p>Method under test: {@link Account#getAccountName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ByteString Account.getAccountName()"})
  public void testGetAccountName_givenAccount_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertSame(ByteString.EMPTY, new Account().getAccountName());
  }

  /**
   * Test {@link Account#setAccountName(String)}.
   *
   * <ul>
   *   <li>When {@code Dr Jane Doe}.
   *   <li>Then not {@link Account} (default constructor) AccountName Empty.
   * </ul>
   *
   * <p>Method under test: {@link Account#setAccountName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Account.setAccountName(String)"})
  public void testSetAccountName_whenDrJaneDoe_thenNotAccountAccountNameEmpty() {
    // Arrange
    Account account = new Account();

    // Act
    account.setAccountName("Dr Jane Doe");

    // Assert
    ByteString accountName = account.getAccountName();
    assertFalse(accountName.isEmpty());
    ByteIterator iteratorResult = accountName.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('D', iteratorResult.next().byteValue());
    assertEquals('r', iteratorResult.next().byteValue());
    assertEquals(' ', iteratorResult.next().byteValue());
    assertEquals("Dr Jane Doe", accountName.toStringUtf8());
  }

  /**
   * Test {@link Account#setAccountName(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Account#setAccountName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Account.setAccountName(String)"})
  public void testSetAccountName_whenEmptyString_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Account().setAccountName(""));
  }

  /**
   * Test {@link Account#setAccountName(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Account#setAccountName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Account.setAccountName(String)"})
  public void testSetAccountName_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Account().setAccountName(null));
  }

  /**
   * Test {@link Account#setAccountName(String)}.
   *
   * <ul>
   *   <li>When space.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Account#setAccountName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Account.setAccountName(String)"})
  public void testSetAccountName_whenSpace_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Account().setAccountName(" "));
  }

  /**
   * Test {@link Account#getAccountType()}.
   *
   * <ul>
   *   <li>Given {@link Account} (default constructor) AccountType is {@code ASSETISSUE}.
   *   <li>Then return {@code AssetIssue}.
   * </ul>
   *
   * <p>Method under test: {@link Account#getAccountType()}
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
   *
   * <ul>
   *   <li>Given {@link Account} (default constructor) AccountType is {@code CONTRACT}.
   *   <li>Then return {@code Contract}.
   * </ul>
   *
   * <p>Method under test: {@link Account#getAccountType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Protocol.AccountType Account.getAccountType()"})
  public void testGetAccountType_givenAccountAccountTypeIsContract_thenReturnContract() {
    // Arrange
    Account account = new Account();
    account.setAccountName("Dr Jane Doe");
    account.setAccountType("CONTRACT");

    // Act and Assert
    assertEquals(AccountType.Contract, account.getAccountType());
  }

  /**
   * Test {@link Account#getAccountType()}.
   *
   * <ul>
   *   <li>Given {@link Account} (default constructor) AccountType is {@code NORMAL}.
   *   <li>Then return {@code Normal}.
   * </ul>
   *
   * <p>Method under test: {@link Account#getAccountType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Protocol.AccountType Account.getAccountType()"})
  public void testGetAccountType_givenAccountAccountTypeIsNormal_thenReturnNormal() {
    // Arrange
    Account account = new Account();
    account.setAccountName("Dr Jane Doe");
    account.setAccountType("NORMAL");

    // Act and Assert
    assertEquals(AccountType.Normal, account.getAccountType());
  }

  /**
   * Test {@link Account#getAccountType()}.
   *
   * <ul>
   *   <li>Given {@link Account} (default constructor).
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Account#getAccountType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Protocol.AccountType Account.getAccountType()"})
  public void testGetAccountType_givenAccount_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Account().getAccountType());
  }

  /**
   * Test {@link Account#setAccountType(String)}.
   *
   * <ul>
   *   <li>When {@code 3}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Account#setAccountType(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Account.setAccountType(String)"})
  public void testSetAccountType_when3_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Account().setAccountType("3"));
  }

  /**
   * Test {@link Account#setAccountType(String)}.
   *
   * <ul>
   *   <li>When {@code ASSETISSUE}.
   *   <li>Then {@link Account} (default constructor) AccountType is {@code AssetIssue}.
   * </ul>
   *
   * <p>Method under test: {@link Account#setAccountType(String)}
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
   *
   * <ul>
   *   <li>When {@code CONTRACT}.
   *   <li>Then {@link Account} (default constructor) AccountType is {@code Contract}.
   * </ul>
   *
   * <p>Method under test: {@link Account#setAccountType(String)}
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
   *
   * <ul>
   *   <li>When {@code NORMAL}.
   *   <li>Then {@link Account} (default constructor) AccountType is {@code Normal}.
   * </ul>
   *
   * <p>Method under test: {@link Account#setAccountType(String)}
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
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Account#setAccountType(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Account.setAccountType(String)"})
  public void testSetAccountType_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Account().setAccountType(null));
  }

  /**
   * Test {@link Account#isAccountType(String)}.
   *
   * <ul>
   *   <li>When {@code 3}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Account#isAccountType(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Account.isAccountType(String)"})
  public void testIsAccountType_when3_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Account().isAccountType("3"));
  }

  /**
   * Test {@link Account#isAccountType(String)}.
   *
   * <ul>
   *   <li>When {@code ASSETISSUE}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Account#isAccountType(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Account.isAccountType(String)"})
  public void testIsAccountType_whenAssetissue_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new Account().isAccountType("ASSETISSUE"));
  }

  /**
   * Test {@link Account#isAccountType(String)}.
   *
   * <ul>
   *   <li>When {@code CONTRACT}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Account#isAccountType(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Account.isAccountType(String)"})
  public void testIsAccountType_whenContract_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new Account().isAccountType("CONTRACT"));
  }

  /**
   * Test {@link Account#isAccountType(String)}.
   *
   * <ul>
   *   <li>When {@code NORMAL}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Account#isAccountType(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Account.isAccountType(String)"})
  public void testIsAccountType_whenNormal_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new Account().isAccountType("NORMAL"));
  }

  /**
   * Test {@link Account#isAccountType(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Account#isAccountType(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Account.isAccountType(String)"})
  public void testIsAccountType_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Account().isAccountType(null));
  }

  /**
   * Test {@link Account#getAccountTypeByString(String)}.
   *
   * <ul>
   *   <li>When {@code 3}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Account#getAccountTypeByString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Protocol.AccountType Account.getAccountTypeByString(String)"})
  public void testGetAccountTypeByString_when3_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Account().getAccountTypeByString("3"));
  }

  /**
   * Test {@link Account#getAccountTypeByString(String)}.
   *
   * <ul>
   *   <li>When {@code ASSETISSUE}.
   *   <li>Then return {@code AssetIssue}.
   * </ul>
   *
   * <p>Method under test: {@link Account#getAccountTypeByString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Protocol.AccountType Account.getAccountTypeByString(String)"})
  public void testGetAccountTypeByString_whenAssetissue_thenReturnAssetIssue() {
    // Arrange, Act and Assert
    assertEquals(AccountType.AssetIssue, new Account().getAccountTypeByString("ASSETISSUE"));
  }

  /**
   * Test {@link Account#getAccountTypeByString(String)}.
   *
   * <ul>
   *   <li>When {@code CONTRACT}.
   *   <li>Then return {@code Contract}.
   * </ul>
   *
   * <p>Method under test: {@link Account#getAccountTypeByString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Protocol.AccountType Account.getAccountTypeByString(String)"})
  public void testGetAccountTypeByString_whenContract_thenReturnContract() {
    // Arrange, Act and Assert
    assertEquals(AccountType.Contract, new Account().getAccountTypeByString("CONTRACT"));
  }

  /**
   * Test {@link Account#getAccountTypeByString(String)}.
   *
   * <ul>
   *   <li>When {@code NORMAL}.
   *   <li>Then return {@code Normal}.
   * </ul>
   *
   * <p>Method under test: {@link Account#getAccountTypeByString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Protocol.AccountType Account.getAccountTypeByString(String)"})
  public void testGetAccountTypeByString_whenNormal_thenReturnNormal() {
    // Arrange, Act and Assert
    assertEquals(AccountType.Normal, new Account().getAccountTypeByString("NORMAL"));
  }

  /**
   * Test {@link Account#getAccountTypeByString(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Account#getAccountTypeByString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Protocol.AccountType Account.getAccountTypeByString(String)"})
  public void testGetAccountTypeByString_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Account().getAccountTypeByString(null));
  }

  /**
   * Test new {@link Account} (default constructor).
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Account}
   *   <li>{@link Account#getAddress()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Account.<init>()", "byte[] Account.getAddress()"})
  public void testNewAccount() {
    // Arrange, Act and Assert
    assertNull(new Account().getAddress());
  }
}
