package org.tron.core.capsule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.tron.core.exception.BadItemException;
import org.tron.protos.Protocol;
import org.tron.protos.contract.BalanceContract;

public class BlockBalanceTraceCapsuleDiffblueTest {
  /**
   * Method under test: {@link BlockBalanceTraceCapsule#getData()}
   */
  @Test
  public void testGetData() {
    // Arrange, Act and Assert
    assertEquals(0, (new BlockBalanceTraceCapsule()).getData().length);
    assertEquals(0,
        (new BlockBalanceTraceCapsule(BalanceContract.BlockBalanceTrace.getDefaultInstance())).getData().length);
    assertNull((new BlockBalanceTraceCapsule((BalanceContract.BlockBalanceTrace) null)).getData());
    assertArrayEquals(
        new byte[]{'\n', '"', '\n', ' ', 0, 0, 0, 0, 0, 0, 0, 0, -102, -5, -12, -56, -103, 'o', -71, '$', '\'', -82,
            'A', -28, 'd', -101, -109, 'L', -92, -107, -103, 27, 'x', 'R', -72, 'U'},
        (new BlockBalanceTraceCapsule(new BlockCapsule(Protocol.Block.getDefaultInstance()))).getData());
  }

  /**
   * Method under test: {@link BlockBalanceTraceCapsule#getData()}
   */
  @Test
  public void testGetData2() {
    // Arrange
    BlockBalanceTraceCapsule blockBalanceTraceCapsule = new BlockBalanceTraceCapsule();
    blockBalanceTraceCapsule.addTransactionBalanceTrace(BalanceContract.TransactionBalanceTrace.getDefaultInstance());

    // Act and Assert
    assertArrayEquals(new byte[]{26, 0}, blockBalanceTraceCapsule.getData());
  }

  /**
   * Method under test: {@link BlockBalanceTraceCapsule#getTimestamp()}
   */
  @Test
  public void testGetTimestamp() {
    // Arrange, Act and Assert
    assertEquals(0L, (new BlockBalanceTraceCapsule()).getTimestamp());
  }

  /**
   * Method under test: {@link BlockBalanceTraceCapsule#getTransactions()}
   */
  @Test
  public void testGetTransactions() {
    // Arrange, Act and Assert
    assertTrue((new BlockBalanceTraceCapsule()).getTransactions().isEmpty());
  }

  /**
   * Method under test:
   * {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(BalanceContract.BlockBalanceTrace)}
   */
  @Test
  public void testNewBlockBalanceTraceCapsule() {
    // Arrange
    BalanceContract.BlockBalanceTrace blockBalanceTrace = BalanceContract.BlockBalanceTrace.getDefaultInstance();

    // Act and Assert
    assertSame(blockBalanceTrace, (new BlockBalanceTraceCapsule(blockBalanceTrace)).getInstance());
  }

  /**
   * Method under test:
   * {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}
   */
  @Test
  public void testNewBlockBalanceTraceCapsule2() throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new BlockBalanceTraceCapsule("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test:
   * {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}
   */
  @Test
  public void testNewBlockBalanceTraceCapsule3() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new BlockBalanceTraceCapsule(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Method under test:
   * {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}
   */
  @Test
  public void testNewBlockBalanceTraceCapsule4() throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new BlockBalanceTraceCapsule("\nXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test:
   * {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}
   */
  @Test
  public void testNewBlockBalanceTraceCapsule5() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new BlockBalanceTraceCapsule(new byte[]{16, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Method under test:
   * {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}
   */
  @Test
  public void testNewBlockBalanceTraceCapsule6() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new BlockBalanceTraceCapsule(new byte[]{26, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Method under test:
   * {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}
   */
  @Test
  public void testNewBlockBalanceTraceCapsule7() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new BlockBalanceTraceCapsule(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Method under test:
   * {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}
   */
  @Test
  public void testNewBlockBalanceTraceCapsule8() throws UnsupportedEncodingException, BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class, () -> new BlockBalanceTraceCapsule("XXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test:
   * {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}
   */
  @Test
  public void testNewBlockBalanceTraceCapsule9() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new BlockBalanceTraceCapsule(new byte[]{'\n', 2, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Method under test:
   * {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}
   */
  @Test
  public void testNewBlockBalanceTraceCapsule10() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new BlockBalanceTraceCapsule(new byte[]{'\n', 0, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Method under test:
   * {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}
   */
  @Test
  public void testNewBlockBalanceTraceCapsule11() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new BlockBalanceTraceCapsule(new byte[]{16, 'X', 26, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Method under test:
   * {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}
   */
  @Test
  public void testNewBlockBalanceTraceCapsule12() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new BlockBalanceTraceCapsule(new byte[]{26, 2, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Method under test:
   * {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}
   */
  @Test
  public void testNewBlockBalanceTraceCapsule13() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new BlockBalanceTraceCapsule(new byte[]{26, 0, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Method under test:
   * {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}
   */
  @Test
  public void testNewBlockBalanceTraceCapsule14() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new BlockBalanceTraceCapsule(new byte[]{'\n', 2, 2, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Method under test:
   * {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}
   */
  @Test
  public void testNewBlockBalanceTraceCapsule15() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new BlockBalanceTraceCapsule(new byte[]{'\n', 2, '\n', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Method under test:
   * {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}
   */
  @Test
  public void testNewBlockBalanceTraceCapsule16() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new BlockBalanceTraceCapsule(new byte[]{'\n', 2, 16, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Method under test:
   * {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}
   */
  @Test
  public void testNewBlockBalanceTraceCapsule17() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new BlockBalanceTraceCapsule(new byte[]{'\n', 2, 'X', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Method under test:
   * {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}
   */
  @Test
  public void testNewBlockBalanceTraceCapsule18() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new BlockBalanceTraceCapsule(new byte[]{'\n', 0, '\n', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Method under test:
   * {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}
   */
  @Test
  public void testNewBlockBalanceTraceCapsule19() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new BlockBalanceTraceCapsule(new byte[]{18, 2, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Method under test:
   * {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}
   */
  @Test
  public void testNewBlockBalanceTraceCapsule20() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new BlockBalanceTraceCapsule(new byte[]{26, 2, 2, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Method under test:
   * {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}
   */
  @Test
  public void testNewBlockBalanceTraceCapsule21() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new BlockBalanceTraceCapsule(new byte[]{26, 2, '\n', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Method under test:
   * {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}
   */
  @Test
  public void testNewBlockBalanceTraceCapsule22() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new BlockBalanceTraceCapsule(new byte[]{26, 2, 16, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Method under test:
   * {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}
   */
  @Test
  public void testNewBlockBalanceTraceCapsule23() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new BlockBalanceTraceCapsule(new byte[]{26, 2, 26, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Method under test:
   * {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}
   */
  @Test
  public void testNewBlockBalanceTraceCapsule24() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new BlockBalanceTraceCapsule(new byte[]{26, 2, 18, 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Method under test:
   * {@link BlockBalanceTraceCapsule#BlockBalanceTraceCapsule(byte[])}
   */
  @Test
  public void testNewBlockBalanceTraceCapsule25() throws BadItemException {
    // Arrange, Act and Assert
    assertThrows(BadItemException.class,
        () -> new BlockBalanceTraceCapsule(new byte[]{26, 2, '"', 'X', 'A', 'X', 'A', 'X'}));
  }
}
