package org.tron.core.db.accountstate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.tron.protos.Protocol;

public class AccountStateEntityDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AccountStateEntity#AccountStateEntity()}
   *   <li>{@link AccountStateEntity#setAccount(Protocol.Account)}
   *   <li>{@link AccountStateEntity#toString()}
   *   <li>{@link AccountStateEntity#getAccount()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    AccountStateEntity actualAccountStateEntity = new AccountStateEntity();
    Protocol.Account account = Protocol.Account.getDefaultInstance();
    AccountStateEntity actualSetAccountResult = actualAccountStateEntity.setAccount(account);
    String actualToStringResult = actualAccountStateEntity.toString();

    // Assert
    assertEquals("address:3QJmnh; ", actualToStringResult);
    assertSame(actualAccountStateEntity, actualSetAccountResult);
    assertSame(account, actualAccountStateEntity.getAccount());
  }

  /**
   * Method under test: {@link AccountStateEntity#parse(byte[])}
   */
  @Test
  public void testParse() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(AccountStateEntity.parse("AXAXAXAX".getBytes("UTF-8")));
    assertNull(AccountStateEntity.parse(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
    assertNull(AccountStateEntity.parse("\nXAXAXAX".getBytes("UTF-8")));
    assertNull(AccountStateEntity.parse(new byte[]{16, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
    assertNull(AccountStateEntity.parse(new byte[]{26, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
    assertNull(AccountStateEntity.parse(" XAXAXAX".getBytes("UTF-8")));
    assertNull(AccountStateEntity.parse("XXAXAXAX".getBytes("UTF-8")));
    assertNull(AccountStateEntity.parse("*XAXAXAX".getBytes("UTF-8")));
    assertNull(AccountStateEntity.parse(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
    assertNull(AccountStateEntity.parse("2XAXAXAX".getBytes("UTF-8")));
    assertNull(AccountStateEntity.parse(":XAXAXAX".getBytes("UTF-8")));
    assertNull(AccountStateEntity.parse(new byte[]{Byte.MIN_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
    assertNull(AccountStateEntity.parse("@XAXAXAX".getBytes("UTF-8")));
    assertNull(AccountStateEntity.parse(new byte[]{'\n', 2, 'A', 'X', 'A', 'X', 'A', 'X'}));
    assertNull(AccountStateEntity.parse(new byte[]{'\n', 0, 'A', 'X', 'A', 'X', 'A', 'X'}));
    assertNull(AccountStateEntity.parse(new byte[]{26, 2, 'A', 'X', 'A', 'X', 'A', 'X'}));
    assertNull(AccountStateEntity.parse(new byte[]{26, 0, 'A', 'X', 'A', 'X', 'A', 'X'}));
    assertNull(AccountStateEntity.parse(new byte[]{'*', 2, 'A', 'X', 'A', 'X', 'A', 'X'}));
    assertNull(AccountStateEntity.parse(new byte[]{'*', 0, 'A', 'X', 'A', 'X', 'A', 'X'}));
    assertNull(AccountStateEntity.parse(new byte[]{'2', 2, 'A', 'X', 'A', 'X', 'A', 'X'}));
    assertNull(AccountStateEntity.parse(new byte[]{'2', 0, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Method under test: {@link AccountStateEntity#toByteArrays()}
   */
  @Test
  public void testToByteArrays() {
    // Arrange
    AccountStateEntity accountStateEntity = new AccountStateEntity();
    accountStateEntity.setAccount(Protocol.Account.getDefaultInstance());

    // Act and Assert
    assertEquals(0, accountStateEntity.toByteArrays().length);
  }

  /**
   * Method under test: {@link AccountStateEntity#toByteArrays()}
   */
  @Test
  public void testToByteArrays2() {
    // Arrange, Act and Assert
    assertEquals(0, (new AccountStateEntity(Protocol.Account.getDefaultInstance())).toByteArrays().length);
  }

  /**
   * Method under test:
   * {@link AccountStateEntity#AccountStateEntity(Protocol.Account)}
   */
  @Test
  public void testNewAccountStateEntity() {
    // Arrange
    Protocol.Account account = Protocol.Account.getDefaultInstance();

    // Act
    AccountStateEntity actualAccountStateEntity = new AccountStateEntity(account);

    // Assert
    assertEquals(0, actualAccountStateEntity.toByteArrays().length);
    assertEquals(account, actualAccountStateEntity.getAccount());
  }
}
