package org.tron.common.zksnark;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.common.zksnark.JLibsodiumParam.Black2bSaltPersonalParams;
import org.tron.common.zksnark.JLibsodiumParam.Blake2bFinalParams;
import org.tron.common.zksnark.JLibsodiumParam.Blake2bInitSaltPersonalParams;
import org.tron.common.zksnark.JLibsodiumParam.Blake2bUpdateParams;
import org.tron.core.exception.ZksnarkException;

public class JLibsodiumParamDiffblueTest {
  /**
   * Test Black2bSaltPersonalParams {@link
   * Black2bSaltPersonalParams#Black2bSaltPersonalParams(byte[], int, byte[], long, byte[], int,
   * byte[], byte[])}.
   *
   * <p>Method under test: {@link Black2bSaltPersonalParams#Black2bSaltPersonalParams(byte[], int,
   * byte[], long, byte[], int, byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void Black2bSaltPersonalParams.<init>(byte[], int, byte[], long, byte[], int, byte[], byte[])"
  })
  public void testBlack2bSaltPersonalParamsNewBlack2bSaltPersonalParams()
      throws UnsupportedEncodingException, ZksnarkException {
    // Arrange, Act and Assert
    assertThrows(
        ZksnarkException.class,
        () ->
            new Black2bSaltPersonalParams(
                "AXAXAXAX".getBytes("UTF-8"),
                3,
                "AXAXAXAX".getBytes("UTF-8"),
                3L,
                "AXAXAXAX".getBytes("UTF-8"),
                3,
                "AXAXAXAX".getBytes("UTF-8"),
                "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test Black2bSaltPersonalParams {@link
   * Black2bSaltPersonalParams#Black2bSaltPersonalParams(byte[], int, byte[], long, byte[], int,
   * byte[], byte[])}.
   *
   * <p>Method under test: {@link Black2bSaltPersonalParams#Black2bSaltPersonalParams(byte[], int,
   * byte[], long, byte[], int, byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void Black2bSaltPersonalParams.<init>(byte[], int, byte[], long, byte[], int, byte[], byte[])"
  })
  public void testBlack2bSaltPersonalParamsNewBlack2bSaltPersonalParams2()
      throws UnsupportedEncodingException, ZksnarkException {
    // Arrange, Act and Assert
    assertThrows(
        ZksnarkException.class,
        () ->
            new Black2bSaltPersonalParams(
                "AXAXAXAX".getBytes("UTF-8"),
                8,
                "AXAXAXAX".getBytes("UTF-8"),
                3L,
                "AXAXAXAX".getBytes("UTF-8"),
                3,
                "AXAXAXAX".getBytes("UTF-8"),
                "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test Blake2bFinalParams {@link Blake2bFinalParams#Blake2bFinalParams(long, byte[], int)}.
   *
   * <ul>
   *   <li>When eight.
   *   <li>Then throw {@link ZksnarkException}.
   * </ul>
   *
   * <p>Method under test: {@link Blake2bFinalParams#Blake2bFinalParams(long, byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Blake2bFinalParams.<init>(long, byte[], int)"})
  public void testBlake2bFinalParamsNewBlake2bFinalParams_whenEight_thenThrowZksnarkException()
      throws UnsupportedEncodingException, ZksnarkException {
    // Arrange, Act and Assert
    assertThrows(
        ZksnarkException.class, () -> new Blake2bFinalParams(1L, "AXAXAXAX".getBytes("UTF-8"), 8));
  }

  /**
   * Test Blake2bFinalParams {@link Blake2bFinalParams#Blake2bFinalParams(long, byte[], int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then throw {@link ZksnarkException}.
   * </ul>
   *
   * <p>Method under test: {@link Blake2bFinalParams#Blake2bFinalParams(long, byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Blake2bFinalParams.<init>(long, byte[], int)"})
  public void testBlake2bFinalParamsNewBlake2bFinalParams_whenOne_thenThrowZksnarkException()
      throws UnsupportedEncodingException, ZksnarkException {
    // Arrange, Act and Assert
    assertThrows(
        ZksnarkException.class, () -> new Blake2bFinalParams(1L, "AXAXAXAX".getBytes("UTF-8"), 3));
  }

  /**
   * Test Blake2bInitSaltPersonalParams {@link
   * Blake2bInitSaltPersonalParams#Blake2bInitSaltPersonalParams(long, byte[], int, int, byte[],
   * byte[])}.
   *
   * <p>Method under test: {@link Blake2bInitSaltPersonalParams#Blake2bInitSaltPersonalParams(long,
   * byte[], int, int, byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void Blake2bInitSaltPersonalParams.<init>(long, byte[], int, int, byte[], byte[])"
  })
  public void testBlake2bInitSaltPersonalParamsNewBlake2bInitSaltPersonalParams()
      throws UnsupportedEncodingException, ZksnarkException {
    // Arrange and Act
    Blake2bInitSaltPersonalParams actualBlake2bInitSaltPersonalParams =
        new Blake2bInitSaltPersonalParams(
            1L,
            "AXAXAXAX".getBytes("UTF-8"),
            3,
            3,
            "AXAXAXAX".getBytes("UTF-8"),
            new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Assert
    assertEquals(1L, actualBlake2bInitSaltPersonalParams.getState());
    assertEquals(3, actualBlake2bInitSaltPersonalParams.getKeyLen());
    assertEquals(3, actualBlake2bInitSaltPersonalParams.getOutLen());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualBlake2bInitSaltPersonalParams.getKey());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualBlake2bInitSaltPersonalParams.getSalt());
    assertArrayEquals(
        new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1},
        actualBlake2bInitSaltPersonalParams.getPersonal());
  }

  /**
   * Test Blake2bUpdateParams {@link Blake2bUpdateParams#Blake2bUpdateParams(long, byte[], long)}.
   *
   * <ul>
   *   <li>When eight.
   * </ul>
   *
   * <p>Method under test: {@link Blake2bUpdateParams#Blake2bUpdateParams(long, byte[], long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Blake2bUpdateParams.<init>(long, byte[], long)"})
  public void testBlake2bUpdateParamsNewBlake2bUpdateParams_whenEight()
      throws UnsupportedEncodingException, ZksnarkException {
    // Arrange, Act and Assert
    assertThrows(
        ZksnarkException.class,
        () -> new Blake2bUpdateParams(1L, "AXAXAXAX".getBytes("UTF-8"), 8L));
  }

  /**
   * Test Blake2bUpdateParams {@link Blake2bUpdateParams#Blake2bUpdateParams(long, byte[], long)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then throw {@link ZksnarkException}.
   * </ul>
   *
   * <p>Method under test: {@link Blake2bUpdateParams#Blake2bUpdateParams(long, byte[], long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Blake2bUpdateParams.<init>(long, byte[], long)"})
  public void testBlake2bUpdateParamsNewBlake2bUpdateParams_whenOne_thenThrowZksnarkException()
      throws UnsupportedEncodingException, ZksnarkException {
    // Arrange, Act and Assert
    assertThrows(
        ZksnarkException.class,
        () -> new Blake2bUpdateParams(1L, "AXAXAXAX".getBytes("UTF-8"), 3L));
  }

  /**
   * Test {@link JLibsodiumParam#validNull(byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then throw {@link ZksnarkException}.
   * </ul>
   *
   * <p>Method under test: {@link JLibsodiumParam#validNull(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JLibsodiumParam.validNull(byte[])"})
  public void testValidNull_whenEmptyArrayOfByte_thenThrowZksnarkException()
      throws ZksnarkException {
    // Arrange, Act and Assert
    assertThrows(ZksnarkException.class, () -> JLibsodiumParam.validNull(new byte[] {}));
  }

  /**
   * Test {@link JLibsodiumParam#validNull(byte[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link ZksnarkException}.
   * </ul>
   *
   * <p>Method under test: {@link JLibsodiumParam#validNull(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JLibsodiumParam.validNull(byte[])"})
  public void testValidNull_whenNull_thenThrowZksnarkException() throws ZksnarkException {
    // Arrange, Act and Assert
    assertThrows(ZksnarkException.class, () -> JLibsodiumParam.validNull(null));
  }

  /**
   * Test {@link JLibsodiumParam#validValueParams(long)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then throw {@link ZksnarkException}.
   * </ul>
   *
   * <p>Method under test: {@link JLibsodiumParam#validValueParams(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JLibsodiumParam.validValueParams(long)"})
  public void testValidValueParams_whenMinusOne_thenThrowZksnarkException()
      throws ZksnarkException {
    // Arrange, Act and Assert
    assertThrows(ZksnarkException.class, () -> JLibsodiumParam.validValueParams(-1L));
  }

  /**
   * Test {@link JLibsodiumParam#validParamLength(byte[], int)}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then throw {@link ZksnarkException}.
   * </ul>
   *
   * <p>Method under test: {@link JLibsodiumParam#validParamLength(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JLibsodiumParam.validParamLength(byte[], int)"})
  public void testValidParamLength_whenAxaxaxaxBytesIsUtf8_thenThrowZksnarkException()
      throws UnsupportedEncodingException, ZksnarkException {
    // Arrange, Act and Assert
    assertThrows(
        ZksnarkException.class,
        () -> JLibsodiumParam.validParamLength("AXAXAXAX".getBytes("UTF-8"), 3));
  }

  /**
   * Test {@link JLibsodiumParam#validParamLength(byte[], int)}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then throw {@link ZksnarkException}.
   * </ul>
   *
   * <p>Method under test: {@link JLibsodiumParam#validParamLength(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JLibsodiumParam.validParamLength(byte[], int)"})
  public void testValidParamLength_whenEmptyArrayOfByte_thenThrowZksnarkException()
      throws ZksnarkException {
    // Arrange, Act and Assert
    assertThrows(ZksnarkException.class, () -> JLibsodiumParam.validParamLength(new byte[] {}, 3));
  }

  /**
   * Test {@link JLibsodiumParam#validParamLength(byte[], int)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link ZksnarkException}.
   * </ul>
   *
   * <p>Method under test: {@link JLibsodiumParam#validParamLength(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JLibsodiumParam.validParamLength(byte[], int)"})
  public void testValidParamLength_whenNull_thenThrowZksnarkException() throws ZksnarkException {
    // Arrange, Act and Assert
    assertThrows(ZksnarkException.class, () -> JLibsodiumParam.validParamLength(null, 3));
  }
}
