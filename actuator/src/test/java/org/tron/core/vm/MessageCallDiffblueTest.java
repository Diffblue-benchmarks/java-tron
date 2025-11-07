package org.tron.core.vm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.tron.common.runtime.vm.DataWord;

public class MessageCallDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link MessageCall#MessageCall(int, DataWord, DataWord, DataWord, DataWord, DataWord, DataWord, DataWord, DataWord, boolean)}
   *   <li>{@link MessageCall#getCodeAddress()}
   *   <li>{@link MessageCall#getEndowment()}
   *   <li>{@link MessageCall#getEnergy()}
   *   <li>{@link MessageCall#getInDataOffs()}
   *   <li>{@link MessageCall#getInDataSize()}
   *   <li>{@link MessageCall#getOpCode()}
   *   <li>{@link MessageCall#getOutDataOffs()}
   *   <li>{@link MessageCall#getOutDataSize()}
   *   <li>{@link MessageCall#getTokenId()}
   *   <li>{@link MessageCall#isTokenTransferMsg()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    DataWord energy = DataWord.ZERO();
    DataWord codeAddress = DataWord.ZERO();
    DataWord endowment = DataWord.ZERO();
    DataWord inDataOffs = DataWord.ZERO();
    DataWord inDataSize = DataWord.ZERO();
    DataWord outDataOffs = DataWord.ZERO();
    DataWord outDataSize = DataWord.ZERO();
    DataWord tokenId = DataWord.ZERO();

    // Act
    MessageCall actualMessageCall = new MessageCall(1, energy, codeAddress, endowment, inDataOffs, inDataSize,
        outDataOffs, outDataSize, tokenId, true);
    DataWord actualCodeAddress = actualMessageCall.getCodeAddress();
    DataWord actualEndowment = actualMessageCall.getEndowment();
    DataWord actualEnergy = actualMessageCall.getEnergy();
    DataWord actualInDataOffs = actualMessageCall.getInDataOffs();
    DataWord actualInDataSize = actualMessageCall.getInDataSize();
    int actualOpCode = actualMessageCall.getOpCode();
    DataWord actualOutDataOffs = actualMessageCall.getOutDataOffs();
    DataWord actualOutDataSize = actualMessageCall.getOutDataSize();
    DataWord actualTokenId = actualMessageCall.getTokenId();

    // Assert
    assertEquals(1, actualOpCode);
    assertTrue(actualMessageCall.isTokenTransferMsg());
    assertSame(codeAddress, actualCodeAddress);
    assertSame(endowment, actualEndowment);
    assertSame(energy, actualEnergy);
    assertSame(inDataOffs, actualInDataOffs);
    assertSame(inDataSize, actualInDataSize);
    assertSame(outDataOffs, actualOutDataOffs);
    assertSame(outDataSize, actualOutDataSize);
    assertSame(tokenId, actualTokenId);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link MessageCall#MessageCall(int, DataWord, DataWord, DataWord, DataWord, DataWord, DataWord, boolean)}
   *   <li>{@link MessageCall#getCodeAddress()}
   *   <li>{@link MessageCall#getEndowment()}
   *   <li>{@link MessageCall#getEnergy()}
   *   <li>{@link MessageCall#getInDataOffs()}
   *   <li>{@link MessageCall#getInDataSize()}
   *   <li>{@link MessageCall#getOpCode()}
   *   <li>{@link MessageCall#getOutDataOffs()}
   *   <li>{@link MessageCall#getOutDataSize()}
   *   <li>{@link MessageCall#getTokenId()}
   *   <li>{@link MessageCall#isTokenTransferMsg()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() {
    // Arrange
    DataWord energy = DataWord.ZERO();
    DataWord codeAddress = DataWord.ZERO();
    DataWord endowment = DataWord.ZERO();
    DataWord inDataOffs = DataWord.ZERO();
    DataWord inDataSize = DataWord.ZERO();
    DataWord tokenId = DataWord.ZERO();

    // Act
    MessageCall actualMessageCall = new MessageCall(1, energy, codeAddress, endowment, inDataOffs, inDataSize, tokenId,
        true);
    DataWord actualCodeAddress = actualMessageCall.getCodeAddress();
    DataWord actualEndowment = actualMessageCall.getEndowment();
    DataWord actualEnergy = actualMessageCall.getEnergy();
    DataWord actualInDataOffs = actualMessageCall.getInDataOffs();
    DataWord actualInDataSize = actualMessageCall.getInDataSize();
    int actualOpCode = actualMessageCall.getOpCode();
    DataWord actualOutDataOffs = actualMessageCall.getOutDataOffs();
    DataWord actualOutDataSize = actualMessageCall.getOutDataSize();
    DataWord actualTokenId = actualMessageCall.getTokenId();

    // Assert
    assertNull(actualOutDataOffs);
    assertNull(actualOutDataSize);
    assertEquals(1, actualOpCode);
    assertTrue(actualMessageCall.isTokenTransferMsg());
    assertSame(codeAddress, actualCodeAddress);
    assertSame(endowment, actualEndowment);
    assertSame(energy, actualEnergy);
    assertSame(inDataOffs, actualInDataOffs);
    assertSame(inDataSize, actualInDataSize);
    assertSame(tokenId, actualTokenId);
  }
}
