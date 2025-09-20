package org.tron.core.services.jsonrpc.types;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.tron.core.Wallet;
import org.tron.core.exception.JsonRpcInvalidParamsException;
import org.tron.core.exception.JsonRpcInvalidRequestException;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class BuildArgumentsDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BuildArguments#BuildArguments()}
   *   <li>{@link BuildArguments#setAbi(String)}
   *   <li>{@link BuildArguments#setConsumeUserResourcePercent(Long)}
   *   <li>{@link BuildArguments#setData(String)}
   *   <li>{@link BuildArguments#setExtraData(String)}
   *   <li>{@link BuildArguments#setFrom(String)}
   *   <li>{@link BuildArguments#setGas(String)}
   *   <li>{@link BuildArguments#setGasPrice(String)}
   *   <li>{@link BuildArguments#setName(String)}
   *   <li>{@link BuildArguments#setNonce(String)}
   *   <li>{@link BuildArguments#setOriginEnergyLimit(Long)}
   *   <li>{@link BuildArguments#setPermissionId(Integer)}
   *   <li>{@link BuildArguments#setTo(String)}
   *   <li>{@link BuildArguments#setTokenId(Long)}
   *   <li>{@link BuildArguments#setTokenValue(Long)}
   *   <li>{@link BuildArguments#setValue(String)}
   *   <li>{@link BuildArguments#setVisible(boolean)}
   *   <li>{@link BuildArguments#toString()}
   *   <li>{@link BuildArguments#getAbi()}
   *   <li>{@link BuildArguments#getConsumeUserResourcePercent()}
   *   <li>{@link BuildArguments#getData()}
   *   <li>{@link BuildArguments#getExtraData()}
   *   <li>{@link BuildArguments#getFrom()}
   *   <li>{@link BuildArguments#getGas()}
   *   <li>{@link BuildArguments#getGasPrice()}
   *   <li>{@link BuildArguments#getName()}
   *   <li>{@link BuildArguments#getNonce()}
   *   <li>{@link BuildArguments#getOriginEnergyLimit()}
   *   <li>{@link BuildArguments#getPermissionId()}
   *   <li>{@link BuildArguments#getTo()}
   *   <li>{@link BuildArguments#getTokenId()}
   *   <li>{@link BuildArguments#getTokenValue()}
   *   <li>{@link BuildArguments#getValue()}
   *   <li>{@link BuildArguments#isVisible()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void BuildArguments.<init>()",
    "void BuildArguments.<init>(String, String, String, String, String, String, String, Long, Long, String, Long, Long, String, Integer, String, boolean)",
    "String BuildArguments.getAbi()",
    "Long BuildArguments.getConsumeUserResourcePercent()",
    "String BuildArguments.getData()",
    "String BuildArguments.getExtraData()",
    "String BuildArguments.getFrom()",
    "String BuildArguments.getGas()",
    "String BuildArguments.getGasPrice()",
    "String BuildArguments.getName()",
    "String BuildArguments.getNonce()",
    "Long BuildArguments.getOriginEnergyLimit()",
    "Integer BuildArguments.getPermissionId()",
    "String BuildArguments.getTo()",
    "Long BuildArguments.getTokenId()",
    "Long BuildArguments.getTokenValue()",
    "String BuildArguments.getValue()",
    "boolean BuildArguments.isVisible()",
    "void BuildArguments.setAbi(String)",
    "void BuildArguments.setConsumeUserResourcePercent(Long)",
    "void BuildArguments.setData(String)",
    "void BuildArguments.setExtraData(String)",
    "void BuildArguments.setFrom(String)",
    "void BuildArguments.setGas(String)",
    "void BuildArguments.setGasPrice(String)",
    "void BuildArguments.setName(String)",
    "void BuildArguments.setNonce(String)",
    "void BuildArguments.setOriginEnergyLimit(Long)",
    "void BuildArguments.setPermissionId(Integer)",
    "void BuildArguments.setTo(String)",
    "void BuildArguments.setTokenId(Long)",
    "void BuildArguments.setTokenValue(Long)",
    "void BuildArguments.setValue(String)",
    "void BuildArguments.setVisible(boolean)",
    "String BuildArguments.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    BuildArguments actualBuildArguments = new BuildArguments();
    actualBuildArguments.setAbi("Abi");
    actualBuildArguments.setConsumeUserResourcePercent(1L);
    actualBuildArguments.setData("Data");
    actualBuildArguments.setExtraData("Extra Data");
    actualBuildArguments.setFrom("jane.doe@example.org");
    actualBuildArguments.setGas("Gas");
    actualBuildArguments.setGasPrice("Gas Price");
    actualBuildArguments.setName("Name");
    actualBuildArguments.setNonce("Nonce");
    actualBuildArguments.setOriginEnergyLimit(1L);
    actualBuildArguments.setPermissionId(1);
    actualBuildArguments.setTo("alice.liddell@example.org");
    actualBuildArguments.setTokenId(1L);
    actualBuildArguments.setTokenValue(42L);
    actualBuildArguments.setValue("42");
    actualBuildArguments.setVisible(true);
    String actualToStringResult = actualBuildArguments.toString();
    String actualAbi = actualBuildArguments.getAbi();
    Long actualConsumeUserResourcePercent = actualBuildArguments.getConsumeUserResourcePercent();
    String actualData = actualBuildArguments.getData();
    String actualExtraData = actualBuildArguments.getExtraData();
    String actualFrom = actualBuildArguments.getFrom();
    String actualGas = actualBuildArguments.getGas();
    String actualGasPrice = actualBuildArguments.getGasPrice();
    String actualName = actualBuildArguments.getName();
    String actualNonce = actualBuildArguments.getNonce();
    Long actualOriginEnergyLimit = actualBuildArguments.getOriginEnergyLimit();
    Integer actualPermissionId = actualBuildArguments.getPermissionId();
    String actualTo = actualBuildArguments.getTo();
    Long actualTokenId = actualBuildArguments.getTokenId();
    Long actualTokenValue = actualBuildArguments.getTokenValue();
    String actualValue = actualBuildArguments.getValue();
    boolean actualIsVisibleResult = actualBuildArguments.isVisible();

    // Assert
    assertEquals("42", actualValue);
    assertEquals("Abi", actualAbi);
    assertEquals(
        "BuildArguments(from=jane.doe@example.org, to=alice.liddell@example.org, gas=Gas, gasPrice=Gas Price,"
            + " value=42, data=Data, nonce=Nonce, tokenId=1, tokenValue=42, abi=Abi, consumeUserResourcePercent=1,"
            + " originEnergyLimit=1, name=Name, permissionId=1, extraData=Extra Data, visible=true)",
        actualToStringResult);
    assertEquals("Data", actualData);
    assertEquals("Extra Data", actualExtraData);
    assertEquals("Gas Price", actualGasPrice);
    assertEquals("Gas", actualGas);
    assertEquals("Name", actualName);
    assertEquals("Nonce", actualNonce);
    assertEquals("alice.liddell@example.org", actualTo);
    assertEquals("jane.doe@example.org", actualFrom);
    assertEquals(1, actualPermissionId.intValue());
    assertEquals(1L, actualConsumeUserResourcePercent.longValue());
    assertEquals(1L, actualOriginEnergyLimit.longValue());
    assertEquals(1L, actualTokenId.longValue());
    assertEquals(42L, actualTokenValue.longValue());
    assertTrue(actualIsVisibleResult);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code jane.doe@example.org}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BuildArguments#BuildArguments(String, String, String, String, String, String,
   *       String, Long, Long, String, Long, Long, String, Integer, String, boolean)}
   *   <li>{@link BuildArguments#setAbi(String)}
   *   <li>{@link BuildArguments#setConsumeUserResourcePercent(Long)}
   *   <li>{@link BuildArguments#setData(String)}
   *   <li>{@link BuildArguments#setExtraData(String)}
   *   <li>{@link BuildArguments#setFrom(String)}
   *   <li>{@link BuildArguments#setGas(String)}
   *   <li>{@link BuildArguments#setGasPrice(String)}
   *   <li>{@link BuildArguments#setName(String)}
   *   <li>{@link BuildArguments#setNonce(String)}
   *   <li>{@link BuildArguments#setOriginEnergyLimit(Long)}
   *   <li>{@link BuildArguments#setPermissionId(Integer)}
   *   <li>{@link BuildArguments#setTo(String)}
   *   <li>{@link BuildArguments#setTokenId(Long)}
   *   <li>{@link BuildArguments#setTokenValue(Long)}
   *   <li>{@link BuildArguments#setValue(String)}
   *   <li>{@link BuildArguments#setVisible(boolean)}
   *   <li>{@link BuildArguments#toString()}
   *   <li>{@link BuildArguments#getAbi()}
   *   <li>{@link BuildArguments#getConsumeUserResourcePercent()}
   *   <li>{@link BuildArguments#getData()}
   *   <li>{@link BuildArguments#getExtraData()}
   *   <li>{@link BuildArguments#getFrom()}
   *   <li>{@link BuildArguments#getGas()}
   *   <li>{@link BuildArguments#getGasPrice()}
   *   <li>{@link BuildArguments#getName()}
   *   <li>{@link BuildArguments#getNonce()}
   *   <li>{@link BuildArguments#getOriginEnergyLimit()}
   *   <li>{@link BuildArguments#getPermissionId()}
   *   <li>{@link BuildArguments#getTo()}
   *   <li>{@link BuildArguments#getTokenId()}
   *   <li>{@link BuildArguments#getTokenValue()}
   *   <li>{@link BuildArguments#getValue()}
   *   <li>{@link BuildArguments#isVisible()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void BuildArguments.<init>()",
    "void BuildArguments.<init>(String, String, String, String, String, String, String, Long, Long, String, Long, Long, String, Integer, String, boolean)",
    "String BuildArguments.getAbi()",
    "Long BuildArguments.getConsumeUserResourcePercent()",
    "String BuildArguments.getData()",
    "String BuildArguments.getExtraData()",
    "String BuildArguments.getFrom()",
    "String BuildArguments.getGas()",
    "String BuildArguments.getGasPrice()",
    "String BuildArguments.getName()",
    "String BuildArguments.getNonce()",
    "Long BuildArguments.getOriginEnergyLimit()",
    "Integer BuildArguments.getPermissionId()",
    "String BuildArguments.getTo()",
    "Long BuildArguments.getTokenId()",
    "Long BuildArguments.getTokenValue()",
    "String BuildArguments.getValue()",
    "boolean BuildArguments.isVisible()",
    "void BuildArguments.setAbi(String)",
    "void BuildArguments.setConsumeUserResourcePercent(Long)",
    "void BuildArguments.setData(String)",
    "void BuildArguments.setExtraData(String)",
    "void BuildArguments.setFrom(String)",
    "void BuildArguments.setGas(String)",
    "void BuildArguments.setGasPrice(String)",
    "void BuildArguments.setName(String)",
    "void BuildArguments.setNonce(String)",
    "void BuildArguments.setOriginEnergyLimit(Long)",
    "void BuildArguments.setPermissionId(Integer)",
    "void BuildArguments.setTo(String)",
    "void BuildArguments.setTokenId(Long)",
    "void BuildArguments.setTokenValue(Long)",
    "void BuildArguments.setValue(String)",
    "void BuildArguments.setVisible(boolean)",
    "String BuildArguments.toString()"
  })
  public void testGettersAndSetters_whenJaneDoeExampleOrg() {
    // Arrange and Act
    BuildArguments actualBuildArguments =
        new BuildArguments(
            "jane.doe@example.org",
            "alice.liddell@example.org",
            "Gas",
            "Gas Price",
            "42",
            "Data",
            "Nonce",
            1L,
            42L,
            "Abi",
            1L,
            1L,
            "Name",
            1,
            "Extra Data",
            true);
    actualBuildArguments.setAbi("Abi");
    actualBuildArguments.setConsumeUserResourcePercent(1L);
    actualBuildArguments.setData("Data");
    actualBuildArguments.setExtraData("Extra Data");
    actualBuildArguments.setFrom("jane.doe@example.org");
    actualBuildArguments.setGas("Gas");
    actualBuildArguments.setGasPrice("Gas Price");
    actualBuildArguments.setName("Name");
    actualBuildArguments.setNonce("Nonce");
    actualBuildArguments.setOriginEnergyLimit(1L);
    actualBuildArguments.setPermissionId(1);
    actualBuildArguments.setTo("alice.liddell@example.org");
    actualBuildArguments.setTokenId(1L);
    actualBuildArguments.setTokenValue(42L);
    actualBuildArguments.setValue("42");
    actualBuildArguments.setVisible(true);
    String actualToStringResult = actualBuildArguments.toString();
    String actualAbi = actualBuildArguments.getAbi();
    Long actualConsumeUserResourcePercent = actualBuildArguments.getConsumeUserResourcePercent();
    String actualData = actualBuildArguments.getData();
    String actualExtraData = actualBuildArguments.getExtraData();
    String actualFrom = actualBuildArguments.getFrom();
    String actualGas = actualBuildArguments.getGas();
    String actualGasPrice = actualBuildArguments.getGasPrice();
    String actualName = actualBuildArguments.getName();
    String actualNonce = actualBuildArguments.getNonce();
    Long actualOriginEnergyLimit = actualBuildArguments.getOriginEnergyLimit();
    Integer actualPermissionId = actualBuildArguments.getPermissionId();
    String actualTo = actualBuildArguments.getTo();
    Long actualTokenId = actualBuildArguments.getTokenId();
    Long actualTokenValue = actualBuildArguments.getTokenValue();
    String actualValue = actualBuildArguments.getValue();
    boolean actualIsVisibleResult = actualBuildArguments.isVisible();

    // Assert
    assertEquals("42", actualValue);
    assertEquals("Abi", actualAbi);
    assertEquals(
        "BuildArguments(from=jane.doe@example.org, to=alice.liddell@example.org, gas=Gas, gasPrice=Gas Price,"
            + " value=42, data=Data, nonce=Nonce, tokenId=1, tokenValue=42, abi=Abi, consumeUserResourcePercent=1,"
            + " originEnergyLimit=1, name=Name, permissionId=1, extraData=Extra Data, visible=true)",
        actualToStringResult);
    assertEquals("Data", actualData);
    assertEquals("Extra Data", actualExtraData);
    assertEquals("Gas Price", actualGasPrice);
    assertEquals("Gas", actualGas);
    assertEquals("Name", actualName);
    assertEquals("Nonce", actualNonce);
    assertEquals("alice.liddell@example.org", actualTo);
    assertEquals("jane.doe@example.org", actualFrom);
    assertEquals(1, actualPermissionId.intValue());
    assertEquals(1L, actualConsumeUserResourcePercent.longValue());
    assertEquals(1L, actualOriginEnergyLimit.longValue());
    assertEquals(1L, actualTokenId.longValue());
    assertEquals(42L, actualTokenValue.longValue());
    assertTrue(actualIsVisibleResult);
  }

  /**
   * Test {@link BuildArguments#BuildArguments(CallArguments)}.
   *
   * <ul>
   *   <li>Then return Abi is empty string.
   * </ul>
   *
   * <p>Method under test: {@link BuildArguments#BuildArguments(CallArguments)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BuildArguments.<init>(CallArguments)"})
  public void testNewBuildArguments_thenReturnAbiIsEmptyString() {
    // Arrange
    CallArguments args =
        new CallArguments(
            "jane.doe@example.org",
            "alice.liddell@example.org",
            "Gas",
            "Gas Price",
            "42",
            "Data",
            "Nonce");

    // Act
    BuildArguments actualBuildArguments = new BuildArguments(args);

    // Assert
    assertEquals("", actualBuildArguments.getAbi());
    assertEquals("", actualBuildArguments.getExtraData());
    assertEquals("", actualBuildArguments.getName());
    assertEquals("", actualBuildArguments.getNonce());
    assertEquals("42", actualBuildArguments.getValue());
    assertEquals("Data", actualBuildArguments.getData());
    assertEquals("Gas Price", actualBuildArguments.getGasPrice());
    assertEquals("Gas", actualBuildArguments.getGas());
    assertEquals("alice.liddell@example.org", actualBuildArguments.getTo());
    assertEquals("jane.doe@example.org", actualBuildArguments.getFrom());
    assertEquals(0, actualBuildArguments.getPermissionId().intValue());
    assertEquals(0L, actualBuildArguments.getConsumeUserResourcePercent().longValue());
    assertEquals(0L, actualBuildArguments.getOriginEnergyLimit().longValue());
    assertEquals(0L, actualBuildArguments.getTokenId().longValue());
    assertEquals(0L, actualBuildArguments.getTokenValue().longValue());
    assertFalse(actualBuildArguments.isVisible());
  }

  /**
   * Test {@link BuildArguments#getContractType(Wallet)}.
   *
   * <ul>
   *   <li>Given {@link BuildArguments#BuildArguments(CallArguments)} with args is {@link
   *       CallArguments#CallArguments(String, String, String, String, String, String, String)} Data
   *       is {@code 0x}.
   * </ul>
   *
   * <p>Method under test: {@link BuildArguments#getContractType(Wallet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "org.tron.protos.Protocol.Transaction.Contract.ContractType BuildArguments.getContractType(Wallet)"
  })
  public void testGetContractType_givenBuildArgumentsWithArgsIsCallArgumentsDataIs0x()
      throws JsonRpcInvalidParamsException, JsonRpcInvalidRequestException {
    // Arrange
    CallArguments args =
        new CallArguments(
            "jane.doe@example.org",
            "alice.liddell@example.org",
            "Gas",
            "Gas Price",
            "42",
            "Data",
            "Nonce");

    BuildArguments buildArguments = new BuildArguments(args);
    buildArguments.setValue("not empty");
    buildArguments.setTo("");
    buildArguments.setData("0x");
    buildArguments.setTokenId(0L);
    buildArguments.setTokenValue(0L);

    // Act and Assert
    assertThrows(
        JsonRpcInvalidRequestException.class, () -> buildArguments.getContractType(new Wallet()));
  }

  /**
   * Test {@link BuildArguments#getContractType(Wallet)}.
   *
   * <ul>
   *   <li>Given {@link BuildArguments#BuildArguments()}.
   *   <li>Then throw {@link JsonRpcInvalidRequestException}.
   * </ul>
   *
   * <p>Method under test: {@link BuildArguments#getContractType(Wallet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "org.tron.protos.Protocol.Transaction.Contract.ContractType BuildArguments.getContractType(Wallet)"
  })
  public void testGetContractType_givenBuildArguments_thenThrowJsonRpcInvalidRequestException()
      throws JsonRpcInvalidParamsException, JsonRpcInvalidRequestException {
    // Arrange
    BuildArguments buildArguments = new BuildArguments();

    // Act and Assert
    assertThrows(
        JsonRpcInvalidRequestException.class, () -> buildArguments.getContractType(new Wallet()));
  }

  /**
   * Test {@link BuildArguments#getContractType(Wallet)}.
   *
   * <ul>
   *   <li>Then throw {@link JsonRpcInvalidRequestException}.
   * </ul>
   *
   * <p>Method under test: {@link BuildArguments#getContractType(Wallet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "org.tron.protos.Protocol.Transaction.Contract.ContractType BuildArguments.getContractType(Wallet)"
  })
  public void testGetContractType_thenThrowJsonRpcInvalidRequestException()
      throws JsonRpcInvalidParamsException, JsonRpcInvalidRequestException {
    // Arrange
    CallArguments args =
        new CallArguments(
            "jane.doe@example.org",
            "alice.liddell@example.org",
            "Gas",
            "Gas Price",
            "42",
            "Data",
            "Nonce");

    BuildArguments buildArguments = new BuildArguments(args);
    buildArguments.setValue("not empty");
    buildArguments.setTo("");
    buildArguments.setData("");
    buildArguments.setTokenId(0L);
    buildArguments.setTokenValue(0L);

    // Act and Assert
    assertThrows(
        JsonRpcInvalidRequestException.class, () -> buildArguments.getContractType(new Wallet()));
  }

  /**
   * Test {@link BuildArguments#parseValue()}.
   *
   * <ul>
   *   <li>Given {@link BuildArguments#BuildArguments(CallArguments)} with args is {@link
   *       CallArguments#CallArguments(String, String, String, String, String, String, String)}
   *       Value is {@code 0x0}.
   * </ul>
   *
   * <p>Method under test: {@link BuildArguments#parseValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long BuildArguments.parseValue()"})
  public void testParseValue_givenBuildArgumentsWithArgsIsCallArgumentsValueIs0x0()
      throws JsonRpcInvalidParamsException {
    // Arrange
    CallArguments args =
        new CallArguments(
            "jane.doe@example.org",
            "alice.liddell@example.org",
            "Gas",
            "Gas Price",
            "42",
            "Data",
            "Nonce");

    BuildArguments buildArguments = new BuildArguments(args);
    buildArguments.setValue("0x0");

    // Act and Assert
    assertEquals(0L, buildArguments.parseValue());
  }

  /**
   * Test {@link BuildArguments#parseValue()}.
   *
   * <ul>
   *   <li>Given {@link BuildArguments#BuildArguments(CallArguments)} with args is {@link
   *       CallArguments#CallArguments(String, String, String, String, String, String, String)}
   *       Value is empty string.
   * </ul>
   *
   * <p>Method under test: {@link BuildArguments#parseValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long BuildArguments.parseValue()"})
  public void testParseValue_givenBuildArgumentsWithArgsIsCallArgumentsValueIsEmptyString()
      throws JsonRpcInvalidParamsException {
    // Arrange
    CallArguments args =
        new CallArguments(
            "jane.doe@example.org",
            "alice.liddell@example.org",
            "Gas",
            "Gas Price",
            "42",
            "Data",
            "Nonce");

    BuildArguments buildArguments = new BuildArguments(args);
    buildArguments.setValue("");

    // Act and Assert
    assertEquals(0L, buildArguments.parseValue());
  }

  /**
   * Test {@link BuildArguments#parseValue()}.
   *
   * <ul>
   *   <li>Given {@link BuildArguments#BuildArguments()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link BuildArguments#parseValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long BuildArguments.parseValue()"})
  public void testParseValue_givenBuildArguments_thenReturnZero()
      throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertEquals(0L, new BuildArguments().parseValue());
  }

  /**
   * Test {@link BuildArguments#parseGas()}.
   *
   * <ul>
   *   <li>Given {@link BuildArguments#BuildArguments(CallArguments)} with args is {@link
   *       CallArguments#CallArguments(String, String, String, String, String, String, String)} Gas
   *       is empty string.
   * </ul>
   *
   * <p>Method under test: {@link BuildArguments#parseGas()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long BuildArguments.parseGas()"})
  public void testParseGas_givenBuildArgumentsWithArgsIsCallArgumentsGasIsEmptyString()
      throws JsonRpcInvalidParamsException {
    // Arrange
    CallArguments args =
        new CallArguments(
            "jane.doe@example.org",
            "alice.liddell@example.org",
            "Gas",
            "Gas Price",
            "42",
            "Data",
            "Nonce");

    BuildArguments buildArguments = new BuildArguments(args);
    buildArguments.setGas("");

    // Act and Assert
    assertEquals(0L, buildArguments.parseGas());
  }

  /**
   * Test {@link BuildArguments#parseGas()}.
   *
   * <ul>
   *   <li>Given {@link BuildArguments#BuildArguments(CallArguments)} with args is {@link
   *       CallArguments#CallArguments(String, String, String, String, String, String, String)} Gas
   *       is {@code null}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link BuildArguments#parseGas()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long BuildArguments.parseGas()"})
  public void testParseGas_givenBuildArgumentsWithArgsIsCallArgumentsGasIsNull_thenReturnZero()
      throws JsonRpcInvalidParamsException {
    // Arrange
    CallArguments args =
        new CallArguments(
            "jane.doe@example.org",
            "alice.liddell@example.org",
            "Gas",
            "Gas Price",
            "42",
            "Data",
            "Nonce");

    BuildArguments buildArguments = new BuildArguments(args);
    buildArguments.setGas(null);

    // Act and Assert
    assertEquals(0L, buildArguments.parseGas());
  }

  /**
   * Test {@link BuildArguments#parseGas()}.
   *
   * <ul>
   *   <li>Given {@link BuildArguments#BuildArguments()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link BuildArguments#parseGas()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long BuildArguments.parseGas()"})
  public void testParseGas_givenBuildArguments_thenReturnZero()
      throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertEquals(0L, new BuildArguments().parseGas());
  }
}
