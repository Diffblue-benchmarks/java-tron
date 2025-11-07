package org.tron.core.services.jsonrpc.types;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tron.core.Wallet;
import org.tron.core.exception.JsonRpcInvalidParamsException;
import org.tron.core.exception.JsonRpcInvalidRequestException;

@ContextConfiguration(classes = {BuildArguments.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class BuildArgumentsDiffblueTest {
  @Autowired
  private BuildArguments buildArguments;

  /**
   * Method under test: {@link BuildArguments#getContractType(Wallet)}
   */
  @Test
  public void testGetContractType() throws JsonRpcInvalidParamsException, JsonRpcInvalidRequestException {
    // Arrange, Act and Assert
    assertThrows(JsonRpcInvalidRequestException.class, () -> buildArguments.getContractType(new Wallet()));
  }

  /**
   * Method under test: {@link BuildArguments#parseValue()}
   */
  @Test
  public void testParseValue() throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertEquals(0L, (new BuildArguments()).parseValue());
  }

  /**
   * Method under test: {@link BuildArguments#parseValue()}
   */
  @Test
  public void testParseValue2() throws JsonRpcInvalidParamsException {
    // Arrange
    BuildArguments buildArguments = new BuildArguments();
    buildArguments.setValue("");

    // Act and Assert
    assertEquals(0L, buildArguments.parseValue());
  }

  /**
   * Method under test: {@link BuildArguments#parseValue()}
   */
  @Test
  public void testParseValue3() throws JsonRpcInvalidParamsException {
    // Arrange
    BuildArguments buildArguments = new BuildArguments();
    buildArguments.setValue("0x0");

    // Act and Assert
    assertEquals(0L, buildArguments.parseValue());
  }

  /**
   * Methods under test:
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

    // Assert that nothing has changed
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
   * Method under test: {@link BuildArguments#parseGas()}
   */
  @Test
  public void testParseGas() throws JsonRpcInvalidParamsException {
    // Arrange, Act and Assert
    assertEquals(0L, (new BuildArguments()).parseGas());
  }

  /**
   * Method under test: {@link BuildArguments#parseGas()}
   */
  @Test
  public void testParseGas2() throws JsonRpcInvalidParamsException {
    // Arrange
    BuildArguments buildArguments = new BuildArguments();
    buildArguments.setGas(null);

    // Act and Assert
    assertEquals(0L, buildArguments.parseGas());
  }

  /**
   * Method under test: {@link BuildArguments#parseGas()}
   */
  @Test
  public void testParseGas3() throws JsonRpcInvalidParamsException {
    // Arrange
    BuildArguments buildArguments = new BuildArguments();
    buildArguments.setGas("");

    // Act and Assert
    assertEquals(0L, buildArguments.parseGas());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link BuildArguments#BuildArguments(String, String, String, String, String, String, String, Long, Long, String, Long, Long, String, Integer, String, boolean)}
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
  public void testGettersAndSetters2() {
    // Arrange and Act
    BuildArguments actualBuildArguments = new BuildArguments("jane.doe@example.org", "alice.liddell@example.org", "Gas",
        "Gas Price", "42", "Data", "Nonce", 1L, 42L, "Abi", 1L, 1L, "Name", 1, "Extra Data", true);
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

    // Assert that nothing has changed
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
   * Method under test: {@link BuildArguments#BuildArguments(CallArguments)}
   */
  @Test
  public void testNewBuildArguments() {
    // Arrange and Act
    BuildArguments actualBuildArguments = new BuildArguments(new CallArguments("jane.doe@example.org",
        "alice.liddell@example.org", "Gas", "Gas Price", "42", "Data", "Nonce"));

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
}
