package org.tron.core.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.cache.Cache;
import com.google.protobuf.ByteString;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.core.capsule.BlockCapsule;
import org.tron.core.capsule.BlockCapsule.BlockId;
import org.tron.core.services.WitnessProductBlockService.CheatWitnessInfo;

@RunWith(MockitoJUnitRunner.class)
public class WitnessProductBlockServiceDiffblueTest {
  @Mock private Cache<Long, BlockCapsule> cache;

  @InjectMocks private WitnessProductBlockService witnessProductBlockService;

  /**
   * Test CheatWitnessInfo {@link CheatWitnessInfo#add(BlockCapsule)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link CheatWitnessInfo} (default constructor) BlockCapsuleSet size is one.
   * </ul>
   *
   * <p>Method under test: {@link CheatWitnessInfo#add(BlockCapsule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CheatWitnessInfo CheatWitnessInfo.add(BlockCapsule)"})
  public void testCheatWitnessInfoAdd_whenNull_thenCheatWitnessInfoBlockCapsuleSetSizeIsOne() {
    // Arrange
    CheatWitnessInfo cheatWitnessInfo = new CheatWitnessInfo();

    // Act
    CheatWitnessInfo actualAddResult = cheatWitnessInfo.add(null);

    // Assert
    assertEquals(1, cheatWitnessInfo.getBlockCapsuleSet().size());
    assertSame(cheatWitnessInfo, actualAddResult);
  }

  /**
   * Test CheatWitnessInfo {@link CheatWitnessInfo#clear()}.
   *
   * <p>Method under test: {@link CheatWitnessInfo#clear()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CheatWitnessInfo CheatWitnessInfo.clear()"})
  public void testCheatWitnessInfoClear() {
    // Arrange
    CheatWitnessInfo cheatWitnessInfo = new CheatWitnessInfo();

    // Act
    CheatWitnessInfo actualClearResult = cheatWitnessInfo.clear();

    // Assert
    assertSame(cheatWitnessInfo, actualClearResult);
  }

  /**
   * Test CheatWitnessInfo {@link CheatWitnessInfo#getBlockCapsuleSet()}.
   *
   * <p>Method under test: {@link CheatWitnessInfo#getBlockCapsuleSet()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Set CheatWitnessInfo.getBlockCapsuleSet()"})
  public void testCheatWitnessInfoGetBlockCapsuleSet() {
    // Arrange, Act and Assert
    assertTrue(new CheatWitnessInfo().getBlockCapsuleSet().isEmpty());
  }

  /**
   * Test CheatWitnessInfo getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CheatWitnessInfo#setLatestBlockNum(long)}
   *   <li>{@link CheatWitnessInfo#setTime(long)}
   *   <li>{@link CheatWitnessInfo#setTimes(AtomicInteger)}
   *   <li>{@link CheatWitnessInfo#toString()}
   *   <li>{@link CheatWitnessInfo#getLatestBlockNum()}
   *   <li>{@link CheatWitnessInfo#getTime()}
   *   <li>{@link CheatWitnessInfo#getTimes()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long CheatWitnessInfo.getLatestBlockNum()",
    "long CheatWitnessInfo.getTime()",
    "AtomicInteger CheatWitnessInfo.getTimes()",
    "CheatWitnessInfo CheatWitnessInfo.setLatestBlockNum(long)",
    "CheatWitnessInfo CheatWitnessInfo.setTime(long)",
    "CheatWitnessInfo CheatWitnessInfo.setTimes(AtomicInteger)",
    "String CheatWitnessInfo.toString()"
  })
  public void testCheatWitnessInfoGettersAndSetters() {
    // Arrange
    CheatWitnessInfo cheatWitnessInfo = new CheatWitnessInfo();

    // Act
    CheatWitnessInfo actualSetLatestBlockNumResult = cheatWitnessInfo.setLatestBlockNum(1L);
    CheatWitnessInfo actualSetTimeResult = cheatWitnessInfo.setTime(10L);
    AtomicInteger times = new AtomicInteger();
    CheatWitnessInfo actualSetTimesResult = cheatWitnessInfo.setTimes(times);
    String actualToStringResult = cheatWitnessInfo.toString();
    long actualLatestBlockNum = cheatWitnessInfo.getLatestBlockNum();
    long actualTime = cheatWitnessInfo.getTime();
    AtomicInteger actualTimes = cheatWitnessInfo.getTimes();

    // Assert
    assertEquals("{times=0, time=10, latestBlockNum=1, blockCapsuleSet=[]}", actualToStringResult);
    assertEquals(10L, actualTime);
    assertEquals(1L, actualLatestBlockNum);
    assertTrue(actualSetLatestBlockNumResult.getBlockCapsuleSet().isEmpty());
    assertSame(times, actualTimes);
    assertSame(cheatWitnessInfo, actualSetLatestBlockNumResult);
    assertSame(cheatWitnessInfo, actualSetTimeResult);
    assertSame(cheatWitnessInfo, actualSetTimesResult);
  }

  /**
   * Test CheatWitnessInfo {@link CheatWitnessInfo#increment()}.
   *
   * <ul>
   *   <li>Given {@link CheatWitnessInfo} (default constructor).
   *   <li>Then return {@link CheatWitnessInfo} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CheatWitnessInfo#increment()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CheatWitnessInfo CheatWitnessInfo.increment()"})
  public void testCheatWitnessInfoIncrement_givenCheatWitnessInfo_thenReturnCheatWitnessInfo() {
    // Arrange
    CheatWitnessInfo cheatWitnessInfo = new CheatWitnessInfo();

    // Act
    CheatWitnessInfo actualIncrementResult = cheatWitnessInfo.increment();

    // Assert
    assertSame(cheatWitnessInfo, actualIncrementResult);
  }

  /**
   * Test CheatWitnessInfo new {@link CheatWitnessInfo} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link CheatWitnessInfo}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CheatWitnessInfo.<init>()"})
  public void testCheatWitnessInfoNewCheatWitnessInfo() {
    // Arrange and Act
    CheatWitnessInfo actualCheatWitnessInfo = new CheatWitnessInfo();

    // Assert
    assertEquals(0, actualCheatWitnessInfo.getTimes().get());
    assertEquals(0L, actualCheatWitnessInfo.getLatestBlockNum());
    assertEquals(0L, actualCheatWitnessInfo.getTime());
    assertTrue(actualCheatWitnessInfo.getBlockCapsuleSet().isEmpty());
  }

  /**
   * Test CheatWitnessInfo {@link CheatWitnessInfo#setBlockCapsuleSet(Set)}.
   *
   * <p>Method under test: {@link CheatWitnessInfo#setBlockCapsuleSet(Set)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CheatWitnessInfo CheatWitnessInfo.setBlockCapsuleSet(Set)"})
  public void testCheatWitnessInfoSetBlockCapsuleSet() {
    // Arrange
    CheatWitnessInfo cheatWitnessInfo = new CheatWitnessInfo();

    // Act
    CheatWitnessInfo actualSetBlockCapsuleSetResult =
        cheatWitnessInfo.setBlockCapsuleSet(new HashSet<>());

    // Assert
    assertSame(cheatWitnessInfo, actualSetBlockCapsuleSetResult);
  }

  /**
   * Test {@link WitnessProductBlockService#validWitnessProductTwoBlock(BlockCapsule)}.
   *
   * <p>Method under test: {@link
   * WitnessProductBlockService#validWitnessProductTwoBlock(BlockCapsule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WitnessProductBlockService.validWitnessProductTwoBlock(BlockCapsule)"})
  public void testValidWitnessProductTwoBlock() {
    // Arrange
    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getWitnessAddress()).thenThrow(new RuntimeException());
    when(cache.getIfPresent(Mockito.<Object>any())).thenReturn(blockCapsule);

    BlockCapsule block = mock(BlockCapsule.class);
    when(block.getNum()).thenReturn(1L);
    when(block.getBlockId()).thenReturn(new BlockId());

    // Act
    witnessProductBlockService.validWitnessProductTwoBlock(block);

    // Assert
    verify(cache).getIfPresent(isA(Object.class));
    verify(block).getBlockId();
    verify(block, atLeast(1)).getNum();
    verify(blockCapsule).getWitnessAddress();
  }

  /**
   * Test {@link WitnessProductBlockService#validWitnessProductTwoBlock(BlockCapsule)}.
   *
   * <ul>
   *   <li>Given {@link BlockCapsule} {@link BlockCapsule#getWitnessAddress()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * WitnessProductBlockService#validWitnessProductTwoBlock(BlockCapsule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WitnessProductBlockService.validWitnessProductTwoBlock(BlockCapsule)"})
  public void testValidWitnessProductTwoBlock_givenBlockCapsuleGetWitnessAddressReturnNull() {
    // Arrange
    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getWitnessAddress()).thenReturn(null);
    when(cache.getIfPresent(Mockito.<Object>any())).thenReturn(blockCapsule);

    BlockCapsule block = mock(BlockCapsule.class);
    when(block.getNum()).thenReturn(1L);
    when(block.getBlockId()).thenReturn(new BlockId());

    // Act
    witnessProductBlockService.validWitnessProductTwoBlock(block);

    // Assert
    verify(cache).getIfPresent(isA(Object.class));
    verify(block).getBlockId();
    verify(block, atLeast(1)).getNum();
    verify(blockCapsule).getWitnessAddress();
  }

  /**
   * Test {@link WitnessProductBlockService#validWitnessProductTwoBlock(BlockCapsule)}.
   *
   * <ul>
   *   <li>Given {@link BlockId}.
   * </ul>
   *
   * <p>Method under test: {@link
   * WitnessProductBlockService#validWitnessProductTwoBlock(BlockCapsule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WitnessProductBlockService.validWitnessProductTwoBlock(BlockCapsule)"})
  public void testValidWitnessProductTwoBlock_givenBlockId() {
    // Arrange
    when(cache.getIfPresent(Mockito.<Object>any())).thenThrow(new RuntimeException());

    BlockCapsule block = mock(BlockCapsule.class);
    when(block.getNum()).thenReturn(1L);
    when(block.getBlockId()).thenReturn(mock(BlockId.class));

    // Act
    witnessProductBlockService.validWitnessProductTwoBlock(block);

    // Assert
    verify(cache).getIfPresent(isA(Object.class));
    verify(block).getBlockId();
    verify(block, atLeast(1)).getNum();
  }

  /**
   * Test {@link WitnessProductBlockService#validWitnessProductTwoBlock(BlockCapsule)}.
   *
   * <ul>
   *   <li>Given {@link Cache} {@link Cache#getIfPresent(Object)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * WitnessProductBlockService#validWitnessProductTwoBlock(BlockCapsule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WitnessProductBlockService.validWitnessProductTwoBlock(BlockCapsule)"})
  public void testValidWitnessProductTwoBlock_givenCacheGetIfPresentThrowRuntimeException() {
    // Arrange
    when(cache.getIfPresent(Mockito.<Object>any())).thenThrow(new RuntimeException());

    BlockCapsule block = mock(BlockCapsule.class);
    when(block.getNum()).thenReturn(1L);
    when(block.getBlockId()).thenReturn(new BlockId());

    // Act
    witnessProductBlockService.validWitnessProductTwoBlock(block);

    // Assert
    verify(cache).getIfPresent(isA(Object.class));
    verify(block).getBlockId();
    verify(block, atLeast(1)).getNum();
  }

  /**
   * Test {@link WitnessProductBlockService#validWitnessProductTwoBlock(BlockCapsule)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * WitnessProductBlockService#validWitnessProductTwoBlock(BlockCapsule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WitnessProductBlockService.validWitnessProductTwoBlock(BlockCapsule)"})
  public void testValidWitnessProductTwoBlock_givenRuntimeException()
      throws UnsupportedEncodingException {
    // Arrange
    ByteString byteString = mock(ByteString.class);
    when(byteString.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getWitnessAddress()).thenReturn(byteString);
    when(cache.getIfPresent(Mockito.<Object>any())).thenReturn(blockCapsule);

    BlockCapsule block = mock(BlockCapsule.class);
    when(block.getWitnessAddress()).thenThrow(new RuntimeException());
    when(block.getNum()).thenReturn(1L);
    when(block.getBlockId()).thenReturn(new BlockId());

    // Act
    witnessProductBlockService.validWitnessProductTwoBlock(block);

    // Assert
    verify(cache).getIfPresent(isA(Object.class));
    verify(byteString).toByteArray();
    verify(block).getBlockId();
    verify(block, atLeast(1)).getNum();
    verify(blockCapsule).getWitnessAddress();
    verify(block).getWitnessAddress();
  }

  /**
   * Test {@link WitnessProductBlockService#validWitnessProductTwoBlock(BlockCapsule)}.
   *
   * <ul>
   *   <li>When {@link BlockCapsule} {@link BlockCapsule#getWitnessAddress()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * WitnessProductBlockService#validWitnessProductTwoBlock(BlockCapsule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WitnessProductBlockService.validWitnessProductTwoBlock(BlockCapsule)"})
  public void testValidWitnessProductTwoBlock_whenBlockCapsuleGetWitnessAddressReturnNull()
      throws UnsupportedEncodingException {
    // Arrange
    ByteString byteString = mock(ByteString.class);
    when(byteString.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    BlockCapsule blockCapsule = mock(BlockCapsule.class);
    when(blockCapsule.getWitnessAddress()).thenReturn(byteString);
    when(cache.getIfPresent(Mockito.<Object>any())).thenReturn(blockCapsule);

    BlockCapsule block = mock(BlockCapsule.class);
    when(block.getWitnessAddress()).thenReturn(null);
    when(block.getNum()).thenReturn(1L);
    when(block.getBlockId()).thenReturn(new BlockId());

    // Act
    witnessProductBlockService.validWitnessProductTwoBlock(block);

    // Assert
    verify(cache).getIfPresent(isA(Object.class));
    verify(byteString).toByteArray();
    verify(block).getBlockId();
    verify(block, atLeast(1)).getNum();
    verify(blockCapsule).getWitnessAddress();
    verify(block).getWitnessAddress();
  }

  /**
   * Test {@link WitnessProductBlockService#queryCheatWitnessInfo()}.
   *
   * <p>Method under test: {@link WitnessProductBlockService#queryCheatWitnessInfo()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Map WitnessProductBlockService.queryCheatWitnessInfo()"})
  public void testQueryCheatWitnessInfo() {
    // Arrange, Act and Assert
    assertTrue(new WitnessProductBlockService().queryCheatWitnessInfo().isEmpty());
  }
}
