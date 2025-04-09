package org.tron.core.net.message;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.utils.Sha256Hash;
import org.tron.core.exception.P2pException;
import org.tron.core.net.message.adv.FetchInvDataMessage;
import org.tron.core.net.message.adv.InventoryMessage;
import org.tron.core.net.message.sync.ChainInventoryMessage;
import org.tron.core.net.message.sync.SyncBlockChainMessage;

public class TronMessageFactoryDiffblueTest {
  /**
   * Test {@link TronMessageFactory#create(byte[])} with {@code data}.
   * <ul>
   *   <li>Then return {@link SyncBlockChainMessage}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronMessageFactory#create(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TronMessage TronMessageFactory.create(byte[])"})
  public void testCreateWithData_thenReturnSyncBlockChainMessage() throws Exception {
    // Arrange and Act
    TronMessage actualCreateResult = TronMessageFactory
        .create(new byte[]{'\b', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'});

    // Assert
    assertTrue(actualCreateResult instanceof SyncBlockChainMessage);
    assertEquals(MessageTypes.SYNC_BLOCK_CHAIN, actualCreateResult.getType());
    assertTrue(((SyncBlockChainMessage) actualCreateResult).getBlockIds().isEmpty());
    Class<ChainInventoryMessage> expectedAnswerMessage = ChainInventoryMessage.class;
    assertEquals(expectedAnswerMessage, actualCreateResult.getAnswerMessage());
    assertArrayEquals(new byte[]{'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'}, actualCreateResult.getData());
    assertArrayEquals(new byte[]{'\b', 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'},
        actualCreateResult.getSendBytes());
    Sha256Hash messageId = actualCreateResult.getMessageId();
    assertArrayEquals(new byte[]{-49, -99, -28, 'm', -115, '_', -49, 'R', -71, -4, 'X', '^', '<', '\b', -100, -116, 'f',
        -35, -23, 'I', -20, '-', 18, -43, 'e', 3, 17, 'i', -110, 17, '6', -10}, messageId.getBytes());
    assertArrayEquals(new byte[]{0, -49, -99, -28, 'm', -115, '_', -49, 'R', -71, -4, 'X', '^', '<', '\b', -100, -116,
        'f', -35, -23, 'I', -20, '-', 18, -43, 'e', 3, 17, 'i', -110, 17, '6', -10},
        messageId.toBigInteger().toByteArray());
  }

  /**
   * Test {@link TronMessageFactory#create(byte[])} with {@code data}.
   * <ul>
   *   <li>When array of {@code byte} with backspace and one.</li>
   *   <li>Then throw {@link P2pException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronMessageFactory#create(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TronMessage TronMessageFactory.create(byte[])"})
  public void testCreateWithData_whenArrayOfByteWithBackspaceAndOne_thenThrowP2pException() throws Exception {
    // Arrange, Act and Assert
    assertThrows(P2pException.class,
        () -> TronMessageFactory.create(new byte[]{'\b', 1, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link TronMessageFactory#create(byte[])} with {@code data}.
   * <ul>
   *   <li>When array of {@code byte} with one and {@code X}.</li>
   *   <li>Then throw {@link P2pException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronMessageFactory#create(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TronMessage TronMessageFactory.create(byte[])"})
  public void testCreateWithData_whenArrayOfByteWithOneAndX_thenThrowP2pException() throws Exception {
    // Arrange, Act and Assert
    assertThrows(P2pException.class, () -> TronMessageFactory.create(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link TronMessageFactory#create(byte[])} with {@code data}.
   * <ul>
   *   <li>When array of {@code byte} with seven and one.</li>
   *   <li>Then throw {@link P2pException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronMessageFactory#create(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TronMessage TronMessageFactory.create(byte[])"})
  public void testCreateWithData_whenArrayOfByteWithSevenAndOne_thenThrowP2pException() throws Exception {
    // Arrange, Act and Assert
    assertThrows(P2pException.class, () -> TronMessageFactory.create(new byte[]{7, 1, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link TronMessageFactory#create(byte[])} with {@code data}.
   * <ul>
   *   <li>When array of {@code byte} with seven and {@code X}.</li>
   *   <li>Then return {@link FetchInvDataMessage}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronMessageFactory#create(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TronMessage TronMessageFactory.create(byte[])"})
  public void testCreateWithData_whenArrayOfByteWithSevenAndX_thenReturnFetchInvDataMessage() throws Exception {
    // Arrange and Act
    TronMessage actualCreateResult = TronMessageFactory
        .create(new byte[]{7, 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'});

    // Assert
    assertTrue(actualCreateResult instanceof FetchInvDataMessage);
    assertEquals(MessageTypes.FETCH_INV_DATA, actualCreateResult.getType());
    assertSame(
        ((FetchInvDataMessage) actualCreateResult).getInventory()
            .getDefaultInstanceForType()
            .getDefaultInstanceForType(),
        ((FetchInvDataMessage) actualCreateResult).getInventory()
            .getDefaultInstanceForType()
            .getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'}, actualCreateResult.getData());
    assertArrayEquals(new byte[]{7, 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'}, actualCreateResult.getSendBytes());
    Sha256Hash messageId = actualCreateResult.getMessageId();
    assertArrayEquals(new byte[]{-49, -99, -28, 'm', -115, '_', -49, 'R', -71, -4, 'X', '^', '<', '\b', -100, -116, 'f',
        -35, -23, 'I', -20, '-', 18, -43, 'e', 3, 17, 'i', -110, 17, '6', -10}, messageId.getBytes());
    assertArrayEquals(new byte[]{0, -49, -99, -28, 'm', -115, '_', -49, 'R', -71, -4, 'X', '^', '<', '\b', -100, -116,
        'f', -35, -23, 'I', -20, '-', 18, -43, 'e', 3, 17, 'i', -110, 17, '6', -10},
        messageId.toBigInteger().toByteArray());
  }

  /**
   * Test {@link TronMessageFactory#create(byte[])} with {@code data}.
   * <ul>
   *   <li>When array of {@code byte} with six and backspace.</li>
   *   <li>Then throw {@link P2pException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronMessageFactory#create(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TronMessage TronMessageFactory.create(byte[])"})
  public void testCreateWithData_whenArrayOfByteWithSixAndBackspace_thenThrowP2pException() throws Exception {
    // Arrange, Act and Assert
    assertThrows(P2pException.class,
        () -> TronMessageFactory.create(new byte[]{6, '\b', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link TronMessageFactory#create(byte[])} with {@code data}.
   * <ul>
   *   <li>When array of {@code byte} with six and one.</li>
   *   <li>Then throw {@link P2pException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronMessageFactory#create(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TronMessage TronMessageFactory.create(byte[])"})
  public void testCreateWithData_whenArrayOfByteWithSixAndOne_thenThrowP2pException() throws Exception {
    // Arrange, Act and Assert
    assertThrows(P2pException.class, () -> TronMessageFactory.create(new byte[]{6, 1, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link TronMessageFactory#create(byte[])} with {@code data}.
   * <ul>
   *   <li>When array of {@code byte} with six and {@code X}.</li>
   *   <li>Then return {@link InventoryMessage}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronMessageFactory#create(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TronMessage TronMessageFactory.create(byte[])"})
  public void testCreateWithData_whenArrayOfByteWithSixAndX_thenReturnInventoryMessage() throws Exception {
    // Arrange and Act
    TronMessage actualCreateResult = TronMessageFactory
        .create(new byte[]{6, 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'});

    // Assert
    assertTrue(actualCreateResult instanceof InventoryMessage);
    assertEquals(MessageTypes.INVENTORY, actualCreateResult.getType());
    assertSame(
        ((InventoryMessage) actualCreateResult).getInventory().getDefaultInstanceForType().getDefaultInstanceForType(),
        ((InventoryMessage) actualCreateResult).getInventory().getDefaultInstanceForType().getDefaultInstanceForType());
    assertArrayEquals(new byte[]{'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'}, actualCreateResult.getData());
    assertArrayEquals(new byte[]{6, 'X', 'A', 'X', 'A', Byte.MIN_VALUE, 'A', 'X'}, actualCreateResult.getSendBytes());
    Sha256Hash messageId = actualCreateResult.getMessageId();
    assertArrayEquals(new byte[]{-49, -99, -28, 'm', -115, '_', -49, 'R', -71, -4, 'X', '^', '<', '\b', -100, -116, 'f',
        -35, -23, 'I', -20, '-', 18, -43, 'e', 3, 17, 'i', -110, 17, '6', -10}, messageId.getBytes());
    assertArrayEquals(new byte[]{0, -49, -99, -28, 'm', -115, '_', -49, 'R', -71, -4, 'X', '^', '<', '\b', -100, -116,
        'f', -35, -23, 'I', -20, '-', 18, -43, 'e', 3, 17, 'i', -110, 17, '6', -10},
        messageId.toBigInteger().toByteArray());
  }

  /**
   * Test {@link TronMessageFactory#create(byte[])} with {@code data}.
   * <ul>
   *   <li>When array of {@code byte} with six and {@code X}.</li>
   *   <li>Then throw {@link P2pException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronMessageFactory#create(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TronMessage TronMessageFactory.create(byte[])"})
  public void testCreateWithData_whenArrayOfByteWithSixAndX_thenThrowP2pException() throws Exception {
    // Arrange, Act and Assert
    assertThrows(P2pException.class, () -> TronMessageFactory.create(new byte[]{6, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link TronMessageFactory#create(byte[])} with {@code data}.
   * <ul>
   *   <li>When array of {@code byte} with tab and one.</li>
   *   <li>Then throw {@link P2pException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronMessageFactory#create(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TronMessage TronMessageFactory.create(byte[])"})
  public void testCreateWithData_whenArrayOfByteWithTabAndOne_thenThrowP2pException() throws Exception {
    // Arrange, Act and Assert
    assertThrows(P2pException.class,
        () -> TronMessageFactory.create(new byte[]{'\t', 1, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link TronMessageFactory#create(byte[])} with {@code data}.
   * <ul>
   *   <li>When array of {@code byte} with three and {@code X}.</li>
   *   <li>Then throw {@link P2pException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronMessageFactory#create(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TronMessage TronMessageFactory.create(byte[])"})
  public void testCreateWithData_whenArrayOfByteWithThreeAndX_thenThrowP2pException() throws Exception {
    // Arrange, Act and Assert
    assertThrows(P2pException.class, () -> TronMessageFactory.create(new byte[]{3, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link TronMessageFactory#create(byte[])} with {@code data}.
   * <ul>
   *   <li>When array of {@code byte} with two and {@code X}.</li>
   *   <li>Then throw {@link P2pException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronMessageFactory#create(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TronMessage TronMessageFactory.create(byte[])"})
  public void testCreateWithData_whenArrayOfByteWithTwoAndX_thenThrowP2pException() throws Exception {
    // Arrange, Act and Assert
    assertThrows(P2pException.class, () -> TronMessageFactory.create(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link TronMessageFactory#create(byte[])} with {@code data}.
   * <ul>
   *   <li>When array of {@code byte} with zero and {@code X}.</li>
   *   <li>Then throw {@link P2pException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronMessageFactory#create(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TronMessage TronMessageFactory.create(byte[])"})
  public void testCreateWithData_whenArrayOfByteWithZeroAndX_thenThrowP2pException() throws Exception {
    // Arrange, Act and Assert
    assertThrows(P2pException.class, () -> TronMessageFactory.create(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link TronMessageFactory#create(byte[])} with {@code data}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then throw {@link P2pException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronMessageFactory#create(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TronMessage TronMessageFactory.create(byte[])"})
  public void testCreateWithData_whenAxaxaxaxBytesIsUtf8_thenThrowP2pException() throws Exception {
    // Arrange, Act and Assert
    assertThrows(P2pException.class, () -> TronMessageFactory.create("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link TronMessageFactory#create(byte[])} with {@code data}.
   * <ul>
   *   <li>When backspace.</li>
   *   <li>Then throw {@link P2pException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TronMessageFactory#create(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TronMessage TronMessageFactory.create(byte[])"})
  public void testCreateWithData_whenBackspace_thenThrowP2pException() throws Exception {
    // Arrange, Act and Assert
    assertThrows(P2pException.class,
        () -> TronMessageFactory.create(new byte[]{6, 'X', 'A', 'X', 'A', 'X', 'A', '\b'}));
  }
}
