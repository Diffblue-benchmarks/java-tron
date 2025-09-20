package org.tron.common.crypto.zksnark;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BN128FpDiffblueTest {
  /**
   * Test {@link BN128Fp#BN128Fp(Fp, Fp, Fp)}.
   *
   * <p>Method under test: {@link BN128Fp#BN128Fp(Fp, Fp, Fp)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BN128Fp.<init>(Fp, Fp, Fp)"})
  public void testNewBN128Fp() {
    // Arrange and Act
    BN128Fp actualBn128Fp = new BN128Fp(Fp.NON_RESIDUE, Fp.NON_RESIDUE, Fp.NON_RESIDUE);

    // Assert
    BigInteger bigInteger = actualBn128Fp.b().v;
    assertEquals("3", bigInteger.toString());
    assertEquals(0, bigInteger.getLowestSetBit());
    assertEquals(1, bigInteger.signum());
    assertArrayEquals(new byte[] {3}, bigInteger.toByteArray());
    assertArrayEquals(
        new byte[] {
          '0', 'd', 'N', 'r', -31, '1', -96, ')', -72, 'P', 'E', -74, -127, -127, 'X', ']', -105,
          -127, 'j', -111, 'h', 'q', -54, -115, '<', ' ', -116, 22, -40, '|', -3, 'F'
        },
        actualBn128Fp.x.bytes());
    assertArrayEquals(
        new byte[] {
          '0', 'd', 'N', 'r', -31, '1', -96, ')', -72, 'P', 'E', -74, -127, -127, 'X', ']', -105,
          -127, 'j', -111, 'h', 'q', -54, -115, '<', ' ', -116, 22, -40, '|', -3, 'F'
        },
        actualBn128Fp.y.bytes());
    assertArrayEquals(
        new byte[] {
          '0', 'd', 'N', 'r', -31, '1', -96, ')', -72, 'P', 'E', -74, -127, -127, 'X', ']', -105,
          -127, 'j', -111, 'h', 'q', -54, -115, '<', ' ', -116, 22, -40, '|', -3, 'F'
        },
        actualBn128Fp.z.bytes());
  }

  /**
   * Test {@link BN128Fp#create(byte[], byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BN128Fp#create(byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BN128 BN128Fp.create(byte[], byte[])"})
  public void testCreate_whenAxaxaxaxBytesIsUtf8_thenReturnNull()
      throws UnsupportedEncodingException {
    // Arrange and Act
    BN128<Fp> actualCreateResult =
        BN128Fp.create("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualCreateResult);
  }

  /**
   * Test {@link BN128Fp#create(byte[], byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BN128Fp#create(byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BN128 BN128Fp.create(byte[], byte[])"})
  public void testCreate_whenEmptyArrayOfByte_thenReturnNull() throws UnsupportedEncodingException {
    // Arrange and Act
    BN128<Fp> actualCreateResult = BN128Fp.create(new byte[] {}, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualCreateResult);
  }

  /**
   * Test {@link BN128Fp#create(byte[], byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then toAffine return {@link BN128Fp}.
   * </ul>
   *
   * <p>Method under test: {@link BN128Fp#create(byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BN128 BN128Fp.create(byte[], byte[])"})
  public void testCreate_whenEmptyArrayOfByte_thenToAffineReturnBN128Fp() {
    // Arrange and Act
    BN128<Fp> actualCreateResult = BN128Fp.create(new byte[] {}, new byte[] {});

    // Assert
    assertTrue(actualCreateResult.toAffine() instanceof BN128Fp);
    assertTrue(actualCreateResult instanceof BN128Fp);
    assertTrue(actualCreateResult.isValid());
    assertTrue(actualCreateResult.isZero());
    Fp fp = actualCreateResult.z;
    assertSame(fp, actualCreateResult.x());
    assertSame(fp, actualCreateResult.y());
    BN128<Fp> bn128 = ((BN128Fp) actualCreateResult).ZERO;
    assertSame(bn128, actualCreateResult.toEthNotation());
    assertSame(bn128, actualCreateResult.zero());
  }

  /**
   * Test {@link BN128Fp#zero()}.
   *
   * <p>Method under test: {@link BN128Fp#zero()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BN128 BN128Fp.zero()"})
  public void testZero() {
    // Arrange
    BN128Fp bn128Fp = new BN128Fp(Fp.NON_RESIDUE, Fp.NON_RESIDUE, Fp.NON_RESIDUE);

    // Act
    BN128<Fp> actualZeroResult = bn128Fp.zero();

    // Assert
    assertSame(((BN128Fp) actualZeroResult).ZERO, actualZeroResult);
  }

  /**
   * Test {@link BN128Fp#instance(Fp, Fp, Fp)} with {@code Fp}, {@code Fp}, {@code Fp}.
   *
   * <p>Method under test: {@link BN128Fp#instance(Fp, Fp, Fp)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BN128 BN128Fp.instance(Fp, Fp, Fp)"})
  public void testInstanceWithFpFpFp() {
    // Arrange
    BN128Fp bn128Fp = new BN128Fp(Fp.NON_RESIDUE, Fp.NON_RESIDUE, Fp.NON_RESIDUE);

    // Act
    BN128<Fp> actualInstanceResult =
        bn128Fp.instance(Fp.NON_RESIDUE, Fp.NON_RESIDUE, Fp.NON_RESIDUE);

    // Assert
    assertTrue(actualInstanceResult.toAffine() instanceof BN128Fp);
    assertTrue(actualInstanceResult.toEthNotation() instanceof BN128Fp);
    BN128<Fp> zeroResult = actualInstanceResult.zero();
    assertTrue(zeroResult instanceof BN128Fp);
    assertTrue(actualInstanceResult instanceof BN128Fp);
    assertFalse(actualInstanceResult.isValid());
    assertFalse(actualInstanceResult.isZero());
    Fp fp = actualInstanceResult.z;
    assertSame(fp, actualInstanceResult.x());
    assertSame(fp, actualInstanceResult.y());
    assertSame(((BN128Fp) actualInstanceResult).ZERO, zeroResult);
    assertSame(Fp._1, actualInstanceResult.one());
  }

  /**
   * Test {@link BN128Fp#b()}.
   *
   * <p>Method under test: {@link BN128Fp#b()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Fp BN128Fp.b()"})
  public void testB() {
    // Arrange
    BN128Fp bn128Fp = new BN128Fp(Fp.NON_RESIDUE, Fp.NON_RESIDUE, Fp.NON_RESIDUE);

    // Act
    Fp actualBResult = bn128Fp.b();

    // Assert
    Fp fp = Fp.NON_RESIDUE;
    assertSame(fp, bn128Fp.x());
    assertSame(fp, bn128Fp.y());
    assertSame(Fp._1, bn128Fp.one());
    assertArrayEquals(new byte[] {3}, actualBResult.bytes());
  }

  /**
   * Test {@link BN128Fp#one()}.
   *
   * <p>Method under test: {@link BN128Fp#one()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Fp BN128Fp.one()"})
  public void testOne() {
    // Arrange
    BN128Fp bn128Fp = new BN128Fp(Fp.NON_RESIDUE, Fp.NON_RESIDUE, Fp.NON_RESIDUE);

    // Act
    Fp actualOneResult = bn128Fp.one();

    // Assert
    Fp fp = Fp.NON_RESIDUE;
    assertSame(fp, bn128Fp.x());
    assertSame(fp, bn128Fp.y());
    assertSame(Fp._1, actualOneResult);
    assertArrayEquals(new byte[] {1}, actualOneResult.bytes());
  }
}
