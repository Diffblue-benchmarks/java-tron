package org.tron.core.zen;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.tron.api.GrpcAPI;
import org.tron.core.exception.ZksnarkException;
import org.tron.core.zen.address.DiversifierT;

public class ShieldedTRC20ParametersBuilderDiffblueTest {
  /**
   * Method under test:
   * {@link ShieldedTRC20ParametersBuilder#getTriggerContractInput(GrpcAPI.ShieldedTRC20Parameters, List, BigInteger, boolean, byte[])}
   */
  @Test
  public void testGetTriggerContractInput() throws UnsupportedEncodingException {
    // Arrange
    ShieldedTRC20ParametersBuilder shieldedTRC20ParametersBuilder = new ShieldedTRC20ParametersBuilder();
    shieldedTRC20ParametersBuilder
        .setShieldedTRC20ParametersType(ShieldedTRC20ParametersBuilder.ShieldedTRC20ParametersType.TRANSFER);
    GrpcAPI.ShieldedTRC20Parameters shieldedTRC20Parameters = GrpcAPI.ShieldedTRC20Parameters.getDefaultInstance();
    ArrayList<GrpcAPI.BytesMessage> spendAuthoritySignature = new ArrayList<>();
    BigInteger value = BigInteger.valueOf(1L);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> shieldedTRC20ParametersBuilder.getTriggerContractInput(shieldedTRC20Parameters, spendAuthoritySignature,
            value, true, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test:
   * {@link ShieldedTRC20ParametersBuilder#getTriggerContractInput(GrpcAPI.ShieldedTRC20Parameters, List, BigInteger, boolean, byte[])}
   */
  @Test
  public void testGetTriggerContractInput2() throws UnsupportedEncodingException {
    // Arrange
    ShieldedTRC20ParametersBuilder shieldedTRC20ParametersBuilder = new ShieldedTRC20ParametersBuilder();
    shieldedTRC20ParametersBuilder
        .setShieldedTRC20ParametersType(ShieldedTRC20ParametersBuilder.ShieldedTRC20ParametersType.MINT);
    GrpcAPI.ShieldedTRC20Parameters shieldedTRC20Parameters = GrpcAPI.ShieldedTRC20Parameters.getDefaultInstance();
    ArrayList<GrpcAPI.BytesMessage> spendAuthoritySignature = new ArrayList<>();
    BigInteger value = BigInteger.valueOf(0L);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> shieldedTRC20ParametersBuilder.getTriggerContractInput(shieldedTRC20Parameters, spendAuthoritySignature,
            value, true, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test:
   * {@link ShieldedTRC20ParametersBuilder#addOutput(byte[], DiversifierT, byte[], long, byte[], byte[])}
   */
  @Test
  public void testAddOutput() throws UnsupportedEncodingException, ZksnarkException {
    // Arrange
    ShieldedTRC20ParametersBuilder shieldedTRC20ParametersBuilder = new ShieldedTRC20ParametersBuilder();
    byte[] ovk = "AXAXAXAX".getBytes("UTF-8");
    DiversifierT d = DiversifierT.random();
    byte[] pkD = "AXAXAXAX".getBytes("UTF-8");
    byte[] r = "AXAXAXAX".getBytes("UTF-8");

    // Act
    shieldedTRC20ParametersBuilder.addOutput(ovk, d, pkD, 42L, r, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(-42L, shieldedTRC20ParametersBuilder.getValueBalance());
  }

  /**
   * Method under test:
   * {@link ShieldedTRC20ParametersBuilder#addOutput(byte[], DiversifierT, byte[], long, byte[], byte[])}
   */
  @Test
  public void testAddOutput2() throws ZksnarkException {
    // Arrange
    ShieldedTRC20ParametersBuilder shieldedTRC20ParametersBuilder = new ShieldedTRC20ParametersBuilder();

    // Act
    shieldedTRC20ParametersBuilder.addOutput(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, DiversifierT.random(),
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 42L, new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        null);

    // Assert
    assertEquals(-42L, shieldedTRC20ParametersBuilder.getValueBalance());
  }

  /**
   * Method under test:
   * {@link ShieldedTRC20ParametersBuilder#ShieldedTRC20ParametersBuilder(String)}
   */
  @Test
  public void testNewShieldedTRC20ParametersBuilder() throws ZksnarkException {
    // Arrange, Act and Assert
    assertThrows(ZksnarkException.class, () -> new ShieldedTRC20ParametersBuilder("Type"));
  }
}
