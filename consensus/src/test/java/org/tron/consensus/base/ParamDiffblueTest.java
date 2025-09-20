package org.tron.consensus.base;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.consensus.base.Param.Miner;

public class ParamDiffblueTest {
  /**
   * Test {@link Param#getMiner()}.
   *
   * <p>Method under test: {@link Param#getMiner()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Miner Param.getMiner()"})
  public void testGetMiner() throws UnsupportedEncodingException {
    // Arrange
    ArrayList<Miner> miners = new ArrayList<>();
    Miner miner =
        Param.getInstance()
        .new Miner("AXAXAXAX".getBytes("UTF-8"), mock(ByteString.class), mock(ByteString.class));
    miners.add(miner);

    Param instance = Param.getInstance();
    instance.setMiners(miners);

    // Act
    Miner actualMiner = instance.getMiner();

    // Assert
    assertSame(miner, actualMiner);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualMiner.getPrivateKey());
  }

  /**
   * Test Miner getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Miner#Miner(Param, byte[], ByteString, ByteString)}
   *   <li>{@link Miner#setPrivateKey(byte[])}
   *   <li>{@link Miner#setPrivateKeyAddress(ByteString)}
   *   <li>{@link Miner#setWitnessAddress(ByteString)}
   *   <li>{@link Miner#getPrivateKey()}
   *   <li>{@link Miner#getPrivateKeyAddress()}
   *   <li>{@link Miner#getWitnessAddress()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void Miner.<init>(Param, byte[], ByteString, ByteString)",
    "byte[] Miner.getPrivateKey()",
    "ByteString Miner.getPrivateKeyAddress()",
    "ByteString Miner.getWitnessAddress()",
    "void Miner.setPrivateKey(byte[])",
    "void Miner.setPrivateKeyAddress(ByteString)",
    "void Miner.setWitnessAddress(ByteString)"
  })
  public void testMinerGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange and Act
    Miner actualMiner = Param.getInstance().new Miner("AXAXAXAX".getBytes("UTF-8"), null, null);
    byte[] privateKey = "AXAXAXAX".getBytes("UTF-8");
    actualMiner.setPrivateKey(privateKey);
    actualMiner.setPrivateKeyAddress(null);
    actualMiner.setWitnessAddress(null);
    byte[] actualPrivateKey = actualMiner.getPrivateKey();
    ByteString actualPrivateKeyAddress = actualMiner.getPrivateKeyAddress();

    // Assert
    assertNull(actualPrivateKeyAddress);
    assertNull(actualMiner.getWitnessAddress());
    assertSame(privateKey, actualPrivateKey);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualPrivateKey);
  }
}
