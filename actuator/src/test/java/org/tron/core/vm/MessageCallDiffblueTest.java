package org.tron.core.vm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.runtime.vm.DataWord;

public class MessageCallDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return OutDataOffs is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MessageCall#MessageCall(int, DataWord, DataWord, DataWord, DataWord, DataWord,
   *       DataWord, boolean)}
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MessageCall.<init>(int, DataWord, DataWord, DataWord, DataWord, DataWord, DataWord, DataWord, DataWord, boolean)",
    "void MessageCall.<init>(int, DataWord, DataWord, DataWord, DataWord, DataWord, DataWord, boolean)",
    "DataWord MessageCall.getCodeAddress()",
    "DataWord MessageCall.getEndowment()",
    "DataWord MessageCall.getEnergy()",
    "DataWord MessageCall.getInDataOffs()",
    "DataWord MessageCall.getInDataSize()",
    "int MessageCall.getOpCode()",
    "DataWord MessageCall.getOutDataOffs()",
    "DataWord MessageCall.getOutDataSize()",
    "DataWord MessageCall.getTokenId()",
    "boolean MessageCall.isTokenTransferMsg()"
  })
  public void testGettersAndSetters_thenReturnOutDataOffsIsNull() {
    // Arrange
    DataWord energy = DataWord.ZERO();
    DataWord codeAddress = DataWord.ZERO();
    DataWord endowment = DataWord.ZERO();
    DataWord inDataOffs = DataWord.ZERO();
    DataWord inDataSize = DataWord.ZERO();
    DataWord tokenId = DataWord.ZERO();

    // Act
    MessageCall actualMessageCall =
        new MessageCall(1, energy, codeAddress, endowment, inDataOffs, inDataSize, tokenId, true);
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

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return OutDataOffs is ZERO.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MessageCall#MessageCall(int, DataWord, DataWord, DataWord, DataWord, DataWord,
   *       DataWord, DataWord, DataWord, boolean)}
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MessageCall.<init>(int, DataWord, DataWord, DataWord, DataWord, DataWord, DataWord, DataWord, DataWord, boolean)",
    "void MessageCall.<init>(int, DataWord, DataWord, DataWord, DataWord, DataWord, DataWord, boolean)",
    "DataWord MessageCall.getCodeAddress()",
    "DataWord MessageCall.getEndowment()",
    "DataWord MessageCall.getEnergy()",
    "DataWord MessageCall.getInDataOffs()",
    "DataWord MessageCall.getInDataSize()",
    "int MessageCall.getOpCode()",
    "DataWord MessageCall.getOutDataOffs()",
    "DataWord MessageCall.getOutDataSize()",
    "DataWord MessageCall.getTokenId()",
    "boolean MessageCall.isTokenTransferMsg()"
  })
  public void testGettersAndSetters_thenReturnOutDataOffsIsZero() {
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
    MessageCall actualMessageCall =
        new MessageCall(
            1,
            energy,
            codeAddress,
            endowment,
            inDataOffs,
            inDataSize,
            outDataOffs,
            outDataSize,
            tokenId,
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
}
