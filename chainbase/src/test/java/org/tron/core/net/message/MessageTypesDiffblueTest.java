package org.tron.core.net.message;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class MessageTypesDiffblueTest {
  /**
   * Test {@link MessageTypes#fromByte(byte)}.
   * <p>
   * Method under test: {@link MessageTypes#fromByte(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MessageTypes MessageTypes.fromByte(byte)"})
  public void testFromByte() {
    // Arrange, Act and Assert
    assertNull(MessageTypes.fromByte((byte) 'A'));
  }

  /**
   * Test {@link MessageTypes#inRange(byte)}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageTypes#inRange(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MessageTypes.inRange(byte)"})
  public void testInRange_whenA_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(MessageTypes.inRange((byte) 'A'));
  }

  /**
   * Test {@link MessageTypes#inRange(byte)}.
   * <ul>
   *   <li>When {@link Byte#MIN_VALUE}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageTypes#inRange(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MessageTypes.inRange(byte)"})
  public void testInRange_whenMin_value_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(MessageTypes.inRange(Byte.MIN_VALUE));
  }

  /**
   * Test {@link MessageTypes#inP2pRange(byte)}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageTypes#inP2pRange(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MessageTypes.inP2pRange(byte)"})
  public void testInP2pRange_whenA_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(MessageTypes.inP2pRange((byte) 'A'));
  }

  /**
   * Test {@link MessageTypes#inP2pRange(byte)}.
   * <ul>
   *   <li>When {@code #}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageTypes#inP2pRange(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MessageTypes.inP2pRange(byte)"})
  public void testInP2pRange_whenNumberSign_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(MessageTypes.inP2pRange((byte) '#'));
  }

  /**
   * Test {@link MessageTypes#inP2pRange(byte)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageTypes#inP2pRange(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MessageTypes.inP2pRange(byte)"})
  public void testInP2pRange_whenZero_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(MessageTypes.inP2pRange((byte) 0));
  }

  /**
   * Test {@link MessageTypes#inTronRange(byte)}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageTypes#inTronRange(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MessageTypes.inTronRange(byte)"})
  public void testInTronRange_whenA_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(MessageTypes.inTronRange((byte) 'A'));
  }

  /**
   * Test {@link MessageTypes#inTronRange(byte)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageTypes#inTronRange(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MessageTypes.inTronRange(byte)"})
  public void testInTronRange_whenMinusOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(MessageTypes.inTronRange((byte) -1));
  }

  /**
   * Test {@link MessageTypes#inTronRange(byte)}.
   * <ul>
   *   <li>When twenty.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageTypes#inTronRange(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MessageTypes.inTronRange(byte)"})
  public void testInTronRange_whenTwenty_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(MessageTypes.inTronRange((byte) 20));
  }

  /**
   * Test {@link MessageTypes#asByte()}.
   * <p>
   * Method under test: {@link MessageTypes#asByte()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte MessageTypes.asByte()"})
  public void testAsByte() {
    // Arrange, Act and Assert
    assertEquals((byte) 0, MessageTypes.FIRST.asByte());
  }

  /**
   * Test {@link MessageTypes#inPbftRange(byte)}.
   * <ul>
   *   <li>When {@code 4}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageTypes#inPbftRange(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MessageTypes.inPbftRange(byte)"})
  public void testInPbftRange_when4_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(MessageTypes.inPbftRange((byte) '4'));
  }

  /**
   * Test {@link MessageTypes#inPbftRange(byte)}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageTypes#inPbftRange(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MessageTypes.inPbftRange(byte)"})
  public void testInPbftRange_whenA_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(MessageTypes.inPbftRange((byte) 'A'));
  }

  /**
   * Test {@link MessageTypes#toString()}.
   * <ul>
   *   <li>Given {@code BLOCK}.</li>
   *   <li>Then return {@code BLOCK}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageTypes#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String MessageTypes.toString()"})
  public void testToString_givenBlock_thenReturnBlock() {
    // Arrange, Act and Assert
    assertEquals("BLOCK", MessageTypes.BLOCK.toString());
  }

  /**
   * Test {@link MessageTypes#toString()}.
   * <ul>
   *   <li>Given {@code FETCH_INV_DATA}.</li>
   *   <li>Then return {@code FETCH_INV_DATA}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageTypes#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String MessageTypes.toString()"})
  public void testToString_givenFetchInvData_thenReturnFetchInvData() {
    // Arrange, Act and Assert
    assertEquals("FETCH_INV_DATA", MessageTypes.FETCH_INV_DATA.toString());
  }

  /**
   * Test {@link MessageTypes#toString()}.
   * <ul>
   *   <li>Given {@code FIRST}.</li>
   *   <li>Then return {@code FIRST}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageTypes#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String MessageTypes.toString()"})
  public void testToString_givenFirst_thenReturnFirst() {
    // Arrange, Act and Assert
    assertEquals("FIRST", MessageTypes.FIRST.toString());
  }

  /**
   * Test {@link MessageTypes#toString()}.
   * <ul>
   *   <li>Given {@code INVENTORY}.</li>
   *   <li>Then return {@code INVENTORY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageTypes#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String MessageTypes.toString()"})
  public void testToString_givenInventory_thenReturnInventory() {
    // Arrange, Act and Assert
    assertEquals("INVENTORY", MessageTypes.INVENTORY.toString());
  }

  /**
   * Test {@link MessageTypes#toString()}.
   * <ul>
   *   <li>Given {@code SYNC_BLOCK_CHAIN}.</li>
   *   <li>Then return {@code SYNC_BLOCK_CHAIN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageTypes#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String MessageTypes.toString()"})
  public void testToString_givenSyncBlockChain_thenReturnSyncBlockChain() {
    // Arrange, Act and Assert
    assertEquals("SYNC_BLOCK_CHAIN", MessageTypes.SYNC_BLOCK_CHAIN.toString());
  }

  /**
   * Test {@link MessageTypes#toString()}.
   * <ul>
   *   <li>Given {@code TRX}.</li>
   *   <li>Then return {@code TRX}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageTypes#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String MessageTypes.toString()"})
  public void testToString_givenTrx_thenReturnTrx() {
    // Arrange, Act and Assert
    assertEquals("TRX", MessageTypes.TRX.toString());
  }
}
