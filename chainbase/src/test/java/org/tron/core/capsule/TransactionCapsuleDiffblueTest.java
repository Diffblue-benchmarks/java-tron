package org.tron.core.capsule;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.InvalidProtocolBufferException;
import java.io.IOException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.exception.BadItemException;

public class TransactionCapsuleDiffblueTest {
  /**
   * Test {@link TransactionCapsule#TransactionCapsule(CodedInputStream)}.
   *
   * <p>Method under test: {@link TransactionCapsule#TransactionCapsule(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionCapsule.<init>(CodedInputStream)"})
  public void testNewTransactionCapsule() throws IOException, BadItemException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag())
        .thenThrow(
            new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(BadItemException.class, () -> new TransactionCapsule(codedInputStream));
    verify(codedInputStream).readTag();
  }

  /**
   * Test {@link TransactionCapsule#TransactionCapsule(CodedInputStream)}.
   *
   * <p>Method under test: {@link TransactionCapsule#TransactionCapsule(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionCapsule.<init>(CodedInputStream)"})
  public void testNewTransactionCapsule2() throws IOException, BadItemException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readFixed64())
        .thenThrow(
            new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(codedInputStream.readTag()).thenReturn(1);

    // Act and Assert
    assertThrows(BadItemException.class, () -> new TransactionCapsule(codedInputStream));
    verify(codedInputStream).readFixed64();
    verify(codedInputStream).readTag();
  }

  /**
   * Test {@link TransactionCapsule#TransactionCapsule(CodedInputStream)}.
   *
   * <ul>
   *   <li>Given minus one.
   * </ul>
   *
   * <p>Method under test: {@link TransactionCapsule#TransactionCapsule(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionCapsule.<init>(CodedInputStream)"})
  public void testNewTransactionCapsule_givenMinusOne() throws IOException, BadItemException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(-1);

    // Act and Assert
    assertThrows(BadItemException.class, () -> new TransactionCapsule(codedInputStream));
    verify(codedInputStream).readTag();
  }

  /**
   * Test {@link TransactionCapsule#TransactionCapsule(CodedInputStream)}.
   *
   * <ul>
   *   <li>When {@link CodedInputStream} {@link CodedInputStream#readFixed64()} throw {@link
   *       IOException#IOException()}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionCapsule#TransactionCapsule(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionCapsule.<init>(CodedInputStream)"})
  public void testNewTransactionCapsule_whenCodedInputStreamReadFixed64ThrowIOException()
      throws IOException, BadItemException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readFixed64()).thenThrow(new IOException());
    when(codedInputStream.readTag()).thenReturn(1);

    // Act and Assert
    assertThrows(BadItemException.class, () -> new TransactionCapsule(codedInputStream));
    verify(codedInputStream).readFixed64();
    verify(codedInputStream).readTag();
  }

  /**
   * Test {@link TransactionCapsule#TransactionCapsule(CodedInputStream)}.
   *
   * <ul>
   *   <li>When {@link CodedInputStream} {@link CodedInputStream#readTag()} throw {@link
   *       IOException#IOException()}.
   * </ul>
   *
   * <p>Method under test: {@link TransactionCapsule#TransactionCapsule(CodedInputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TransactionCapsule.<init>(CodedInputStream)"})
  public void testNewTransactionCapsule_whenCodedInputStreamReadTagThrowIOException()
      throws IOException, BadItemException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenThrow(new IOException());

    // Act and Assert
    assertThrows(BadItemException.class, () -> new TransactionCapsule(codedInputStream));
    verify(codedInputStream).readTag();
  }
}
