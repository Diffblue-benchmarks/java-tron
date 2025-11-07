package org.tron.common.zksnark;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.tron.core.exception.ZksnarkException;

public class JLibsodiumParamDiffblueTest {
  /**
   * Method under test:
   * {@link JLibsodiumParam.Black2bSaltPersonalParams#Black2bSaltPersonalParams(byte[], int, byte[], long, byte[], int, byte[], byte[])}
   */
  @Test
  public void testBlack2bSaltPersonalParamsNewBlack2bSaltPersonalParams()
      throws UnsupportedEncodingException, ZksnarkException {
    // Arrange
    byte[] out = "AXAXAXAX".getBytes("UTF-8");
    byte[] in = "AXAXAXAX".getBytes("UTF-8");
    byte[] key = "AXAXAXAX".getBytes("UTF-8");
    byte[] salt = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(ZksnarkException.class, () -> new JLibsodiumParam.Black2bSaltPersonalParams(out, 3, in, 3L, key, 3,
        salt, "AXAXAXAX".getBytes("UTF-8")));

  }

  /**
   * Method under test:
   * {@link JLibsodiumParam.Black2bSaltPersonalParams#Black2bSaltPersonalParams(byte[], int, byte[], long, byte[], int, byte[], byte[])}
   */
  @Test
  public void testBlack2bSaltPersonalParamsNewBlack2bSaltPersonalParams2()
      throws UnsupportedEncodingException, ZksnarkException {
    // Arrange
    byte[] out = "AXAXAXAX".getBytes("UTF-8");
    byte[] in = "AXAXAXAX".getBytes("UTF-8");
    byte[] key = "AXAXAXAX".getBytes("UTF-8");
    byte[] salt = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(ZksnarkException.class, () -> new JLibsodiumParam.Black2bSaltPersonalParams(out, 8, in, 3L, key, 3,
        salt, "AXAXAXAX".getBytes("UTF-8")));

  }

  /**
   * Method under test:
   * {@link JLibsodiumParam.Blake2bFinalParams#Blake2bFinalParams(long, byte[], int)}
   */
  @Test
  public void testBlake2bFinalParamsNewBlake2bFinalParams() throws UnsupportedEncodingException, ZksnarkException {
    // Arrange, Act and Assert
    assertThrows(ZksnarkException.class,
        () -> new JLibsodiumParam.Blake2bFinalParams(1L, "AXAXAXAX".getBytes("UTF-8"), 3));

    assertThrows(ZksnarkException.class,
        () -> new JLibsodiumParam.Blake2bFinalParams(1L, "AXAXAXAX".getBytes("UTF-8"), 8));
  }

  /**
   * Method under test:
   * {@link JLibsodiumParam.Blake2bInitSaltPersonalParams#Blake2bInitSaltPersonalParams(long, byte[], int, int, byte[], byte[])}
   */
  @Test
  public void testBlake2bInitSaltPersonalParamsNewBlake2bInitSaltPersonalParams()
      throws UnsupportedEncodingException, ZksnarkException {
    // Arrange
    byte[] key = "AXAXAXAX".getBytes("UTF-8");
    byte[] salt = "AXAXAXAX".getBytes("UTF-8");
    byte[] personal = new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1};

    // Act
    JLibsodiumParam.Blake2bInitSaltPersonalParams actualBlake2bInitSaltPersonalParams = new JLibsodiumParam.Blake2bInitSaltPersonalParams(
        1L, key, 3, 3, salt, personal);

    // Assert
    assertEquals(1L, actualBlake2bInitSaltPersonalParams.getState());
    assertEquals(3, actualBlake2bInitSaltPersonalParams.getKeyLen());
    assertEquals(3, actualBlake2bInitSaltPersonalParams.getOutLen());
    assertSame(key, actualBlake2bInitSaltPersonalParams.getKey());
    assertSame(salt, actualBlake2bInitSaltPersonalParams.getSalt());
    assertSame(personal, actualBlake2bInitSaltPersonalParams.getPersonal());
  }

  /**
   * Method under test:
   * {@link JLibsodiumParam.Blake2bUpdateParams#Blake2bUpdateParams(long, byte[], long)}
   */
  @Test
  public void testBlake2bUpdateParamsNewBlake2bUpdateParams() throws UnsupportedEncodingException, ZksnarkException {
    // Arrange, Act and Assert
    assertThrows(ZksnarkException.class,
        () -> new JLibsodiumParam.Blake2bUpdateParams(1L, "AXAXAXAX".getBytes("UTF-8"), 3L));

    assertThrows(ZksnarkException.class,
        () -> new JLibsodiumParam.Blake2bUpdateParams(1L, "AXAXAXAX".getBytes("UTF-8"), 8L));
  }

  /**
   * Method under test: {@link JLibsodiumParam#validNull(byte[])}
   */
  @Test
  public void testValidNull() throws ZksnarkException {
    // Arrange, Act and Assert
    assertThrows(ZksnarkException.class, () -> JLibsodiumParam.validNull(null));
    assertThrows(ZksnarkException.class, () -> JLibsodiumParam.validNull(new byte[]{}));
  }

  /**
   * Method under test: {@link JLibsodiumParam#validValueParams(long)}
   */
  @Test
  public void testValidValueParams() throws ZksnarkException {
    // Arrange, Act and Assert
    assertThrows(ZksnarkException.class, () -> JLibsodiumParam.validValueParams(-1L));
  }

  /**
   * Method under test: {@link JLibsodiumParam#validParamLength(byte[], int)}
   */
  @Test
  public void testValidParamLength() throws UnsupportedEncodingException, ZksnarkException {
    // Arrange, Act and Assert
    assertThrows(ZksnarkException.class, () -> JLibsodiumParam.validParamLength("AXAXAXAX".getBytes("UTF-8"), 3));
    assertThrows(ZksnarkException.class, () -> JLibsodiumParam.validParamLength(null, 3));
    assertThrows(ZksnarkException.class, () -> JLibsodiumParam.validParamLength(new byte[]{}, 3));
  }
}
