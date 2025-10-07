package org.tron.core.db.accountstate;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.Account;

public class AccountStateEntityDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AccountStateEntity#AccountStateEntity()}
   *   <li>{@link AccountStateEntity#getAccount()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AccountStateEntity.<init>()",
    "Account AccountStateEntity.getAccount()",
    "AccountStateEntity AccountStateEntity.setAccount(Account)",
    "java.lang.String AccountStateEntity.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertNull(new AccountStateEntity().getAccount());
  }

  /**
   * Test {@link AccountStateEntity#AccountStateEntity(Account)}.
   *
   * <p>Method under test: {@link AccountStateEntity#AccountStateEntity(Account)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccountStateEntity.<init>(Account)"})
  public void testNewAccountStateEntity() {
    // Arrange
    Account account = mock(Account.class);
    when(account.getAllowance()).thenReturn(1L);
    when(account.getBalance()).thenReturn(42L);
    when(account.getAddress()).thenReturn(ByteString.EMPTY);

    // Act
    AccountStateEntity actualAccountStateEntity = new AccountStateEntity(account);

    // Assert
    verify(account).getAddress();
    verify(account).getAllowance();
    verify(account).getBalance();
    assertArrayEquals(new byte[] {' ', '*', 'X', 1}, actualAccountStateEntity.toByteArrays());
  }

  /**
   * Test {@link AccountStateEntity#AccountStateEntity(Account)}.
   *
   * <ul>
   *   <li>When DefaultInstance.
   *   <li>Then return Account is DefaultInstance.
   * </ul>
   *
   * <p>Method under test: {@link AccountStateEntity#AccountStateEntity(Account)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccountStateEntity.<init>(Account)"})
  public void testNewAccountStateEntity_whenDefaultInstance_thenReturnAccountIsDefaultInstance() {
    // Arrange
    Account account = Account.getDefaultInstance();

    // Act
    AccountStateEntity actualAccountStateEntity = new AccountStateEntity(account);

    // Assert
    assertEquals(account, actualAccountStateEntity.getAccount());
    assertArrayEquals(new byte[] {}, actualAccountStateEntity.toByteArrays());
  }

  /**
   * Test {@link AccountStateEntity#parse(byte[])}.
   *
   * <ul>
   *   <li>When {@code 2XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AccountStateEntity#parse(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AccountStateEntity AccountStateEntity.parse(byte[])"})
  public void testParse_when2xaxaxaxBytesIsUtf8_thenReturnNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(AccountStateEntity.parse("2XAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link AccountStateEntity#parse(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code 2} and two.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AccountStateEntity#parse(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AccountStateEntity AccountStateEntity.parse(byte[])"})
  public void testParse_whenArrayOfByteWith2AndTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        AccountStateEntity.parse(
            new byte[] {'2', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2}));
  }

  /**
   * Test {@link AccountStateEntity#parse(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code 2} and zero.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AccountStateEntity#parse(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AccountStateEntity AccountStateEntity.parse(byte[])"})
  public void testParse_whenArrayOfByteWith2AndZero_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(AccountStateEntity.parse(new byte[] {'2', 0, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link AccountStateEntity#parse(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and two.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AccountStateEntity#parse(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AccountStateEntity AccountStateEntity.parse(byte[])"})
  public void testParse_whenArrayOfByteWithAAndTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        AccountStateEntity.parse(
            new byte[] {'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2}));
  }

  /**
   * Test {@link AccountStateEntity#parse(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and two.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AccountStateEntity#parse(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AccountStateEntity AccountStateEntity.parse(byte[])"})
  public void testParse_whenArrayOfByteWithAAndTwo_thenReturnNull2() {
    // Arrange, Act and Assert
    assertNull(
        AccountStateEntity.parse(
            new byte[] {'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 'A', 'A', 2, 'A', 2, 'A', 2}));
  }

  /**
   * Test {@link AccountStateEntity#parse(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code *} and two.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AccountStateEntity#parse(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AccountStateEntity AccountStateEntity.parse(byte[])"})
  public void testParse_whenArrayOfByteWithAsteriskAndTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        AccountStateEntity.parse(
            new byte[] {'*', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2}));
  }

  /**
   * Test {@link AccountStateEntity#parse(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code *} and zero.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AccountStateEntity#parse(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AccountStateEntity AccountStateEntity.parse(byte[])"})
  public void testParse_whenArrayOfByteWithAsteriskAndZero_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(AccountStateEntity.parse(new byte[] {'*', 0, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link AccountStateEntity#parse(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with lf and two.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AccountStateEntity#parse(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AccountStateEntity AccountStateEntity.parse(byte[])"})
  public void testParse_whenArrayOfByteWithLfAndTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        AccountStateEntity.parse(
            new byte[] {'\n', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2}));
  }

  /**
   * Test {@link AccountStateEntity#parse(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with lf and zero.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AccountStateEntity#parse(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AccountStateEntity AccountStateEntity.parse(byte[])"})
  public void testParse_whenArrayOfByteWithLfAndZero_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(AccountStateEntity.parse(new byte[] {'\n', 0, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link AccountStateEntity#parse(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@link Byte#MIN_VALUE} and {@code X}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AccountStateEntity#parse(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AccountStateEntity AccountStateEntity.parse(byte[])"})
  public void testParse_whenArrayOfByteWithMin_valueAndX_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        AccountStateEntity.parse(new byte[] {Byte.MIN_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link AccountStateEntity#parse(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AccountStateEntity#parse(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AccountStateEntity AccountStateEntity.parse(byte[])"})
  public void testParse_whenArrayOfByteWithMinusOneAndX_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(AccountStateEntity.parse(new byte[] {-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link AccountStateEntity#parse(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with sixteen and {@code X}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AccountStateEntity#parse(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AccountStateEntity AccountStateEntity.parse(byte[])"})
  public void testParse_whenArrayOfByteWithSixteenAndX_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(AccountStateEntity.parse(new byte[] {16, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link AccountStateEntity#parse(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and two.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AccountStateEntity#parse(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AccountStateEntity AccountStateEntity.parse(byte[])"})
  public void testParse_whenArrayOfByteWithTwentySixAndTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        AccountStateEntity.parse(
            new byte[] {26, 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2}));
  }

  /**
   * Test {@link AccountStateEntity#parse(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and {@code X}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AccountStateEntity#parse(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AccountStateEntity AccountStateEntity.parse(byte[])"})
  public void testParse_whenArrayOfByteWithTwentySixAndX_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(AccountStateEntity.parse(new byte[] {26, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link AccountStateEntity#parse(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and zero.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AccountStateEntity#parse(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AccountStateEntity AccountStateEntity.parse(byte[])"})
  public void testParse_whenArrayOfByteWithTwentySixAndZero_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(AccountStateEntity.parse(new byte[] {26, 0, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link AccountStateEntity#parse(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AccountStateEntity#parse(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AccountStateEntity AccountStateEntity.parse(byte[])"})
  public void testParse_whenAxaxaxaxBytesIsUtf8_thenReturnNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(AccountStateEntity.parse("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link AccountStateEntity#parse(byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return toByteArrays is empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link AccountStateEntity#parse(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AccountStateEntity AccountStateEntity.parse(byte[])"})
  public void testParse_whenEmptyArrayOfByte_thenReturnToByteArraysIsEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {}, AccountStateEntity.parse(new byte[] {}).toByteArrays());
  }

  /**
   * Test {@link AccountStateEntity#parse(byte[])}.
   *
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AccountStateEntity#parse(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AccountStateEntity AccountStateEntity.parse(byte[])"})
  public void testParse_whenXaxaxaxBytesIsUtf8_thenReturnNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(AccountStateEntity.parse("\nXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link AccountStateEntity#parse(byte[])}.
   *
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AccountStateEntity#parse(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AccountStateEntity AccountStateEntity.parse(byte[])"})
  public void testParse_whenXaxaxaxBytesIsUtf8_thenReturnNull2()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(AccountStateEntity.parse(" XAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link AccountStateEntity#parse(byte[])}.
   *
   * <ul>
   *   <li>When {@code *XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AccountStateEntity#parse(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AccountStateEntity AccountStateEntity.parse(byte[])"})
  public void testParse_whenXaxaxaxBytesIsUtf8_thenReturnNull3()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(AccountStateEntity.parse("*XAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link AccountStateEntity#parse(byte[])}.
   *
   * <ul>
   *   <li>When {@code :XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AccountStateEntity#parse(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AccountStateEntity AccountStateEntity.parse(byte[])"})
  public void testParse_whenXaxaxaxBytesIsUtf8_thenReturnNull4()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(AccountStateEntity.parse(":XAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link AccountStateEntity#parse(byte[])}.
   *
   * <ul>
   *   <li>When {@code XXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AccountStateEntity#parse(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AccountStateEntity AccountStateEntity.parse(byte[])"})
  public void testParse_whenXxaxaxaxBytesIsUtf8_thenReturnNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(AccountStateEntity.parse("XXAXAXAX".getBytes("UTF-8")));
  }
}
