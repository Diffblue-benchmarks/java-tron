package org.tron.core.db.accountstate;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.protos.Protocol;
import org.tron.protos.Protocol.Account;

public class AccountStateEntityDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AccountStateEntity#AccountStateEntity()}
   *   <li>{@link AccountStateEntity#getAccount()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AccountStateEntity.<init>()", "Account AccountStateEntity.getAccount()",
      "AccountStateEntity AccountStateEntity.setAccount(Account)", "java.lang.String AccountStateEntity.toString()"})
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertNull((new AccountStateEntity()).getAccount());
  }

  /**
   * Test {@link AccountStateEntity#AccountStateEntity(Account)}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then return Account is DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountStateEntity#AccountStateEntity(Account)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AccountStateEntity.<init>(Account)"})
  public void testNewAccountStateEntity_whenDefaultInstance_thenReturnAccountIsDefaultInstance() {
    // Arrange
    Account account = Account.getDefaultInstance();

    // Act
    AccountStateEntity actualAccountStateEntity = new AccountStateEntity(account);

    // Assert
    assertEquals(account, actualAccountStateEntity.getAccount());
    assertArrayEquals(new byte[]{}, actualAccountStateEntity.toByteArrays());
  }

  /**
   * Test {@link AccountStateEntity#parse(byte[])}.
   * <ul>
   *   <li>When {@code 2XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountStateEntity#parse(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountStateEntity AccountStateEntity.parse(byte[])"})
  public void testParse_when2xaxaxaxBytesIsUtf8_thenReturnNull() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(AccountStateEntity.parse("2XAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link AccountStateEntity#parse(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with {@code 2} and two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountStateEntity#parse(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountStateEntity AccountStateEntity.parse(byte[])"})
  public void testParse_whenArrayOfByteWith2AndTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(AccountStateEntity.parse(new byte[]{'2', 2, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link AccountStateEntity#parse(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with {@code 2} and zero.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountStateEntity#parse(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountStateEntity AccountStateEntity.parse(byte[])"})
  public void testParse_whenArrayOfByteWith2AndZero_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(AccountStateEntity.parse(new byte[]{'2', 0, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link AccountStateEntity#parse(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with {@code *} and two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountStateEntity#parse(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountStateEntity AccountStateEntity.parse(byte[])"})
  public void testParse_whenArrayOfByteWithAsteriskAndTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(AccountStateEntity.parse(new byte[]{'*', 2, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link AccountStateEntity#parse(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with {@code *} and zero.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountStateEntity#parse(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountStateEntity AccountStateEntity.parse(byte[])"})
  public void testParse_whenArrayOfByteWithAsteriskAndZero_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(AccountStateEntity.parse(new byte[]{'*', 0, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link AccountStateEntity#parse(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with lf and two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountStateEntity#parse(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountStateEntity AccountStateEntity.parse(byte[])"})
  public void testParse_whenArrayOfByteWithLfAndTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(AccountStateEntity.parse(new byte[]{'\n', 2, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link AccountStateEntity#parse(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with lf and zero.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountStateEntity#parse(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountStateEntity AccountStateEntity.parse(byte[])"})
  public void testParse_whenArrayOfByteWithLfAndZero_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(AccountStateEntity.parse(new byte[]{'\n', 0, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link AccountStateEntity#parse(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with {@link Byte#MIN_VALUE} and {@code X}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountStateEntity#parse(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountStateEntity AccountStateEntity.parse(byte[])"})
  public void testParse_whenArrayOfByteWithMin_valueAndX_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(AccountStateEntity.parse(new byte[]{Byte.MIN_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link AccountStateEntity#parse(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with minus one and {@code X}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountStateEntity#parse(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountStateEntity AccountStateEntity.parse(byte[])"})
  public void testParse_whenArrayOfByteWithMinusOneAndX_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(AccountStateEntity.parse(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link AccountStateEntity#parse(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with sixteen and {@code X}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountStateEntity#parse(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountStateEntity AccountStateEntity.parse(byte[])"})
  public void testParse_whenArrayOfByteWithSixteenAndX_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(AccountStateEntity.parse(new byte[]{16, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link AccountStateEntity#parse(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountStateEntity#parse(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountStateEntity AccountStateEntity.parse(byte[])"})
  public void testParse_whenArrayOfByteWithTwentySixAndTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(AccountStateEntity.parse(new byte[]{26, 2, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link AccountStateEntity#parse(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and {@code X}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountStateEntity#parse(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountStateEntity AccountStateEntity.parse(byte[])"})
  public void testParse_whenArrayOfByteWithTwentySixAndX_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(AccountStateEntity.parse(new byte[]{26, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link AccountStateEntity#parse(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with twenty-six and zero.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountStateEntity#parse(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountStateEntity AccountStateEntity.parse(byte[])"})
  public void testParse_whenArrayOfByteWithTwentySixAndZero_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(AccountStateEntity.parse(new byte[]{26, 0, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link AccountStateEntity#parse(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with two and {@code X}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountStateEntity#parse(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountStateEntity AccountStateEntity.parse(byte[])"})
  public void testParse_whenArrayOfByteWithTwoAndX_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(AccountStateEntity.parse(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link AccountStateEntity#parse(byte[])}.
   * <ul>
   *   <li>When {@code *}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountStateEntity#parse(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountStateEntity AccountStateEntity.parse(byte[])"})
  public void testParse_whenAsterisk_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(AccountStateEntity.parse(new byte[]{16, 'X', '*', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link AccountStateEntity#parse(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountStateEntity#parse(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountStateEntity AccountStateEntity.parse(byte[])"})
  public void testParse_whenAxaxaxaxBytesIsUtf8_thenReturnNull() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(AccountStateEntity.parse("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link AccountStateEntity#parse(byte[])}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return toByteArrays is empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountStateEntity#parse(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountStateEntity AccountStateEntity.parse(byte[])"})
  public void testParse_whenEmptyArrayOfByte_thenReturnToByteArraysIsEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, AccountStateEntity.parse(new byte[]{}).toByteArrays());
  }

  /**
   * Test {@link AccountStateEntity#parse(byte[])}.
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountStateEntity#parse(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountStateEntity AccountStateEntity.parse(byte[])"})
  public void testParse_whenXaxaxaxBytesIsUtf8_thenReturnNull() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(AccountStateEntity.parse("\nXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link AccountStateEntity#parse(byte[])}.
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountStateEntity#parse(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountStateEntity AccountStateEntity.parse(byte[])"})
  public void testParse_whenXaxaxaxBytesIsUtf8_thenReturnNull2() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(AccountStateEntity.parse(" XAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link AccountStateEntity#parse(byte[])}.
   * <ul>
   *   <li>When {@code *XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountStateEntity#parse(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountStateEntity AccountStateEntity.parse(byte[])"})
  public void testParse_whenXaxaxaxBytesIsUtf8_thenReturnNull3() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(AccountStateEntity.parse("*XAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link AccountStateEntity#parse(byte[])}.
   * <ul>
   *   <li>When {@code :XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountStateEntity#parse(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountStateEntity AccountStateEntity.parse(byte[])"})
  public void testParse_whenXaxaxaxBytesIsUtf8_thenReturnNull4() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(AccountStateEntity.parse(":XAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link AccountStateEntity#parse(byte[])}.
   * <ul>
   *   <li>When {@code @XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountStateEntity#parse(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountStateEntity AccountStateEntity.parse(byte[])"})
  public void testParse_whenXaxaxaxBytesIsUtf8_thenReturnNull5() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(AccountStateEntity.parse("@XAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link AccountStateEntity#parse(byte[])}.
   * <ul>
   *   <li>When {@code XXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountStateEntity#parse(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AccountStateEntity AccountStateEntity.parse(byte[])"})
  public void testParse_whenXxaxaxaxBytesIsUtf8_thenReturnNull() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(AccountStateEntity.parse("XXAXAXAX".getBytes("UTF-8")));
  }
}
