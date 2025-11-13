package org.tron.core.services.http;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ProtocolStringList;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.tron.api.GrpcAPI;
import org.tron.api.GrpcAPI.DecryptNotesTRC20;
import org.tron.core.Wallet;
import org.tron.core.exception.BadItemException;
import org.tron.core.exception.ContractExeException;
import org.tron.core.exception.ZksnarkException;

@RunWith(MockitoJUnitRunner.class)
public class ScanShieldedTRC20NotesByIvkServletDiffblueTest {
  @InjectMocks private ScanShieldedTRC20NotesByIvkServlet scanShieldedTRC20NotesByIvkServlet;

  @Mock private Wallet wallet;

  /**
   * Test {@link ScanShieldedTRC20NotesByIvkServlet#convertOutput(DecryptNotesTRC20, boolean)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>Then calls {@link GrpcAPI.DecryptNotesTRC20#getAllFields()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ScanShieldedTRC20NotesByIvkServlet#convertOutput(GrpcAPI.DecryptNotesTRC20, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ScanShieldedTRC20NotesByIvkServlet.convertOutput(GrpcAPI.DecryptNotesTRC20, boolean)"
  })
  public void testConvertOutput_givenZero_thenCallsGetAllFields() {
    // Arrange
    DecryptNotesTRC20 notes = mock(DecryptNotesTRC20.class);
    when(notes.getNoteTxsCount()).thenReturn(0);
    when(notes.getAllFields()).thenReturn(new HashMap<>());

    // Act
    String actualConvertOutputResult =
        ScanShieldedTRC20NotesByIvkServlet.convertOutput(notes, true);

    // Assert
    verify(notes).getAllFields();
    verify(notes).getNoteTxsCount();
    assertEquals("{}", actualConvertOutputResult);
  }

  /**
   * Test {@link ScanShieldedTRC20NotesByIvkServlet#convertOutput(DecryptNotesTRC20, boolean)}.
   *
   * <ul>
   *   <li>When DefaultInstance.
   * </ul>
   *
   * <p>Method under test: {@link
   * ScanShieldedTRC20NotesByIvkServlet#convertOutput(GrpcAPI.DecryptNotesTRC20, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ScanShieldedTRC20NotesByIvkServlet.convertOutput(GrpcAPI.DecryptNotesTRC20, boolean)"
  })
  public void testConvertOutput_whenDefaultInstance() {
    // Arrange, Act and Assert
    assertEquals(
        "{}",
        ScanShieldedTRC20NotesByIvkServlet.convertOutput(
            DecryptNotesTRC20.getDefaultInstance(), true));
  }

  /**
   * Test {@link ScanShieldedTRC20NotesByIvkServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <p>Method under test: {@link ScanShieldedTRC20NotesByIvkServlet#doPost(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ScanShieldedTRC20NotesByIvkServlet.doPost(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoPost() throws UnsupportedEncodingException {
    // Arrange
    ScanShieldedTRC20NotesByIvkServlet scanShieldedTRC20NotesByIvkServlet =
        new ScanShieldedTRC20NotesByIvkServlet();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    scanShieldedTRC20NotesByIvkServlet.doPost(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class org.tron.core.services.http.JsonFormat$ParseException : 1:1: Expected \\\"{\\\".\"}\n",
        response.getContentAsString());
    assertEquals(95, response.getContentAsByteArray().length);
  }

  /**
   * Test {@link ScanShieldedTRC20NotesByIvkServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link ScanShieldedTRC20NotesByIvkServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ScanShieldedTRC20NotesByIvkServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet() throws UnsupportedEncodingException {
    // Arrange
    ScanShieldedTRC20NotesByIvkServlet scanShieldedTRC20NotesByIvkServlet =
        new ScanShieldedTRC20NotesByIvkServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("end_block_index", "42");
    request.addParameter("start_block_index", "42");
    request.addParameter(Util.VISIBLE, "");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    scanShieldedTRC20NotesByIvkServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NullPointerException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link ScanShieldedTRC20NotesByIvkServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link ScanShieldedTRC20NotesByIvkServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ScanShieldedTRC20NotesByIvkServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet2()
      throws UnsupportedEncodingException, BadItemException, ContractExeException,
          ZksnarkException {
    // Arrange
    when(wallet.scanShieldedTRC20NotesByIvk(
            anyLong(),
            anyLong(),
            Mockito.<byte[]>any(),
            Mockito.<byte[]>any(),
            Mockito.<byte[]>any(),
            Mockito.<byte[]>any(),
            Mockito.<ProtocolStringList>any()))
        .thenThrow(new RuntimeException());

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("end_block_index", "42");
    request.addParameter("start_block_index", "42");
    request.addParameter("ivk", "0x");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    scanShieldedTRC20NotesByIvkServlet.doGet(request, response);

    // Assert
    verify(wallet)
        .scanShieldedTRC20NotesByIvk(
            eq(42L),
            eq(42L),
            isA(byte[].class),
            isA(byte[].class),
            isA(byte[].class),
            isA(byte[].class),
            isNull());
    assertEquals(
        "{\"Error\":\"class java.lang.RuntimeException : null\"}\n", response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.RuntimeException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link ScanShieldedTRC20NotesByIvkServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link ScanShieldedTRC20NotesByIvkServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ScanShieldedTRC20NotesByIvkServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet3() throws UnsupportedEncodingException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("end_block_index", "42");
    request.addParameter("start_block_index", "42");
    request.addParameter("shielded_TRC20_contract_address", " : ");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    scanShieldedTRC20NotesByIvkServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class org.bouncycastle.util.encoders.DecoderException : exception decoding Hex string: invalid"
            + " characters encountered in Hex string\"}\n",
        response.getContentAsString());
    assertEquals(144, response.getContentAsByteArray().length);
  }

  /**
   * Test {@link ScanShieldedTRC20NotesByIvkServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@code ak}.
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} addParameter {@code ak} and
   *       {@code :}.
   * </ul>
   *
   * <p>Method under test: {@link ScanShieldedTRC20NotesByIvkServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ScanShieldedTRC20NotesByIvkServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_givenAk_whenMockHttpServletRequestAddParameterAkAndColon()
      throws UnsupportedEncodingException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("end_block_index", "42");
    request.addParameter("start_block_index", "42");
    request.addParameter("ak", " : ");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    scanShieldedTRC20NotesByIvkServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class org.bouncycastle.util.encoders.DecoderException : exception decoding Hex string: invalid"
            + " characters encountered in Hex string\"}\n",
        response.getContentAsString());
    assertEquals(144, response.getContentAsByteArray().length);
  }

  /**
   * Test {@link ScanShieldedTRC20NotesByIvkServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@code nk}.
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} addParameter {@code nk} and
   *       {@code :}.
   * </ul>
   *
   * <p>Method under test: {@link ScanShieldedTRC20NotesByIvkServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ScanShieldedTRC20NotesByIvkServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_givenNk_whenMockHttpServletRequestAddParameterNkAndColon()
      throws UnsupportedEncodingException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("end_block_index", "42");
    request.addParameter("start_block_index", "42");
    request.addParameter("nk", " : ");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    scanShieldedTRC20NotesByIvkServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class org.bouncycastle.util.encoders.DecoderException : exception decoding Hex string: invalid"
            + " characters encountered in Hex string\"}\n",
        response.getContentAsString());
    assertEquals(144, response.getContentAsByteArray().length);
  }

  /**
   * Test {@link ScanShieldedTRC20NotesByIvkServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@code not blank}.
   *   <li>Then array length is one hundred two.
   * </ul>
   *
   * <p>Method under test: {@link ScanShieldedTRC20NotesByIvkServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ScanShieldedTRC20NotesByIvkServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_givenNotBlank_thenArrayLengthIsOneHundredTwo()
      throws UnsupportedEncodingException {
    // Arrange
    ScanShieldedTRC20NotesByIvkServlet scanShieldedTRC20NotesByIvkServlet =
        new ScanShieldedTRC20NotesByIvkServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(Util.VISIBLE, "not blank");
    request.addParameter("shielded_TRC20_contract_address", "0x");
    request.addParameter("ivk", "0x");
    request.addParameter("ak", "0x");
    request.addParameter("nk", "0x");
    request.addParameter("start_block_index", "https://example.org/example");
    request.addParameter("end_block_index", "https://example.org/example");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    scanShieldedTRC20NotesByIvkServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NumberFormatException : For input string: \\\"https://example.org/example\\\"\"}"
            + "\n",
        response.getContentAsString());
    assertEquals(102, response.getContentAsByteArray().length);
  }

  /**
   * Test {@link ScanShieldedTRC20NotesByIvkServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.
   * </ul>
   *
   * <p>Method under test: {@link ScanShieldedTRC20NotesByIvkServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ScanShieldedTRC20NotesByIvkServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_whenMockHttpServletRequest() throws UnsupportedEncodingException {
    // Arrange
    ScanShieldedTRC20NotesByIvkServlet scanShieldedTRC20NotesByIvkServlet =
        new ScanShieldedTRC20NotesByIvkServlet();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    scanShieldedTRC20NotesByIvkServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NumberFormatException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NumberFormatException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link ScanShieldedTRC20NotesByIvkServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} addParameter {@code ivk} and
   *       empty string.
   * </ul>
   *
   * <p>Method under test: {@link ScanShieldedTRC20NotesByIvkServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ScanShieldedTRC20NotesByIvkServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_whenMockHttpServletRequestAddParameterIvkAndEmptyString()
      throws UnsupportedEncodingException, BadItemException, ContractExeException,
          ZksnarkException {
    // Arrange
    when(wallet.scanShieldedTRC20NotesByIvk(
            anyLong(),
            anyLong(),
            Mockito.<byte[]>any(),
            Mockito.<byte[]>any(),
            Mockito.<byte[]>any(),
            Mockito.<byte[]>any(),
            Mockito.<ProtocolStringList>any()))
        .thenThrow(new RuntimeException());

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("end_block_index", "42");
    request.addParameter("start_block_index", "42");
    request.addParameter("ivk", "");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    scanShieldedTRC20NotesByIvkServlet.doGet(request, response);

    // Assert
    verify(wallet)
        .scanShieldedTRC20NotesByIvk(
            eq(42L),
            eq(42L),
            isA(byte[].class),
            isA(byte[].class),
            isA(byte[].class),
            isA(byte[].class),
            isNull());
    assertEquals(
        "{\"Error\":\"class java.lang.RuntimeException : null\"}\n", response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.RuntimeException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link ScanShieldedTRC20NotesByIvkServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} addParameter {@code ivk} and
   *       {@link Util#VISIBLE}.
   * </ul>
   *
   * <p>Method under test: {@link ScanShieldedTRC20NotesByIvkServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ScanShieldedTRC20NotesByIvkServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_whenMockHttpServletRequestAddParameterIvkAndVisible()
      throws UnsupportedEncodingException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("end_block_index", "42");
    request.addParameter("start_block_index", "42");
    request.addParameter("ivk", Util.VISIBLE);
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    scanShieldedTRC20NotesByIvkServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class org.bouncycastle.util.encoders.DecoderException : exception decoding Hex string: invalid"
            + " characters encountered in Hex string\"}\n",
        response.getContentAsString());
    assertEquals(144, response.getContentAsByteArray().length);
  }

  /**
   * Test {@link ScanShieldedTRC20NotesByIvkServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} addParameter {@link
   *       Util#VISIBLE} and {@code :}.
   * </ul>
   *
   * <p>Method under test: {@link ScanShieldedTRC20NotesByIvkServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ScanShieldedTRC20NotesByIvkServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_whenMockHttpServletRequestAddParameterVisibleAndColon()
      throws UnsupportedEncodingException {
    // Arrange
    ScanShieldedTRC20NotesByIvkServlet scanShieldedTRC20NotesByIvkServlet =
        new ScanShieldedTRC20NotesByIvkServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("start_block_index", "42");
    request.addParameter(Util.VISIBLE, " : ");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    scanShieldedTRC20NotesByIvkServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NumberFormatException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NumberFormatException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link ScanShieldedTRC20NotesByIvkServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} addParameter {@link
   *       Util#VISIBLE} and empty string.
   * </ul>
   *
   * <p>Method under test: {@link ScanShieldedTRC20NotesByIvkServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ScanShieldedTRC20NotesByIvkServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_whenMockHttpServletRequestAddParameterVisibleAndEmptyString()
      throws UnsupportedEncodingException {
    // Arrange
    ScanShieldedTRC20NotesByIvkServlet scanShieldedTRC20NotesByIvkServlet =
        new ScanShieldedTRC20NotesByIvkServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(Util.VISIBLE, "");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    scanShieldedTRC20NotesByIvkServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NumberFormatException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NumberFormatException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }

  /**
   * Test {@link ScanShieldedTRC20NotesByIvkServlet#doGet(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} addParameter {@link
   *       Util#VISIBLE} and empty string.
   * </ul>
   *
   * <p>Method under test: {@link ScanShieldedTRC20NotesByIvkServlet#doGet(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ScanShieldedTRC20NotesByIvkServlet.doGet(HttpServletRequest, HttpServletResponse)"
  })
  public void testDoGet_whenMockHttpServletRequestAddParameterVisibleAndEmptyString2()
      throws UnsupportedEncodingException {
    // Arrange
    ScanShieldedTRC20NotesByIvkServlet scanShieldedTRC20NotesByIvkServlet =
        new ScanShieldedTRC20NotesByIvkServlet();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("start_block_index", "42");
    request.addParameter(Util.VISIBLE, "");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    scanShieldedTRC20NotesByIvkServlet.doGet(request, response);

    // Assert
    assertEquals(
        "{\"Error\":\"class java.lang.NumberFormatException : null\"}\n",
        response.getContentAsString());
    assertArrayEquals(
        "{\"Error\":\"class java.lang.NumberFormatException : null\"}\n".getBytes("UTF-8"),
        response.getContentAsByteArray());
  }
}
