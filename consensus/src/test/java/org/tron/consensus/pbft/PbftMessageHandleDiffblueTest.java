package org.tron.consensus.pbft;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.tron.consensus.pbft.message.PbftMessage;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class PbftMessageHandleDiffblueTest {
  @InjectMocks private PbftMessageHandle pbftMessageHandle;

  /**
   * Test {@link PbftMessageHandle#onPrePrepare(PbftMessage)}.
   *
   * <ul>
   *   <li>Given {@code Data String}.
   *   <li>Then calls {@link PbftMessage#getDataString()}.
   * </ul>
   *
   * <p>Method under test: {@link PbftMessageHandle#onPrePrepare(PbftMessage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PbftMessageHandle.onPrePrepare(PbftMessage)"})
  public void testOnPrePrepare_givenDataString_thenCallsGetDataString() {
    // Arrange
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
   *   <li>Given {@code Key}.
   *   <li>When {@link PbftMessage} {@link PbftMessage#getKey()} return {@code Key}.
   *   <li>Then calls {@link PbftMessage#getKey()}.
   * </ul>
   *
   * <p>Method under test: {@link PbftMessageHandle#onCommit(PbftMessage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PbftMessageHandle.onCommit(PbftMessage)"})
  public void testOnCommit_givenKey_whenPbftMessageGetKeyReturnKey_thenCallsGetKey() {
    // Arrange
    PbftMessage message = mock(PbftMessage.class);
    when(message.getKey()).thenReturn("Key");

    // Act
    pbftMessageHandle.onCommit(message);

    // Assert
    verify(message).getKey();
  }
}
