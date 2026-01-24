package org.tron.consensus.pbft;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.cache.Cache;
import com.google.common.util.concurrent.AtomicLongMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.tron.consensus.base.Param;
import org.tron.consensus.base.Param.Miner;
import org.tron.consensus.dpos.MaintenanceManager;
import org.tron.consensus.pbft.message.PbftMessage;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class PbftMessageHandleDiffblueTest {
  @Mock private AtomicLongMap<String> atomicLongMap;

  @Mock private Cache<String, PbftMessage> cache;

  @InjectMocks private PbftMessageHandle pbftMessageHandle;

  @Mock private Set<String> set;

  @Mock private Timer timer;

  /**
   * Test {@link PbftMessageHandle#init()}.
   *
   * <p>Method under test: {@link PbftMessageHandle#init()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PbftMessageHandle.init()"})
  public void testInit() {
    // Arrange
    doNothing()
        .when(timer)
        .schedule(Mockito.<TimerTask>any(), ArgumentMatchers.anyLong(), ArgumentMatchers.anyLong());

    // Act
    pbftMessageHandle.init();

    // Assert
    verify(timer).schedule(isA(TimerTask.class), eq(10L), eq(1000L));
  }

  /**
   * Test {@link PbftMessageHandle#close()}.
   *
   * <ul>
   *   <li>Given {@link Timer} {@link Timer#cancel()} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link PbftMessageHandle#close()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PbftMessageHandle.close()"})
  public void testClose_givenTimerCancelDoesNothing() {
    // Arrange
    doNothing().when(timer).cancel();

    // Act
    pbftMessageHandle.close();

    // Assert
    verify(timer).cancel();
  }

  /**
   * Test {@link PbftMessageHandle#close()}.
   *
   * <ul>
   *   <li>Given {@link Timer} {@link Timer#cancel()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link PbftMessageHandle#close()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PbftMessageHandle.close()"})
  public void testClose_givenTimerCancelThrowRuntimeException() {
    // Arrange
    doThrow(new RuntimeException()).when(timer).cancel();

    // Act
    pbftMessageHandle.close();

    // Assert
    verify(timer).cancel();
  }

  /**
   * Test {@link PbftMessageHandle#onPrePrepare(PbftMessage)}.
   *
   * <ul>
   *   <li>Given {@link AtomicLongMap} {@link AtomicLongMap#asMap()} return {@link
   *       HashMap#HashMap()}.
   *   <li>Then calls {@link AtomicLongMap#asMap()}.
   * </ul>
   *
   * <p>Method under test: {@link PbftMessageHandle#onPrePrepare(PbftMessage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PbftMessageHandle.onPrePrepare(PbftMessage)"})
  public void testOnPrePrepare_givenAtomicLongMapAsMapReturnHashMap_thenCallsAsMap() {
    // Arrange
    when(atomicLongMap.asMap()).thenReturn(new HashMap<>());
    when(set.remove(Mockito.<Object>any())).thenReturn(true);

    PbftMessage message = mock(PbftMessage.class);
    when(message.getDataString()).thenReturn("Data String");
    when(message.getNumber()).thenReturn(1L);
    when(message.isSwitch()).thenReturn(true);
    when(message.getNo()).thenReturn("No");

    // Act
    pbftMessageHandle.onPrePrepare(message);

    // Assert
    verify(atomicLongMap).asMap();
    verify(set).remove(isA(Object.class));
    verify(message).getDataString();
    verify(message).getNumber();
    verify(message).isSwitch();
    verify(message).getNo();
  }

  /**
   * Test {@link PbftMessageHandle#onPrePrepare(PbftMessage)}.
   *
   * <ul>
   *   <li>Given {@link AtomicLongMap} {@link AtomicLongMap#remove(Object)} return one.
   *   <li>Then calls {@link AtomicLongMap#remove(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link PbftMessageHandle#onPrePrepare(PbftMessage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PbftMessageHandle.onPrePrepare(PbftMessage)"})
  public void testOnPrePrepare_givenAtomicLongMapRemoveReturnOne_thenCallsRemove() {
    // Arrange
    HashMap<String, Long> stringResultLongMap = new HashMap<>();
    stringResultLongMap.put("_", 0L);
    stringResultLongMap.put("block chain switch, again proposal block num: {}, data: {}", 1L);
    when(atomicLongMap.remove(Mockito.<String>any())).thenReturn(1L);
    when(atomicLongMap.asMap()).thenReturn(stringResultLongMap);
    when(set.remove(Mockito.<Object>any())).thenReturn(true);

    PbftMessage message = mock(PbftMessage.class);
    when(message.getDataString()).thenReturn("Data String");
    when(message.getNumber()).thenReturn(1L);
    when(message.isSwitch()).thenReturn(true);
    when(message.getNo()).thenReturn("");

    // Act
    pbftMessageHandle.onPrePrepare(message);

    // Assert
    verify(atomicLongMap).asMap();
    verify(atomicLongMap).remove("_");
    verify(set).remove(isA(Object.class));
    verify(message).getDataString();
    verify(message).getNumber();
    verify(message).isSwitch();
    verify(message).getNo();
  }

  /**
   * Test {@link PbftMessageHandle#onPrePrepare(PbftMessage)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link PbftMessage} {@link PbftMessage#isSwitch()} return {@code false}.
   *   <li>Then calls {@link Set#contains(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link PbftMessageHandle#onPrePrepare(PbftMessage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PbftMessageHandle.onPrePrepare(PbftMessage)"})
  public void testOnPrePrepare_givenFalse_whenPbftMessageIsSwitchReturnFalse_thenCallsContains() {
    // Arrange
    when(set.contains(Mockito.<Object>any())).thenReturn(true);

    PbftMessage message = mock(PbftMessage.class);
    when(message.isSwitch()).thenReturn(false);
    when(message.getNo()).thenReturn("No");

    // Act
    pbftMessageHandle.onPrePrepare(message);

    // Assert
    verify(set).contains(isA(Object.class));
    verify(message).isSwitch();
    verify(message).getNo();
  }

  /**
   * Test {@link PbftMessageHandle#onPrePrepare(PbftMessage)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code block chain switch, again proposal block num: {},
   *       data: {}} is one.
   * </ul>
   *
   * <p>Method under test: {@link PbftMessageHandle#onPrePrepare(PbftMessage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PbftMessageHandle.onPrePrepare(PbftMessage)"})
  public void testOnPrePrepare_givenHashMapBlockChainSwitchAgainProposalBlockNumDataIsOne() {
    // Arrange
    HashMap<String, Long> stringResultLongMap = new HashMap<>();
    stringResultLongMap.put("block chain switch, again proposal block num: {}, data: {}", 1L);
    when(atomicLongMap.asMap()).thenReturn(stringResultLongMap);
    when(set.remove(Mockito.<Object>any())).thenReturn(true);

    PbftMessage message = mock(PbftMessage.class);
    when(message.getDataString()).thenReturn("Data String");
    when(message.getNumber()).thenReturn(1L);
    when(message.isSwitch()).thenReturn(true);
    when(message.getNo()).thenReturn("No");

    // Act
    pbftMessageHandle.onPrePrepare(message);

    // Assert
    verify(atomicLongMap).asMap();
    verify(set).remove(isA(Object.class));
    verify(message).getDataString();
    verify(message).getNumber();
    verify(message).isSwitch();
    verify(message).getNo();
  }

  /**
   * Test {@link PbftMessageHandle#onPrePrepare(PbftMessage)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code null} is one.
   *   <li>Then calls {@link AtomicLongMap#asMap()}.
   * </ul>
   *
   * <p>Method under test: {@link PbftMessageHandle#onPrePrepare(PbftMessage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PbftMessageHandle.onPrePrepare(PbftMessage)"})
  public void testOnPrePrepare_givenHashMapNullIsOne_thenCallsAsMap() {
    // Arrange
    HashMap<String, Long> stringResultLongMap = new HashMap<>();
    stringResultLongMap.put("_", 0L);
    stringResultLongMap.put(null, 1L);
    when(atomicLongMap.asMap()).thenReturn(stringResultLongMap);
    when(set.remove(Mockito.<Object>any())).thenReturn(true);

    PbftMessage message = mock(PbftMessage.class);
    when(message.getDataString()).thenReturn("Data String");
    when(message.getNumber()).thenReturn(1L);
    when(message.isSwitch()).thenReturn(true);
    when(message.getNo()).thenReturn("No");

    // Act
    pbftMessageHandle.onPrePrepare(message);

    // Assert
    verify(atomicLongMap).asMap();
    verify(set).remove(isA(Object.class));
    verify(message).getDataString();
    verify(message).getNumber();
    verify(message).isSwitch();
    verify(message).getNo();
  }

  /**
   * Test {@link PbftMessageHandle#onPrePrepare(PbftMessage)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code _} is zero.
   *   <li>Then calls {@link AtomicLongMap#asMap()}.
   * </ul>
   *
   * <p>Method under test: {@link PbftMessageHandle#onPrePrepare(PbftMessage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PbftMessageHandle.onPrePrepare(PbftMessage)"})
  public void testOnPrePrepare_givenHashMapUnderscoreIsZero_thenCallsAsMap() {
    // Arrange
    HashMap<String, Long> stringResultLongMap = new HashMap<>();
    stringResultLongMap.put("_", 0L);
    stringResultLongMap.put("block chain switch, again proposal block num: {}, data: {}", 1L);
    when(atomicLongMap.asMap()).thenReturn(stringResultLongMap);
    when(set.remove(Mockito.<Object>any())).thenReturn(true);

    PbftMessage message = mock(PbftMessage.class);
    when(message.getDataString()).thenReturn("Data String");
    when(message.getNumber()).thenReturn(1L);
    when(message.isSwitch()).thenReturn(true);
    when(message.getNo()).thenReturn("No");

    // Act
    pbftMessageHandle.onPrePrepare(message);

    // Assert
    verify(atomicLongMap).asMap();
    verify(set).remove(isA(Object.class));
    verify(message).getDataString();
    verify(message).getNumber();
    verify(message).isSwitch();
    verify(message).getNo();
  }

  /**
   * Test {@link PbftMessageHandle#onPrePrepare(PbftMessage)}.
   *
   * <ul>
   *   <li>Given {@link PbftMessageHandle} (default constructor).
   *   <li>Then calls {@link PbftMessage#getDataString()}.
   * </ul>
   *
   * <p>Method under test: {@link PbftMessageHandle#onPrePrepare(PbftMessage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PbftMessageHandle.onPrePrepare(PbftMessage)"})
  public void testOnPrePrepare_givenPbftMessageHandle_thenCallsGetDataString() {
    // Arrange
    PbftMessageHandle pbftMessageHandle = new PbftMessageHandle();

    PbftMessage message = mock(PbftMessage.class);
    when(message.getDataString()).thenReturn("Data String");
    when(message.getNumber()).thenReturn(1L);
    when(message.isSwitch()).thenReturn(true);
    when(message.getNo()).thenReturn("No");

    // Act
    pbftMessageHandle.onPrePrepare(message);

    // Assert
    verify(message).getDataString();
    verify(message).getNumber();
    verify(message).isSwitch();
    verify(message).getNo();
  }

  /**
   * Test {@link PbftMessageHandle#onPrepare(PbftMessage)}.
   *
   * <ul>
   *   <li>Given {@code Key}.
   *   <li>When {@link PbftMessage} {@link PbftMessage#getKey()} return {@code Key}.
   *   <li>Then calls {@link PbftMessage#getKey()}.
   * </ul>
   *
   * <p>Method under test: {@link PbftMessageHandle#onPrepare(PbftMessage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PbftMessageHandle.onPrepare(PbftMessage)"})
  public void testOnPrepare_givenKey_whenPbftMessageGetKeyReturnKey_thenCallsGetKey() {
    // Arrange
    PbftMessageHandle pbftMessageHandle = new PbftMessageHandle();

    PbftMessage message = mock(PbftMessage.class);
    when(message.getKey()).thenReturn("Key");
    when(message.getNo()).thenReturn("No");

    // Act
    pbftMessageHandle.onPrepare(message);

    // Assert
    verify(message).getKey();
    verify(message).getNo();
  }

  /**
   * Test {@link PbftMessageHandle#onCommit(PbftMessage)}.
   *
   * <ul>
   *   <li>Given {@link Cache} {@link Cache#put(Object, Object)} does nothing.
   *   <li>Then calls {@link Cache#put(Object, Object)}.
   * </ul>
   *
   * <p>Method under test: {@link PbftMessageHandle#onCommit(PbftMessage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PbftMessageHandle.onCommit(PbftMessage)"})
  public void testOnCommit_givenCachePutDoesNothing_thenCallsPut() {
    // Arrange
    doNothing().when(cache).put(Mockito.<String>any(), Mockito.<PbftMessage>any());

    PbftMessage message = mock(PbftMessage.class);
    when(message.getKey()).thenReturn("Key");

    // Act
    pbftMessageHandle.onCommit(message);

    // Assert
    verify(cache).put(eq("Key"), isA(PbftMessage.class));
    verify(message).getKey();
  }

  /**
   * Test {@link PbftMessageHandle#onCommit(PbftMessage)}.
   *
   * <ul>
   *   <li>Given {@link PbftMessageHandle} (default constructor).
   *   <li>Then calls {@link PbftMessage#getKey()}.
   * </ul>
   *
   * <p>Method under test: {@link PbftMessageHandle#onCommit(PbftMessage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PbftMessageHandle.onCommit(PbftMessage)"})
  public void testOnCommit_givenPbftMessageHandle_thenCallsGetKey() {
    // Arrange
    PbftMessageHandle pbftMessageHandle = new PbftMessageHandle();

    PbftMessage message = mock(PbftMessage.class);
    when(message.getKey()).thenReturn("Key");

    // Act
    pbftMessageHandle.onCommit(message);

    // Assert
    verify(message).getKey();
  }

  /**
   * Test {@link PbftMessageHandle#start()}.
   *
   * <p>Method under test: {@link PbftMessageHandle#start()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PbftMessageHandle.start()"})
  public void testStart() {
    // Arrange
    doNothing()
        .when(timer)
        .schedule(Mockito.<TimerTask>any(), ArgumentMatchers.anyLong(), ArgumentMatchers.anyLong());

    // Act
    pbftMessageHandle.start();

    // Assert
    verify(timer).schedule(isA(TimerTask.class), eq(10L), eq(1000L));
  }
}
